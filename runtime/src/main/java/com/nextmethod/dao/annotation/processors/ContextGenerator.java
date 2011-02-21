package com.nextmethod.dao.annotation.processors;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import com.google.common.collect.Sets;
import com.nextmethod.dao.Queryable;
import com.nextmethod.dao.annotation.Column;
import com.nextmethod.dao.annotation.Table;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.util.ElementFilter;
import javax.lang.model.util.Elements;
import javax.tools.Diagnostic;
import javax.tools.JavaFileObject;
import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SupportedAnnotationTypes ({"com.nextmethod.dao.annotation.Table"})
@SupportedSourceVersion (SourceVersion.RELEASE_6)
public class ContextGenerator extends AbstractProcessor
{


	private Filer filer;
	private Messager messager;
	@SuppressWarnings ({"UnusedDeclaration"})
	private Elements eltUtils;

	private String basePackage;

	@SuppressWarnings ({"NonSynchronizedMethodOverridesSynchronizedMethod"})
	@Override
	public void init (final ProcessingEnvironment processingEnv)
	{
		super.init (processingEnv);
		filer = processingEnv.getFiler ();
		messager = processingEnv.getMessager ();
		eltUtils = processingEnv.getElementUtils ();

		final Map<String, String> options = processingEnv.getOptions ().isEmpty () ? ImmutableMap.of ("basePackage", "com.nextmethod.dao")
		                                                                           : processingEnv.getOptions ();

		basePackage = options.get ("basePackage");
	}

	@Override
	public boolean process (final Set<? extends TypeElement> annotations, final RoundEnvironment roundEnv)
	{
		if (!roundEnv.processingOver ())
		{

			final List<Entity> entities = Lists.<Entity>newArrayList ();

			for (TypeElement typeElement : ElementFilter.typesIn (roundEnv.getElementsAnnotatedWith (Table.class)))
			{

				if (typeElement.getKind () != ElementKind.CLASS)
				{
					messager.printMessage (Diagnostic.Kind.ERROR, "Only a class can be treated as a @Table entity.", typeElement);
					return true;
				}

				final Entity entity = new Entity (basePackage, typeElement);
				for (VariableElement variableElement : ElementFilter.fieldsIn (typeElement.getEnclosedElements ()))
				{
					if (variableElement.getAnnotation (Column.class) == null)
					{
						continue;
					}
					entity.addProperty (new Property (variableElement));
				}

				generateContextInterface (entity);
				entities.add (entity);
			}


			generateDataContext (entities);
		}
		return true;
	}

	private void generateDataContext (final List<Entity> entities)
	{
		if (entities.isEmpty ())
		{
			return;
		}
		try
		{
			final JavaFileObject fileObject = filer.createSourceFile ("com.nextmethod.dao.context.DataContext");
			final Writer writer = fileObject.openWriter ();
			try
			{
				writePackageStatement (entities.get (0), writer);
				final StringBuilder b = new StringBuilder (16);
				b.append ("public final class DataContext {\n\n");
				b.append ("\tprivate DataContext() {}\n\n");

				Set<String> imports = Sets.newHashSet ();

				for (Entity entity : Ordering.<Entity>natural ().sortedCopy (entities))
				{
					imports.add (entity.getTypeElement ().getQualifiedName ().toString ());
					b.append (String.format (
							"\tpublic static %1$s from(Class<? extends %2$s> entity) {\n",
							entity.getSimpleName (),
							entity.getTypeElement ().getSimpleName ()
					                        ));
					b.append (String.format (
							"\t\treturn ContextFactory.newInstance(entity, %1$s.class);\n",
							entity.getSimpleName ()
					                        ));
					b.append ("\t}\n\n");
				}

				b.append (generateContextFactory ());

				b.append ("}\n");

				writeImportStatements (imports, writer);
				writer.write (b.toString ());
			}
			finally
			{
				writer.close ();
			}
		}
		catch (IOException e)
		{
			// Should print stacktrace or handle in a more informative manner.
			messager.printMessage (Diagnostic.Kind.ERROR, "IOException encountered: " + e.getMessage ());
		}
	}

	private void generateContextInterface (final Entity entity)
	{
		entity.setGenType (GeneratorType.CONTEXT_INTERFACE);
		try
		{
			final JavaFileObject contextFileObject = filer.createSourceFile (entity.getName (), entity.getTypeElement ());
			final Writer writer = contextFileObject.openWriter ();
			try
			{
				final Class<Queryable> queryableClass = Queryable.class;
				writePackageStatement (entity, writer);
				final Set<String> imports = entity.getImports ();
				imports.add (queryableClass.getName ());
				imports.add (entity.getTypeElement ().getQualifiedName ().toString ());
				writeImportStatements (imports, writer);

				writer.write (String.format (
						"public interface %1$s extends %2$s<%3$s, %1$s> {\n\n",
						entity.getSimpleName (),
						queryableClass.getSimpleName (),
						entity.getTypeElement ().getSimpleName ()
				                            ));

				for (Property property : entity.getProperties ())
				{
					final String prefix = String.format ("%s where%s", entity.getSimpleName (), property.getName ());
					writer.write (String.format ("\t%s(%s value);\n", prefix, property.getJavaType ()));
					writer.write (String.format ("\t%s(%s expression);\n\n", prefix, property.getExpressionType ()));
				}

//                for (VariableElement fieldElement : ElementFilter.fieldsIn(entityClass.getEnclosedElements())) {
//
//                    final String properName = getProperCaseFieldName(fieldElement);
//
//                    writer.write(String.format("\t%s where%s(", name.getClassName(), properName));
//                    writeFieldType(fieldElement, writer);
//                    writer.write(" value);\n");
//
//                    writer.write(String.format("\t%s where%s(", name.getClassName(), properName));
//                    writeExpressionType(fieldElement, writer);
//                    writer.write(" expression);\n\n");
//                }


				writer.write ("}\n");
			}
			finally
			{
				writer.close ();
			}

		}
		catch (IOException e)
		{
			// Should print stacktrace or handle in a more informative manner.
			messager.printMessage (Diagnostic.Kind.ERROR, "IOException encountered.", entity.getTypeElement ());
			messager.printMessage (Diagnostic.Kind.ERROR, e.getMessage (), entity.getTypeElement ());
		}
	}

	private String generateContextFactory ()
	{
		final StringBuilder b = new StringBuilder (16);

		final InputStream stream = this.getClass ().getResourceAsStream ("ContextFactory.template");
		final BufferedReader reader = new BufferedReader (new InputStreamReader (stream));
		try
		{
			while (true)
			{
				final String s = reader.readLine ();
				if (s == null)
				{
					break;
				}
				b.append (s).append ("\n");
			}
		}
		catch (IOException e)
		{
			e.printStackTrace ();
		}
		finally
		{
			try
			{
				reader.close ();
			}
			catch (IOException e)
			{
			}
			;
		}

		return b.toString ();
	}

//    private static void writeFieldType(final VariableElement field, final Writer writer) throws IOException {
//        final TypeMirror typeMirror = field.asType();
//        final String typeName = ClassTypeMapping.containsKey(typeMirror.getKind()) ? ClassTypeMapping.get(typeMirror.getKind()).getSimpleName() : typeMirror.toString();
//        writer.write(typeName);
//    }
//
//    private static void writeExpressionType(final VariableElement field, final Writer writer) throws IOException {
//
//        final TypeMirror typeMirror = field.asType();
//
//        Class<?> expression = ExpressionTypeMapping.containsKey(typeMirror.getKind()) ? ExpressionTypeMapping.get(typeMirror.getKind()) : null;
//        expression = expression == null && ExpressionTypeMapping.containsKey(typeMirror.toString()) ? ExpressionTypeMapping.get(typeMirror.toString()) : expression;
//        expression = expression == null ? ObjectExpression.class : expression;
//
//        writer.write(expression.);
//    }

	private static void writeImportStatements (final Set<String> imports, final Writer writer)
			throws IOException
	{
		for (String cls : Ordering.natural ().sortedCopy (imports))
		{
			writer.write (String.format ("import %s;\n", cls));
		}

		if (imports.isEmpty () == false)
		{
			writer.write ("\n\n");
		}
	}

	private static void writePackageStatement (final Entity entity, final Writer writer)
			throws IOException
	{
		writer.write (String.format ("package %s;\n\n", entity.getPackage ()));
	}

}

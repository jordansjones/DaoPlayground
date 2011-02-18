package dao.annotation.processors;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Sets;
import dao.expressions.Expression;
import dao.expressions.ObjectExpression;

import javax.lang.model.element.VariableElement;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import java.util.Date;
import java.util.Set;

class Property {

    private final Set<String> imports;

    private final VariableElement field;
    private final TypeMirror type;

    private final String name;
    private final Class<?> javaType;
    private final String expressionType;

    public Property(final VariableElement field) {
        this.imports = Sets.newHashSet();

        this.field = field;
        this.type = field.asType();

        this.name = getProperCaseFieldName(this.field);
        this.javaType = determineJavaType();
        this.expressionType = determineExpressionType();
    }

    public String getName() {
        return name;
    }

    public Set<String> getImports() {
        return imports;
    }

    public boolean hasImports() {
        return imports.isEmpty() == false;
    }

    private Class<?> determineJavaType() {
        String typeName = type.toString();

        Class<?> javaType = ClassTypeMapping.containsKey(type.getKind().name()) ? ClassTypeMapping.get(type.getKind().name()) : null;
        javaType = javaType == null && ClassTypeMapping.containsKey(typeName) ? ClassTypeMapping.get(typeName) : javaType;

        if (javaType != null && javaType == Date.class) {
            imports.add(javaType.getName());
        }
        else if (javaType == null) {
            imports.add(typeName);
        }

        return javaType;
    }

    public String getJavaType() {
        return javaType != null ? javaType.getSimpleName() : type.toString();
    }

    private static Class<?> objectExpression = ObjectExpression.class;

    private String determineExpressionType() {
        final String expressionType = ExpressionTypeMapping.containsKey(javaType) ? ExpressionTypeMapping.get(javaType) : Expression.class.getSimpleName();
        final String importName = expressionType.startsWith("NumericExpression") ? "NumericExpression" : expressionType;
        imports.add(String.format("%s.%s", objectExpression.getPackage().getName(), importName));

        return expressionType;
    }

    public String getExpressionType() {
        return expressionType;
    }

    private static String getProperCaseFieldName(final VariableElement field) {
        final String s = field.getSimpleName().toString();
        return String.format("%s%s", s.substring(0, 1).toUpperCase(), s.substring(1));
    }

    private static final ImmutableMap<String, Class<?>> ClassTypeMapping = ImmutableMap.<String, Class<?>>builder()
            .put(TypeKind.BOOLEAN.name(), Boolean.class)
            .put(TypeKind.BYTE.name(), Byte.class)
            .put(TypeKind.CHAR.name(), Character.class)
            .put(TypeKind.DOUBLE.name(), Double.class)
            .put(TypeKind.FLOAT.name(), Float.class)
            .put(TypeKind.INT.name(), Integer.class)
            .put(TypeKind.LONG.name(), Long.class)
            .put(TypeKind.SHORT.name(), Short.class)
            .put(String.class.getName(), String.class)
            .put(java.util.Date.class.getName(), Date.class)
            .build();

    private static final ImmutableMap<Class<?>, String> ExpressionTypeMapping = ImmutableMap.<Class<?>, String>builder()
//            .put(Boolean.class, "BooleanExpression")
//            .put(Byte.class, "NumericExpression<Byte>")
//            .put(Character.class, "StringExpression")
//            .put(Double.class, "NumericExpression<Double>")
//            .put(Float.class, "NumericExpression<Float>")
//            .put(Integer.class, "NumericExpression<Integer>")
//            .put(Long.class, "NumericExpression<Long>")
//            .put(Short.class, "NumericExpression<Short>")
//            .put(String.class, "StringExpression")
//            .put(Date.class, "DateExpression")
//            .put(Object.class, "ObjectExpression")
            .build();

}

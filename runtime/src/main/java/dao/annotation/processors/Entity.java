package dao.annotation.processors;

import javax.lang.model.element.Name;
import javax.lang.model.element.TypeElement;
import java.util.List;
import java.util.Set;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import com.google.common.collect.Sets;

class Entity implements Comparable<Entity> {

    private final List<Property> properties;
    private final Set<String> imports;

    private final TypeElement typeElement;
    private final String basePackage;
    private final Name baseName;

    private GeneratorType genType;

    public Entity(final String basePackage, final TypeElement element) {
        this.properties = Lists.newArrayList();
        this.imports = Sets.newHashSet();

        this.typeElement = element;
        this.baseName = element.getSimpleName();
        this.basePackage = new StringBuilder(3)
                .append(Strings.nullToEmpty(basePackage))
                .append(Strings.isNullOrEmpty(basePackage) ? "" : ".")
                .toString();
    }

    public void setGenType(final GeneratorType genType) {
        this.genType = genType;
    }

    public void addProperty(final Property property) {
        if (property.hasImports()) {
            imports.addAll(property.getImports());
        }
        properties.add(property);
    }

    public List<Property> getProperties() {
        return properties;
    }

    public TypeElement getTypeElement() {
        return typeElement;
    }

    public String getPackage() {
        return new StringBuilder(2)
                .append(Strings.nullToEmpty(basePackage))
                .append(genType == null ? "" : genType.getPackagePart())
                .toString();
    }

    public String getSimpleName() {
        return new StringBuilder(2)
                .append(baseName.toString())
                .append(genType == null ? "" : genType.getClassSuffix())
                .toString();
    }

    public String getName() {
        return String.format("%s.%s", getPackage(), getSimpleName());
    }

    public boolean hasImports() {
        return imports.isEmpty() == false;
    }

    public Set<String> getImports() {
        return imports;
    }

    @Override
    public int compareTo(final Entity o) {
        return getSimpleName().compareToIgnoreCase(o.getSimpleName());
    }
}

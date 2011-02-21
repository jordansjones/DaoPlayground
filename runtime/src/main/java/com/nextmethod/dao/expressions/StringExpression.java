package com.nextmethod.dao.expressions;

public interface StringExpression extends BaseExpression, CompositeExpression<StringExpression>, EqualityExpression<String, StringExpression>, NullableExpression<StringExpression>, RangeExpression<String, StringExpression>
{
	StringExpression beginsWith (String value);

	StringExpression beginsWith (String value, Boolean caseInsensitive);

	StringExpression contains (String value);

	StringExpression contains (String value, Boolean caseInsensitive);

	StringExpression endsWith (String value);

	StringExpression endsWith (String value, Boolean caseInsensitive);

}

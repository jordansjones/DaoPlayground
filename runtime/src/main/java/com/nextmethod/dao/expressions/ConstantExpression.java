package com.nextmethod.dao.expressions;

public class ConstantExpression extends Expression
{

	private final Object value;

	protected ConstantExpression (final Object value, final Class<?> type)
	{
		super (ExpressionType.Constant, type);
		this.value = value;
	}
}

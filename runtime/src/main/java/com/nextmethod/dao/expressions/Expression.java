package com.nextmethod.dao.expressions;

public abstract class Expression
{
	ExpressionType expressionType;
	Class<?> type;

	protected Expression (final ExpressionType expressionType, final Class<?> type)
	{
		this.expressionType = expressionType;
		this.type = type;
	}

	public ExpressionType getExpressionType ()
	{
		return expressionType;
	}

	public Class<?> getType ()
	{
		return type;
	}

	@Override
	public String toString ()
	{
		return ExpressionPrinter.toString (this);
	}
}

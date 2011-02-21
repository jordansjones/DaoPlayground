package dao.expressions;

import java.util.Date;
import java.util.List;

public final class Expressions {
	private Expressions() {}

	public static Expression equalTo(final Boolean value) {
		return makeSimpleBinary(ExpressionType.Equal, null, new ConstantExpression(value, Boolean.class));
	}

	public static Expression notEqualTo(final Boolean value) {
		return makeSimpleBinary(ExpressionType.NotEqual, null, new ConstantExpression(value, Boolean.class));
	}

	private static BinaryExpression makeSimpleBinary(final ExpressionType type, final Expression left, final Expression right) {
		return new BinaryExpression(type, right);
	}

	public static Expression equalTo(final Date value)
	{
		return makeSimpleBinary(ExpressionType.Equal, null, new ConstantExpression(value, Date.class));
	}

	public static Expression notEqualTo(final Date value)
	{
		return makeSimpleBinary(ExpressionType.NotEqual, null, new ConstantExpression(value, Date.class));
	}

	public static Expression equalTo(final String value)
	{
		return makeSimpleBinary(ExpressionType.Equal, null, new ConstantExpression(value, String.class));
	}

	public static Expression notEqualTo(final String value)
	{
		return makeSimpleBinary(ExpressionType.NotEqual, null, new ConstantExpression(value, String.class));
	}

	
	public static Expression after(final Date value)
	{
		return null;
	}
	
	public static Expression before(final Date value)
	{
		return null;
	}
	
	public static Expression between(final Date min, final Date max)
	{
		return null;
	}


	public static Expression in(final String value)
	{
		return makeSimpleBinary(ExpressionType.Equal, null, new ConstantExpression(value, String.class));
	}

	public static Expression in(final String... values)
	{
		return null;
	}

//	public static Expression in(final List<String> values)
//	{
//		return null;
//	}
	
	public static Expression beginsWith(final String value)
	{
		return null;
	}
	
	public static Expression beginsWith(final String value, final Boolean caseInsensitive)
	{
		return null;
	}
	
	public static Expression contains(final String value)
	{
		return null;
	}
	
	public static Expression contains(final String value, final Boolean caseInsensitive)
	{
		return null;
	}
	
	public static Expression endsWith(final String value)
	{
		return null;
	}
	
	public static Expression endsWith(final String value, final Boolean caseInsensitive)
	{
		return null;
	}



	public static <T extends Number & Comparable<T>> Expression equalTo(final T value)
	{
		return null;
	}

	public static <T extends Number & Comparable<T>> Expression notEqualTo(final T value)
	{
		return null;
	}
	
	public static <T extends Number & Comparable<T>> Expression in(final T value)
	{
		return null;
	}

	public static <T extends Number & Comparable<T>> Expression in(final T... values)
	{
		return null;
	}

	public static <T extends Number & Comparable<T>> Expression in(final List<T> values)
	{
		return null;
	}

	public static <T extends Number & Comparable<T>> Expression greater(final T value)
	{
		return null;
	}

	public static <T extends Number & Comparable<T>> Expression greaterOrEqual(final T value)
	{
		return null;
	}

	public static <T extends Number & Comparable<T>> Expression less(final T value)
	{
		return null;
	}

	public static <T extends Number & Comparable<T>> Expression lessOrEqual(final T value)
	{
		return null;
	}

	public static <T extends Number & Comparable<T>> Expression inRangeOf(final T min, final T max)
	{
		return null;
	}




	public static <T> Expression and(final T expression)
	{
		return null;
	}

	public static <T> Expression and(final T... expressions)
	{
		return null;
	}

	public static <T> Expression and(final List<T> expressions)
	{
		return null;
	}

	public static <T> Expression or(final T expression)
	{
		return null;
	}

	public static <T> Expression or(final T... expressions)
	{
		return null;
	}

	public static <T> Expression or(final List<T> expressions)
	{
		return null;
	}
}

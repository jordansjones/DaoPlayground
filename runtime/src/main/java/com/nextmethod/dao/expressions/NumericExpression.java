package com.nextmethod.dao.expressions;

public interface NumericExpression<T extends Number & Comparable<T>> extends BaseExpression, CompositeExpression<NumericExpression<T>>, EqualityExpression<T, NumericExpression<T>>, NullableExpression<NumericExpression<T>>, RangeExpression<T, NumericExpression<T>>
{
	NumericExpression<T> greater (T value);

	NumericExpression<T> greaterOrEqual (T value);

	NumericExpression<T> less (T value);

	NumericExpression<T> lessOrEqual (T value);

	NumericExpression<T> inRangeOf (T min, T max);
}

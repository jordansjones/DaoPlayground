package com.nextmethod.dao.expressions;

interface NullableExpression<T>
{
	T isEmpty ();

	T isNotEmpty ();
}

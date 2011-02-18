package dao.expressions;

interface NullableExpression<T>
{
	T isEmpty();
	T isNotEmpty();
}

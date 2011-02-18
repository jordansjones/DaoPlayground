package dao.expressions;

interface EqualityExpression<T, ET extends BaseExpression>
{
	ET equalTo(T value);
	ET notEqualTo(T value);
}

package dao.expressions;

public interface DateExpression extends BaseExpression, CompositeExpression<DateExpression>,
	EqualityExpression<java.util.Date, DateExpression>,
	NullableExpression<DateExpression>
{

	DateExpression after(java.util.Date value);
	DateExpression before(java.util.Date value);
	DateExpression between(java.util.Date min, java.util.Date max);
	
}

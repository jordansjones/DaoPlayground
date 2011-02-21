package dao.expressions;

public class BinaryExpression extends Expression
{
	private final Expression rightExpression;

	protected BinaryExpression(final ExpressionType expressionType, final Expression rightExpression)
	{
		super(expressionType, rightExpression.type);

		this.rightExpression = rightExpression;
	}
}

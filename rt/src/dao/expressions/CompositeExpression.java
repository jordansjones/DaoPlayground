package dao.expressions;

import java.util.List;

interface CompositeExpression<ET extends BaseExpression>
{
	ET and(ET expression);
	ET and(ET... expressions);
	ET and(List<ET> expressions);

	ET or(ET expression);
	ET or(ET... expressions);
	ET or(List<ET> expressions);
}

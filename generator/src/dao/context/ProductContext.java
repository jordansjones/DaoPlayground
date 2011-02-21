package dao.context;

import dao.Queryable;
import dao.entities.Product;
import dao.expressions.BooleanExpression;
import dao.expressions.DateExpression;
import dao.expressions.NumericExpression;
import dao.expressions.StringExpression;
import java.util.Date;


public interface ProductContext extends Queryable<Product, ProductContext> {

	ProductContext whereId(Integer value);
	ProductContext whereId(NumericExpression<Integer> expression);

	ProductContext whereName(String value);
	ProductContext whereName(StringExpression expression);

	ProductContext whereDescription(String value);
	ProductContext whereDescription(StringExpression expression);

	ProductContext whereAmount(Double value);
	ProductContext whereAmount(NumericExpression<Double> expression);

	ProductContext whereIsActive(Boolean value);
	ProductContext whereIsActive(BooleanExpression expression);

	ProductContext whereDateAdded(Date value);
	ProductContext whereDateAdded(DateExpression expression);

}

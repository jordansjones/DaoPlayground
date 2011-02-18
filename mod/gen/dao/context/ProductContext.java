package dao.context;

import dao.Queryable;
import dao.entities.Product;
import dao.expressions.Expression;
import java.util.Date;


public interface ProductContext extends Queryable<Product, ProductContext> {

	ProductContext whereId(Integer value);
	ProductContext whereId(Expression expression);

	ProductContext whereName(String value);
	ProductContext whereName(Expression expression);

	ProductContext whereDescription(String value);
	ProductContext whereDescription(Expression expression);

	ProductContext whereAmount(Double value);
	ProductContext whereAmount(Expression expression);

	ProductContext whereIsActive(Boolean value);
	ProductContext whereIsActive(Expression expression);

	ProductContext whereDateAdded(Date value);
	ProductContext whereDateAdded(Expression expression);

}

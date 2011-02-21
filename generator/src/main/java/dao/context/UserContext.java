package dao.context;

import dao.Queryable;
import dao.entities.User;
import dao.expressions.DateExpression;
import dao.expressions.NumericExpression;
import dao.expressions.StringExpression;
import java.util.Date;


public interface UserContext extends Queryable<User, UserContext> {

	UserContext whereId(Integer value);
	UserContext whereId(NumericExpression<Integer> expression);

	UserContext whereFirstName(String value);
	UserContext whereFirstName(StringExpression expression);

	UserContext whereLastName(String value);
	UserContext whereLastName(StringExpression expression);

	UserContext whereEmailAddress(String value);
	UserContext whereEmailAddress(StringExpression expression);

	UserContext whereBirthday(Date value);
	UserContext whereBirthday(DateExpression expression);

}

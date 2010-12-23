package dao.context;

import dao.Queryable;
import dao.entities.User;
import dao.expressions.Expression;
import java.util.Date;


public interface UserContext extends Queryable<User, UserContext> {

	UserContext whereId(Integer value);
	UserContext whereId(Expression expression);

	UserContext whereFirstName(String value);
	UserContext whereFirstName(Expression expression);

	UserContext whereLastName(String value);
	UserContext whereLastName(Expression expression);

	UserContext whereEmailAddress(String value);
	UserContext whereEmailAddress(Expression expression);

	UserContext whereBirthday(Date value);
	UserContext whereBirthday(Expression expression);

	UserContext whereIsActive(Boolean value);
	UserContext whereIsActive(Expression expression);

}

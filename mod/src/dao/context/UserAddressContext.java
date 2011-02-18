package dao.context;

import dao.expressions.NumericExpression;
import dao.expressions.StringExpression;

public interface UserAddressContext// extends UserContext
{

	UserAddressContext whereAddressId(Integer value);
	UserAddressContext whereAddressId(NumericExpression<Integer> expression);

	UserAddressContext whereAddressStreetLine(String value);
	UserAddressContext whereAddressStreetLine(StringExpression expression);

	UserAddressContext whereAddressCity(String value);
	UserAddressContext whereAddressCity(StringExpression expression);

	UserAddressContext whereAddressState(String value);
	UserAddressContext whereAddressState(StringExpression expression);

	UserAddressContext whereAddressZipCode(String value);
	UserAddressContext whereAddressZipCode(StringExpression expression);

}

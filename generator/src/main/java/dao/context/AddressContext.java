package dao.context;

import dao.Queryable;
import dao.entities.Address;
import dao.expressions.NumericExpression;
import dao.expressions.StringExpression;


public interface AddressContext extends Queryable<Address, AddressContext> {

	AddressContext whereId(Integer value);
	AddressContext whereId(NumericExpression<Integer> expression);

	AddressContext whereUserId(Integer value);
	AddressContext whereUserId(NumericExpression<Integer> expression);

	AddressContext whereStreetLine(String value);
	AddressContext whereStreetLine(StringExpression expression);

	AddressContext whereCity(String value);
	AddressContext whereCity(StringExpression expression);

	AddressContext whereState(String value);
	AddressContext whereState(StringExpression expression);

	AddressContext whereZipCode(String value);
	AddressContext whereZipCode(StringExpression expression);

}

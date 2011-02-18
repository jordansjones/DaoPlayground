package dao.context;

import dao.Queryable;
import dao.entities.Address;
import dao.expressions.Expression;


public interface AddressContext extends Queryable<Address, AddressContext> {

	AddressContext whereId(Integer value);
	AddressContext whereId(Expression expression);

	AddressContext whereUserId(Integer value);
	AddressContext whereUserId(Expression expression);

	AddressContext whereStreetLine(String value);
	AddressContext whereStreetLine(Expression expression);

	AddressContext whereCity(String value);
	AddressContext whereCity(Expression expression);

	AddressContext whereState(String value);
	AddressContext whereState(Expression expression);

	AddressContext whereZipCode(String value);
	AddressContext whereZipCode(Expression expression);

}

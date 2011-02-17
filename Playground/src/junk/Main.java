package junk;

import dao.Enumerable;
import dao.context.DataContext;
import dao.context.UserContext;
import dao.entities.User;

import static dao.context.DataContext.from;
import static dao.expressions.Expressions.and;
import static dao.expressions.Expressions.beginsWith;
import static dao.expressions.Expressions.equalTo;
import static dao.expressions.Expressions.notEqualTo;
import static dao.expressions.Expressions.or;

public class Main
{

	public static void main(String[] args)
	{
        final UserContext context = from(User.class);

        final Enumerable<User> userEnumerable = from(User.class)
			.whereEmailAddress("jordansjones@gmail.com")
			.or().whereEmailAddress("jordan.jones@quest.com")
			.select(User.class);

		userEnumerable.count();
		final User[] users = userEnumerable.toArray();

		final Enumerable<User> enumerable = from(User.class)
			.whereId(and(equalTo(3), equalTo(4), equalTo(5)))
			.whereId(or(equalTo(34)))
			.whereEmailAddress(beginsWith("jordan", true))
			.whereIsActive(notEqualTo(false))
			.select(User.class);
//			.first();

		int x = 1;
//		final User userWithAddress = from(User.class)
//			.whereId(10)
//			.joinAddress()
//			.whereAddressState("UT")
//			.select(User.class)
//			.first();
	}

}

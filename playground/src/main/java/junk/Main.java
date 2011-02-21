package junk;

import com.nextmethod.dao.Enumerable;
import com.nextmethod.dao.context.UserContext;
import com.nextmethod.dao.entities.User;

import static com.nextmethod.dao.context.DataContext.from;
import static com.nextmethod.dao.expressions.Expressions.*;

public class Main
{

	public static void main (String[] args)
	{
		final UserContext context = from (User.class);

		final Enumerable<User> userEnumerable = from (User.class)
				.whereEmailAddress ("jordansjones@gmail.com")
				.or ().whereEmailAddress ("jordan.jones@quest.com")
				.select (User.class);

		userEnumerable.count ();
		final User[] users = userEnumerable.toArray ();

		final Enumerable<User> enumerable = from (User.class)
				.whereId (and (equalTo (3), equalTo (4), equalTo (5)))
				.whereId (or (equalTo (34)))
				.whereEmailAddress (beginsWith ("jordan", true))
				.whereIsActive (notEqualTo (false))
				.select (User.class);
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

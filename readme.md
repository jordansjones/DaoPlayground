This is a playground area for an idea I had about making data access easier in Java.

The idea comes from Linq to SQL in .Net.

Here is an example what this might look like:

```java
final UserContext context = from (User.class);

final Enumerable<User> userEnumerable = from (User.class)
		.whereEmailAddress ("jordansjones@gmail.com")
		.or ().whereEmailAddress ("email@domain.net")
		.select (User.class);

final int totalUsers = userEnumerable.count ();
final User[] users = userEnumerable.toArray ();
```


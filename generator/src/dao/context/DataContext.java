package dao.context;

import dao.entities.Address;
import dao.entities.Product;
import dao.entities.User;


public final class DataContext {

	private DataContext() {}

	public static AddressContext from(Class<? extends Address> entity) {
		return ContextFactory.newInstance(entity, AddressContext.class);
	}

	public static ProductContext from(Class<? extends Product> entity) {
		return ContextFactory.newInstance(entity, ProductContext.class);
	}

	public static UserContext from(Class<? extends User> entity) {
		return ContextFactory.newInstance(entity, UserContext.class);
	}


	private static final class ContextFactory implements java.lang.reflect.InvocationHandler
	{
		private final Class<?> entityClass;
		private final Class<?> proxiedClass;
		private final java.util.List<dao.expressions.MethodCallExpression> expressions;

		private ContextFactory(final Class<?> entityClass, final Class<?> contextClass) {
			this.entityClass = entityClass;
			this.proxiedClass = contextClass;
			this.expressions = new java.util.ArrayList<dao.expressions.MethodCallExpression>();
		}

		@SuppressWarnings({"unchecked"})
		public static <EC, CC> CC newInstance(final Class<EC> entityClass, final Class<CC> contextClass) {
			return (CC) java.lang.reflect.Proxy.newProxyInstance(contextClass.getClassLoader(), new Class[]{contextClass}, new ContextFactory(entityClass, contextClass));
		}

		@Override
		public Object invoke(final Object proxy, final java.lang.reflect.Method method, final Object[] args)
			throws Throwable
		{
			final String s = method.getName();
			if (s.equals("toString")) {
				return proxiedClass.getName();
			}
			if (s.equals("select")) {
				return generateEnumerable(this);
			}
			expressions.add(new dao.expressions.MethodCallExpression((java.lang.reflect.Proxy) proxy, method, args));
			return proxy;
		}

		private static <EC> dao.Enumerable<EC> generateEnumerable(final ContextFactory factory) {
			return new dao.Enumerable<EC>() {

				@Override
				public int count()
				{
					return 0;
				}

				@Override
				public EC first()
				{
					return null;
				}

				@Override
				public EC itemAt(final int index)
				{
					return null;
				}

				@Override
				public java.util.Iterator<EC> iterator()
				{
					return null;
				}

				@Override
				public EC last()
				{
					return null;
				}

				@Override
				public dao.Enumerable<EC> reverse()
				{
					return null;
				}

				@Override
				public EC single()
				{
					return null;
				}

				@SuppressWarnings({"unchecked"})
				@Override
				public EC[] toArray()
				{
					return (EC[])java.lang.reflect.Array.newInstance(factory.entityClass,0);
				}

				@Override
				public java.util.List<EC> toList()
				{
					return null;
				}
			};
		}
	}
}
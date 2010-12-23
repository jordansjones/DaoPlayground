package dao.expressions;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MethodCallExpression implements BaseExpression
{

	private final Proxy proxy;
	private final Method method;
	private final Object[] arguments;

	public MethodCallExpression(final Proxy proxy, final Method method, final Object[] arguments)
	{
		this.proxy = proxy;
		this.method = method;
		this.arguments = arguments;
	}

	@Override
	public String toString()
	{
		return String.format("%s<%s>.%s()",
			this.getClass().getSimpleName(),
			this.proxy.toString(),
			this.method.getName()
		);
	}
}

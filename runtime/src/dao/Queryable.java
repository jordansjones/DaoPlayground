package dao;

import dao.expressions.JoinExpression;

public interface Queryable<T, QT>
{
	QT or();
	QT and();

//	QT join(JoinExpression expression);

	Enumerable<T> select(Class<? extends T> projection);

	void dump();
}

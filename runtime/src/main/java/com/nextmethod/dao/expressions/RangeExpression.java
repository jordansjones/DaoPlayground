package com.nextmethod.dao.expressions;

import java.util.List;

interface RangeExpression<T, ET extends BaseExpression>
{
	ET in (T value);

	ET in (T... values);

	ET in (List<T> values);
}

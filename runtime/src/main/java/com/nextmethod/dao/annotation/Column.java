package com.nextmethod.dao.annotation;

import java.lang.annotation.*;

@Target ({ElementType.FIELD})
@Retention (RetentionPolicy.RUNTIME)
@Documented
public @interface Column
{
	String value ();
}

package com.nextmethod.dao;

import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

public interface Enumerable<T> extends Iterable<T>, RandomAccess
{

	int count ();

	T first ();

	T itemAt (int index);

	@Override
	Iterator<T> iterator ();

	T last ();

	Enumerable<T> reverse ();

	T single ();

	T[] toArray ();

	List<T> toList ();

}

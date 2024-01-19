/**
 * 
 */
package edu.unca.csci202;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class LinkedSet<E> implements Set<E> {

	LinkedList<E> set;
	
	public LinkedSet() {
		this.set = new LinkedList<E>();
	}

	/**
	 * returns the size of the set
	 */
	@Override
	public int size() {
		return set.size();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * returns true if set contains o, false otherwise
	 */
	@Override
	public boolean contains(Object o) {
		return set.contains(o);
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * returns false if set contains e, adds e to set and returns true otherwise
	 */
	@Override
	public boolean add(E e) {
		if(set.contains(e)) {
			return false;
		}
		return set.add(e);
	}

	/**
	 * returns false if element cannot be removed, removes element and returns true otherwise
	 */
	@Override
	public boolean remove(Object o) {
		return set.remove(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

}

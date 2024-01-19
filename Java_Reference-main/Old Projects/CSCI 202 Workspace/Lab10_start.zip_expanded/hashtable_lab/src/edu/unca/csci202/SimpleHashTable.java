package edu.unca.csci202;

import java.util.LinkedList;

/**
 * Hash table implemented using an array of LinkedLists,
 * where the LinkedLists are used to implement chaining for collision resolution
 * 
 * @author ksanft
 *
 * @param <K> key type
 * @param <V> value type
 */
public class SimpleHashTable<K,V> implements SimpleHashTableADT<K, V> {

	/**
	 * inner class to hold key:value pairs
	 * 
	 * @param <K> key type
	 * @param <V> value type
	 */
	private class Pair<K,V> {
		K key;
		V value;
		public Pair(K key, V value) {
			this.key=key;
			this.value=value;
		}
		K getKey() {
			return key;
		}
		V getValue() {
			return value;
		}
		public String toString() {
			return key+":"+value;
		}
	}
	
	LinkedList<Pair<K,V>>[] bins;
	int size;
	double loadFactorLimit;
	final double DEFAULT_LOAD_FACTOR_LIMIT = 0.75;
	
	public SimpleHashTable(int numberOfBins) {
		// initialize array and linked lists
		bins = (LinkedList<Pair<K,V>>[]) new LinkedList<?>[numberOfBins];
		for (int i=0; i<numberOfBins; i++) {
			bins[i] = new LinkedList<Pair<K,V>>();
		}
		size=0;
		loadFactorLimit=DEFAULT_LOAD_FACTOR_LIMIT;
	}
	
	@Override
	public void put(K key, V value) {
		// implement this method
		//this.setLoadFactorLimit(this.getCurrentLoadFactor());
		int loc = Math.abs(key.hashCode()%bins.length);
		Pair<K, V> p = new Pair<K,V>(key, value);
		for (Pair<K,V> pi : bins[loc]) {
			if(pi.getKey().equals(key)) {
				//System.out.println("found!!!!!!!!!!!!!!!!!!!!!!!!");
				pi.value = value;
				return;
			}
		}
		bins[loc].add(p);
		size++;
	}

	/**
	 * double the length of the underlying array
	 */
	protected void increaseCapacity() {
		// do not delete this print statement
		System.out.println("increasing capacity...");
		// implement this method
		LinkedList<Pair<K,V>>[] nuBins = (LinkedList<Pair<K,V>>[]) new LinkedList<?>[bins.length*2];
		for (int i = 0; i<nuBins.length; i++) {
			nuBins[i] = new LinkedList<Pair<K,V>>();
		}
		for (int i = 0; i<bins.length; i++) {
			for (Pair<K,V> p : bins[i]) {
				int loc = Math.abs(p.key.hashCode()%nuBins.length);
				//Pair<K, V> p = new Pair<K,V>(key, value);
				nuBins[loc].add(p);
			}
		}
		bins=nuBins;
		
		
	}
	
	@Override
	public V get(K key) {
		// implement this method
		int loc = Math.abs(key.hashCode()%bins.length);
		for (Pair<K,V> p : bins[loc]) {
			if(p.getKey().equals(key)) {
				return p.getValue();
			}
		}
		return null;
	}

	@Override
	public V remove(K key) {
		int loc = Math.abs(key.hashCode()%bins.length);
		for (Pair<K,V> p : bins[loc]) {
			if(p.getKey().equals(key)) {
				Pair<K,V> temp = p;
				bins[loc].remove(p);
				return temp.getValue();
			}
		}
		return null;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void setLoadFactorLimit(double loadFactorLimit) {
		this.loadFactorLimit=loadFactorLimit;
		// uncomment this when increaseCapacity is implemented:
		while (getCurrentLoadFactor()>loadFactorLimit) {
			increaseCapacity();
		}
	}

	@Override
	public double getLoadFactorLimit() {
		return loadFactorLimit;
	}

	@Override
	public double getCurrentLoadFactor() {
		return (double) size/bins.length;
	}

	public String toString() {
		String out="{";
		for (int i=0; i<bins.length; i++) {
			for (Pair<K,V> pair : bins[i]) {
				out+=pair+", ";
			}
		}
		out+="}";
		return out;
	}
	
	public void printTable() {
		for (int i=0; i<bins.length; i++) {
			System.out.println(i+": "+bins[i]);
		}
	}
}

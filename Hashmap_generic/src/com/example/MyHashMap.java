package com.example;

import java.math.BigInteger;
import java.security.MessageDigest;

public class MyHashMap<K,V> {

	int n;
	// buckets to store data
	Node<K,V>[] buckets;
	
	public MyHashMap(int buckets) {
		n = buckets;
		this.buckets = new Node[n];
	}
	
	public MyHashMap() {
		this(100);
	}
	
	public void put(K key, V value) {
		int hashCode = key.hashCode();
		int idx = hashCode & (n-1);
		if (buckets[idx] == null) {
			Node node = new Node(key, value);
			buckets[idx] = node;
		} 
		else {
			buckets[idx].put(key, value);
		}
	}
	
	public V get(K key) {
		int hashCode = key.hashCode();
		int idx = hashCode & (n-1);
		if (buckets[idx] == null) {
			return null;
		}
		else {
			return buckets[idx].get(key);
		}
	}
	
	public static void main(String[] args) {
		MyHashMap map = new MyHashMap<String, String>(100);
		map.put("hello", "world");
		map.put("food", "pizza");
		System.out.println("Value of hello is " + map.get("hello"));
		System.out.println("Value of food is " + map.get("food"));
		map.put("food", "salad");
		System.out.println("Updated value of food is " + map.get("food"));
		System.out.println("Value of unknown is " + map.get("unknown"));

		MyHashMap map2 = new MyHashMap<Integer, String>(100);
		map.put(1, "abc");
		map.put(2, "def");
		System.out.println("Value of 1 is " + map.get(1));
		System.out.println("Value of 2 is " + map.get(2));
		System.out.println("Value of 3 is " + map.get(3));

		MyHashMap<Stock, Integer> prices = new MyHashMap<>();
		Stock msft = new Stock("MSFT", "Microsoft");
		Stock ibm = new Stock("IBM", "IBM");
		prices.put(msft, 200);
		prices.put(ibm, 50);
		System.out.println("Price of MSFT is " + prices.get(msft));
		System.out.println("Price os IBM is " + prices.get(ibm));
		System.out.println("Price of MSFT is " + prices.get(new Stock("MSFT", "Micro")));
		System.out.println("Price of GOOG is" + prices.get(new Stock("GOOG", "Google")));



	}

}

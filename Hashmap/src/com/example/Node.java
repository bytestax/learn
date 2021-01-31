package com.example;

public class Node {
	
	String key;
	String value;
	Node next;
	
	public Node(String key, String value) {
		this.key=key;
		this.value = value;
		next = null;
	}
	
	public String getKey() {
		return key;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	public String getValue(){
		return value;
	}
	
	public Node getNext() {
		return next;
	}
	public void setNext(Node n) {
		next = n;
	}
	
	private void add(Node node) {
		Node start = this;
		while(true) {
			if (start.equals(node)) {
				start.setValue(node.getValue());
				break;
			} 
			else if (start.getNext() == null) {
				start.setNext(node);
				break;
			} 
			else {
				start = start.getNext();
			}
		}
	}
	
	public void put(String key, String value) {
		Node node = new Node(key, value);
		add(node);		
	}
	
	public String get(String key) {
		Node start = this;
		while(true) {
			if (start.getKey().equals(key)) {
				return start.getValue();
			} 
			else if (start.getNext() == null) {
				return null;
			} 
			else {
				start = start.getNext();
			}
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (this.getClass() != obj.getClass()) return false;
		
		Node node = (Node) obj;
		return key.equals(node.getKey());		
	}
	
	@Override 
	public int hashCode() {
		return key.hashCode();
	}

}

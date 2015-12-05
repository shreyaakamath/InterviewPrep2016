package com.java.algorithms;
import java.util.Iterator;

public class Bag<Item> implements Iterable<Item> {
	Node first; 
	int size;
	
	private class Node{
		Item item;
		Node next;
	}
	
	class bagIterator implements Iterator<Item>{
		Node firstCopy=first;
		int sizeCopy=size;
		
		public Item next(){
			Item value = firstCopy.item;
			firstCopy=firstCopy.next;
			//sizeCopy--;
			return value;
		}
		
		public boolean hasNext(){return firstCopy!=null;}
		
		public void remove(){}
		
	}
	public Iterator<Item> iterator(){
		return new bagIterator();
	}
	Bag(){
		size=0;
		first= new Node();
	}
	void add(Item a){
			Node newFirst= new Node();
			newFirst.item=a;
			newFirst.next=first;
			first=newFirst;
			size++;
		
	}
	
	boolean isEmpty(){return first==null;}

	int size(){return size;}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bag<String> bag = new Bag<String>();
		System.out.println(bag.isEmpty());
		bag.add("hello");
		bag.add("bye");
		System.out.println(bag.isEmpty());
		System.out.println(bag.size());
		for(String s : bag) System.out.println(s);
		
	}

}

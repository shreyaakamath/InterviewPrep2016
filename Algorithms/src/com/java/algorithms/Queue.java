package com.java.algorithms;

import javax.management.RuntimeErrorException;



import java.util.Iterator;

public class Queue <Item> implements Iterable<Item>{

	Node first; 
	Node last;
	int size;
	
	private class Node {
		Item item;
		Node next;
		
		Node(Item item ){ this.item= item;}
		Node(){}
			
	}
	
	private class QueueIterator implements Iterator{
		Node lastCopy;
		int sizeCopy;
		
		public QueueIterator() {
			lastCopy=last;
			sizeCopy=size;
		}
		
		public Item next(){
			Item value=lastCopy.item;
			lastCopy=lastCopy.next;
			sizeCopy--;
			return value;
		}
		public boolean hasNext(){return sizeCopy>0;}
		public void remove(){}
		
	}
	public Iterator<Item> iterator(){
		return new QueueIterator();
	}
	Queue(){
		size=0;
		Node first = new Node();
		Node last = new Node();
	}
	void enqueue(Item a ){
		Node newFirst= new Node(a);
		if(size==0){
			first=newFirst;
			last=newFirst;
		} else {
		first.next=newFirst;
		first=newFirst;
		}
		size++;
	}
	
	Item dequeue(){
		if(size!=0) {
		Item dequeue=last.item;
		last=last.next;
		size--;
		return dequeue;
		} else {
			throw new RuntimeException("queue empty");
		}
		
	
	}
	
	int size(){return size;}
	boolean isEmpty(){return size==0;}
	
	public static void main(String[] args) {
		Queue<String> queue=new Queue<String>();
		queue.enqueue("hello");
		queue.enqueue("is it me");
		queue.enqueue("you're looking for");
		for(String s : queue ){
			System.out.println(s);
		}
		queue.dequeue();
		queue.dequeue();
	}

}

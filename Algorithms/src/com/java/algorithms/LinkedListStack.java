package com.java.algorithms;
import java.util.Iterator;

public class LinkedListStack<Item> implements Iterable<Item> {
	Node first;
	Node last;
	int size;
	
	
	private class Node {
		Item  a; 
		Node next;
		Node(Item a){ this.a=a;}
		Node(){}
	}
	
	private class LinkedListIterator implements Iterator<Item>{
		Node node;
		int n;

		public LinkedListIterator() {
		node=first;
		n=size;
		}
		
		public Item next(){
			Item result = node.a;
			node=node.next;
			n--;
			return result;
		}
		
		public boolean hasNext(){ return n!=0;}
		
		public void remove(){}
		
	}
	
	public Iterator<Item> iterator() {
		return new LinkedListIterator();	
	}

	
	public LinkedListStack() {
	 first = new Node();
	 size=0;
	}
	
	void push(Item a){
	Node newFirst= new Node(a);
	Node oldFirst = first;
	newFirst.next=oldFirst;
	first=newFirst;
	size++;
	}
	
	Item pop(){
		//if(first!=null) {
		if(size!=0){
			Item pop=first.a;
			first= first.next;
			size--;
			return pop;
		} else {
			throw new NullPointerException("Stack is empty");
		}
		
	}
	
	boolean isEmpty(){
		//return first==null;
		return size==0;
	}
	
	int size(){
		return size;
	}
	
	public static void main(String[] args) {

		LinkedListStack<String> stack  =new LinkedListStack<String>();
		stack.push("hello");
		stack.push("bye");
		System.out.println(stack.size);
		System.out.println(stack.isEmpty());
		for(String s : stack) { System.out.println(s);}
		stack.pop();
		stack.pop();
		System.out.println(stack.isEmpty());
		System.out.println(stack.pop());
		System.out.println(stack.isEmpty());
		
	}

	
	

}

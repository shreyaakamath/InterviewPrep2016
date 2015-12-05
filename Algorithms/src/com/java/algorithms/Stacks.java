package com.java.algorithms;
import java.util.Iterator;

class FixedCapaciyStackOfStrings {
	String[] stack; 
	int counter; 
	
	FixedCapaciyStackOfStrings(int n ){
		stack = new String[n];
		counter=-1;
	}
	
	void push(String value){
		stack[++counter]= value;
	}
	
	String pop(){
		if(counter >=0) return stack[counter--];
		else return "emptyStack";
		
	}
	
	int size (){
		return counter;
	}
	
	boolean isEmpty(){
		return counter==0;
}
}

class ResizingArrayStack<Item> implements Iterable<Item> {
	Item[] stack; 
	int counter; 
	
	int size (){ return stack.length;}
	
	boolean isEmpty(){ return counter<0;}
	
	ResizingArrayStack(int n ){
		stack = (Item[])new Object[n];
		counter=-1;
	}
	
	void resize (int max) {
		Item[] temp = (Item[]) new Object[max];
		Item value;
		for(int i=0;i<=counter;i++){
			value=stack[i];
			temp[i]=stack[i];
		}
		stack=temp;
	}
	
	void push(Item value){
		if(counter == stack.length-1) resize(2*stack.length);
		stack[++counter]= value;
	}
	
	//if array is one fourth full then reduce the size of array by half 
	Item pop(){
		
		if(counter == stack.length/4) resize(stack.length/2);
		if(counter >=0) {Item value= stack[counter--]; stack[counter+1] = null;return value;}
		return (Item)"empty";
	}
	
	
	public Iterator<Item> iterator(){
	return new ReverseArrayIterator();
	}
	
	private class ReverseArrayIterator implements Iterator<Item> {
		int i=counter;
		public boolean hasNext(){ return i>=0 ; }
		public Item next () { return stack[	i--]; }
		public void remove () {}
		
	}
}

public class Stacks {

	public static void main(String[] args) {
		
		//FixedCapaciyStackOfStrings stack = new FixedCapaciyStackOfStrings(2);
		ResizingArrayStack<String> stack= new ResizingArrayStack<String>(2);
		
		stack.push("hello");
		stack.push("bye");
		stack.push("abc");
		System.out.println("size "+stack.size());
		for(String s : stack) {
			System.out.println(s);
		}
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
		System.out.println("is empty"+stack.isEmpty());
		System.out.println("size "+stack.size());
	}

}


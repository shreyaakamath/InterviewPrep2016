package stack.operations;

import java.util.LinkedList;

public class Stack<T>{
	LinkedList<T> list;
	
	public boolean isEmpty(){
		if(list==null||list.size()==0) return true;
		else return false;
	}
	
	public void push(T n){
		if(list==null) list = new LinkedList<T>();
		list.addFirst(n);
	}
	
	public T pop(){
		return list.removeFirst();
	}
	
	public T peek(){
		return list.peek();
	}
	
	public int size(){
		return list.size();
	}
	
	public void print(){
		for(T val:list) System.out.print(val+" ");
	}
	public static void main(String args[]){
		Stack<Integer> st = new Stack<Integer>();
		st.push(1);
		System.out.println(st.pop());
		System.out.println(st.isEmpty());
	}
}
package data.structures;

import java.util.ArrayList;
import java.util.List;

public class Stack<T> {
	List<T> a ; 
	int top;//top points to the last element pushed in to the stack else it will be -1
	
	Stack(int size){
		a = new ArrayList<T>(size);
		this.top=-1;
	}
	
	boolean isEmpty(){
		return top<0;
	}
	
	boolean isFull(){
		return top>=a.size();
	}
	void push(T n){
		if(!isFull()){a.add(++top, n);}
	}
	T pop(){
		T num = null;
		if(!isEmpty()){num= a.get(top--);}
		return num;
	}
	
	void printStackValues(){
		for(T num : a) System.out.println(num);
	}
	public static void main(String[] args) {
		Stack<String> s = new Stack<String>(5);
		s.push("hello");
		s.push("hi");
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
	}

}

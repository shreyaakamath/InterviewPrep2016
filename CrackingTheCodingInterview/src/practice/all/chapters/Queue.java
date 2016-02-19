package practice.all.chapters;

import java.util.LinkedList;

public class Queue<T> {
	LinkedList<T> q;
	
	Queue(){
		q= new LinkedList<T>();
	}
	void enqueue(T val){
		q.addLast(val);
	}
	
	T dequeue(){
		return q.removeFirst();
	}
	void print(){
		for(T i : q)
			System.out.println(i);
	}
	
	boolean isEmpty(){
		if(q==null) return true;
		if(q.size()==0) return true;
		return false;
	}
	public static void main(String[] args) {
		Queue<Integer> q= new Queue<Integer>();
		q.enqueue(1);
		q.enqueue(2);
		q.print();
		q.dequeue();
		q.print();
	}

}

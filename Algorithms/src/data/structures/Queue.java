package data.structures;

import java.util.ArrayList;
import java.util.List;

public class Queue<T> {
	List<T> a;
	int front;
	int back;
	int qSize;
	//add element to the back and remove from the front
	
	Queue(int size){
		a = new ArrayList<T>(size);
		front = 0;
		back =0;
		qSize=size;
	}
	
	void enqueue(T num){
		if(!isFull()) a.add(back++, num);
		else System.out.println("full cant push");
	}
	
	T dequeue(){
		T returnValue= null;
		if(!isEmpty()) returnValue= a.get(front++);
		else System.out.println("empty , nothing to pop");
		return returnValue;
	}
	
	boolean isEmpty(){
		return front == qSize;
	}
	boolean isFull(){
		return back == qSize;
	}
	public static void main(String[] args) {
		Queue<Integer> q1 = new Queue<Integer>(2);
		//if(q1.isFull() ) {System.out.println("full");}
		q1.enqueue(1);
		q1.enqueue(2);
		System.out.println("done with 2 nodes");
		q1.enqueue(3);
		System.out.println(q1.dequeue());
		System.out.println(q1.dequeue());
		System.out.println(q1.dequeue());
	}

}

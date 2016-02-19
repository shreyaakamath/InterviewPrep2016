package cracking.the.coding.interview;

class Stack{
	Node head;
	int min;
	
	void push(int data){
		Node n = new Node(data);
		if(head==null){ head=n;min=data;}
		else{
			n.next=head;head=n;
			if(data<min) min=data;
		}
	}
	int min(){
		return min;
	}
	int pop(){
		if(head==null) {min=0;return 0;}
		int n = head.data;
		head=head.next;
		if(min==n){
		}
		return n;
	}
	
	void print(){
		Node tmp=head;
		while(tmp!=null){
			System.out.print(tmp.data+" ");tmp=tmp.next;
		}
	}
	
	
}

class Queue{
	Node head;Node tail;
	
	void enqueue(int data){
		Node n = new Node(data);
		if(head==null){
			head=n;tail=n;
		}else{
			tail.next=n;tail=n;
		}
	}
	
	int dequeue(){
		if(head==null) return 0;
		int data=head.data;
		head=head.next;
		return data;
	}
	
	void print(){
		Node tmp=head;
		while(tmp!=null){
			System.out.print(tmp.data+" ");tmp=tmp.next;
		}
	}
}
public class StackQueue {
	
	static void stackTest(){
		Stack s = new Stack();
		s.push(1);s.push(2);s.push(3);
//		s.print();
//		System.out.println();
//		s.pop();s.pop();
//		s.print();
		System.out.println(s.min());
	}
	
	static void qTest(){
		Queue q = new Queue();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.print();
		System.out.println();
		q.dequeue();
		q.print();
	}
	public static void main(String[] args) {
		stackTest();
	}

}

package practice.all.chapters;

public class QueueStack {
	Stack<Integer> s1;
	Stack<Integer> s2;
	
	QueueStack(){
		s1=new Stack<Integer>();
		s2=new Stack<Integer>();
	}
	
	void enqueue(int val){
		s1.push(val);
	}
	
	int peek(){
		while(!s1.isEmpty()){ s2.push(s1.pop());}
		int val = s2.peek();
		while(!s2.isEmpty()){ s1.push(s2.pop());}
		return val;
	}
	
	int dequeue(){
		int val=0;
		if(!s2.isEmpty()) val = s2.pop();
		else {
			while(!s1.isEmpty()){ s2.push(s1.pop());}
			val=s2.pop();
		}
		return val;
	}
	public static void main(String[] args) {
		QueueStack q = new QueueStack();
		q.enqueue(1);
		q.enqueue(2);
		System.out.println(q.dequeue());
	}

}

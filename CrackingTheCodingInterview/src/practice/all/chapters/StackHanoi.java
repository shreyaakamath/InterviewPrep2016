package practice.all.chapters;

public class StackHanoi {
	Stack<Integer> start;
	Stack<Integer> interm;
	Stack<Integer> target;
	int disks;
	
	StackHanoi(int n){
		disks=n;
		start=new Stack<Integer>();
		interm=new Stack<Integer>();
		target=new Stack<Integer>();
		for(int i=disks-1;i>=0;i--) start.push(i);
	}
	void move(Stack<Integer> start , Stack<Integer> interm , Stack<Integer> target, int n){
		if(n==1) {target.push(start.pop());return;}
		move(start,target,interm,n-1);
		target.push(start.pop());
		move(interm,start,target,n-1);
	}
	
	void printTarget(){
//		System.out.println(target.pop());
		target.print();
	}
	void printStart(){
		start.print();
		System.out.println();
	}
	public static void main(String[] args) {
		StackHanoi hanoi = new StackHanoi(3);
		hanoi.printStart();
		hanoi.move(hanoi.start,hanoi.interm,hanoi.target,3);
		hanoi.printTarget();
	}

}

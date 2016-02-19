package practice.all.chapters;

import java.util.LinkedList;



class StackNode{
	int val;
	int prevMin;
	
	StackNode(int val){
		this.val=val;
	}
}
public class StackMin {
	LinkedList<StackNode> list;
	int min;
	
	StackMin(){
		list= new LinkedList<StackNode>();
		min=(int)Double.POSITIVE_INFINITY;
	}
	
	void push(int val){
		StackNode s = new StackNode(val);
		if(val<min){
			if(min==(int)Double.POSITIVE_INFINITY)s.prevMin=val;
			else s.prevMin=min; 
			min=val;
			}
		list.addFirst(s);
	}
	
	void pop(){
		if(list.isEmpty()) return;
		StackNode s = list.removeFirst();
		if(s.val==min){min=s.prevMin;}
	}
	int getMin(){
		if(list.isEmpty()) return -1;
		return min;
	}
	void print(){
		for(StackNode s: list){
			System.out.println("val="+s.val+" prevMin="+s.prevMin);
		}
	}
	public static void main(String[] args) {
		StackMin stack = new StackMin();
		stack.push(3);
		stack.push(1);
		stack.print();
		System.out.println(stack.getMin());
		stack.pop();
		System.out.println(stack.getMin());
		stack.pop();
		System.out.println(stack.getMin());
	}

}

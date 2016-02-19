package practice.all.chapters;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SetOfStacks {
	int capacity;
	int curLL;
	List<LinkedList<Integer>> stacks;
	
	SetOfStacks(int capacity){
		this.capacity=capacity;
		curLL=0;
		stacks=new ArrayList<LinkedList<Integer>>();
		stacks.add(0, new LinkedList<Integer>());
	}
	
	void setCurForPush(){
		if(stacks.get(curLL).size()>=capacity){
			curLL++;
			stacks.add(curLL, new LinkedList<Integer>());
		}
	}
	
	void setCurForPop(){
		if(stacks.get(curLL).size()==0) curLL--;
	}
	
	void push(int val){
		setCurForPush();
		stacks.get(curLL).addFirst(val);
	}
	
	void pop(){
		setCurForPop();
		stacks.get(curLL).removeFirst();
	}
	void print(){
		for(LinkedList<Integer> list : stacks){
			for(int i:list){
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		SetOfStacks stack = new SetOfStacks(2);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.print();
		stack.pop();
		stack.pop();
		stack.pop();
		System.out.println();
		stack.print();
	}

}

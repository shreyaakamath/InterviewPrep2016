package random.trial.stuff;

import java.util.LinkedList;


public  class NestedClass {

	static class Stack<T>{
		LinkedList<T> list = new LinkedList<T>();
		
		boolean isEmpty(){
			return list==null?true:false;
		}
		
		void push(T n){
			list.addFirst(n);
		}
		
		T pop(){
			return list.removeFirst();
		}
		
		T peek(){
			return list.getFirst();
		}
	}
	static void lis(int[] a){
	
	
	
	}
	
	public static void main(String[] args) {
		/*Stack class is nested in class NestedClass. This means it is associated with an instance of the class
		 * cannot do something like new stack() because it has to  associated with an instance of parent class
		 * make the nested class static -> then not associated with any class so can be called as below*/
		Stack<Integer> stack = new Stack<Integer>();
	}

}


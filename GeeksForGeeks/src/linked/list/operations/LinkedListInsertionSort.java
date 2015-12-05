/**
 * http://geeksquiz.com/insertion-sort-for-singly-linked-list/
 * deleted code by mistake -> need to re-do this 
 */
package linked.list.operations;
import java.util.Stack;


public class LinkedListInsertionSort{
	Node head;
	
	LinkedListInsertionSort(){
	}

	void add(int val) { 
		Node n1= new Node(val);
		if(head==null){
			head= n1;
		}else{
			n1.nxt=head;
			head=n1;
		}
	}
	
	void printList(){
		Node tmp=head;
		while(tmp!=null){
			System.out.print(tmp.val+" -> ");
			tmp=tmp.nxt;
		}
	}
	


	public static void main(String[] args) {
		LinkedListInsertionSort l1 = new LinkedListInsertionSort();
		l1.add(1);
		l1.add(2);
		l1.add(1);
		l1.printList();
	}
}

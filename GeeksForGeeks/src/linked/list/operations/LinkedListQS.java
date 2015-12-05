/**
 * http://www.geeksforgeeks.org/pairwise-swap-elements-of-a-given-linked-list/
 */
package linked.list.operations;
import java.util.Stack;


public class LinkedListQS{
	Node head;
	
	LinkedListQS(){
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
	
	void quickSort(){
		
	}
	

	public static void main(String[] args) {
		LinkedListQS l1 = new LinkedListQS();
		for(int i=1;i<6;i++)
			l1.add(i);
		l1.printList();
		System.out.println();
		l1.printList();
	}
}

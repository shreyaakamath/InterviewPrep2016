/**
 * http://www.geeksforgeeks.org/write-a-recursive-function-to-print-reverse-of-a-linked-list/
 */
package linked.list.operations;
import java.util.Stack;


public class LinkedListReversePrint{
	Node head;
	
	LinkedListReversePrint(){
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
	
	void reversePrint(Node n1){
		if(n1==null) return;
		reversePrint(n1.nxt);
		System.out.print(n1.val+" -> ");
	}
	

	public static void main(String[] args) {
		LinkedListReversePrint l1 = new LinkedListReversePrint();
		for(int i=1;i<5;i++)
			l1.add(i);
		l1.printList();
		System.out.println();
		l1.reversePrint(l1.head);
	}
}

/**
 * http://www.geeksforgeeks.org/pairwise-swap-elements-of-a-given-linked-list/
 */
package linked.list.operations;
import java.util.Stack;


public class LinkedListPairSwap{
	Node head;
	
	LinkedListPairSwap(){
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
	
	void swap(Node n , Node m){
		int temp=n.val;
		n.val =m.val;
		m.val =temp;
	}
	void swapPair(){
		Node tmp=head;
		while(tmp!=null && tmp.nxt!=null){
			swap(tmp,tmp.nxt);
			tmp=tmp.nxt.nxt;
		}
	
	}
	

	public static void main(String[] args) {
		LinkedListPairSwap l1 = new LinkedListPairSwap();
		for(int i=1;i<6;i++)
			l1.add(i);
		l1.printList();
		System.out.println();
		l1.swapPair();
		l1.printList();
	}
}

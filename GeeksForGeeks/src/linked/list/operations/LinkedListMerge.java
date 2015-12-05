/**
 * http://www.geeksforgeeks.org/merge-two-sorted-linked-lists/
 */
package linked.list.operations;
import java.util.Stack;


public class LinkedListMerge{
	Node head;
	
	LinkedListMerge(){
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
	
	Node merge(LinkedListMerge l2){
		Node h1=head;
		Node h2=l2.head;
		Node s=null;Node t=null;
		
		while(h1!=null && h2!=null){
			if(h1.val<h2.val){
				if(s==null){ s=h1;t=h1;}
				else{t.nxt=h1;t=h1;}
				h1=h1.nxt;
			}else{
				if(s==null){s=h2;t=h2;}
				else{t.nxt=h2;t=h2;}
				h2=h2.nxt;
			}
		}
		if(h1==null ^ h2==null){
			if(h1==null){
				t.nxt=h2;
			}else{
				t.nxt=h1;
			}
		}
		return s;
	}
	

	public static void main(String[] args) {
		LinkedListMerge l1 = new LinkedListMerge();
		l1.add(3);
		l1.add(2);
		l1.add(1);
		l1.printList();
		System.out.println();
		LinkedListMerge l2 = new LinkedListMerge();
		l2.add(9);
		l2.add(8);
		l2.add(7);
		l2.printList();
		Node s=l1.merge(l2);
		System.out.println();
		while(s!=null){
			System.out.print(s.val +" -> ");s=s.nxt;
		}
		l1.merge(l2);
		l1.printList();
	}
}

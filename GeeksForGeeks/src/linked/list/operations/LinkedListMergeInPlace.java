/**
 * http://www.geeksforgeeks.org/merge-two-sorted-linked-lists/
 */
package linked.list.operations;
import java.util.Stack;


public class LinkedListMergeInPlace{
	Node head;
	
	LinkedListMergeInPlace(){
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
	
	void merge(LinkedListMergeInPlace l2){
		Node h1=head;
		Node h2=l2.head;
		Node p=null;
		Node n1,n2;
		Node n;
		while(h1!=null && h2!=null){
			if(h1.val<h2.val){
				n=h1.nxt;
				if(p==null){
					h1.nxt=h2;
					p=h1;
				}else{
					p.nxt=h1;
					h1.nxt=h2;
					p=h1;
				}
				h1=n;
			} else{
				n=h2.nxt;
				if(p==null){
					h2.nxt=h1;
					head=h2;
					p=h2;
				}else{
					p.nxt=h2;
					h2.nxt=h1;
					p=h2;
				}
				h2=n;
			}
		}
		
	}
	

	public static void main(String[] args) {
		LinkedListMergeInPlace l1 = new LinkedListMergeInPlace();
		l1.add(9);
		l1.add(8);
		l1.add(7);
		l1.printList();
		System.out.println();
		LinkedListMergeInPlace l2 = new LinkedListMergeInPlace();
		l2.add(3);
		l2.add(2);
		l2.add(1);
		l2.printList();
		l1.merge(l2);
		System.out.println();
		l1.printList();
	}
}

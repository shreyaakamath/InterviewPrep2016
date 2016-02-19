/**
 *Prob 1) http://www.geeksforgeeks.org/merge-two-sorted-linked-lists/
 *Prob 2) sort a linked list using merge sort
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
	
	Node mergePlain(LinkedListMerge l2){
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
	
	Node merge(Node n1 , Node n2 , int length){
		Node n = n2;
		for(int k=0;k<length;k++)
			n=n.nxt;
		Node head=null;Node tail=null;int i=0;int j=0;
		while(i!=length && j!=length){
			if(n1.val < n2.val){
				if(head==null){
					head=n1;tail=n1;
					n1=n1.nxt;i++;
				}else{
					tail.nxt=n1;tail=n1;
					n1=n1.nxt;i++;
				}
			}else{
				if(head==null){
					head=n2;tail=n2;
					n2=n2.nxt;j++;
				}else{
					tail.nxt=n2;tail=n2;
					n2=n2.nxt;j++;
				}
			}
		}
		if(i==length) {
			while(j!=length){
				tail.nxt=n2;tail=n2;
				n2=n2.nxt;j++;
			}
		}
		if(j==length) {
			while(i!=length){
				tail.nxt=n1;tail=n1;
				n1=n1.nxt;i++;
			}
		}
		tail.nxt=n;
		return head;
	}
	Node sort(Node start , int length){
		if(length==1) return start;
		Node mid=start;
		for(int i=0;i<length/2;i++){
			mid=mid.nxt;
		}
		start=sort(start,length/2);
		mid=sort(mid,length/2);
		return merge(start,mid,length/2);
	}
	public static void main(String[] args) {
		LinkedListMerge l1 = new LinkedListMerge();
		l1.add(4);
		l1.add(3);
		l1.add(10);
		l1.add(2);
		l1.head = l1.sort(l1.head,4);
		l1.printList();
	}
	
	
	void testMergeTwoLL(){
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
		Node s=l1.mergePlain(l2);
		System.out.println();
		while(s!=null){
			System.out.print(s.val +" -> ");s=s.nxt;
		}
		l1.mergePlain(l2);
		l1.printList();
	}
}

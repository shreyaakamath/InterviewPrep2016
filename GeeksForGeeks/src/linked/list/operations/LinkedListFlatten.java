/**
 * http://www.geeksforgeeks.org/flattening-a-linked-list/
 */
package linked.list.operations;
import java.util.Stack;


public class LinkedListFlatten{
	Node head;
	
	LinkedListFlatten(){
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
	
	Node merge(Node l1,Node l2){
		Node h1=l1;
		Node h2=l2;
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
				if(t!=null){
					t.nxt=h2;
				}else{
					s=h2;
				}
			}else{
				if(t!=null){
				t.nxt=h1;
				}else{
					s=h1;
				}
			}
		}
		return s;
	}
	
	Node flatten(){
		Node merged=null;
		Node tmp=head;
		
		while(tmp!=null){
		merge(merged,new Node(tmp.val));
		merge(merged,tmp.child);
		tmp=tmp.nxt;
		}
		return merged;
	}
	public static void main(String[] args) {
		LinkedListFlatten l1 = new LinkedListFlatten();
		l1.add(3);
		l1.add(2);
		l1.add(1);
		l1.printList();
		Node s=l1.flatten();
		System.out.println();
		while(s!=null){
			System.out.print(s.val +" -> ");s=s.nxt;
		}
		l1.printList();
	}
}

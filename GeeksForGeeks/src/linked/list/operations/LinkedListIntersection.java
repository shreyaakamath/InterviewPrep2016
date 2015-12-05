/**
 * http://www.geeksforgeeks.org/write-a-function-to-get-the-intersection-point-of-two-linked-lists/
 */
package linked.list.operations;
import java.util.Stack;


public class LinkedListIntersection{
	Node head;
	
	LinkedListIntersection(){
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
	
	
	Node interVisited(LinkedListIntersection l2){
		Node h1=head;
		Node h2=l2.head;
		Node inter=null;
		while(h1!=null || h2!=null){
			if(h1!=null){
				if(!h1.visited){
				h1.visited=true;
				h1=h1.nxt;
				}else{
					inter=h1;break;
				}
			}
			
			if(h2!=null){
				if(!h2.visited){
					h2.visited=true;
					h2=h2.nxt;
				}else{
					inter=h2;break;
				}
			}
		}
		return inter;
	}

	Node interAddress(LinkedListIntersection l2){
		Node tmp1=head;
		Node tmp2=l2.head;
		int len1=0;
		int len2=0;
		Node longer=null;
		Node shorter =null;
		Node inter=null;
		while(tmp1!=null){len1++;tmp1=tmp1.nxt;}
		while(tmp2!=null){len2++;tmp2=tmp2.nxt;}
		int d;
		if(len1>len2){
			d=len1-len2;longer=head;shorter=l2.head;
		}else{
			d=len2-len1;longer=l2.head;shorter=head;
		}
		int i=1;
		while(i<=d){
			longer=longer.nxt;
			i++;
		}
		while(longer!=null){
			if(longer==shorter){
				inter=longer;
				break;
			}else{
				longer=longer.nxt;
				shorter=shorter.nxt;
			}
		}
		return inter;
	}
	public static void main(String[] args) {
		LinkedListIntersection l1 = new LinkedListIntersection();
		for(int i=1;i<5;i++)
		l1.add(i);
		l1.printList();
		LinkedListIntersection l2 = new LinkedListIntersection();
		System.out.println();
		l2.head=l1.head.nxt.nxt;
		l2.printList();
		Node tmp=l1.interVisited(l2);
		System.out.println();
		System.out.println(tmp.val);
		tmp=l1.interAddress(l2);
		System.out.println();
		System.out.println(tmp.val);
	}
}

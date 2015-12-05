/**
 * http://www.geeksforgeeks.org/pairwise-swap-elements-of-a-given-linked-list/
http://learningarsenal.info/index.php/2015/08/24/detecting-start-of-a-loop-in-singly-linked-list/
 */
package linked.list.operations;
import java.util.Stack;


public class LinkedListCycle{
	Node head;
	
	LinkedListCycle(){
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
	
	boolean cycle(){
		boolean iscycle=false;
		Node tmp=head;
		Node prev=null;
		while(tmp!=null){
			if(tmp.visited){
				iscycle=true;
				prev.nxt=null;
				break;
			}
			tmp.visited=true;
			prev=tmp;
			tmp=tmp.nxt;
		}
		return iscycle;
	}
	
	boolean floydCycle(){
		Node slow=head;
		Node fast=head;
		Node meet=null;
		boolean isCycle=false;
		while(fast!=null){
			fast=fast.nxt;
			if(fast.nxt!=null){
				fast=fast.nxt;slow=slow.nxt;
			}
			if(fast==slow){
				isCycle=true;
				break;
			}
		}
		if(isCycle){
			slow=head;
			while(fast!=slow){
				meet=fast;
				fast=fast.nxt;
				slow=slow.nxt;
			}
			meet=fast;
		}
		meet.nxt=null;
		return isCycle;
	}

	public static void main(String[] args) {
		LinkedListCycle l1 = new LinkedListCycle();
		for(int i=1;i<6;i++)
			l1.add(i);
		l1.head.nxt.nxt.nxt.nxt=l1.head.nxt;
		//System.out.println(l1.cycle());
		System.out.println(l1.floydCycle());
		l1.printList();
	}
}

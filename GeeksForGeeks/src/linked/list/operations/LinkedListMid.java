package linked.list.operations;
import java.util.Stack;


public class LinkedListMid{
	Node head;
	
	LinkedListMid(){
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
	
	void middle(){
		int len=0;
		Node tmp=head;
		while(tmp!=null){
			len++;
			tmp=tmp.nxt;
		}
		int i=0;
		len/=2;
		tmp=head;
		while(i!=len){tmp=tmp.nxt;i++;}
		System.out.println(tmp.val);
	}
	
	Node middlePtr(){
		Node slow=head;
		Node fast=head;
		
		if(head!=null){
			while(fast.nxt!=null && fast.nxt.nxt!=null){
				slow=slow.nxt;
				fast=fast.nxt.nxt;
			}
		}
		return slow;
	}
	public static void main(String[] args) {
		LinkedListMid l1 = new LinkedListMid();
		for(int i=6;i>=1;i--)
			l1.add(i);
			l1.printList();
			System.out.println(l1.middlePtr().val);
	}
}

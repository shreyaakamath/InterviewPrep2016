package linked.list.operations;
import java.util.Stack;


public class LinkedListSwap{
	Node head;
	
	LinkedListSwap(){
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
	
	void swap(int m,int n){
		Node tmp=head;
		Node prev=null;
		Node p1 =null;
		Node n1 =null;
		Node p2 =null;
		Node n2=null;
		Node u =null;
		Node v =null;
		while(tmp!=null){
			if(tmp.val==m){
				p1=prev;
				n1=tmp.nxt;
				u=tmp;
			}
			if(tmp.val==n){
				p2=prev;
				n2=tmp.nxt;
				v=tmp;
			}
			
			prev=tmp;
			tmp=tmp.nxt;
		}
		if(u==null||v==null)
			return ;
		if(p1==null){
			v.nxt=head.nxt;
			head=v;
			if(p2==null){
				p2.nxt=u;
				u.nxt=null;
			}else{
				p2.nxt=u;
				u.nxt=n2;
			}
		}else if(n1.val==n && p2.val==m){
			p1.nxt=v;
			v.nxt=u;
			u.nxt=n2;
		}else {
			p1.nxt=v;
			v.nxt=n1;
			
			p2.nxt=u;
			u.nxt=n2;
		}
	}

	public static void main(String[] args) {
		LinkedListSwap l1 = new LinkedListSwap();
		for(int i=6;i>=1;i--)
			l1.add(i);
		System.out.println();
		l1.swap(2,3);
		System.out.println();
	}
	}

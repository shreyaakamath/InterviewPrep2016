package practice.all.chapters;

class Node{
	int data;
	Node nxt;
	
	Node(int data){
		this.data=data;
	}
}
public class LinkedList {
	Node head;
	Node tail;
	
	void insert(int data){
		Node n = new Node(data);
		if(head==null) {head=n;tail=n;}
		else{ tail.nxt=n;tail=tail.nxt;}
	}
	static Node add(Node n1 , Node n2 , int carry){
		int v1,v2,v3,ans;
		if(n1==null && n2==null) return null;
		v1= n1==null?0:n1.data; 
		v2= n2==null?0:n2.data;
		v3=v1+v2+carry;
		if(v3>0) {ans=v3%10;carry=v3/10;}
		else ans=v3;
		Node n3= new Node(ans);
		n3.nxt=add(n1==null?n1:n1.nxt,n2==null?n2:n2.nxt,carry);
		return n3;
	}
	static void print(Node n){
		Node tmp=n;
		while(tmp!=null){
			System.out.println(tmp.data);tmp=tmp.nxt;
		}
	}
	
	static Node loopStart(Node head){
		Node slow=head;
		Node fast =head;
		/*find meeting point*/
		while(fast.nxt!=null){
			slow=slow.nxt;
			fast=fast.nxt.nxt;
			if(slow==fast) break;
		}
		
		/*find starting point*/
		slow=head;
		while(slow!=fast){
			slow=slow.nxt;
			fast=fast.nxt;
		}
		return slow;
	}
	
	public static void main(String[] args) {
		LinkedList l1 = new LinkedList();
		l1.insert(3);
		l1.insert(1);
		l1.insert(5);
		LinkedList l2 = new LinkedList();
		l2.insert(5);
		l2.insert(9);
		l2.insert(2);
//		Node n3=add(l1.head,l2.head,0);
//		print(n3);
		l1.head.nxt.nxt.nxt=l1.head.nxt;
		System.out.println(loopStart(l1.head).data);
		}

}

package data.structures;


public class CircularLinkedList<T> {
	Node head;
	Node tail;
	
	class Node{
		T value ; 
		Node next;
		Node prev;
		
		Node(T num,Node prev , Node next){
			value = num;
			this.prev = prev;
			this.next=next;
			}
	}
	
	void addNode(T num){
	if(head == null){
		head = new Node(num,null,null);
		head.next=head;
		head.prev=head;
		tail = head;
	}else{
		Node n1 = new Node(num,tail,head);
		head.prev = n1;
		tail.next =n1;
		head = n1;
	}
	}
	
	void printNodes(){
		if(!isEmpty()){
			Node n1 = head;
			do {
				System.out.println(n1.value);
				n1=n1.next;
			}while(n1!= head);
		}
	}
	
	boolean isEmpty(){
		boolean returnValue = false;
		if(head == null) returnValue= true;
		return returnValue;
	}
	void removeNode(T num){
	if(!isEmpty()){
		Node n1 = head;
		do{
			if(n1.value==num){
				if(n1.next==n1){
					head = null;tail = null;break;
				}
				Node prev = n1.prev;
				Node next = n1.next;
				prev.next=next;
				next.prev=prev;
				break;
			}
			System.out.println("hello");
			n1=n1.next;
		}while(n1!=head);
	}
	}
	
	void pop(){
	if(!isEmpty()){
		Node n1 = head.next;
		//only ine node in the LL
		if(n1==head){
			head=tail=null;
		}else{
		n1.prev=tail;
		tail.next=n1;
		head =n1;
		}
	}
	}
	
	void dequque(){
	if(!isEmpty()){
		Node n1 = tail;
		if(n1.next==tail){
			head=tail=null;
		}else{
		n1.prev.next = n1.next;
		n1.next.prev = n1.prev;
		tail = n1.prev;
		}
	}
	}
	
	public static void main (String args[]){
		CircularLinkedList<Integer> c1 = new CircularLinkedList<Integer>();
		c1.addNode(1);
		c1.addNode(2);
		c1.addNode(3);
		c1.printNodes();
		c1.dequque();
		c1.dequque();
		c1.dequque();
		c1.dequque();
		System.out.println("---after remove---");
		c1.printNodes();
	}
}

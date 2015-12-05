package data.structures;

public class DoubleLinkedList<T> {
	Node head;
	Node tail;
	
	class Node<T>{
		private T value;
		private Node next;
		private Node prev;
		
		Node(T value , Node next , Node prev){
			this.value = value;
			this.next=next;
			this.setPrev(prev);
		}

		public Node getPrev() {
			return prev;
		}

		public void setPrev(Node prev) {
			this.prev = prev;
		}
		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

	}

	void addNode(T value){
		//if linkedlist is currently empty 
		if(head == null){
			head = new Node<T>(value, null, null);
			tail=head;
		} else{
			//this is not the first node 
			Node<T> newNode = new Node<T>(value, head, null);
			head.setPrev(newNode);
			tail = head;
			head = newNode;
		}
	}

	boolean isEmpty(){
		boolean returnValue = false;
		if(head == null){returnValue =true;}
		return returnValue;
	}
	
	void removeNode(T num){
		if(!isEmpty()){
			Node n1 = head;
			
			while(n1!=null){
				if(n1.value == num ){
					//only element 
					if(n1.getNext()==null && n1.getPrev()==null){
						head = null;
						break;
					}
					//first element 
					else if(n1.getPrev()==null){
						n1.getNext().setPrev(null);
						head = n1.getNext();
					}
					//last element 
					else if(n1.getNext()==null){
						n1.getPrev().setNext(null);
						tail = n1.getPrev();
					} else {
						//middle element
						Node prev = n1.getPrev();
						Node next = n1.getNext();
						next.setPrev(prev);
						prev.setNext(next);
					}
					break;
				} else {
					n1=n1.getNext();
				}
			}
		}
	}
	void printList(){
		if(!isEmpty()){
			Node n1 = head; 
			while(n1!=null){
				System.out.println(n1.value);
				n1=n1.getNext();}
		}
	}
	public static void main(String[] args) {
	DoubleLinkedList<Integer> linkedList = new DoubleLinkedList<Integer>();
	linkedList.addNode(1);
	linkedList.addNode(2);
	linkedList.removeNode(1);
	linkedList.removeNode(2);
	linkedList.removeNode(5);
	linkedList.printList();
	}
}

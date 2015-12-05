package data.structures;

public class DoubleLinkedList {
	ListNode head ; 
	
	DoubleLinkedList(){
		head = null;
	}
	
	/*insert element into the front of the list*/
	void insert(int val){
		ListNode n1  = new ListNode(null,head,val);
		if(head != null)
		head.prev = n1;
		head = n1;
	}
	
	/*assume the list is sorted , insert the element so that list remains sorted. smallest at head , largest at tail*/
	void insertSorted(int val){
		ListNode n1 = new ListNode(null,null,val);
		
		ListNode prev = null;ListNode present = head ; 
		while(present!=null){
			if(val<present.val) {
				//insert between prev and present 
				n1.next = present;
				present.prev = n1;
				n1.prev = prev;
				if(prev!=null) prev.next = n1;
				if(present == head) head = n1;
				return;
			}
			prev = present;
			present = present.next;
		}
		//head is null . make new node head
		if(prev == null) {
			head = n1;
		} else {//insert node at end of list
			prev.next = n1;
			n1.prev = prev;
		}
	}
	
	/*delete element from list*/
	void delete(int val){
		ListNode n = head ; 
		while(n != null){
			if(n.val == val){
				if(n.prev != null)n.prev.next = n.next;
				else head = n.next;
				if(n.next != null) n.next.prev = n.prev;
			}
			n = n.next;
		}
	}
	
	/*from head till the end*/
	void printLinkedList(){
		ListNode n1 = head;
		while(n1!=null){
			System.out.print(n1.val+" ");
			n1 = n1.next;
		}
		System.out.println();
	}
	
	boolean exists(int val){
		ListNode n1 = head ; 
		boolean flag=false;
		while(n1!=null){
			if(n1.val == val ) flag = true;
			n1 = n1.next;
		}
		return flag;
	}
	
	public static void main(String[] args) {
		DoubleLinkedList d1 = new DoubleLinkedList();
		d1.insertSorted(3);
		d1.insertSorted(1);
		d1.insertSorted(2);
		d1.printLinkedList();
		/*
		d1.insert(2);
		d1.insert(3);
		d1.printLinkedList();
		System.out.println(d1.exists(2));
		System.out.println(d1.exists(3));
		d1.delete(2);
		d1.printLinkedList();
		d1.delete(3);*/
	}
}

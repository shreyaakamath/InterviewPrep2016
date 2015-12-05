package data.structures;

public class ListNode {
	ListNode prev ;
	ListNode next ; 
	int val ; 
	ListNode(ListNode prev , ListNode next , int val){
		this.next = next ; 
		this.prev = prev;
		this.val = val;
	}	
}

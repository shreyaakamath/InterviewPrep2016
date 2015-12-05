/**
 * http://www.geeksforgeeks.org/function-to-check-if-a-singly-linked-list-is-palindrome/
 */
package linked.list.operations;
import java.util.Stack;


public class LinkedListPalindrome{
	Node head;
	
	LinkedListPalindrome(){
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
	
	
	boolean palindrome(){
		Stack<Integer> s = new Stack<Integer>();
		Node tmp=head;
		while(tmp!=null){
			s.push(tmp.val);
			tmp=tmp.nxt;
		}
		
		tmp=head;
		while(tmp!=null && tmp.val == s.pop()){
			tmp=tmp.nxt;
		}
		if(tmp==null) return true;
		else return false;
	}

	public static void main(String[] args) {
		LinkedListPalindrome l1 = new LinkedListPalindrome();
		l1.add(1);
		l1.add(2);
		l1.add(1);
		l1.printList();
		System.out.println(l1.palindrome());
	}
}

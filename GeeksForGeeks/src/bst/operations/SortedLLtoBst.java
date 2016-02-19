package bst.operations;

import binary.tree.operations.TreeNode;

class LLNode1{
	int val;
	LLNode1 next;
}

public class SortedLLtoBst {
	LLNode1 head;
	
	TreeNode construct(int start , int end){
		if(start>end) return null;
		
		int mid=(start+end)/2;
		
		TreeNode left=construct(start,mid-1);
		
		TreeNode node = new TreeNode(head.val);
		head=head.next;
		
		TreeNode right=construct(mid+1,end);
		
		node.left=left;
		node.right=right;
		
		return node;
			
	}
	
	public static void main(String[] args) {

	}

}

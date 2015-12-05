/**
 * http://www.geeksforgeeks.org/convert-an-arbitrary-binary-tree-to-a-tree-that-holds-children-sum-property/
 */
package binary.tree.operations;

import java.util.LinkedList;
import java.util.Queue;

public class ConvertChildSum {
	TreeNode root;
	
	void adjust(TreeNode n1){
		if(n1.left==null && n1.right==null) return;
		adjust(n1.left);
		adjust(n1.right);
		int val=n1.val;
		int left=0;int right=0;
		if(n1.left!=null)left=n1.left.val;
		if(n1.right!=null)right = n1.right.val;
		if(val < (left+right)){val=(left+right);n1.val=val;}
		else{ left+=(val-left-right);n1.left.val=left;adjust(n1.left);}
		n1.left.val=left;n1.right.val=right;n1.val=val;
	}
	public static void  main(String args[]){
		ConvertChildSum n1 = new ConvertChildSum();
		n1.root=CommonOperations.create();
		CommonOperations.print(n1.root);
		n1.adjust(n1.root);
		CommonOperations.print(n1.root);
	}
	
}



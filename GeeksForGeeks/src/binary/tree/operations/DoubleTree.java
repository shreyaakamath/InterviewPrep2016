/*
 * http://www.geeksforgeeks.org/double-tree/
 */
package binary.tree.operations;

import java.util.LinkedList;
import java.util.Queue;

public class DoubleTree {
	TreeNode root;
	
	void doubleT(TreeNode root){
		if(root ==null) return;
		TreeNode dup = new TreeNode(root.val);
		TreeNode left=root.left;
		root.left=dup;
		dup.left=left;
		doubleT(dup.left);
		doubleT(root.right);
	}
	
	public static void main(String args[]){
	DoubleTree t1= new DoubleTree();
	t1.root=CommonOperations.create();
	CommonOperations.print(t1.root);
	t1.doubleT(t1.root);
	CommonOperations.print(t1.root);
	}
}

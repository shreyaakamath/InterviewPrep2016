/*
 * http://www.geeksforgeeks.org/write-an-efficient-c-function-to-convert-a-tree-into-its-mirror-tree/
 */
package binary.tree.operations;

import java.util.LinkedList;
import java.util.Queue;

public class MirrorTree {
	TreeNode root;
	
	void mirror(TreeNode n){
		if(n==null) return;
		TreeNode tmp;
		tmp=n.right;
		n.right=n.left;
		n.left=tmp;
		mirror(n.left);
		mirror(n.right);
	}
	
	public static void main(String args[]){
	MirrorTree t1= new MirrorTree();
	t1.root=CommonOperations.create();
	CommonOperations.print(t1.root);
	t1.mirror(t1.root);
	CommonOperations.print(t1.root);
	}
}

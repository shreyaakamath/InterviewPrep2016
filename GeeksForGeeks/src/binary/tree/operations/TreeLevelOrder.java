package binary.tree.operations;

/*
 * http://www.geeksforgeeks.org/level-order-tree-traversal/
 */

public class TreeLevelOrder {
TreeNode root;

void level(TreeNode n1){
	if(n1.left==null) return;
	if(n1.right ==null) return;
	System.out.print(n1.left.val+",");
	System.out.print(n1.right.val);
	System.out.println();
	level(n1.left);
	level(n1.right);
}

public static void main(String args[]){
	TreeLevelOrder n1 = new TreeLevelOrder();
	n1.root=CommonOperations.create();
	System.out.print(n1.root.val+ " ");
	n1.level(n1.root);
}
}

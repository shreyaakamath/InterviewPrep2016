/**
 * http://www.geeksforgeeks.org/write-a-c-program-to-get-count-of-leaf-nodes-in-a-binary-tree/
 */
package binary.tree.operations;

public class LeafNodes {
	TreeNode root;
	
	int leaf(TreeNode n1){
		if(n1.left==null && n1.right==null) return 1;
		int left=leaf(n1.left);
		int right=leaf(n1.right);
		return left+right;
	}
	
	public static void  main(String args[]){
		LeafNodes n1 = new LeafNodes();
		n1.root=CommonOperations.create();
		System.out.println(n1.leaf(n1.root));
		
	}
	
}



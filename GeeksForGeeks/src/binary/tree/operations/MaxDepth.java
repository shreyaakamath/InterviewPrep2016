/**
 * http://www.geeksforgeeks.org/write-a-c-program-to-find-the-maximum-depth-or-height-of-a-tree/
 */
package binary.tree.operations;

public class MaxDepth {
	TreeNode root;
	
	void create(){
		root = new TreeNode(1);
		root.left=new TreeNode(2);
		root.right=new TreeNode(3);
		
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		
//		root.left.left.left = new TreeNode(11);
	}
	int depth(TreeNode n){
		if(n==null) return 0;
		int left = depth(n.left);
		int right= depth(n.right);
		if(left>right)
			return left+1;
		else return right+1;
	}
	
	public static void main(String args[]){
	MaxDepth t1= new MaxDepth();
	t1.create();
	System.out.println(t1.depth(t1.root)-1);
	}
}

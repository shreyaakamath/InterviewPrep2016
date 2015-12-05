/**
 * http://www.geeksforgeeks.org/write-c-code-to-determine-if-two-trees-are-identical/
 */
package binary.tree.operations;

public class IdenticalTree {
	TreeNode root;
	
	void create(){
		root = new TreeNode(1);
		root.left=new TreeNode(2);
		root.right=new TreeNode(3);
		
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
	}

	boolean check(TreeNode r1,TreeNode r2){
		if(r1==null && r2==null) return true;
		else if (r1==null ^ r2==null) return false;
		return r1.val==r2.val &&
				check(r1.left,r2.left) &&
				check(r1.right,r2.right);
	}
	
	public static void main(String args[]){
		IdenticalTree t1=new IdenticalTree();
		t1.create();
		IdenticalTree t2=new IdenticalTree();
		t2.create();
		t2.root.left.val=3;
		System.out.println(t1.check(t1.root,t2.root));
	}
}

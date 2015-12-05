package data.structures;

public class TreeNode {

	TreeNode left;
	TreeNode right;
	TreeNode p;
	int key; 
	
	TreeNode(TreeNode left ,TreeNode right , TreeNode p , int key ){
		this.left = left;
		this.right = right ; 
		this.p = p ; 
		this.key = key;
	}
}

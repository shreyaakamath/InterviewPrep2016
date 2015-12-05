/*
 * http://www.geeksforgeeks.org/inorder-predecessor-successor-given-key-bst/
 */
package bst.operations;

import binary.tree.operations.TreeNode;

public class PredSuccBst {
	TreeNode root;
	int succ;
	PredSuccBst(){
		root = new TreeNode(50);
		succ=0;
		BstCommonOperations.generateBst(root);
	}
	boolean isLeaf(TreeNode n1){
		return n1.left==null&&n1.right==null?true:false;
	}
	
	
	int pred(TreeNode n1,int val){
		if(n1==null) return 0;
		if(val<n1.val){
			if(n1.left.val==val){
				if(n1.left.right!=null) succ=n1.left.right.val;
				else succ =0;
				return n1.val;
				}
			if(isLeaf(n1.left)){
				if(val>n1.left.val){
					succ=n1.left.val;
					return n1.val;
					}
			}
			return pred(n1.left,val);
		} else {
			if(n1.right.val==val){
				if(n1.right.right!=null) succ = n1.right.right.val;
				else succ=0;
				return n1.val;
				}
			if(isLeaf(n1.right)){
				if(val<n1.right.val){
					succ=n1.right.val;
					return n1.val;
					}
			}
			return pred(n1.right,val);
		}
	}
	TreeNode search(TreeNode n1,int val){
		if(n1==null) return null;
		if(val==n1.val) return n1;
		if(val<n1.val) return search(n1.left,val);
		if(val>=n1.val) return search(n1.right,val);
		else return null;
	}
	
	
	public static void main(String[] args) {
		PredSuccBst n1 = new PredSuccBst();
		
		int pred=0;
		System.out.println(n1.pred(n1.root,70));
		System.out.println(n1.succ);
	}

}

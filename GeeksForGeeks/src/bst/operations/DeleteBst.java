/**
 * http://geeksquiz.com/binary-search-tree-set-2-delete/
 */
package bst.operations;

import binary.tree.operations.TreeNode;

public class DeleteBst {

	TreeNode root;
	DeleteBst(){
		root = new TreeNode(50);
		BstCommonOperations.generateBst(root);
	}
	
	TreeNode search(TreeNode n1,int val){
		if(n1==null) return null;
		if(val==n1.val) return n1;
		if(val<n1.val) return search(n1.left,val);
		if(val>=n1.val) return search(n1.right,val);
		else return null;
	}
	
	boolean isLeaf(TreeNode n1){
		 return n1.left==null && n1.right==null?true:false;
	}
	void delete(TreeNode n1){
		if(n1==null) return;
		if(isLeaf(n1)){
			TreeNode tmp=root;
			while(true){
				if(tmp.left.val==n1.val){tmp.left=null;return;}
				if(tmp.right.val==n1.val){tmp.right=null;
				return;}
				else if(n1.val<tmp.val){tmp=tmp.left;}
				else{tmp=tmp.right;}
			}
		}
		int val = n1.right.val;
		delete(n1.right);
		n1.val=val;
		
	}

	public static void main(String[] args) {
		DeleteBst n1 = new DeleteBst();
		BstCommonOperations.print(n1.root);
		n1.delete(n1.search(n1.root,50));
		BstCommonOperations.print(n1.root);
	}

}

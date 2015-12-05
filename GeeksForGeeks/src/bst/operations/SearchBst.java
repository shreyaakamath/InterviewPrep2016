package bst.operations;

import binary.tree.operations.TreeNode;

public class SearchBst {

	TreeNode root;
	SearchBst(){
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
	
	public static void main(String[] args) {
		SearchBst n1 = new SearchBst();
		BstCommonOperations.print(n1.root);
		System.out.println(n1.search(n1.root,80).val);
	}

}

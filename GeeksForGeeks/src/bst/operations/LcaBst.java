/*
 * http://www.geeksforgeeks.org/lowest-common-ancestor-in-a-binary-search-tree/
 */
package bst.operations;

import binary.tree.operations.TreeNode;

public class LcaBst {

	TreeNode root;
	
	void generateBst(){
		insert(root,50);
		insert(root,30);
		insert(root,20);
		insert(root,40);
		insert(root,70);
		insert(root,60);
		insert(root,80);
	}
	 void insert(TreeNode n1,int val){
		 if(root==null){root=new TreeNode(val);}
		if(n1==null) {return;}
		if(val<n1.val){
			if(n1.left==null){n1.left=new TreeNode(val);return;}
			else insert(n1.left,val);
		}
		else if(val>=n1.val) {
			if(n1.right==null){n1.right=new TreeNode(val);return;}
			insert(n1.right,val);
		}
	}
	 
	TreeNode lca(TreeNode n1,int a,int b){
		if(n1==null) return n1;
		int val=n1.val;
		if(a<val && b<val){return lca(n1.left,a,b);}
		else if(a>val && b>val){return lca(n1.right,a,b);}
		else if(a<val && b>=val){return n1;}
		else if(a>=val && b<val){return n1;}
		return n1;
	}
	

	public static void main(String[] args) {
		LcaBst t1 = new LcaBst();
		t1.generateBst();
		BstCommonOperations.print(t1.root);
		TreeNode lca=t1.lca(t1.root,20,70);
		System.out.println(lca.val);
		
	}

}

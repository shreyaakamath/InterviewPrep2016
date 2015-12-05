/*
 * http://www.geeksforgeeks.org/find-k-th-smallest-element-in-bst-order-statistics-in-bst/
* http://www.geeksforgeeks.org/kth-largest-element-in-bst-when-modification-to-bst-is-not-allowed/http://www.geeksforgeeks.org/kth-largest-element-in-bst-when-modification-to-bst-is-not-allowed/
 */
package bst.operations;

import binary.tree.operations.TreeNode;

public class smallestBst {

	TreeNode root;
	int cnt=0;
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
	
	void inorder(TreeNode n1,int k ){
		if(n1==null) return;
		inorder(n1.left,k);
		cnt++;
		if(cnt==k)System.out.println(n1.val);
		inorder(n1.right,k);
	}
	
	public static void main(String[] args) {
		smallestBst t1 = new smallestBst();
		t1.generateBst();
		//BstCommonOperations.print(t1.root);
		t1.inorder(t1.root,2);
		Integer n = new Integer(2);
		n=3;
		System.out.println(n);
	}

}

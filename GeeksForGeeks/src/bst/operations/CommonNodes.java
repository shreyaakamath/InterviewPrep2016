/*
 * http://www.geeksforgeeks.org/print-common-nodes-in-two-binary-search-trees/
 */
package bst.operations;

import java.util.ArrayList;
import java.util.List;

import binary.tree.operations.TreeNode;

public class CommonNodes {

	TreeNode root;
	int cnt=0;
	void generateBst(){
		insert(root,5);
		insert(root,1);
		insert(root,10);
		insert(root,0);
		insert(root,4);
		insert(root,7);
		insert(root,9);
	}
	
	void generateBst1(){
		insert(root,10);
		insert(root,20);
		insert(root,4);
		insert(root,7);
		insert(root,9);
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
	
	 void inorder(TreeNode n1,List<Integer> a){
			if(n1==null) return;
			inorder(n1.left,a);
			a.add(n1.val);
			inorder(n1.right,a);
		}
	 
	 void commonNodes(TreeNode n1,List<Integer> a){
		if(n1==null) return;
		commonNodes(n1.left,a);
		if(a.contains(n1.val)) System.out.print(n1.val+" ");
		commonNodes(n1.right,a);
	 }
	
	public static void main(String[] args) {
		CommonNodes t1 = new CommonNodes();
		t1.generateBst();
		CommonNodes t2 = new CommonNodes();
		t2.generateBst1();
		List<Integer> l1 = new ArrayList<Integer>();
		t1.inorder(t1.root,l1);
		t2.commonNodes(t2.root,l1);
	}

}

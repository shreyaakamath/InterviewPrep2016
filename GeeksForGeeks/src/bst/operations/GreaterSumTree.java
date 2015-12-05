/*
* http://www.geeksforgeeks.org/transform-bst-sum-tree/
 */
package bst.operations;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import binary.tree.operations.TreeNode;

public class GreaterSumTree {

	TreeNode root;
	int cnt=0;
	void generateBst(){
		insert(root,11);
		insert(root,2);
		insert(root,1);
		insert(root,7);
		insert(root,29);
		insert(root,15);
		insert(root,40);
		insert(root,35);
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
		
	 int sumToHere(ArrayList<Integer> a, int k){
		 int sum=0;
		 for(int val:a){
			 if(val==k)break;
			 sum+=val;
		 }
		 return sum;
	 }
	 void greaterSum(TreeNode n1,ArrayList<Integer> a){
		 Queue<TreeNode> q= new LinkedList<TreeNode>();
		 q.add(n1);
		 TreeNode tmp;
		 while(!q.isEmpty()){
			 tmp=q.remove();
			 tmp.val=sumToHere(a,tmp.val);
			 if(tmp.left!=null) q.add(tmp.left);
			 if(tmp.right!=null) q.add(tmp.right);
		 }
	 }
	 
	 void revInorder(TreeNode n1,ArrayList<Integer> a ){
			if(n1==null) return;
			revInorder(n1.right,a);
			a.add(n1.val);
			revInorder(n1.left,a);
	}
	 
	public static void main(String[] args) {
		GreaterSumTree t1 = new GreaterSumTree();
		t1.generateBst();
		BstCommonOperations.print(t1.root);
		ArrayList<Integer> a=new ArrayList<Integer>();
		t1.revInorder(t1.root,a);
		t1.greaterSum(t1.root,a);
		BstCommonOperations.print(t1.root);
		
	}

}

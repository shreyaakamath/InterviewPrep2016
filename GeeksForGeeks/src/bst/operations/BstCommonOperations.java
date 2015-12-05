package bst.operations;

import java.util.LinkedList;
import java.util.Queue;

import binary.tree.operations.TreeNode;

public class BstCommonOperations {

	static void generateBst(TreeNode root){
		insert(root,30);
		insert(root,20);
		insert(root,40);
		insert(root,70);
		insert(root,60);
		insert(root,80);
	}
	 static void insert(TreeNode n1,int val){
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
	
	 static boolean search(TreeNode n1,int val){
			if(n1==null) return false;
			if(val==n1.val) return true;
			if(val<n1.val) return search(n1.left,val);
			if(val>=n1.val) return search(n1.right,val);
			else return false;
		}
	 
	 static void print(TreeNode root){
			Queue<TreeNode> s= new LinkedList<TreeNode>();
			s.add(root);
			TreeNode tmp;
			while(!s.isEmpty()){
				tmp=s.remove();
				if(tmp.left!=null || tmp.right!=null) System.out.print(tmp.val+" ->");
				if(tmp.left!=null) {System.out.print(tmp.left.val+",");s.add(tmp.left);}
				if(tmp.right!=null) {System.out.print(tmp.right.val+",");s.add(tmp.right);}
				System.out.println();
				
			}
		}
	 static  boolean isLeaf(TreeNode n1){
		 return n1.left==null&&n1.right==null?true:false;
	 }
	 
}

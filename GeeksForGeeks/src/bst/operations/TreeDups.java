/*
 * http://www.geeksforgeeks.org/how-to-handle-duplicates-in-binary-search-tree/
 */
package bst.operations;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import binary.tree.operations.TreeNode;

public class TreeDups {

	TreeNode root;
	int cnt=0;
	void generateBst(){
		insert(root,12);
		insert(root,10);
		insert(root,20);
		insert(root,9);
		insert(root,11);
		insert(root,10);
		insert(root,12);
		insert(root,12);
	}
	
	
	 void insert(TreeNode n1,int val){
		 if(root==null){root=new TreeNode(val);}
		if(n1==null) {return;}
		if(val<n1.val){
			if(n1.left==null){n1.left=new TreeNode(val);return;}
			else insert(n1.left,val);
		}
		else if(val>n1.val) {
			if(n1.right==null){n1.right=new TreeNode(val);return;}
			insert(n1.right,val);
		}else if(val==n1.val){
			n1.cnt++;
		}
	}
	
	 void print(TreeNode root){
			Queue<TreeNode> s= new LinkedList<TreeNode>();
			s.add(root);
			TreeNode tmp;
			while(!s.isEmpty()){
				tmp=s.remove();
				if(tmp.left!=null || tmp.right!=null) System.out.print(tmp.val+"cnt="+tmp.cnt+" ->");
				if(tmp.left!=null) {System.out.print(tmp.left.val+"cnt="+tmp.left.cnt+",");s.add(tmp.left);}
				if(tmp.right!=null) {System.out.print(tmp.right.val+"cnt="+tmp.right.cnt+",");s.add(tmp.right);}
				System.out.println();
				
			}
		}
	public static void main(String[] args) {
		TreeDups t1 = new TreeDups();
		t1.generateBst();
		t1.print(t1.root);
	}

}

package bst.operations;

import java.util.LinkedList;

import binary.tree.operations.TreeNode;
import bst.operations.BstCommonOperations;

public class DeleteBst2 {
	TreeNode root;
	//smallest value greater than n. first go right then keep going left.
	TreeNode inorderSucc(TreeNode n){
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		stack.addFirst(n.right);
		TreeNode temp=null;
		while(!stack.isEmpty()){
			temp=stack.removeFirst();
			if(BstCommonOperations.isLeaf(temp)) break;
			if(temp.left!=null) stack.addFirst(temp.left);
		}
		return temp;
	}
	
	TreeNode findParent(int val){
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		stack.addFirst(root);
		TreeNode temp=null;
		while(!stack.isEmpty()){
			temp=stack.removeFirst();
			if(temp==null) continue;
			if(temp.right!=null && temp.right.val==val) break;
			if(temp.left!=null && temp.left.val==val) break;
			else if(val<temp.val) stack.addFirst(temp.left);
			else stack.addFirst(temp.right);
		}
		return temp;
	}
	
	void setNull(int val){
		
	}
	TreeNode deleteUtil(TreeNode del, int val){
		if(BstCommonOperations.isLeaf(del)) setNull(val);
		if(del.left==null || del.right==null){
			if(del.left==null) del=del.right;
			else if(del.right==null) del=del.left;
		}
		else {
			int succ = inorderSucc(del).val;
			delete(succ);
			del.val=succ;
			
		}
		return del;
	}
	
	void delete(int val){
		TreeNode parent= findParent(val);
		if(parent.right!=null && parent.right.val==val) parent.right =deleteUtil(parent.right,val);
		else if(parent.left!=null && parent.left.val==val) parent.left =deleteUtil(parent.left,val);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

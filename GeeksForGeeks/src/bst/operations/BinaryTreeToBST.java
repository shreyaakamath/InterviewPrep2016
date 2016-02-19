package bst.operations;

import java.util.Collections;
import java.util.LinkedList;

import binary.tree.operations.TreeNode;

public class BinaryTreeToBST {

	TreeNode btRoot;
	
	void create(){
		btRoot=new TreeNode();
		btRoot.val=10;
		btRoot.right=new TreeNode();
		btRoot.right.val=7;
		btRoot.left=new TreeNode();
		btRoot.left.val=2;
	}
	void convert(){
		LinkedList<Integer> list = new LinkedList<Integer>();
		inorder(btRoot,list);
		Collections.sort(list);
		inorderCopy(btRoot,list);
	}
	
	void inorder(TreeNode n, LinkedList<Integer> list){
		if(n==null) return;
		inorder(n.left,list);
		list.add(n.val);
		inorder(n.right,list);
	}
	void inorderCopy(TreeNode n, LinkedList<Integer> list){
		if(n==null) return;
		inorderCopy(n.left,list);
		n.val=list.removeFirst();
		inorderCopy(n.right,list);
	}
	
	boolean isLeaf(TreeNode n){
		return n.right==null && n.left==null;
	}
	
	
	void print(){
		if(this.btRoot==null) System.out.println("empty");
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		stack.addFirst(btRoot);
		while(!stack.isEmpty()){
			TreeNode temp=stack.removeFirst();
			if(isLeaf(temp)) continue;
			System.out.println();
			System.out.print(temp.val+"->");
			if(temp.left!=null){
				System.out.print(temp.left.val+",");
				stack.addFirst(temp.left);
			}
			
			if(temp.right!=null){
				System.out.print(temp.right.val);
				stack.addFirst(temp.right);
			}
		}
	}
	
	public static void main(String[] args) {
		BinaryTreeToBST b1 = new BinaryTreeToBST();
		b1.create();
		b1.convert();
		b1.print();
	}

}

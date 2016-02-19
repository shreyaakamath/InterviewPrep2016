package bst.operations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import binary.tree.operations.TreeNode;

public class BSTPractice {
	
	TreeNode root;
	void insert(int val , TreeNode n ){
		if(this.root==null) {this.root=new TreeNode(val);return;}
		if(val<n.val){
			if(n.left==null){ n.left=new TreeNode(val);return;}
			else insert(val,n.left);
		}
		else if(val>=n.val){
			if(n.right==null){ n.right=new TreeNode(val);return;}
			else insert(val,n.right);
		}
	}
	
	void print(){
		if(this.root==null) System.out.println("empty");
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		stack.addFirst(root);
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
	
	boolean isLeaf(TreeNode n){
		return n.right==null && n.left==null;
	}
	
	// greatest value smaller than n , first go left then keep going right
	TreeNode inorderPred(TreeNode n){
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		stack.addFirst(n.left);
		TreeNode temp=null;
		while(!stack.isEmpty()){
			temp=stack.removeFirst();
			if(isLeaf(temp)) break;
			stack.addFirst(temp.right);
		}
		return temp;
	}
	
	//smallest value greater than n. first go right then keep going left.
	TreeNode inorderSucc(TreeNode n){
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		stack.addFirst(n.right);
		TreeNode temp=null;
		while(!stack.isEmpty()){
			temp=stack.removeFirst();
			if(isLeaf(temp)) break;
			if(temp.left!=null) stack.addFirst(temp.left);
		}
		return temp;
	}

	//find pairs of elements which add upto given sum value
	void findSum(int sum){
		LinkedList<Integer> stackIn= new LinkedList<Integer>();
		inorder(root,stackIn);
		int len=stackIn.size();
		int i=0;int j=len-1;
		while(i<=j){
			if(stackIn.get(i)+stackIn.get(j)==sum){ System.out.println("found");i++;j--;}
			else if(stackIn.get(i)+stackIn.get(j)<=sum) i++;
			else j--;
		}
	}
	void inorder(TreeNode n,LinkedList<Integer> stack1){
		inorder(n.left,stack1);
		stack1.addFirst(n.val);
		inorder(n.right,stack1);
	}
	
	static void  test(){
//		obj.insert(5,obj.root);
//		obj.insert(2,obj.root);
//		obj.insert(1,obj.root);
//		obj.insert(3,obj.root);
//		obj.insert(8,obj.root);
//		obj.insert(7,obj.root);
//		obj.insert(6,obj.root);
//		obj.insert(9,obj.root);
//		obj.insert(10,obj.root);
		
	}
	
	//construct bst from LL
	
	public static void main(String[] args) {
		BSTPractice obj = new BSTPractice();
		LL l1= new LL();
		l1.createLL();
//		obj.bstFmLL(l1);
		obj.print();
	}

}


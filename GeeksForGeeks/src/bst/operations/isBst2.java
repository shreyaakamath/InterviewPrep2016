package bst.operations;

import binary.tree.operations.TreeNode;

public class isBst2 {

	/*
	 * sol1 : for each TreeNode check if largest element in left subtree is smaller than current.check if smallest in right subtree is greater.NOT efficient 
	 */
	boolean isBst(TreeNode n){
		if(n==null) return true;
		int max=-1;int min=10000;
		if(n.left!=null) max=greatest(n.left);
		if(n.right!=null) min=smallest(n.right);
		if(n.val>max && n.val<=min) return true;
		else return false;
	}
	int max(int a,int b,int c){
		 int max=a>b?a:b;
		 max=max>c?max:c;
		 return max;
	 }
	
	 int min(int a,int b,int c){
		 int min=a>b?b:a;
		 min=min>c?c:min;
		 return min;
	 }
	int greatest(TreeNode n){
		if(n==null) return -1;
		return max(n.val,greatest(n.left),greatest(n.right));
	}
	
	int smallest(TreeNode n){
		if(n==null) return 1000;
		return min(n.val,smallest(n.left),smallest(n.right));
	}
	/*
	 * sol2 : constricting min max value as traverse down the tree 
	 */
	boolean isBst(TreeNode n , int min , int max){
		if(n==null) return true;
		if(n.val<min || n.val > max ) return false;
		return isBst(n.left,min,n.val) && isBst(n.right,n.val,max);
	}
	/*find the kth smallest efficiently TODO*/
	void kthsmallest(int k , Integer count , TreeNode n){
		if(n==null) return;
		kthsmallest(k,count,n.left);
		count=count+1;
		if(count==k) {System.out.println("kth smallest ="+n.val);}
		kthsmallest(k,count,n.right);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

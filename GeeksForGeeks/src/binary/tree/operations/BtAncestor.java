package binary.tree.operations;

import java.util.LinkedList;

class finalHeight{
	int val;

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}
}
public class BtAncestor {
	TreeNode root;
	BtAncestor(){
		root = new TreeNode(10);
		root.left=new TreeNode(2);
		root.right=new TreeNode(8);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
	}
	
	 boolean anc(TreeNode n, int target){
		if(n==null) return false;
		if(n.val==target) return true;
		if(anc(n.left,target)||anc(n.right,target)) {System.out.println(n.val);return true;}
		return false;
	}
	
	 TreeNode lca(TreeNode root,int n1, int n2){
		 if(root==null) return null;
		 if(root.val==n1 || root.val==n2) return root;
		 TreeNode left = lca(root.left,n1,n2);
		 TreeNode right = lca(root.right,n1,n2);
		 //this is when n1=3 n2=5
		 if(left!=null && right!=null) return root;
		 //this is when n1=3 and n2=7 . the lca is not a direct parent
		 return left!=null?left:right;
	 }
	 
	 //if both the nodes are on the same side of root , then need to subtract 2*lca.
	 int dist(TreeNode n1 , TreeNode n2){
		 TreeNode lca = lca(root,n1.val,n2.val);
		 finalHeight f=new finalHeight();
		 distTo(root,lca,0,f);
		 int disLca=f.getVal();
		 
		 f.setVal(0);
		 distTo(root,n1,0,f);
		 int d1=f.getVal();
		 
		 f.setVal(0);
		 distTo(root,n2,0,f);
		 int d2=f.getVal();
		 
		 return d1+d2-2*disLca;
	 }
	 
	 void distTo(TreeNode root , TreeNode target, int ht , finalHeight f){
		 if(f.getVal()!=0) return;
		 if(root==null) return;
		 if(root==target){
			 f.setVal(ht);return;
		 }
		 distTo(root.left,target,ht+1,f);
		 distTo(root.right,target,ht+1,f);
	 }
	 
	public static void main(String[] args) {
		BtAncestor b1= new BtAncestor();
//		b1.anc(b1.root,7);
//		TreeNode lca=b1.lca(b1.root,3,7);
//		System.out.println(lca.val);
//		finalHeight f=new finalHeight();
//		b1.distTo(b1.root,b1.root,0,f);
		System.out.println(b1.dist(b1.root.left,b1.root.left.left));
	}

}

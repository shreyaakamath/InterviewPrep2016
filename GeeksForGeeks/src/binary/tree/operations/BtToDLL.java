package binary.tree.operations;

public class BtToDLL {
	TreeNode root;
	BtToDLL(){
		root=new TreeNode(6);
		root.left=new TreeNode(-13);
		root.left.right=new TreeNode(-8);
		root.right=new TreeNode(14);
		root.right.left=new TreeNode(13);
	}
	TreeNode convertDll(TreeNode root){
		if(root==null) return null;
		if(root.left!=null){
			TreeNode left=convertDll(root.left);
			TreeNode pred=left;
			while(pred.right!=null) pred=pred.right;
			pred.right=root;
			root.left=pred;
		}
		if(root.right!=null){
			TreeNode right=convertDll(root.right);
			TreeNode succ=right;
			while(succ.left!=null) succ=succ.left;
			root.right=succ;
			succ.left=root;
		}
		return root;
	}
	
	boolean sumToZero(){
		TreeNode left=getHead();
		TreeNode right=getTail();
		TreeNode tmp=left;
		boolean flag=false;
		while(tmp!=null){
			if(tmp.val<0){
				TreeNode l=left;TreeNode r=right;
				while(l!=r){
					int sum=l.val+r.val;
					if(sum==tmp.val*-1) {flag=true;break;}
					else if(sum<tmp.val*-1) l=l.right;
					else r=r.left;
				}
				if(flag) break;
			}
		   tmp=tmp.right;
		}
		return flag;
	}
	
	TreeNode getHead(){
		TreeNode tmp=root;
		while(tmp.left!=null) tmp=tmp.left;
		return tmp;
	}
	TreeNode getTail(){
		TreeNode tmp=root;
		while(tmp.right!=null) tmp=tmp.right;
		return tmp;
	}
	void print(){
		TreeNode tmp=getHead();
		while(tmp.right!=null) {System.out.println(tmp.val);tmp=tmp.right;}
	}
	public static void main(String[] args) {
		BtToDLL bt=new BtToDLL();
		bt.convertDll(bt.root);
		bt.print();
		System.out.println(bt.sumToZero());
		
	}

}

package binary.tree.operations;

class Index{
	int val;
	
	Index(int val){
		this.val=val;
	}
	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}
	
}
public class SubTreeCheck {
	TreeNode root;
	TreeNode sub;

	SubTreeCheck(){
		root = new TreeNode(10);
		root.left=new TreeNode(2);
		root.right=new TreeNode(8);
		
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(5);
		
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(7);
		
		sub = new TreeNode(2);
		sub.left=new TreeNode(3);
		sub.right=new TreeNode(5);
		
	}
	boolean check(){
		int lSub= numNodes(sub);
		int lMain = numNodes(root);
		
		int[] inSub = new int[lSub];
		int[] preSub = new int[lSub];
		int[] inMain = new int[lMain];
		int[] preMain = new int[lMain];
		inorder(sub,inSub,new Index(0));
		preorder(sub,preSub,new Index(0));
		
		inorder(root,inMain,new Index(0));
		preorder(root,preMain,new Index(0));
		
		if(isSubArray(inMain,inSub) && isSubArray(preMain,preSub)) return true;
		else return false;
	}
	
	boolean isSubArray(int[] main , int[] sub){
		int j=0;
		boolean flag=false;
		for(int i=0;i<main.length;i++){
			if(main[i]==sub[j]){
				if(j==sub.length-1) {flag=true;break;}
				j++;
			}
			else j=0;
		}
		return flag;
	}
	void inorder(TreeNode n ,int[] arr,Index index){
		if(n==null) return;
		inorder(n.left,arr,index);
		int num = index.getVal();
		arr[num]=n.val;
		num+=1;
		index.setVal(num);
		inorder(n.right,arr,index);
	}
	
	void preorder(TreeNode n ,int[] arr,Index index){
		if(n==null) return;
		int num = index.getVal();
		arr[num]=n.val;
		num+=1;
		index.setVal(num);
		preorder(n.left,arr,index);
		preorder(n.right,arr,index);
	}
	
	int numNodes(TreeNode n){
		if(n.left==null && n.right==null) return 1;
		return numNodes(n.left)+numNodes(n.right)+1;
	}

	public static void main(String[] args) {
		SubTreeCheck s1 = new SubTreeCheck();
		int[] a={1,2,3,4,5};
		int[] b={2,3,4};
//	System.out.println(s1.isSubArray(a,b));
		System.out.println(s1.check());
	}

}

package binary.tree.operations;

class Height{
	int h;

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}
	

}
public class BtPractice {
	TreeNode root;
	
	//o(n) time complexity . calculate height in same recursion set dont do recursion again to get the height.
	int diameter(TreeNode n,Height h){
		if(isLeaf(n)) {h.setH(1);return 1;}
		
		int dleft = diameter(n.left,h);
		int leftH=h.getH();
		
		int dright = diameter(n.right,h);
		int rightH=h.getH();
		
		h.setH((int)Math.max(rightH,leftH)+1);
		return Math.max(Math.max(dleft,dright),leftH+rightH+1);
	}
	
	//height is the number of nodes from root to the leaf. if you want number of edges then subtract one from the returned value
	int height(TreeNode n){
		if(n==null) return 0;
		return Math.max(height(n.left),height(n.right))+1;
	}
	
	boolean isLeaf(TreeNode n){
		return n.left==null && n.right==null?true:false;	
	}
	public static void main(String[] args) {
		BtPractice b1 = new BtPractice();
		b1.root=binary.tree.operations.CommonOperations.create();
		System.out.println(b1.diameter(b1.root,new Height()));
//		System.out.println(b1.height(b1.root));
	}

}

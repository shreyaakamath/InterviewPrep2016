import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;




class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	
	TreeNode(int val){
		this.val=val;
	}
}
public class TreeConstruct {

	TreeNode construct(List<Integer> inorder , List<Integer> preorder, int start , int end){
		if(preorder.size()==0) return null;
		if(end-start ==1){
			preorder.remove(0);
			return new TreeNode(inorder.get(start));
		}
		int split=preorder.remove(0);
		int i;
		for(i=start;i<end;i++){
			if(inorder.get(i)==split) break;
		}
		TreeNode tmp= new TreeNode(split);
		tmp.left=construct(inorder,preorder,start,i);
		tmp.right=construct(inorder,preorder,i+1,end);
		return tmp;
	}
	
	void print(TreeNode root){
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
	
	public static void main(String[] args) {
		List<Integer> preorder= new ArrayList<Integer>();
		preorder.add(10);preorder.add(5);preorder.add(1);preorder.add(7);preorder.add(40);preorder.add(50);
		List<Integer> inorder = new ArrayList<Integer>(preorder);
		Collections.sort(inorder);
		TreeConstruct tc= new TreeConstruct();
		TreeNode root= tc.construct(inorder,preorder,0,preorder.size());
		tc.print(root);
		
	}

}

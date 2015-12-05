/**
 * http://www.geeksforgeeks.org/write-a-c-program-to-get-count-of-leaf-nodes-in-a-binary-tree/
 */
package binary.tree.operations;

import java.util.LinkedList;
import java.util.Queue;

public class ChildSum {
	TreeNode root;
	
	boolean isSum(){
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		TreeNode tmp;int left=0;int right=0;
		boolean match = true;
		while(!q.isEmpty()){
			tmp=q.remove();
			if(tmp.left==null && tmp.right==null) continue;
			if(tmp.left!=null){ left=tmp.left.val;q.add(tmp.left);}
			if(tmp.right!=null) {right=tmp.right.val;q.add(tmp.right);}
			if(tmp.val!=left+right){ match=false;break;}
		}
		return match;
	}
	
	public static void  main(String args[]){
		ChildSum n1 = new ChildSum();
		n1.root=CommonOperations.create();
		CommonOperations.print(n1.root);
		System.out.println(n1.isSum());
	}
	
}



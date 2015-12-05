/**
 * http://www.geeksforgeeks.org/root-to-leaf-path-sum-equal-to-a-given-number/
 * http://www.geeksforgeeks.org/given-a-binary-tree-print-all-root-to-leaf-paths/
 */
package binary.tree.operations;

import java.util.LinkedList;
import java.util.Queue;

public class TreePathSum {
	TreeNode root;
	Queue<Integer> pathTree;
	
	TreePathSum(){
		root= null;
		pathTree = new LinkedList<Integer>();
		
	}
	boolean isLeaf(TreeNode n1){
		return n1.left==null && n1.right==null;
	}
	
	boolean pathSum(int sum){
		Queue<TreeNode> q=new LinkedList<TreeNode>();
		Queue<Integer> p=new LinkedList<Integer>();
		q.add(root);
		p.add(0);
		TreeNode tmp;
		boolean flag = false;
		int path;
		while(!q.isEmpty()){
			tmp=q.remove();
			path = p.remove();
			if(tmp==null) break;;
			int newPath = tmp.val+path;
			if(newPath > sum) break;
			if(isLeaf(tmp)){pathTree.add(newPath);}
			if(newPath ==sum && isLeaf(tmp)){ flag= true;break;}
			q.add(tmp.left);
			p.add(newPath);
			q.add(tmp.right);
			p.add(newPath);
		}
		return flag;
	}

	public static void  main(String args[]){
		TreePathSum n1 = new TreePathSum();
		n1.root=CommonOperations.create();
		CommonOperations.print(n1.root);
		System.out.println(n1.pathSum(26));
		for(int val :n1.pathTree) System.out.println(val);
	}
	
}



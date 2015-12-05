/**
 * http://www.geeksforgeeks.org/diameter-of-a-binary-tree/
 * Complexity:
 * currently O(n). merge height calculation with diameter calculation -> O(n) 
 */
package binary.tree.operations;

import java.util.LinkedList;
import java.util.Queue;

public class TreeDiameter {
	TreeNode root;
	
	int depth(TreeNode n){
		if(n==null) return 0;
		int left = depth(n.left);
		int right= depth(n.right);
		if(left>right)
			return left+1;
		else return right+1;
	}
	
	int max(int a , int b , int c){
		int max;
		max=a>b?a:b;
		max=max>c?max:c;
		return max;
	}
	int dia(TreeNode n1){
		if(n1==null) return 0;
		return max(dia(n1.left),depth(n1.left)+depth(n1.right),dia(n1.right));
	}
	public static void  main(String args[]){
		TreeDiameter n1 = new TreeDiameter();
		n1.root=CommonOperations.create();
		CommonOperations.print(n1.root);
		System.out.println(n1.dia(n1.root));
	}
	
}



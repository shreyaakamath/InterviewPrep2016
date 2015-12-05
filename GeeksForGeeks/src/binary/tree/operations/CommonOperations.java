package binary.tree.operations;

import java.util.LinkedList;
import java.util.Queue;

public class CommonOperations {
		
		/**
		 * 
		 * @return
		 */
		public static TreeNode create(){
			TreeNode root;
			root = new TreeNode(10);
			root.left=new TreeNode(8);
			root.right=new TreeNode(2);
			
			root.left.left = new TreeNode(3);
			root.left.right = new TreeNode(5);
			//root.left.left.left=new TreeNode(11);
			//root.left.left.right=new TreeNode(11);
			
			root.right.left = new TreeNode(2);
			root.right.right = new TreeNode(3);
			return root;
		}
		/**
		 * 
		 * @param root
		 */
		static void print(TreeNode root){
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
}

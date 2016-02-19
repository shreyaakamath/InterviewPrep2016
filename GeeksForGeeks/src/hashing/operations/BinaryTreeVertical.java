package hashing.operations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import binary.tree.operations.TreeNode;

public class BinaryTreeVertical {

	TreeNode root;
	BinaryTreeVertical(){
		root = new TreeNode(1);
		root.left=new TreeNode(2);
		root.right=new TreeNode(3);
		
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		
		root.right.left.right = new TreeNode(8);
		root.right.right.right = new TreeNode(9);
	}
	void inorder(TreeNode n , HashMap<Integer,List<TreeNode>> map , int hdist){
		if(n==null) return;
		inorder(n.left,map,hdist-1);
		System.out.println(n.val);
		List<TreeNode> list = map.get(hdist);
		if(list==null){
			list=new ArrayList<TreeNode>();
		}
		list.add(n);
		map.put(hdist,list);
		inorder(n.right,map,hdist+1);
	}
	
	public static void main(String[] args) {
		HashMap<Integer,List<TreeNode>> map = new HashMap<Integer,List<TreeNode>>();
		BinaryTreeVertical b1 = new BinaryTreeVertical();
		b1.inorder(b1.root,map,1);
		
		for(Map.Entry<Integer,List<TreeNode>> e:map.entrySet()){
			List<TreeNode> list=e.getValue();
			for(TreeNode t: list){
				System.out.print(t.val+" ");
			}
			System.out.println();
		}
		
	}

}

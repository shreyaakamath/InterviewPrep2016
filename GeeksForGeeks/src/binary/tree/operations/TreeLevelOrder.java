package binary.tree.operations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
 * http://www.geeksforgeeks.org/level-order-tree-traversal/
 */

public class TreeLevelOrder {
TreeNode root;

void level(TreeNode n1){
	if(n1.left==null) return;
	if(n1.right ==null) return;
	System.out.print(n1.left.val+",");
	System.out.print(n1.right.val);
	System.out.println();
	level(n1.left);
	level(n1.right);
}

void level(){
	LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
	queue.addLast(root);
	while(queue.size()!=0){
	TreeNode temp = queue.removeFirst();
	System.out.print(temp.val+" ");
	if(temp.right!=null) queue.addLast(temp.right);
	if(temp.left!=null) queue.addLast(temp.left);
	}
}

void width(TreeNode n,HashMap<Integer,Integer> map,int level){
	if(n==null) return;
	width(n.left,map,level+1);
	if(map.containsKey(level)){
		int newMax=map.get(level)+1;
		map.put(level,newMax);
		}
	else map.put(level,1);
	width(n.right,map,level+1);
}

void widthUtil(){
	HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
	width(root,map,1);
	Map.Entry<Integer,Integer> max=null;
	for(Map.Entry<Integer,Integer> e:map.entrySet()){
		if(max==null||e.getValue().compareTo(max.getValue())>0) max=e;
	} 
	System.out.println(max.getKey() +" - "+max.getValue());
}


public static void main(String args[]){
	TreeLevelOrder n1 = new TreeLevelOrder();
	n1.root=CommonOperations.create();
//	System.out.print(n1.root.val+ " ");
//	n1.level(n1.root);
//	n1.level();
}
}

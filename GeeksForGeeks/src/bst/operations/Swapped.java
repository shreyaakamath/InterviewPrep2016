package bst.operations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import binary.tree.operations.TreeNode;

public class Swapped {
	TreeNode root;
	/*two elements in bst are swapped . find them and swap. do an inorder traveral , sort it , compare the two to id incorrectly  positions nums swap those in the tree*/
	void inorder(List<Integer> list , TreeNode n ){
		if(n==null) return ; 
	    inorder(list,n.left);
	    list.add(n.val);
	    inorder(list,n.right);
	}
	//simple  , do inorder traversal , then sort , then compare
	void idSwapped(){
		List<Integer> listBad = new ArrayList<Integer>();
		inorder(listBad,root);
		List<Integer> listGood = new ArrayList<Integer>(listBad);
		Collections.sort(listGood);
		int[] swap=new int[2];int j=0;
		for(int i=0;i<listBad.size();i++){
			if(listBad.get(i)!=listGood.get(i))
				swap[j++]=listBad.get(i);
		}
		
		fixSwap(root,swap[0],swap[1],new Integer(0));
	}
	//use inorder traversal list to determine the swapped elements
	void idSwapped2(){
		List<Integer> list = new ArrayList<Integer>();
		inorder(list,root);
		Integer first =null;
		Integer middle =null; 
		Integer second = null;
		boolean flag=false;
		for(int i=1;i<list.size();i++){
			if(list.get(i)<list.get(i-1)){
				if(!flag) {
				first=list.get(i-1);
				middle=list.get(i);
				flag=true;
				} else{
					second = list.get(i);
				}
			}
		}
		if(second==null){
			second=middle;
		}
		fixSwap(root,first,second,new Integer(0));
	}
	void fixSwap(TreeNode n , int swap1, int swap2,Integer count)
	{
		if(n==null) return;
		if(count==2) return;
		if(n.val==swap1){n.val=swap2;count+=1;}
		else if(n.val==swap2) {n.val=swap1;count+=1;}
		fixSwap(n.left,swap1,swap2,count);
		fixSwap(n.right,swap1,swap2,count);
	}
	public static void main(String[] args) {
		
	}

}

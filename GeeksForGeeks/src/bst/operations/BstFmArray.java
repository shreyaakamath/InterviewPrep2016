package bst.operations;
import binary.tree.operations.TreeNode;

public class BstFmArray {
	
	//make bst from sorted array.the corner conditions are : on the right  start=-1 end =0 on the left start=4 end =3 for n=4 . 
	TreeNode makeFmArr(int[] arr , int start,int end){
		if(start>end) return null;
		int mid=(end+start)/2;
		TreeNode n = new TreeNode(arr[mid]);
		n.left=makeFmArr(arr,start,mid-1);
		n.right=makeFmArr(arr,mid+1,end);
		return n;
	}
	
	public static void main(String[] args) {

	}

}

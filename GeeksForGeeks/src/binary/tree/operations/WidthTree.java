/**
 * http://www.geeksforgeeks.org/maximum-width-of-a-binary-tree/
 */
package binary.tree.operations;

public class WidthTree {
	TreeNode root;
	
	int nodeCnt(int count , TreeNode n1){
		if(n1==null) return count;
		count++;
		count=nodeCnt(count,n1.left);
		count=nodeCnt(count,n1.right);
		return count;
	}
	
	void width(int[] array,int level,TreeNode n){
		if(n==null)return;
		array[level]++;
		width(array,level+1,n.left);
		width(array,level+1,n.right);
	}
	
	void sort(int[] a){
		int j=1;
		int i =j;
		int val;
		while(j<a.length){
			val = a[j];
			for(i=j-1;i>=0;i--){
				if(a[i]>val) a[i+1]=a[i];
				else break;
			}
			a[i+1]=val;
			j++;
		}
	}
	public static void  main(String args[]){
		WidthTree n1 = new WidthTree();
		n1.root=CommonOperations.create();
		CommonOperations.print(n1.root);
		int n =n1.nodeCnt(0,n1.root);
		int[] arr = new int[n];
		n1.width(arr,1,n1.root);
		n1.sort(arr);
		System.out.println(arr[arr.length-1]);
	}
}

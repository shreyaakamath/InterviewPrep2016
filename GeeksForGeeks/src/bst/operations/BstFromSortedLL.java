package bst.operations;

import java.util.LinkedList;

import binary.tree.operations.TreeNode;

class LLNode{
	int val;
	LLNode next;
	
	LLNode(int val){
		this.val=val;
	}
}

class LL {
	LLNode head;
	void createLL(){
		head=new LLNode(0);
		LLNode temp=head;
		for(int i=1;i<=2;i++){
			temp.next=new LLNode(i);
			temp=temp.next;
		}
	}
}
public class BstFromSortedLL {
	TreeNode root;
	void insert(int val , TreeNode n ){
		if(this.root==null) {this.root=new TreeNode(val);return;}
		if(val<n.val){
			if(n.left==null){ n.left=new TreeNode(val);return;}
			else insert(val,n.left);
		}
		else if(val>=n.val){
			if(n.right==null){ n.right=new TreeNode(val);return;}
			else insert(val,n.right);
		}
	}
	
	void print(){
		if(this.root==null) System.out.println("empty");
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		stack.addFirst(root);
		while(!stack.isEmpty()){
			TreeNode temp=stack.removeFirst();
			if(BstCommonOperations.isLeaf(temp)) continue;
			System.out.println();
			System.out.print(temp.val+"->");
			if(temp.left!=null){
				System.out.print(temp.left.val+",");
				stack.addFirst(temp.left);
			}
			
			if(temp.right!=null){
				System.out.print(temp.right.val);
				stack.addFirst(temp.right);
			}
		}
	}
	
	//adding the elements like this will make an unbalanced tree!! -> diff between right and left is not more than 1. 
	void notBalancedTree(LL list){
		LLNode temp=list.head;
		while(temp!=null){
			insert(temp.val,root);
			temp=temp.next;
		}
	}
	//running code  -> approach similar to the array approach . consider middle element as root , do same for right and left subtree.O(nlogn)
	TreeNode convert(LL list,LLNode start,LLNode end,int len){
		if(len<=0) return null;
		LLNode temp=start;
		int i=0;int mid=len/2;
		for(i=0;i<mid;i++)
			temp=temp.next;
		TreeNode n = new TreeNode(temp.val);
		n.left=convert(list,start,temp,mid);
		n.right=convert(list,temp.next,end,mid);
		return n;
	}
	
	//conceptual not implementation -> Tricky . not working 
	 TreeNode convertEfficient(LLNode head , int len){
		if(len<=0) return null;
		TreeNode left = convertEfficient(head,len/2);
		
		TreeNode root=new TreeNode(head.val);
		root.left=left;
		
		head=head.next;
		
		root.right=convertEfficient(head,len-len/2-1);
		
		return root;
	}
	public static void main(String[] args) {
		BstFromSortedLL b1= new BstFromSortedLL();
		LL l1= new LL();
		l1.createLL();
		LLNode tmp=l1.head;int i=1;
		while(tmp.next!=null) {tmp=tmp.next;i++;}
//		b1.root=b1.convert(l1,l1.head,tmp,i);
		b1.root=b1.convertEfficient(l1.head,3);
		b1.print();
		
	}

}

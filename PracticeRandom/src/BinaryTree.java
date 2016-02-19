import java.util.LinkedList;
import java.util.Queue;

	class Node{
		int val;
		Node right;
		Node left;
		
		Node(int val){
			this.val=val;
		}
	}
	
public class BinaryTree {
	Node root;
	
	BinaryTree(){
		root=new Node(1);
		root.left=new Node(2);
		root.right=new Node(3);
		root.left.left=new Node(4);
		root.left.right=new Node(5);
		root.right.left=new Node(6);
		root.right.right=new Node(7);
	}
	
	void levelOrder(){
		LinkedList<Node> q=new LinkedList<Node>();
		q.addLast(root);
		while(!q.isEmpty()){
			Node temp=q.removeFirst();
			System.out.print(temp.val+" ");
			if(temp.right!=null) q.addLast(temp.right);
			if(temp.left!=null) q.addLast(temp.left);
		}
	}
	public static void main(String[] args) {
		BinaryTree bt= new BinaryTree();
		bt.levelOrder();
	}

}

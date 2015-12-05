package data.structures;

public class BinarySearchTree {

	TreeNode root ; 
	
	void insert(int key){
		TreeNode n1 = new TreeNode(null, null, null, key);
		if(root == null) { root = n1 ;return;}
		TreeNode parent = root;
		while(parent!=null){
			if(key <= parent.key){
				if(parent.left ==null) {parent.left = n1; n1.p =parent;break;}
				else {parent = parent.left;}
			}
			if(key > parent.key) {
				if(parent.right==null) {parent.right =n1;n1.p=parent;break;}
				else {parent = parent.right;}
			}
		}
	
	}

	int successor(int key){
		TreeNode n1 = root;
		int succ = n1.key;
		while(n1!=null){
			if(n1.key == key){
				succ = minimum(n1.right);break;
			}
			else if (key <= n1.key) {n1 = n1.left;}
			else if (key > n1.key ) {n1 = n1.right;}
		}
		return succ ; 
	}
	
	int predecessor(int key){
		TreeNode n1 = root; 
		int pred = n1.key;
		while(n1!=null){
			if(n1.key==key){
				pred=maximum(n1.left);break;
			}
			else if (key <= n1.key) {n1=n1.left;}
			else if (key > n1.key) {n1 =n1.right;}
		}
		return pred;
	}
	
	int minimum(TreeNode n1){
		int min = n1.key;
		while(n1!=null){
			if(n1.key < min) min = n1.key;
			n1=n1.left;
		}
		return min ; 
	}
	
	int maximum(TreeNode n1){
		int max = n1.key;
		while(n1!=null){
			if(n1.key>max) max = n1.key;
			n1=n1.right;
		}
		return max; 
	}
	
	TreeNode treeSearch(int key){
		TreeNode n1 = root;
		TreeNode foundNode = null;
		while(n1!=null){
			if(n1.key == key) {foundNode = n1; break;}
			if(key <= n1.key) {n1=n1.left;}
			else if(key > n1.key) {n1=n1.right;}
		}
		return foundNode;
	}
	
	void inorderWalk(TreeNode n1){
		if(n1==null) return;
		inorderWalk(n1.left);
		System.out.println(n1.key);
		inorderWalk(n1.right);
	}
	
	void delete(int key){
	TreeNode node = treeSearch(key);
	while(node!=null) {
		if(node.right!=null) {
			node.key = node.right.key;
			node = node.right;
		} else if (node.right ==null){
			node.p.right = null;node = null;
		} else if(node.left!=null) {
			node.key = node.left.key;
			node = node.left;
		} else if(node.left ==null) {
			node.p.left = null;node = null;
		}
	}
	}
	
	void translaplant(int key, int dest){
		
	}
	
	public static void main(String[] args) {
		
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(2);
		bst.insert(5);
		bst.insert(6);
		bst.insert(0);
		bst.insert(4);
		bst.insert(1);
		bst.inorderWalk(bst.root);
		bst.delete(5);
		System.out.println("---");
		bst.inorderWalk(bst.root);
		
	}
}

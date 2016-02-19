package bst.operations;

import binary.tree.operations.TreeNode;

public class TreeSize {

	// get size of tree
	int size(TreeNode n){
		if(n==null) return 0;
		if(BstCommonOperations.isLeaf(n)) return 1;
		return size(n.left) + size(n.right) +1;
	}
	
}

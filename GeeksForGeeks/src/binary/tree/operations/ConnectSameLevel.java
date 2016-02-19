package binary.tree.operations;

import java.util.LinkedList;
class NewTreeNode{
	int val;
	NewTreeNode left;
	NewTreeNode right;
	NewTreeNode nextRight;
	
	NewTreeNode(int val){
		this.val=val;
	}
}
class TreeContainer{
	NewTreeNode n;
	int level;
	
	TreeContainer(NewTreeNode n,int level){
		this.n=n;
		this.level=level;
	}
}

public class ConnectSameLevel {
	NewTreeNode root;
	
	ConnectSameLevel(){
		root = new NewTreeNode(10);
		root.left=new NewTreeNode(2);
		root.right=new NewTreeNode(8);
		root.left.left = new NewTreeNode(3);
		root.left.right = new NewTreeNode(5);
		root.right.left = new NewTreeNode(6);
		root.right.right = new NewTreeNode(7);
	}
	
	void getNodesPerLevel(LinkedList<TreeContainer> queue){
		queue.addLast(new TreeContainer(root,0));
		int i=0;
		int num=7;//get the no of nodes in the tree
		while(i<num){
			TreeContainer tempContainer = queue.get(i);
			i++;
			NewTreeNode n = tempContainer.n;
			int level = tempContainer.level+1;
			if(n.left!=null) queue.addLast(new TreeContainer(n.left,level));
			if(n.right!=null) queue.addLast(new TreeContainer(n.right,level));
			
		}
	}
	void level(){
		LinkedList<TreeContainer> queue = new LinkedList<TreeContainer>();
		int i=0;
		getNodesPerLevel(queue);
		for(i=0;i<queue.size();i++){
			NewTreeNode n1=queue.get(i).n;
			int levelNow = queue.get(i).level;
			NewTreeNode nxt=null;
			int levelnxt=0;
			if(i+1<queue.size()){
				nxt=queue.get(i+1).n;
				levelnxt=queue.get(i+1).level;
			}
			if(levelNow == levelnxt){
				n1.nextRight=nxt;
			}else{
				n1.nextRight=null;
			}
		}
	}
	
	void printKDist(NewTreeNode n,int presentLevel, int target){
		if(n==null) return;
		if(presentLevel>target) return;
		if(presentLevel==target) {System.out.println(n.val);return;}
		printKDist(n.left,presentLevel+1,target);
		printKDist(n.right,presentLevel+1,target);
	}
	
	public static void main(String[] args) {
		ConnectSameLevel c1= new ConnectSameLevel();
//		c1.level();
		c1.printKDist(c1.root,0,2);
		
	}

}

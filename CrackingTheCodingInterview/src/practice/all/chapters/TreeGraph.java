package practice.all.chapters;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;



class TreeNode{
	int val;
	TreeNode right;
	TreeNode left;
	TreeNode parent;
	
	TreeNode(int data){
		this.val=data;
	}
}


class Tree{
	TreeNode root;
	
	Tree(){
		root=new TreeNode(10);
		root.right = new TreeNode(3);
		root.left = new TreeNode(5);
		root.left.left= new TreeNode(2);
		root.right.left=new TreeNode(4);
		root.right.right=new TreeNode(6);
	}
	void print(TreeNode temp){
		if(temp==null) return;
		System.out.print(temp.val +"->");
		if(temp.left!=null) System.out.print(temp.left.val+",");
		if(temp.right!=null) System.out.print(temp.right.val+",");
		System.out.println();
		print(temp.right);
		print(temp.left);
	}
	int maxDepth(TreeNode n ){
		if(n==null) return 0;
		return 1+ Math.max(maxDepth(n.left),maxDepth(n.right));
	}
	
	int minDepth(TreeNode n ){
		if(n==null) return 0;
		return 1+ Math.min(minDepth(n.left),minDepth(n.right));
	}
	
	boolean isBalanced(){
		return maxDepth(root)-minDepth(root)<=1;
	}
	
	/*construct a balanced tree from a sorted array. make the mid root , do the same on left and right.*/
	TreeNode construct(int[] a , int start , int end){
		if(start>=end) return null;
		int mid=(start+end)/2;
		TreeNode temp = new TreeNode(a[mid]);
		temp.left = construct(a,start,mid);
		temp.right = construct(a,mid+1,end);
		return temp;
	}
	
	/*normal level order traversal using a queue. Like simpel BFS traversal*/
	void levelOrder(){
		Queue<TreeNode> q = new Queue<TreeNode>();
		q.enqueue(root);
		while(!q.isEmpty()){
			TreeNode temp = q.dequeue();
			System.out.println(temp.val);
			if(temp.left!=null) q.enqueue(temp.left);
			if(temp.right!=null) q.enqueue(temp.right);
		}
		
	}
	
	/*using map and queue to put all elements at one level into a list. uses basic level order logic.*/
	void levelOrderToList1(){
		Queue<LevelNode> q = new Queue<LevelNode>();
		q.enqueue(new LevelNode(root,0));
		HashMap<Integer,List<TreeNode>> map = new HashMap<Integer,List<TreeNode>>(); 
		while(!q.isEmpty()){
			LevelNode n = q.dequeue();
			TreeNode temp = n.n;
			int level= n.level;
			if(map.get(level)==null){
				List<TreeNode> list = new ArrayList<TreeNode>();
				list.add(temp);
				map.put(level,list);
			}else{
				List<TreeNode> list = map.get(level);
				list.add(temp);
				map.put(level,list);	
			}
			
			if(temp.left!=null) {q.enqueue(new LevelNode(temp.left,level+1));}
			if(temp.right!=null) {q.enqueue(new LevelNode(temp.right,level+1));}
		}
		
		for(Map.Entry<Integer,List<TreeNode>> m :map.entrySet()){
			for(TreeNode n : m.getValue()) System.out.print(n.val+" ");
			System.out.println();
		}
	}
	
	/*tree nodes at each level in a list . easier and cleaner than using a map. using recursive stack method to add elements to a list*/
	void levelArray(TreeNode n , List<TreeNode>[] arr , int level , int height){
		if(n==null) return ;
		if(level>height) return ;
		arr[level].add(n);
		levelArray(n.left,arr,level+1,height);
		levelArray(n.right,arr,level+1,height);
	}
	
	void levelOrderToList2(){
		int height = height(root);
		List<TreeNode>[] arr = (List<TreeNode>[])new List[height+1];
		for(int i=0;i<=height;i++)
			arr[i]= new ArrayList<TreeNode>();
		levelArray(root,arr,1,height);
		for(List<TreeNode> list :arr)
			for(TreeNode t : list)
				System.out.print(t.val+" ");
		System.out.println();
	}
	
	int height(TreeNode n){
		if(n==null) return 0;
		return 1+ Math.max(height(n.left),height(n.right));
	}
	
	/*inorder successor with parent link was a left child (P.left = X), then P is the successor of X*/
	TreeNode inorderSucc(TreeNode n){
		TreeNode succ=null;
		if(n!=null){
			if(n.right==null){
				TreeNode p = n.parent;
				while(p!=null && n==p.right){
					n=p;
					p=p;
				}
				succ=p;
			}else{
				succ=getSmallest(n.right);
			}
		}
		return succ;
	}
	
	TreeNode getSmallest(TreeNode n){
		TreeNode small=n;
		while(small.left!=null){
			small=small.left;
		}
		return small;
	}
	
	/*inorder traversal without recursion. use a stack traverse full left.then pop and print. change current to right. do same thing again*/
	void inorderWithoutRecur(){
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode curr = root;
		while(!stack.isEmpty() || curr!=null){
			while(curr!=null){
				stack.push(curr);
				curr=curr.left;
			}
			TreeNode tmp = stack.pop();
			System.out.println(tmp.val);
			curr=tmp.right;
		}
	}
	
	/*LCA for BST , simple can use BST properties */
	TreeNode commonAncBST(TreeNode a , TreeNode b , TreeNode root){
		if(a.val==root.val|| b.val==root.val) return root;
		else if(a.val<root.val && b.val < root.val) return commonAncBST(a,b,root.left);
		else if(a.val>root.val && b.val > root.val) return commonAncBST(a,b,root.right);
		else return root;
	}
	
	/*Check if one tree is subtree of another. Millions of nodes in parent tree. cant use extra space. If no restriction on space then 
	 * can traverse inorder and preorder and make array. check if the arrays are sub-arrys or not.*/
	boolean subtree(TreeNode main , TreeNode sub){
		if(main==null) return false;
		if(main.val == sub.val) return check(main,sub);
		else return subtree(main.left,sub) || subtree(main.right,sub);
	}
	
	boolean check(TreeNode main , TreeNode sub){
		if(main==null && sub==null) return true;
		else if(main==null || sub==null) return false;
		else if(main.val!=sub.val) return false;
		else return check(main.left,sub.left) && check(main.right,sub.right);
	}
	
	/*root to leaf path of given value*/
	boolean rootToLeafRecur(TreeNode n , int sum ,int sumSoFar){
		if(n==null) return false;
		if(n.val+sumSoFar==sum) return true;
		return rootToLeafRecur(n.left,sum,sumSoFar+n.val)||rootToLeafRecur(n.right,sum,sumSoFar+n.val);
	}
	 
	/*root to leaf path of given value. save all paths in double list*/
	void rootToLeaf(TreeNode n , int sum ,int sumSoFar,List<TreeNode> listSoFar,List<List<TreeNode>> finalList){
		if(n==null) return;
		listSoFar.add(n);
		if(sumSoFar+n.val==sum)  finalList.add(new ArrayList<TreeNode>(listSoFar));
		rootToLeaf(n.left,sum,sumSoFar+n.val,listSoFar,finalList);
		listSoFar.remove(n.left);
		rootToLeaf(n.right,sum,sumSoFar+n.val,listSoFar,finalList);
		listSoFar.remove(n.right);
	}
	/*node to node sums to given path . o(n2) solution*/
	void nodeToNode(int val){
		List<List<TreeNode>> finalList = new ArrayList<List<TreeNode>>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.add(root);
		while(!stack.isEmpty()){
			TreeNode tmp = stack.pop();
			List<TreeNode> list1 = new ArrayList<TreeNode>();
			rootToLeaf(tmp,val,0,list1,finalList);
			
			if(tmp.right!=null) stack.push(tmp.right);
			if(tmp.left!=null) stack.push(tmp.left);
		}
		for(List<TreeNode> list : finalList){
			for(TreeNode n : list){
				System.out.println(n.val);
			}
		}
	}
	
}

class LevelNode{
	TreeNode n ;
	int level;
	LevelNode(TreeNode n , int level){
		this.level=level;
		this.n=n;
	}
}
class Graph{
	List<Integer>[] adj;
	int n;
	int e;
	boolean[] visited;
	int[] edgeTo;
	
	Graph(){
		File f = new File("graph.txt");
		Scanner scan = null;
		try {
			scan = new Scanner(f);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
		n = scan.nextInt();
		e = scan.nextInt();
		adj = (List<Integer>[])new List[n+1];
		visited = new boolean[n+1];
		edgeTo = new int[n+1];
		for(int i=0;i<=n;i++) adj[i] = new ArrayList<Integer>();
		
		while(scan.hasNext()){
			int a = scan.nextInt();
			int b = scan.nextInt();
			adj[a].add(b);
			adj[b].add(a);
		}
	}
	
	void refresh(){
		visited = new boolean[n+1];
		edgeTo = new int[n+1];
	}
	void print(){
		for(int i=0;i<=n;i++){
			System.out.print(i+"-> ");
			for(int g: adj[i])
				System.out.print(g +",");
			System.out.println();
		}
	}
	
	void bfs(int s){
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.addLast(s);
		visited[s]= true;
		System.out.println(s);
		while(!queue.isEmpty()){
			int temp = queue.removeFirst();
			for(int n : adj[temp]){
				if(!visited[n]) {
					visited[n] = true;
					System.out.println(n);
					queue.addLast(n);
				}
			}
		}
	}
	
	void dfs(int node){
		visited[node] = true;
		System.out.println(node);
		for(int n : adj[node]){
			if(!visited[n]){
				edgeTo[n]=node;
				dfs(n);
			}
		}
	}
}
public class TreeGraph {
	static void graphTest(){
		Graph g = new Graph();
//		g.print();
//		g.dfs(1);
//		System.out.println("=====");
//		g.refresh();
//		g.bfs(1);
	}
	static void treeTest(){
		Tree t = new Tree();
//		t.levelOrder();
//		t.levelOrderToList();
//		t.levelOrderToList2();
//		t.inorderWithoutRecur();
//		System.out.println(t.rootToLeaf(t.root,17,0));
//		List<TreeNode> list1 = new ArrayList<TreeNode>();
//		List<List<TreeNode>> finalList = new ArrayList<List<TreeNode>>();
//		t.rootToLeaf(t.root,17,0,list1,finalList);
//		for(List<TreeNode> list : finalList){
//			for(TreeNode n : list){
//				System.out.println(n.val);
//			}
//		}
		t.nodeToNode(7);
//		System.out.println(t.isBalanced());
//		int[] a ={1,2,3,4,5};
//		t.root=t.construct(a,0,a.length);
//		t.print(t.root);
	}
	public static void main(String[] args) {
		treeTest();
		
		
		
	}

}

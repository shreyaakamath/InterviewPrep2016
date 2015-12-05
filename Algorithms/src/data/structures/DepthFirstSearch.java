package data.structures;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearch {
	boolean[] marked;
	int[] edgeTo;
	List<Integer> path ;
	
	DepthFirstSearch(GraphAdjList g){
		marked = new boolean[g.v];
		edgeTo = new int[g.v];
	}
		
	void dfs(GraphAdjList g1, int source){
		marked[source] = true; 
		for(int num : g1.adj[source]){
			if(!marked[num]){
			edgeTo[num] = source;
			dfs(g1, num);
			} 
		}
	}
	
	Stack<Integer> pathTo(GraphAdjList g1, int v){
		Stack<Integer> path = new Stack<Integer>(g1.v);
		int currentNode = v;
		
		path.push(v);
		while(edgeTo[currentNode] != 0){
			path.push(edgeTo[currentNode]);
			currentNode= edgeTo[currentNode];
		}
		path.push(0);
		return path ; 
	}
	public static void main (String args[]){
		GraphAdjList g1 = new GraphAdjList(GraphAdjList.getScanner("C:\\Users\\shreyak.NETAPP\\Documents\\personal\\algorithms\\Algorithms\\src\\data\\structures\\tiny.txt"));
		DepthFirstSearch d1 = new DepthFirstSearch(g1);
		d1.dfs(g1, 0);
		for(int i =0;i<g1.v;i++)
			System.out.println(d1.marked[i]);
		for(int i =0;i<g1.v;i++)
			System.out.println(d1.edgeTo[i]);
		
	   Stack<Integer> path = d1.pathTo(g1, 2);
	   
		
	}
}

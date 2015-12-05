package data.structure.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphSearch {

	Queue<Integer> q ;
	int[] edgeTo;
	boolean[] marked;
	boolean[] stack;
	Stack<Integer> cycle;
	boolean isDag;
	
	GraphSearch(GraphAdjList graph){
		initVariables(graph);
	}
	
	void initVariables(GraphAdjList graph){
		q = new LinkedList<Integer>();
		edgeTo = new int[graph.v];
		marked = new boolean[graph.v];
		stack = new boolean[graph.v];
		cycle = new Stack<Integer>();
		isDag = true;
	}
	
	void BreadthFirstSearch(GraphAdjList graph , int source){
		q.add(source);
		marked[source] = true;
		
		while(!q.isEmpty()){
			int parent = q.remove();
			for(int child : graph.g[parent]) {
				while(!marked[child]) {
					q.add(child);
					edgeTo[child] = parent;
					marked[child] = true;
				}
			}
		}
	}
	
	void DepthFirstSearch(GraphAdjList graph , int source){
		stack[source] = true;
		marked[source] = true;
		for(int i : graph.g[source]){
			if(!isDag){return;}
			else if(!marked[i]){
				edgeTo[i] = source;
				DepthFirstSearch(graph,i);
			} else if(stack[i]) {
				isDag = false;
				for(int j = source ; j!=i;j=edgeTo[j]){
					cycle.push(j);
				}
				cycle.push(i);cycle.push(source);
			}
		}
	}
	
	void DFS(GraphAdjList g1){
		for(int i =0;i< g1.v;i++) {
			if(!marked[i]){
				DepthFirstSearch(g1,i);
			}
		}
	}

	boolean hasPath(int v){
		return marked[v];
	}
	
	void pathTo(int v,int source){
		Stack<Integer> s1 = new Stack<Integer>();
		int parent = edgeTo[v];
		s1.push(v);
		while(parent!=source){
		s1.push(parent);
		parent = edgeTo[parent];
		}
		s1.push(source);
		
		while(!s1.isEmpty()) System.out.print(s1.pop()+"->");
		
	}
	
	public static void main(String args[]){
		GraphAdjList g1 = new GraphAdjList("graph.txt");
		GraphSearch b1 = new GraphSearch(g1);
		b1.BreadthFirstSearch(g1, 0);
		//System.out.println(b1.hasPath(3));
		//b1.pathTo(1, 0);
		b1.initVariables(g1);
		b1.DFS(g1);
		//b1.pathTo(4, 0);
		System.out.println("----");
		while(!b1.cycle.isEmpty()) System.out.println(b1.cycle.pop()+"->");
	}
}

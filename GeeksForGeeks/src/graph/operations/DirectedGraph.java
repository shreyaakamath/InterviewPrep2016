/**
 * http://stackoverflow.com/questions/14917375/cannot-create-generic-array-of-how-to-create-an-array-of-mapstring-obje
 * cannot directly create array of generic type .therefor on RHS array is initialised without data type in <>. Need to caste it to the specific type
 * 
 * http://www.geeksforgeeks.org/breadth-first-traversal-for-a-graph/
 * http://www.geeksforgeeks.org/depth-first-traversal-for-a-graph/
 * http://www.geeksforgeeks.org/topological-sorting/
 * http://www.geeksforgeeks.org/find-longest-path-directed-acyclic-graph/
 */
package graph.operations;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class GraphNode{
	int data; 
	
	GraphNode(int data){
		this.data=data;
	}
}

public class DirectedGraph {
	
	ArrayList<GraphNode>[] adj; 
	int n;
	int e;
	Queue<GraphNode> q;
	boolean visited[];
	int pathTo[];
	
	DirectedGraph(String path){

		File file = new File(path);
		Scanner scan=null;
		try {
			scan = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		n = scan.nextInt();
		e = scan.nextInt();
		adj = (ArrayList<GraphNode>[])new ArrayList[n+1];
		for(int i=0;i<=n;i++){
			adj[i]= new ArrayList<GraphNode>();
		}
		q=new LinkedList<GraphNode>();
		visited = new boolean[n+1];
		pathTo = new int[n+1];
		
		for(int i=0;i<e;i++){
			int u=scan.nextInt();
			int v=scan.nextInt();
			adj[u].add(new GraphNode(v));
		}
	}
	
	void printGraph(){
		for(int i=0;i<=n;i++){
			System.out.print(i+"->");
			for(GraphNode n : adj[i])
				System.out.print(n.data+" , ");
			System.out.println();
		}
	}
	/*Time Complexity: O(V+E) where V is number of vertices in the graph and E is number of edges in the graph.*/
	void BFS(GraphNode s){
		q.add(s);
		visited[s.data] = true;
		pathTo[s.data] = s.data;
		while(!q.isEmpty()){
			GraphNode tmp = q.remove();
			for(GraphNode n : adj[tmp.data]){
				if(!visited[n.data]){
					pathTo[n.data]=tmp.data;
					//System.out.print(n.data+",");
					q.add(n);
					visited[n.data]=true;}
				else continue;
			}
		}
	}
	
	/*Time Complexity: O(V+E) where V is number of vertices in the graph and E is number of edges in the graph.*/
	void dfs(GraphNode s){
		if(s==null) return;
		for(GraphNode n : adj[s.data]){
			if(!visited[n.data]){
				visited[n.data]=true;
				dfs(n);
				pathTo[n.data]=s.data;
				System.out.println(n.data+" ");
			}
		}
		return;
	}
	/*TODO 
	Fri:
	DFS 
	cycle detection undirected
	cycle detection directed 
	longest path in DAG
	Topo sorting
	
	Sat,Sun:
	Prims MST 
	Kruskals MST 
	
	Dijkstras shortest path 
	floyd warshal shortest path 
	johnson shortest path 
	
	connectivity in directed graph 	
	connected components 
	
	maxflow , mincut 
	*/ 
	void connectedNodes(GraphNode s){
		int val = s.data;
		for(int i =1;i<n;i++){
			int tmp=i;
			if(tmp==val) continue;
			while(pathTo[tmp]!=val){
				tmp=pathTo[tmp];
			}
			if(pathTo[tmp]==val) System.out.print(i+" ");
			System.out.println();
		}
	}
	
	void testBfs(){
		BFS(new GraphNode(1));
		connectedNodes(new GraphNode(1));
	}
	
	void testDfs(){
		GraphNode n= new GraphNode(1);
		visited[n.data]=true;
		pathTo[n.data]=n.data;
		dfs(new GraphNode(1));
	}
	
	/*Time Complexity: O(V+E) where V is number of vertices in the graph and E is number of edges in the graph.*/
	boolean detectCycle(GraphNode s){
		q.add(s);
		visited[s.data] = true;
		pathTo[s.data] = s.data;
		boolean flag=false;
		while(!q.isEmpty()){
			GraphNode tmp = q.remove();
			for(GraphNode n : adj[tmp.data]){
				if(!visited[n.data]){
					pathTo[n.data]=tmp.data;
					//System.out.print(n.data+",");
					q.add(n);
					visited[n.data]=true;
				}else {
					flag=true;	
					break;
				}
			}
			if(flag==true) break;
		}
		return flag;
	}
	
	void topoSort(GraphNode s, Stack<Integer> stk){
		if(s==null) return;
		for(GraphNode n : adj[s.data]){
			if(!visited[n.data]){
				visited[n.data]=true;
				topoSort(n,stk);
				stk.push(n.data);
				pathTo[n.data]=s.data;
			}
		}
		return;
	}
	
	void maxPath(GraphNode s){
		Stack<Integer> stk = new Stack<Integer>();
		int distTo[]= new int[n+1];
		for(int i=0;i<=n;i++) distTo[i]=-1;
		distTo[s.data]=0;
		
		topoSort(new GraphNode(1),stk);
		stk.push(1);
		
		while(!stk.isEmpty()){
			int n = stk.pop();
			for(GraphNode g1:adj[n]){
				int m =g1.data;
				if(distTo[m]<distTo[n]+1){
					distTo[m]=distTo[n]+1;
				}
			}
		}
		
		for(int i=0;i<=n;i++) System.out.println(distTo[i]);
	}
	
	void minPath(GraphNode s){
		Stack<Integer> stk = new Stack<Integer>();
		int distTo[]= new int[n+1];
		for(int i=0;i<=n;i++) distTo[i]=1000;
		distTo[s.data]=0;
		
		topoSort(new GraphNode(1),stk);
		stk.push(1);
		
		while(!stk.isEmpty()){
			int n = stk.pop();
			for(GraphNode g1:adj[n]){
				int m =g1.data;
				if(distTo[m]>distTo[n]+1){	
					distTo[m]=distTo[n]+1;
				}
			}
		}
		
		for(int i=0;i<=n;i++) System.out.println(distTo[i]);
	}
	public static void main(String[] args) {
		DirectedGraph g1= new DirectedGraph("graph.txt");
//		Stack<Integer> stk = new Stack<Integer>();
//		g1.topoSort(new GraphNode(1),stk);
//		stk.push(1);
//		while(!stk.isEmpty())
//			System.out.println(stk.pop());
		g1.minPath(new GraphNode(1));
	}

}

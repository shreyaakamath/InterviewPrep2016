/**
 * http://stackoverflow.com/questions/14917375/cannot-create-generic-array-of-how-to-create-an-array-of-mapstring-obje
 * cannot directly create array of generic type .therefor on RHS array is initialised without data type in <>. Need to caste it to the specific type
 * 
 * http://www.geeksforgeeks.org/breadth-first-traversal-for-a-graph/
 * http://www.geeksforgeeks.org/depth-first-traversal-for-a-graph/
 */
package graph.operations;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;


public class UndirectedGraph {
	
	ArrayList<GraphNode>[] adj; 
	int n;
	int e;
	Queue<GraphNode> q;
	boolean visited[];
	int pathTo[];
	
	UndirectedGraph(String path){

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
			adj[v].add(new GraphNode(u));//this makes it an undirected graph 
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
	void detectCycle(GraphNode s){
		int node[]= new int[n];
		int subset[]= new int[n];
		q.add(s);
		visited[s.data] = true;
		pathTo[s.data] = s.data;
		while(!q.isEmpty()){
			GraphNode tmp = q.remove();
			for(GraphNode n : adj[tmp.data]){
				subset[n.data] = tmp.data;
				if(!visited[n.data]){
					pathTo[n.data]=tmp.data;
					//System.out.print(n.data+",");
					q.add(n);
					visited[n.data]=true;}
				else continue;
			}
		}
	}
	public static void main(String[] args) {
		UndirectedGraph g1= new UndirectedGraph("graph.txt");
	}

}

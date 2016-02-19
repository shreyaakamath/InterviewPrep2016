
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class GraphNode implements Comparable<GraphNode>{
	int src;
	int dest;
	int weight;
	
	GraphNode(int src,int dest,int weight){
		this.src=src;this.dest=dest;this.weight=weight;
	}
	
	public int compareTo(GraphNode that){
		if(this.weight<that.weight) return -1;
		else if(this.weight>that.weight) return 1;
		else return 0;
	}
}

public class GraphPath {
	ArrayList<GraphNode>[] adj;
	int n;
	int e;
	boolean visited[];
	int pathTo[];
	Stack<Integer> reversePost;
	Stack<Integer> cycle;
	boolean[] onStack;
	
	GraphPath(String path){
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
		reversePost=new Stack<Integer>();
		cycle=new Stack<Integer>();
		visited = new boolean[n+1];
		pathTo = new int[n+1];
		onStack=new boolean[n+1];
		
		for(int i=0;i<e;i++){
			int u=scan.nextInt();
			int v=scan.nextInt();
			int weight=scan.nextInt();
			GraphNode tmp= new GraphNode(u,v,weight);
			adj[u].add(tmp);
//			adj[v].add(u);//this makes it an undirected graph 
		}
	}
	
	
	
	/*DFS recursive with util function. DFS modified to support topological sorted order , cycle detection*/
	void dfsRecur(int start){
		visited[start]=true;
		onStack[start]=true;
		for(GraphNode node:adj[start]){
			int i=node.dest;
			if(!cycle.isEmpty()) return;
			else if(!visited[i]){
				pathTo[i]=start;
				dfsRecur(i);
			}else if(onStack[i]){
				cycle.push(i);
				cycle.push(start);
				int temp=start;
				while(pathTo[temp]!=i){
					cycle.push(pathTo[temp]);
					temp=pathTo[temp];
				}
				cycle.push(i);
			}
		}
		onStack[start]=false;
		reversePost.push(start);
	}
	
	/*shortest path in directed acyclic graph */
	void shortestLongestPath(int source,boolean shortest){
		int[] dist= new int[n+1];
		if(shortest) Arrays.fill(dist,Integer.MAX_VALUE);
		else Arrays.fill(dist,Integer.MIN_VALUE);
		dist[source]=0;
		visited[1]=true;
		dfsRecur(1);
		while(!reversePost.isEmpty()){
			int temp=reversePost.pop();
			for(GraphNode node:adj[temp]){
				int i=node.dest;
				if(shortest){
					if(dist[i]>dist[temp]+node.weight){
						dist[i]=dist[temp]+node.weight;
					}
				}else{
					if(dist[i]<dist[temp]+node.weight){
						dist[i]=dist[temp]+node.weight;
					}
				}
			}
		}
		
		for(int i=1;i<=n;i++)
			System.out.println(dist[i]);
	}
	
	public static void main(String[] args) {
		GraphPath g = new GraphPath("DAGWeighted.txt");
		g.shortestLongestPath(1,false);
	}

}

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;


public class GraphPrims {
	ArrayList<GraphNode>[] adj;
	int n;
	int e;
	boolean visited[];
	int pathTo[];
	Stack<Integer> reversePost;
	Stack<Integer> cycle;
	boolean[] onStack;
	GraphPrims(String path){
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
	
	void visit(int v,PriorityQueue<GraphNode> pq){
		visited[v]=true;
		for(GraphNode e:adj[v]){
			int w=e.src==v?e.dest:e.src;
			if(!visited[w]) pq.add(e);
		}
	}
	void prims(){
		PriorityQueue<GraphNode> pq= new PriorityQueue<GraphNode>();
		LinkedList<GraphNode> mst= new LinkedList<GraphNode>();
		visit(1,pq);
		while(!pq.isEmpty()){
			GraphNode min=pq.remove();
			int v=min.src;
			int w=min.dest;
			if(visited[v] && visited[w]) continue;
			mst.addLast(min);
			if(!visited[v]) visit(v,pq);
			if(!visited[w]) visit(w,pq);
		}
		for(GraphNode n:mst) System.out.println("src-"+n.src+" dst-"+n.dest+" edge="+n.weight);
		
	}
	public static void main(String[] args) {
		GraphPrims g = new GraphPrims("DAGWeighted.txt");
		g.prims();
	}

}

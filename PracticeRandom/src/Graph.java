
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class Edge{
	int src;
	int dest;
	Edge(int src,int dest){
		this.src=src;
		this.dest=dest;
	}
}

public class Graph {
	ArrayList<Integer>[] adj;
	List<Edge> edges;
	int n;
	int e;
	Queue<Integer> q;
	boolean visited[];
	int pathTo[];
	Stack<Integer> reversePost;
	Stack<Integer> cycle;
	boolean[] onStack;
	
	Graph(String path){
		File file = new File(path);
		Scanner scan=null;
		try {
			scan = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		n = scan.nextInt();
		e = scan.nextInt();
		adj = (ArrayList<Integer>[])new ArrayList[n+1];
		for(int i=0;i<=n;i++){
			adj[i]= new ArrayList<Integer>();
		}
		q=new LinkedList<Integer>();
		edges=new ArrayList<Edge>();
		reversePost=new Stack<Integer>();
		cycle=new Stack<Integer>();
		visited = new boolean[n+1];
		pathTo = new int[n+1];
		onStack=new boolean[n+1];
		
		for(int i=0;i<e;i++){
			int u=scan.nextInt();
			int v=scan.nextInt();
			edges.add(new Edge(u,v));
			adj[u].add(v);
//			adj[v].add(u);//this makes it an undirected graph 
		}
	}
	
	/*detect cycle in undirected graph using union find*/
	int find(int[] parent,int x){
		if(parent[x]==-1) return x;
		else return find(parent,parent[x]);
	}
	
	void union(int parent[] , int x,int y){
		int xset=find(parent,x);
		int yset=find(parent,y);
		parent[xset]=yset;
	}
	boolean detectCycleUndirected(){
		int[] parent= new int[n];
		Arrays.fill(parent,-1);
		boolean flag=false;
		for(Edge e:edges){
			int x= find(parent,e.src);
			int y=find(parent,e.dest);
			if(x==y) {flag=true;break;}
			else union(parent,x,y);
		}
		return flag;
	}
	
	/*DFS iterative with util function*/
	void dfsIter(int start){
		Stack<Integer> stack=new Stack<Integer>();
		visited[start]=true;
		pathTo[start]=start;
		stack.push(start);
		while(!stack.isEmpty()){
			int temp=stack.pop();
			System.out.println(temp);
			for(int i:adj[temp]){
				if(!visited[i]){
					visited[i]=true;pathTo[i]=temp;
					stack.push(i);
				}
			}
		}
	}
	void dfsUtil(){
		for(int i=1;i<=n;i++){
			if(!visited[i])dfsIter(i);
		}
	}
	
	/*DFS recursive with util function. DFS modified to support topological sorted order , cycle detection*/
	void dfsRecur(int start){
		visited[start]=true;
		onStack[start]=true;
		for(int i:adj[start]){
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
	
	boolean detectCycle(){
		for(int i=1;i<=n;i++){
			if(!visited[i])dfsRecur(i);
		}
		if(!cycle.isEmpty()){
			while(!cycle.isEmpty()) System.out.println(cycle.pop());
			return true;
		}else{
			return false;
		}
	}
	void TopoSort(){
		visited[1]=true;
		dfsRecur(1);
		while(!reversePost.isEmpty()){
			System.out.println(reversePost.pop());
		}
	}
	
	/*BFS iterative*/
	void bfs(int start){
		LinkedList<Integer> stack=new LinkedList<Integer>();
		visited[start]=true;
		pathTo[start]=start;
		stack.addLast(start);
		while(!stack.isEmpty()){
			int temp=stack.removeFirst();
			System.out.println(temp);
			for(int i:adj[temp]){
				if(!visited[i]){
					visited[i]=true;pathTo[i]=temp;
					stack.addLast(i);
				}
			}
		}
		
	}
	/*shortest path in directed acyclic graph */
	void shortesPath(int source){
		int[] dist= new int[n];
		Arrays.fill(dist,Integer.MAX_VALUE);
		dist[source]=0;
		
		visited[1]=true;
		dfsRecur(1);
		while(!reversePost.isEmpty()){
			int temp=reversePost.pop();
			for(int i:adj[temp]){
			}
		}
		
		
	}
	public static void main(String[] args) {
		Graph g = new Graph("graph.txt");
		System.out.println(g.detectCycleUndirected());
	}

}

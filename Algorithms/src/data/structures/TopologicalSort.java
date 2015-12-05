package data.structures;

public class TopologicalSort {
	boolean marked[];
	Queue<Integer> pre;
	Queue<Integer> post;
	Stack<Integer> reversePost;
	
	TopologicalSort(DirectedGraph d1){
		marked = new boolean[d1.v];
		pre = new Queue<Integer>(d1.v);
		post = new Queue<Integer>(d1.v);
		reversePost = new Stack<Integer>(d1.v);
	}
	
	void getOrder(DirectedGraph d1){
		dfs(d1,0);
		for(int i=0;i<d1.v;i++)
			if(!marked[i]) dfs(d1, i);
	}
	void dfs(DirectedGraph d1 , int v){
		if(marked[v]) return; 
		pre.enqueue(v);
		marked[v] = true;
		for(int n : d1.adj[v])
			dfs(d1,n);
		post.enqueue(v);
		reversePost.push(v);
	}
	
	void printPrePath(){
		while(!pre.isEmpty()){
			System.out.println(pre.dequeue());
		}
	}
	
	public static void main(String args[]){
		DirectedGraph  d1 = new DirectedGraph(GraphAdjList.getScanner("C:\\Users\\shreyak.NETAPP\\Documents\\personal\\algorithms\\Algorithms\\src\\data\\structures\\integer.txt"));
		TopologicalSort t1 = new TopologicalSort(d1);
		t1.getOrder(d1);
		//t1.printPrePath();
		t1.reversePost.printStackValues();
	}
}

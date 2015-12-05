package data.structures;

public class BreadthFirstSearch {

	boolean[] marked; 
	int[] edgeTo;
	int[] nodeId;
	int count;
	
	public BreadthFirstSearch(GraphAdjList g1) {
		marked = new boolean[g1.v];
		edgeTo = new int[g1.v];
		nodeId = new int[g1.v];
		count=1;
	}
	
	void bfs(int source, GraphAdjList g1){
		Queue<Integer> q1 = new Queue<Integer>(g1.v);
		q1.enqueue(source);
		int currentNode;
		//queue size is equal to no of vertices but if there are disconnected components then will get npe when accessing queueu
		int count =1;
		while(count!=0){
			currentNode = q1.dequeue();
			count--;
			marked[currentNode] = true;
			nodeId[currentNode] = count;
			for(int num : g1.adj[currentNode]){
				if(!marked[num]){
					edgeTo[num] = currentNode;
					q1.enqueue(num);
					count++;
				}
			}
		}
	}
	
	Stack<Integer> getPathTo(int v, GraphAdjList g1,int source){
		bfs(source,g1);
		Stack<Integer> s1 = new Stack<Integer>(g1.v);
		s1.push(v);
		while(edgeTo[v]!=source){
			s1.push(edgeTo[v]);
			v=edgeTo[v];
		}
		s1.push(source);
		return s1;
	}
	
	void connectedComp(GraphAdjList g1){
		bfs(0,g1);
		for(int i=0;i<g1.v;i++)
			//if node is not marked after bfs from 0 , then it is a diff component
			if(!marked[i]) {
				count+=1;
				bfs(i,g1);
			}
	}
	
	public static void main(String args[]){
		GraphAdjList g1 = new GraphAdjList(GraphAdjList.getScanner("C:\\Users\\shreyak.NETAPP\\Documents\\personal\\algorithms\\Algorithms\\src\\data\\structures\\tiny.txt"));
		BreadthFirstSearch b1 = new BreadthFirstSearch(g1);
		b1.bfs(0, g1);
		for(boolean val : b1.marked) System.out.println(val);
		Stack<Integer> s1 = b1.getPathTo(3, g1, 1);
		s1.printStackValues();
		
		b1.connectedComp(g1);
		System.out.println(b1.count);
		
		
	}
}

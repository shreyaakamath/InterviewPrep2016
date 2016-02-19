package Backtracking;

public class ColorGraph {

	boolean safe(int[][] graph , int vertex, int color , int n,int[] ans){
		for(int i=0;i<n;i++){
			if(graph[vertex][i]==1){
				if(ans[i]==color) return false;
			}
		}
		return true;
	}
	
	boolean markUtil(int[][] graph , int vertex , int[] ans , int n , int m){
		if(vertex==n) return true;
		for(int i=1;i<=m;i++){
			if(safe(graph,vertex,i,n,ans)){
				ans[vertex]=i;
				if(markUtil(graph,vertex+1,ans,n,m)==true) return true;
				else ans[vertex]=0;
			}
		}
		return false;
	}
	void mark(int[][] graph , int n , int m ){
		int[] ans = new int[n];
		if(markUtil(graph,0,ans,n,m)==false) System.out.println("no sol");
		else {
			for(int i=0;i<n;i++) System.out.println(ans[i]);
		}
	}
	public static void main(String[] args) {
		ColorGraph c = new ColorGraph();
		int[][] graph = {{0, 1, 1, 1},
		        {1, 0, 1, 0},
		        {1, 1, 0, 1},
		        {1, 0, 1, 0}};
		int m=3;
		c.mark(graph,4,3);

}
}

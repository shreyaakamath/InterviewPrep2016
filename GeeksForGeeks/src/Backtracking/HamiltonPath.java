package Backtracking;

import java.util.Arrays;

public class HamiltonPath {
	
	boolean isSafe(int v, int[][] graph, int[] path , int pos){
		//new vertex should be adjacent
		if(graph[path[pos-1]][v]==0) return false;
		//new vertex should not already be on the path
		for(int i=0;i<pos;i++){
			if(path[i]==v) return false;
		}
		return true;
	}
	boolean hamilUtil(int[][] graph,int n,int[] path,int pos){
		if(pos==n) {
			if(graph[path[n-1]][path[0]] ==1 ){ return true;}
			else{ return false;}
			
		}
		for(int v=1;v<n;v++){
			if(isSafe(v,graph,path,pos)){
				path[pos]=v;
				if(hamilUtil(graph,n,path,pos+1)==true) {	return true;}
				else {path[pos]=-1;}
			}
		}
		return false;
	}
	void hamil(int[][] graph, int n ){
		int[] path= new int[n];
		Arrays.fill(path,-1);
		path[0]=0;
		if(hamilUtil(graph,n,path,1)==false) System.out.println("no path");
		else { for(int i=0;i<n;i++)System.out.println(path[i]);}
	}
	
	public static void main(String[] args) {
		HamiltonPath hp = new HamiltonPath();
		int[][] graph={{0, 1, 0, 1, 0},
            {1, 0, 1, 1, 1},
            {0, 1, 0, 0, 1},
            {1, 1, 0, 0, 1},
            {0, 1, 1, 1, 0},
           };
		hp.hamil(graph,5);
	}

}

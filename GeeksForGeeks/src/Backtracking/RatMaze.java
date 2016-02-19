package Backtracking;

import java.util.Arrays;

public class RatMaze {

	void printSol(int[][] sol, int n ){
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				System.out.print(sol[i][j]+" ");
			}
			System.out.println();
		}
	}
	 void mazePath(int n ){
		 int[][] maze= { {1, 0, 0, 0},
		        {1, 1, 0, 1},
		        {0, 1, 0, 0},
		        {1, 1, 1, 1}};
//		 for(int i=0;i<n;i++){
//			 Arrays.fill(maze[i],0);
//		 }
		 maze[0][0]=2;
		 int[] movex={1,0};
		 int[] movey={0,1};
		 if(mazePathUtil(0,0,maze,movex,movey,n)==false) System.out.println("no sol");
		 else printSol(maze,n);
	 }
	 boolean safe(int x, int y, int[][] maze, int n ){
		 return x>=0 && x<n && y>=0 && y<n && maze[x][y]==1;
	 }
	 boolean mazePathUtil(int x, int y, int[][]maze,int[] movex,int[]movey,int n){
		 if(x==n-1 && y==n-1){
			 maze[x][y]=2;
			 return true;
		 }
		 for(int i=0;i<2;i++){
			 int newx=x+movex[i];
			 int newy=y+movey[i];
			 if(safe(newx,newy,maze,n)){
				 maze[newx][newy]=2;
				 if(mazePathUtil(newx,newy,maze,movex,movey,n)==true){
					 return true;
				 }else{
					 maze[newx][newy]=1;
				 }
			 }
		 }
		 return false;
	 }
	public static void main(String[] args) {
		RatMaze rm = new RatMaze();
		rm.mazePath(4);
	}

}

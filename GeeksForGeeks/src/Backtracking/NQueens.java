package Backtracking;

import java.util.Arrays;

public class NQueens {
	void printSol(int[][] sol, int n ){
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				System.out.print(sol[i][j]+" ");
			}
			System.out.println();
		}
	}
	boolean isSafe(int row , int col , int[][]sol){
		//check if queen present in same row
		for(int i=0;i<col;i++) if(sol[row][i]==1) return false;
		
		//check upper left diagonal
		for(int i=0;i<row;i++) if(sol[i][i]==1) return false;
		
		//check for lower left diagonal
		if(row>=3) return true;
		for(int i=row+1;i>=0;i--) if(sol[i][i]==1) return false;
		
		return true;
	}
	
	boolean setQueenUtil(int col,int[][]sol,int n){
		if(col>=n) return true;
		for(int newRow=0;newRow<n;newRow++){
			if(isSafe(newRow,col,sol)){
				sol[newRow][col]=1;
				if(setQueenUtil(col+1,sol,n)==true) return true;
				else sol[newRow][col]=0;
			}
		}
		return false;
	}
	void setQueen(int n){
		int[][] sol = new int[n][n];
		for(int i=0;i<n;i++) Arrays.fill(sol[i],0);
		if(setQueenUtil(0,sol,n)==false) System.out.println("no sol");
		else printSol(sol,n);
	}
	public static void main(String[] args) {
		NQueens q= new NQueens();
		q.setQueen(4);
	}

}

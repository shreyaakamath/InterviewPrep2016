package Backtracking;

import java.util.Arrays;

public class KnightTour {

	boolean isSafe(int x , int y, int[][] sol, int n ){
		return (x>=0 && x<n && y>=0 && y<n && sol[x][y]==-1);
	}
	
	void printSol(int[][] sol){
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				System.out.print(sol[i][j]+" ");
			}
			System.out.println();
		}
	}
	void solveKT(){
		int[][] sol= new int[8][8];
		for(int i=0;i<8;i++)
			Arrays.fill(sol[i],-1);
		int[] movex={  2, 1, -1, -2, -2, -1,  1,  2 };
		int[] movey ={  1, 2,  2,  1, -1, -2, -2, -1 };
		sol[0][0]=0;
		if(solveKtUtil(0,0,1,sol,movex,movey,8)==false) {System.out.println("no solution");printSol(sol);}
		else {
			printSol(sol);
		}
	}
	
	boolean solveKtUtil(int x , int y , int val , int[][] sol , int[] movex, int[] movey, int n ){
		if(val==n*n) return true;
		int newx=0;int newy=0;
		for(int i=0;i<8;i++){
			newx=x+movex[i];
			newy=y+movey[i];
			if(isSafe(newx,newy,sol,8)){
				sol[newx][newy]=val;
				if(solveKtUtil(newx,newy,val+1,sol,movex,movey,n)==true)
					return true;
				else
					sol[newx][newy]=-1;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		KnightTour kt = new KnightTour();
		kt.solveKT();
	}

}

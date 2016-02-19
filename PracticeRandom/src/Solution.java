import java.util.Arrays;
import java.util.Scanner;


public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		Scanner scan = new Scanner(System.in);
//		int n=scan.nextInt();
//		int m=scan.nextInt();
//		long[] arr= new long[n+1];
//		for(int i=0;i<m;i++){
//			int first=scan.nextInt();
//			int second=scan.nextInt();
//			int add=scan.nextInt();
//			arr[first]+=add;
//			if(second+1<=n)
//			arr[second+1]-=add;
//		}
//		long max=-1;long sum=0;
//		for(int i=1;i<=n;i++){
//			sum+=arr[i];
//			if(sum>max) max=sum;
//		}
//		System.out.println(max);
//		String[] arr={"X","o","o"};
		String[] arr={"Xoo"};
		String[] ans=generateSensorNetworkRoutes(arr);
		for(int i=0;i<ans.length;i++)
			System.out.println(ans[i]);
	}
	
	static String[] generateSensorNetworkRoutes(String[] input) {
		int m=input.length;
		int n=input[0].length();
		char[][] sol = new char[m][n];
		boolean found=false;
		int x=0;int y=0;
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				sol[i][j]=input[i].charAt(j);
				if(!found && sol[i][j]=='o'){
					found=true;
					x=i;y=j;
				}
			}
		}
		int[] movex={-1,0,1,0};//north , east , south , west
		int[] movey={0,1,0,-1};
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(sol[i][j]=='o'){
					backtrack(sol,i,j,movex,movey,m,n,i,j);
				}
			}
		}
//		backtrack(sol,x,y,movex,movey,m,n,x,y);
		String[] arr=new String[m];
		for(int i=0;i<m;i++){
			StringBuilder str=new StringBuilder();
			for(int j=0;j<n;j++){
				str.insert(j,sol[i][j]);
			}
			arr[i]=str.toString();
		}
		return arr;
    }
	
	static boolean isSafe(char[][] sol , int x , int y, int m , int n,int oldx,int oldy){
		if(x==oldx && y==oldy) return false;
		if(x<0 || x>=m) return false;
		if(y<0 || y>=n) return false;
		if(sol[x][y]=='F') return false;
//		if(sol[x][y]=='^'||sol[x][y]=='>'||sol[x][y]=='v'||sol[x][y]=='<')return false;
		return true;
	}
	static char getArrow(int i){
		char ans='0';
		switch(i){
		case 0:ans='^';break;
		case 1:ans= '>';break;
		case 2:ans= 'v';break;
		case 3:ans= '<';break;
		}
		return ans;
	}
	static boolean isArrow(char c){
		switch(c){
		case '^':return true;
		case '>':return true;
		case 'v': return true;
		case '<' :return true;
		}
		return false;
	}
	static boolean backtrack(char[][] sol, int x, int y,int[] movex,int[] movey,int m , int n,int oldx,int oldy){
		if(sol[x][y]=='X') return true;
		int newx;int newy;
		for(int i=0;i<4;i++){
			newx=x+movex[i];
			newy=y+movey[i];
			if(isSafe(sol,newx,newy,m,n,oldx,oldy)){
				if(isArrow(sol[newx][newy])){sol[x][y]=sol[newx][newy];break;}
				char old=sol[x][y];
				sol[x][y]=getArrow(i);
				if(backtrack(sol,newx,newy,movex,movey,m,n,x,y)) return true;
				else {
					sol[newx][newy]=old;
				}
			}
		}
		char a='a';char b='b';
		return false;
	}
}

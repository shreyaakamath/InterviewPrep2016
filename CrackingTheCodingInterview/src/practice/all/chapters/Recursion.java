package practice.all.chapters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

enum Color{
black,pink,green,yellow,orange;	
}
public class Recursion {
	
	static int fibRecur(int a){
		if(a==0) return a;
		else if(a==1) return a;
		else return fibRecur(a-1)+fibRecur(a-2);
	}
	
	static int fibIter(int a){
		int m=0;
		int n=1;
		for(int i=2;i<=a;i++){
			int tmp=n;
			n=m+n;
			m=n;
		}
		return n;
	}
	
	/*count number of paths from top left to bottom right*/
	static int path(int i,int j, int m){
		if(i==m-1 && j==m-1) return 1;
		if(i>=m) return 0;
		if(j>=m) return 0;
		return path(i+1,j,m)+path(i,j+1,m);
	}
	
	/*get all subsets of a list*/
	static List<List<Integer>> getSubsets(int[] a, int i , int j){
		List<List<Integer>> finalList = new ArrayList<List<Integer>>();
		List<Integer> list1= new ArrayList<Integer>();
		List<Integer> list3= new ArrayList<Integer>();
		List<Integer> list2= new ArrayList<Integer>();
		
		if(j-i==2){
			list1.add(a[i]);
			list2.add(a[j-1]);
			list3.add(a[i]);list3.add(a[j-1]);
			finalList.add(list1);finalList.add(list2);finalList.add(list3);
		} else {
			finalList = getSubsets(a,i+1,j);
			for(List<Integer> l : finalList)
				l.add(a[i]);
		}
		return finalList;
	}
	
	static void addBaseSets(List<List<Integer>> list,int [] a){
//		List<Integer> all = new ArrayList<Integer>();
		for(int i=0;i<a.length;i++){
			List<Integer> tmp = new ArrayList<Integer>();
//			all.add(a[i]);
			tmp.add(a[i]);
			list.add(tmp);
		}
//		list.add(all);
	}
	
	/*generate all valid parenthesis*/
	static Set<String> brackets(int n){
		Set<String> set = new HashSet<String>();
		if(n==2){
			set.add("(())");
			set.add("()()");
		}else{
			for(String str:brackets(n-1)){
				set.add("()"+str);
				set.add(str+"()");
				set.add("("+str+")");
			}
		}
		return set;
	}
	
	static void bracketsCombi(int open , int close , String str){
		if(open==0 && close ==0) System.out.println(str);
		if(open>0) bracketsCombi(open-1,close+1,str+"(");
		if(close>0) bracketsCombi(open,close-1,str+")");
	}
	
	/*paint fill all pixels surrounding given point*/
	
	static void pixels(Color[][] arr , int i , int j , Color ocolor, Color ncolor,int m){
		if(i>=m || j>=m || i<0||j<0) return;
		if(arr[i][j]==ocolor){
			arr[i][j]=ncolor;
			pixels(arr,i+1,j,ocolor,ncolor,m);
			pixels(arr,i-1,j,ocolor,ncolor,m);
			pixels(arr,i,j+1,ocolor,ncolor,m);
			pixels(arr,i,j-1,ocolor,ncolor,m);
		}
	}
	static void pixelsFill(Color[][] arr , int i , int j,Color newColor){
		pixels(arr,i,j,arr[i][j],newColor,arr[0].length);
	}
	
	/*number of ways of representing n cents using 25,10,5,1 cent*/
	static int cent(int num , int arr[]){
		int sum=0;
		if(num==0) sum= 1;
		else{
			for(int i=0;i<arr.length;i++){
				if(arr[i]==num){sum=1;break;}
				if(arr[i]>num) continue;
				else  sum+=cent(num-arr[i],arr);
			}
		}
		return sum;
	}
	
	static int centRecur(int num , int[] arr , int i,int[][] table){
		if(num==0) return 1;
		if(i<0) return 0;
		if(num<0) return 0;
		if(table[num][i]==0){
			table[num][i]=centRecur(num,arr,i-1,table)+centRecur(num-arr[i],arr,i,table);
		}
		return table[num][i];
	}
	
	/*number of ways to place queen on chess board --> N queens problem*/
	static boolean check(int[] marked , int row){
		for(int i=0;i<row;i++){
			int diff = Math.abs(marked[i]-marked[row]);
			if(diff==0|| diff==row-i) return false;
		}
		return true;
	}
	static void placeQueen(int[] marked , int row){
		if(row==8) {
			System.out.print("queen placement --");
			for(int i=0;i<8;i++) System.out.print(marked[i]+" ");
			System.out.println();
			return;
		}
		for(int i=0;i<8;i++){
			marked[row]=i;
			if(check(marked,row)){
				placeQueen(marked,row+1);
			}
		}
	}
	public static void main(String[] args) {
//		int n =3;
//		System.out.println(fibIter(n-1));
//		System.out.println(path(0,0,n));
//		
		/*all subsets test*/
//		int[] a ={1,2,3,4};
//		List<List<Integer>> list = getSubsets(a,0,a.length);
//		addBaseSets(list,a);
//		for(List<Integer> l : list) {
//			for(int i: l){
//				System.out.print(i+" ");
//			}
//			System.out.println();
//		}
		/*balanced brackets test*/
//		int i=1;
//		for(String str:brackets(4)){
//			System.out.println(i+"-"+str);i++;
//		}
//		System.out.println();
//		bracketsCombi(4,0,"");
		
		/*paint fill test*/
//		Color[][] arr={{Color.black,Color.black,Color.black},{Color.green,Color.green,Color.green},{Color.yellow,Color.yellow,Color.yellow}};
//		for(int i=0;i<3;i++){
//			for(int j=0;j<3;j++){
//				System.out.print(arr[i][j]+ " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
//		pixelsFill(arr,1,1,Color.yellow);
//		for(int i=0;i<3;i++){
//			for(int j=0;j<3;j++){
//				System.out.print(arr[i][j]+ " ");
//			}
//			System.out.println();
//		}
		
		/*test for cents*/
//		int[] arr={1,2,3};
//		int num=4;
//		int len=arr.length;
//		int[][] table = new int[num+1][len];
////		System.out.println(cent(4,arr));
//		System.out.println(centRecur(num,arr,len-1,table));
//		
		int[] marked= new int[8];
		Arrays.fill(marked,-1);
		placeQueen(marked,0);
	}

}

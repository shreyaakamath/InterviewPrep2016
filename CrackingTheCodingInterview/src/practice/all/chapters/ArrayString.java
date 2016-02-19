package practice.all.chapters;

import java.util.ArrayList;
import java.util.List;

public class ArrayString {
	static String dupsDetectRemove(StringBuilder str){
		boolean[] arr = new boolean[256];
		int len=str.length();
		for(int i=0;i<len;i++){
			int val = str.charAt(i);
			if(arr[val]) {
				for(int j=i+1;j<len;j++){
					str.setCharAt(j-1,str.charAt(j));
				}
				len--;
			}else {
				arr[val]=true;
			}
		}
		return str.substring(0,len);
	}
	
	
	static void zero(int[][] a, int m , int n){
		List<Integer> rows= new ArrayList<Integer>();
		List<Integer> cols= new ArrayList<Integer>();
		boolean rowFlag=false;
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(a[i][j]==0){
					if(rows.contains(i)) {rowFlag=true;break;}
					if(cols.contains(j)){continue;}
					for(int p=0;p<n;p++) a[i][p]=0;
					for(int p=0;p<m;p++) a[p][j]=0;
					rows.add(i);
					cols.add(j);
				}
			}
			if(rowFlag) continue;
		}
	}
	public static void main(String[] args) {
		System.out.println(dupsDetectRemove(new StringBuilder("abacd")));
		String str1="abc";
		String str3= str1.concat(str1);
		int [][] a = {{1,0,3},{4,5,6},{8,7,8}};
		zero(a,3,3);
		for(int i=0;i<3;i++)
			for(int j=0;j<3;j++)
				System.out.print(a[i][j]+ " ");
		System.out.println();
	}

}

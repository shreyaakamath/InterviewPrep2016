package cracking.the.coding.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
/**
 * 
 * @author shreyakamath
 *1.1) determine if string has unique chars
 *1.2)reverse string 
 *1.3)remove dups in string 
 *1.4)are strings anagrams?
 *1.5) replace space by %20
 *1.6)rotate n*n matric by 90 degrees
 *1.7) zero row and column if any elements in matrix is zero 
 */
public class ArraysStrings {
	
	static void hashTables(){
		HashMap<Integer,String> ht = new HashMap<Integer,String>();
		ht.put(1,"hello");
		ht.put(2,"bye");
		for(Map.Entry<Integer,String> entry:ht.entrySet()){
			System.out.println(entry.getKey()+"-"+entry.getValue());
		}
		
		StringBuffer sb = new StringBuffer();
		sb.append("hi");
		System.out.println(sb.toString());
	}

	static boolean strUnique1(String s){
		/*sol1*/
		Set<Character> set = new HashSet<Character>();
		for(int i=0;i<s.length();i++){
			if(set.contains(s.charAt(i))) return false;
			else set.add(s.charAt(i));
		}
		return true;
	}
	static boolean strUnique2(String s){
	/*if set is not available*/
		boolean[] dup = new boolean[256];
		for(int i=0;i<s.length();i++){
			int n = s.charAt(i);
			if(dup[n]) return false;
			else dup[n]=true;
		}
		return true;
	}
	static void strReverse(String str){
		/*in-place reverse*/
		char[] s = str.toCharArray();
		int n = s.length;
		for(int i=0;i<n;i++){
			if(n%2!=0) if(i==n/2) break;
			else if(i>n/2) break;
			char a = s[i];
			char b = s[n-i-1];
			s[i] = b;
			s[n-i-1] = a;
		}
		System.out.println(Arrays.toString(s));
	}
	
	static void removeDups(String str){
		char[] newStr = new char[str.length()];
		Set<Character> set = new HashSet<Character>();
		int j=0;
		for(int i =0;i<str.length();i++){
			if(set.add(str.charAt(i))){
				newStr[j++] = str.charAt(i);
			}
		}
		System.out.println(Arrays.toString(newStr));
	}
	
	/*complexity O(n) */
	static boolean anagrams(String str1 , String str2){
		int len1 = str1.length();
		int len2 = str2.length();
		boolean flag = true;
		if(len1!=len2) {flag = false;}
		char[] arr1 = str1.toCharArray();
		char[] arr2 = str2.toCharArray();
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		if(Arrays.toString(arr1)==Arrays.toString(arr2)){flag=true;}
		/*else{
			for(int i =0;i<str1.length();i++){
				if(arr1[i] == arr2[i]) continue;
				else {flag=false;break;}
			}
		}*/
		if(flag){System.out.println("anagrams");}
		else{System.out.println("not anagrams");}
		return flag;
	}
	
	
	static void replaceSpace(String str){
		//method1
		String str1 = str.replace(' ','#');
		System.out.println(str1);
		
		//method2
		String[] arr = str.split(" ");
		int n = arr.length;
		//adding to string iteratively so need to use string builder. with string we will land up creating many extra string copies
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++){
			sb.append(arr[i]);
			if(i!=(n-1))
			sb.append("%20");
		}
		System.out.println(sb.toString());
	}
	
	static void arrayRotate(int[][] arr, int n ){
		int[][] arr2 = new int[n][n];
		for(int i =0;i<n;i++){
			for(int j=0;j<n;j++){
				arr2[n-i-1][j]=arr[j][i];
			}
		}
		printArr(arr2,n);
		}
	
	static void printArr(int[][] arr , int n ){
		for(int i =0;i<n;i++){
			for(int j=0;j<n;j++){
				System.out.print(arr[i][j]);
			}
			System.out.println();
			}
	}
	static void matrixZero(int[][] arr, int n ){
		List<Integer> found = new ArrayList<Integer>();
		//locate all zero elements
		for(int i=0;i<n;i++){
			for(int j =0;j<n;j++){
				if(arr[i][j]==0){
					int pos = (n+1)*(i+1)-(n-j) -1;
					found.add(pos);
				}
			}
		}
		//zero the row and column only for original found elements
		for(int i=0;i<n;i++){
			for(int j =0;j<n;j++){
				if(arr[i][j]==0){
					int pos = (n+1)*(i+1)-(n-j) -1;
					if(found.contains(pos)){
						for(int p =0;p<n;p++){
							arr[i][p] =0;arr[p][j]=0;
						}
					}
				}
			}
		}
		printArr(arr,n);
	}
	
	static boolean isSubstring(String str1, String str2){
		return str1.toLowerCase().contains(str2.toLowerCase());
	}
	static void strRotate(String str1, String str2){
		String str3 = str1+str1;
		if(isSubstring(str3,str2)) System.out.println("rotated");
		else System.out.println("not rotated ");
	}
	public static void main(String[] args) {
//		hashTables();'
//		strReverse("hello");
//		removeDups("aaccbb");
//		anagrams("schoolmaster","theclassroom");
//		System.out.println(strUnique1("abbc"));
//		replaceSpace("abc def");
//		int[][] arr = {{1,2,3},{4,0,6},{7,8,1}};
//		arrayRotate(arr,3);
//		matrixZero(arr,3);
		strRotate("roar","oarr");
	}

}

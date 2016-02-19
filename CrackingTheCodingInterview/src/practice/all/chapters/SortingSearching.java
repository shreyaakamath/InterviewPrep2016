package practice.all.chapters;

import java.util.Arrays;
import java.util.Comparator;

/*custom comparator*/
class AnagramComparator implements Comparator<String>{
	/*check if str is anagram*/
	public String sortChars(String str){
		char[] c= str.toCharArray();
		Arrays.sort(c);
		return new String(c);
	}
	
	public int compare(String str1, String str2){
		return sortChars(str1).compareTo(sortChars(str2));
	}
}
class HtWt{
	int ht;
	int wt;
	HtWt(int a , int b){
		this.ht=a;
		this.wt=b;
	}
}
class htComparator implements Comparator<HtWt>{
	public int compare(HtWt a, HtWt b){
		if(a.ht == b.ht) return 0;
		else if(a.ht>b.ht) return 1;
		else return -1;
	}
}
class wtComparator implements Comparator<HtWt>{
	public int compare(HtWt a, HtWt b){
		if(a.wt == b.wt) return 0;
		else if(a.wt>b.wt) return 1;
		else return -1;
	}
}

public class SortingSearching {
	/*sort strings so anagrams are next to each other*/
	static void sortAnagrams(String[] arr){
		Arrays.sort(arr,new AnagramComparator());
	}
	
	/*merge two sorted arrays into first array*/
	static void merge(int[] a , int [] b, int boundary){
		int i=0;int len1=a.length;
		int j=0;int len2=b.length;
		while(i<boundary && j<len2){
			if(a[i]<b[j]) i++;
			else {
				for(int k=boundary-1;k>=i;k--) a[k+1]=a[k];
				a[i]=b[j];
				i++;j++;boundary++;
			}
		}
		if(i>=boundary){
			for(int k=j;k<len2;k++){
				a[i]=b[k];i++;
			}
		}
	}
	
	/*binary search on rotated array*/
	static int findPivot(int[] arr , int start, int end){
		if(start>end) return -1;
		if(start==end) return start;
		int mid=(start+end)/2;
		int pivot=0;
		if(arr[mid-1]>=arr[mid] && arr[mid+1]>=arr[mid]) return mid; // mid is pivot
		if(arr[mid+1]>=arr[mid] && arr[mid]>arr[start]) { pivot= findPivot(arr,mid+1,end);} // pivot is left of mid
		if(arr[mid+1]>=arr[mid] && arr[mid]<arr[start]) {pivot= findPivot(arr,start,mid);} // pivot is right of mid
		if(arr[mid+1]<arr[mid]){ pivot=mid+1;} // next of mid is pivot
		return pivot;
	}
	
	static boolean binSearhIter(int[] arr,int find){
		int start=0;
		int end=arr.length;
		int mid=0;boolean flag=false;
		while(start<end){
			mid=(start+end)/2;
			if(arr[mid+1]<arr[mid]) {flag=true;break;}
			else if(find>arr[mid]) {start=mid+1;}
			else if(find<arr[mid]) {end=mid;}
		}
		return flag;
	}
	
	static boolean binSearch(int find,int[] arr , int start, int end){
		if(start>=end) return false;
		int mid=(start+end)/2;
		if(arr[mid]==find) return true;
		if(find>arr[mid]) return binSearch(find,arr,mid+1,end);
		else return binSearch(find,arr,start,mid);
	}
	static boolean search(int[] arr,int find){
		int pivot = findPivot(arr,0,arr.length);
		return binSearch(find,arr,0,pivot) || binSearch(find,arr,pivot,arr.length);
	}
	
	/*bin search on strings with many empty strings in array*/
	static int binSearchStr(String[] arr , int start , int end , String find){
		int result=0;
		if(start>=end) return -1;
		int mid=(start+end)/2;
		int original=mid;
		while(mid<end && arr[mid].isEmpty()) mid++;
		if(mid>=end){ result= binSearchStr(arr,start,original,find);}
		else{
			if(arr[mid].equals(find)) result=mid;
			else if(find.compareTo(arr[mid])<0) result= binSearchStr(arr,start,mid,find);
			else if(find.compareTo(arr[mid])>0) result=binSearchStr(arr,mid+1,end,find);
		}
		return result;
	}
	
	/*search for elem in sorted matrix*/
	static boolean searchMat(int[][] mat , int find){
		int n = mat[0].length;
		int row=0;int col=n-1;
		while(row<n && col >=0){
			if(mat[row][col]==find) return true;
			else if(mat[row][col] > find ) col--;
			else row++;
		}
		return false;
	}
	
	/*ht wt tower in asceding order*/
	static void tower(HtWt[] arr){
		Arrays.sort(arr,new htComparator());
		Arrays.sort(arr,new wtComparator());
		int count=1;int max=-1;
		for(int i=0;i<arr.length-1;i++){
			if(arr[i].ht<arr[i+1].ht && arr[i].wt <arr[i+1].wt) {
				count++;
				if(count>max) max=count;
			}else {
				count=0;
			}
		}
		System.out.println(max);
	}
	public static void main(String[] args) {
		/*test merge*/
//		int[] a={1,3,5,7,0,0,0,0};
//		int[] b={1,4,6,10};
//		merge(a,b,4);
//		for(int i=0;i<a.length;i++)System.out.println(a[i]);
		
		/*test anagram sort*/
//		String[] arr={"aba","cfd","baa","dfc"};
//		sortAnagrams(arr);
//		for(int i=0;i<arr.length;i++)
//			System.out.println(arr[i]);
		
		/*rotated bin search*/
//		int[] arr ={15,16,19,20,20,26,3,4,5,7,10,14};
//		int[] a ={1,2,3,4,5,6,7};
//		System.out.println(search(arr,20));
		
		/*bin search on string array with empty strings*/
//		int[] a={1,2,3,4,5,6};
//		String[] arr={"at","","ball","","","","",""};
//		System.out.println(binSearchStr(arr,0,arr.length,"fluff"));
	
		/*search for elem in sorted matrix*/
//		int[][] a ={{1,4,5},{2,5,6},{3,6,7}};
//		System.out.println(searchMat(a,3));
		
		/*ht wt ascending order tower arrangement*/
		HtWt[] arr= new HtWt[6];
		int[] ht={65,70,56,75,60,68};
		int[] wt={100,150,90,190,195,110};
		for(int i=0;i<arr.length;i++){ arr[i]= new HtWt(ht[i],wt[i]);}
		tower(arr);
	}

}

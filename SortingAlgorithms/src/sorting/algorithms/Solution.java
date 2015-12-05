package sorting.algorithms;

import java.util.Scanner;

public class Solution {
    
    static void quickSort(int[] ar) {
      sort(ar,0,ar.length-1);
      printArray(ar);
 }   
 
static void sort(int[] ar , int start , int end){
if(start>=end) return;
  int p = partition(ar,start,end);
  sort(ar,start,p-1);
  //for(int i = start;i<p;i++) System.out.print(ar[i]+" ");System.out.println();
  sort(ar,p+1,end);  
  //for(int i = p+1;i<end;i++) System.out.print(ar[i]+" ");System.out.println();
}

static int partition(int[] ar, int start , int end) {
  int x = ar[start];
  int i = start, j=start+1;
  while(j<=end){
      if(ar[j]<x){
          int val = ar[j];
          for(int m =j-1;m>i;m--) ar[m+1] = ar[m];
          ar[i+1] = val;
          i=i+1;j=j+1;
      } else {
          j=j+1;
      }
  }
  if((i-start) == 1){
	  int temp = ar[i];
	  ar[i]= ar[start];
	  ar[start] = temp;
  } else {
	  for(int m = start+1;m<=i;m++) ar[m-1] = ar[m];
  }
  ar[i] = x;
 // for(int m = start;m<end;m++) System.out.print(ar[m]+" ");System.out.println();
  return i;
  
}
static void printArray(int[] ar) {
   for(int n: ar){
      System.out.print(n+" ");
   }
     System.out.println("");
}
 
static void isort(int[] ar){
	int count =0;
    for(int j =1;j<ar.length;j++){
        int x = ar[j];
        int i ; 
        for(i = j-1;i>=0 && ar[i]>x;i--){
            ar[i+1] = ar[i];
            count++;
        }
        ar[i+1] = x;
    }
    System.out.println(count);
}

public static void main(String[] args) {
     Scanner in = new Scanner(System.in);
     int n = in.nextInt();
     int[] ar = new int[n];
     for(int i=0;i<n;i++){
        ar[i]=in.nextInt(); 
     }
    // quickSort(ar);
    isort(ar);
    printArray(ar);
    
 }    
}
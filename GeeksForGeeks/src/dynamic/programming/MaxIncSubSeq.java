package dynamic.programming;

public class MaxIncSubSeq {

	static void maxsubseq(int[] a){
		int[] prev = new int[a.length];
		int[] sum = new int[a.length];
		int max=0;int maxIndex=0;int i;
		for(i=0;i<a.length;i++){
			for(int j=0;j<=i;j++){
				int val = sum[i]+a[j];
				if(a[j]<=a[i] && val > sum[i]){
					sum[i]=val;
					prev[i]=j;
				}
			}
		}
		for(i=0;i<a.length;i++)
			if(sum[i]>max) max=sum[i];
		System.out.println("val-"+max);
		
	}
	public static void main(String[] args) {
		int arr[] = {1, 101, 2, 3, 100, 4, 5};
		maxsubseq(arr);
	}

}


public class ArrayLargestJMinusI {

	public int find(int[] arr){
		int n=arr.length;
		int[] lmin=new int[n];
		int[] rmax=new int[n];
		
		int min=Integer.MAX_VALUE;
		for(int i=0;i<n;i++){
			if(arr[i]<min) {lmin[i]=arr[i];min=arr[i];continue;}
			else lmin[i]=min;
		}
		
		int max=Integer.MIN_VALUE;
		for(int i=arr.length-1;i>=0;i--){
			if(arr[i]>max){rmax[i]=arr[i];max=arr[i];continue;}
			else rmax[i]=max;
		}
		
		int i=0;int j=0;int maxdiff=-1;
		while(i<n && j<n){
			if(lmin[i]<rmax[j]){
				if(j-i > maxdiff) maxdiff=j-i;
				j+=1;
			}else{
				i+=1;
			}
		}
		return maxdiff;
	}
	
	public static void main(String[] args) {
		int[] arr={34,8,10,3,2,80,30,33,1};
		ArrayLargestJMinusI obj=new ArrayLargestJMinusI();
		System.out.println(obj.find(arr));
	}

}

import java.util.ArrayList;
import java.util.List;

public class MaxSubArray {
	// DO NOT MODFIY THE LIST. 
	public int maxSubArray(final List<Integer> a) {
		int left=0;int right=0;
	    int max_ending_here=0;
	    int max_so_far=(int)Double.NEGATIVE_INFINITY;
	    for(int n:a){
	       max_ending_here+=n;
	       if(max_so_far < max_ending_here ){ max_so_far=max_ending_here;right=n;}
	       if(max_ending_here<0){max_ending_here=0;left=n;}
	    }
	    return max_so_far;
	}
	
	public static void main(String args[]){
		List<Integer> a= new ArrayList<Integer>();
		a.add(-163);
		a.add(-20);
		MaxSubArray s = new MaxSubArray();
		System.out.println(s.maxSubArray(a));
	}
}
package sorting.searching;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BucketSort {

	static void bucketSort(float[] a , int k){
		HashMap<Integer,List<Float>> map = new HashMap<Integer,List<Float>>();
		//create buckets
		for(int i=0;i<a.length;i++){
			int val =(int) a[i]*10;
			if(map.containsKey(val)){
				List<Float> list = map.get(val);
				list.add(a[i]);
				map.put(val,list);
			}else{
				List<Float> l= new ArrayList<Float>();
				l.add(a[i]);
				map.put(val,l);
			}
		}
		
		//sort the list associated with each bucket. fill up array 
		int j=0;
		for(Map.Entry<Integer,List<Float>> e: map.entrySet()){
			List<Float> list = e.getValue();
			Collections.sort(list);
			for(float i:list)
				a[j++] =i;
		}
		for(float i:a) System.out.println(i);
	}
	
	
	public static void main(String[] args) {
		float[] a ={0.1f,0.8f,0.4f,0.5f,0.3f};
		bucketSort(a,10);
	}

}

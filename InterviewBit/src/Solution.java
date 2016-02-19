import java.util.ArrayList;


class Interval {
     int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }
 
public class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
	    ArrayList<Interval> result = new ArrayList<Interval>();
	    for(Interval i:intervals){
	    	if(i.end<newInterval.start) result.add(i);
	    	else if(newInterval.end<i.start){
	    		result.add(newInterval);
	    		newInterval=i;
	    	}else{
	    		newInterval=new Interval(Math.min(i.start,newInterval.start),Math.max(i.end,newInterval.end));
	    	}
	    }
	    return result;
    }
}

package practice.all.chapters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;

public class Mathematics {

	
	static List<Integer> getPrimeFactors(int n){
		List<Integer> list = new ArrayList<Integer>();
		/*get all factor "2" out of the way . number will be odd at the end of this while loop*/
		while(n%2==0){
			n=n/2;
			list.add(2);
		}
		/*we can skip even numbers here as they have been factored in above*/
		for(int i=3;i<=Math.sqrt(n);i+=2){
			while(n%i==0){
				n=n/i;list.add(i);
			}
		}
		/*if n has not boiled down to 1 , that means it is prime . so just add it to the list. eg n=10. after while loop it becomes 5. after for loop it remains 5*/
		if(n!=1){
			list.add(n);
		}
		return list;
	}
	
	static int getLCM(int m, int n){
		int lcm=m;
		List<Integer> l1 = getPrimeFactors(m);
		List<Integer> l2 = getPrimeFactors(n);
		for(int i:l2){
			if(l1.contains(i)) continue;
			else lcm*=i;
		}
		return lcm;
	}
	
	static int getGCD(int a, int b){
		if(a==b) return a;
		if(a>b) return getGCD(a-b,b);
		else return getGCD(a,b-a);
	}
	
	static int getLCM2(int m, int n){
		int gcd=getGCD(m,n);
		int mul=m*n;
		return mul/gcd;
	}
	/*implement sub,mul,div using only "+" operator*/
	static int signFlip(int val){
		int add1 = val<0?-1:1;
		int add2 = val<0?1:-1;
		boolean flag=false;
		int sum=0;int count=0;
		while(count!=val){
			count=count+add1;
			sum+=add2;
		}
		return sum;
	}
	static int mult(int a , int b){
		boolean neg = b<0?true:false;
		if(neg) b= signFlip(b);
		int sum=0;
		for(int i=0;i<b;i++)
			sum+=a;
		return neg?signFlip(sum):sum;
	}
	static int sub(int a, int b){
		return a+signFlip(b);
	}
	static int div(int a , int b){
		int count=0;
		if(b==0) count=(int)Double.POSITIVE_INFINITY;
		else {
			boolean aneg=a<0?true:false;
			boolean bneg=b<0?true:false;
			a=aneg?signFlip(a):a;
			b=bneg?signFlip(b):b;
			int sum=0;
			while(sum!=a){
				sum+=b;
				count++;
			}
			if(aneg^bneg) count=signFlip(count);
		}
		return count;
	}
	/*find which line has max points in a 2d space with many points*/
	static Line bestLine(Point[] arr){
		HashMap<Line,Integer> map = new HashMap<Line,Integer>();
		int max=0;Line best=null;
		for(int i=0;i<arr.length;i++){
			for(int j=i+1;j<arr.length;j++){
				Line l = new Line(arr[i],arr[j]);
				if(map.containsKey(l)){
					int cnt=map.get(l)+1;
					map.put(l,cnt);
					if(cnt>max) {max=cnt;best=l;}
				}else{
					map.put(l,0);
				}
			}
		}
		return best;
	}
	
	/*find the kth element which has prime factors 3,5,7 only*/
	static int number357(int k){
		LinkedList<Integer> q3= new LinkedList<Integer>();
		LinkedList<Integer> q5= new LinkedList<Integer>();
		LinkedList<Integer> q7= new LinkedList<Integer>();
		LinkedList<Integer> magic= new LinkedList<Integer>();
		q3.add(3);q5.add(5);q7.add(7);
		magic.add(1);
		while(magic.size()<=k){
			int val = Math.min(Math.min(q3.peek(),q5.peek()),q7.peek());
			magic.add(val);
			if(val==q7.peek()){
				q7.removeFirst();
				q7.add(val*7);
			}else if(val==q5.peek()){
				q5.removeFirst();
				q5.add(val*5);
				q5.add(val*7);
			}else {
				q3.removeFirst();
				q3.add(val*3);
				q5.add(val*5);
				q7.add(val*7);
			}
		}
		return magic.get(k-1);
	}
	public static void main(String[] args) {
//		for(int i:getPrimeFactors(10)) System.out.println(i);
//		System.out.println(getLCM(8,6));
//		System.out.println(getGCD(98,56));
//		System.out.println(getLCM2(8,6));
//		System.out.println(mult(3,2));
//		System.out.println(sub(-3,-2));
//		System.out.println(div(-21,1));
		System.out.println(number357(13));
	}

}

class Point{
	int x;
	int y;
	Point(int a, int b){
		this.x=a;
		this.y=b;
	}
}
class Line{
	double m;
	double c;
	boolean inifinite_slope=false;
	double epsilon=0.0001;
	Line(Point a, Point b){
		if(Math.abs(a.x-b.x)>epsilon){
			m=(a.y-b.y)/(a.x-b.x);
		}else{
			inifinite_slope=true;
			c=a.x;
		}
	}

	public boolean isEquals(double a , double b){
		return Math.abs(a-b)<epsilon ? true:false;
	}
	public int hashcode(){
		int s1=(int)m*1000;
		int s2=(int)c*1000;
		return s1|s2;
	}
	
	public boolean equals(Object o){
		Line l=(Line)o;
		if(isEquals(l.m,m)&&isEquals(l.c,c)&& inifinite_slope==l.inifinite_slope) return true;
		return false;
	}
}
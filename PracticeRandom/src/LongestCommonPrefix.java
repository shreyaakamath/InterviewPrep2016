
public class LongestCommonPrefix {

	public String lcp(String[] arr){
		int minLength=Integer.MAX_VALUE;
		for(int i=0;i<arr.length;i++){
			if(arr[i].length()<minLength) minLength=arr[i].length();
		}
		
		for(int j=0;j<minLength;j++){
			char prev='0';
			for(int i=0;i<arr.length;i++){
				if(i==0) prev=arr[i].charAt(j);
				if(arr[i].charAt(j)!=prev) return arr[i].substring(0,j);
			}
		}
		return arr[0].substring(0,minLength);
	}
	
	public static void main(String[] args) {
		LongestCommonPrefix lcp=new LongestCommonPrefix();
		String[] arr={"boy","boyhood"};
		System.out.println(lcp.lcp(arr));
	}

}

import java.util.ArrayList;
import java.util.List;


public class LongestPrefixMatchDictionary {
	
	public String mathDictionary(List<String> dict,String word){
		int max=Integer.MIN_VALUE;
		String match=null;
		for(int i=1;i<word.length();i++){
			String str = word.substring(0,i);
			if(dict.contains(str)){
				if(str.length()>max){
					max=str.length();match=str;
				}
			}
		}
		if(match==null) return "0";
		else return match;
	}
	public static void main(String[] args) {
		LongestPrefixMatchDictionary obj=new LongestPrefixMatchDictionary();
		List<String> dict= new ArrayList<String>();
		dict.add("cat");dict.add("cater");
		System.out.println(obj.mathDictionary(dict,"caterer"));
	}

}

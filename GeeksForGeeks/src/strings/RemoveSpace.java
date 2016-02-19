package strings;

/**
 * http://www.geeksforgeeks.org/remove-spaces-from-a-given-string/
 * @author shreyakamath
 *
 */
public class RemoveSpace {

	static void removeSpace(StringBuilder str){
		int length=str.length();
		for(int i=str.length()-1;i>=0;i--){
			char c=str.charAt(i);
			if(!Character.isSpaceChar(c)) continue;
			int j=i;
			String toRight=str.substring(i+1);
			str.delete(i+1,length);
			while(Character.isSpaceChar(str.charAt(j))) j--;
			str.replace(j+1,i,toRight);
			i=j+1;
		}
		System.out.println(str.toString());
	}
	public static void main(String[] args) {
		removeSpace(new StringBuilder("g  eeks  for   ge    eeks"));
	}

}

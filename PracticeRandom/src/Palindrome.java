import java.util.HashMap;
import java.util.Stack;

public class Palindrome {
	public static boolean isValidPalindrome(String s){
		if(s==null||s.length()==0) return false;
 
		s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
		System.out.println(s);
 
		for(int i = 0; i < s.length() ; i++){
			if(s.charAt(i) != s.charAt(s.length() - 1 - i)){
				return false;
			}
		}
 
		return true;
	}
	public static boolean isMatch(String s, String p) {
		int i = 0;
		int j = 0;
		int starIndex = -1;
		int iIndex = -1;
	 
		while (i < s.length()) {
			if (j < p.length() && (p.charAt(j) == '?' ||p.charAt(j) == s.charAt(i))) {
				i++;j++;
			} 
			else if(j< p.length() && p.charAt(j)=='.'){
				i++;j++;
			}
			else if (j < p.length() && p.charAt(j) == '*') {
				starIndex = j;		
				iIndex = i;
				j++;
			} else if (starIndex != -1) {
				j = starIndex + 1;
				i = iIndex+1;
				iIndex++;
			} else {
				return false;
			}
		}
	 
		while (j < p.length() && p.charAt(j) == '*') {
			j++;
		}
	 
		return j == p.length();
	}
	
	public static boolean isValid(String s) {
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		map.put('(', ')');
		map.put('[', ']');
		map.put('{', '}');
	 
		Stack<Character> stack = new Stack<Character>();
	 
		for (int i = 0; i < s.length(); i++) {
			char curr = s.charAt(i);
	 
			if (map.containsKey(curr)) {
				stack.push(curr);
			} else if (map.containsValue(curr)) {
				if (!stack.empty() && map.get(stack.peek()) == curr) {
					stack.pop();
				} else {
					return false;
				}
			}
		}
	 
		return stack.empty();
	}
	
	public static void main(String[] args) {
//		String str = "A man, a plan, a canal: Panama";
 
//		System.out.println(isValidPalindrome(str));
		System.out.println(isMatch("abc","a?bc"));
//		System.out.println(isValid("()[]{}"));
	}
}
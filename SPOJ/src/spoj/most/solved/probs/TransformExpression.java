package spoj.most.solved.probs;

import java.util.Scanner;
import java.util.Stack;

public class TransformExpression {


	public static void main(String[] args) {

		Stack<String>  operatorStack = new Stack<String>();
		Stack<String>  letterStack = new Stack<String>();
		
		Scanner scan = new Scanner(System.in);
		int test = scan.nextInt();
		String[] n = new String[test];
		for(int i=0;i<test;i++){
			n[i] = scan.next();
		}
		
		for(int i=0;i<test;i++){
			String expr = n[i];
			String trans = "";
			String ans="";
			for(int j=0;j<expr.length();j++){
				Character c = expr.charAt(j);
				if(c==')'){
					//pop two letters and operator and add to trans
					String str1 = letterStack.pop();
					String str2 = letterStack.pop();
					String operator = operatorStack.pop();
					trans= str2+str1+operator;
					letterStack.push(trans);
					
				} else if (c=='('){
					continue;
				}
				else if(Character.isLetter(c)){
					letterStack.push(c.toString());
				} else {
					operatorStack.push(c.toString());
				}
			}
			System.out.println(letterStack.pop());
		}
	}

}

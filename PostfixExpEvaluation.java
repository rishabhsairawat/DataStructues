package stack;

import java.util.Stack;

public class PostfixExpEvaluation {
	static int evaluatePostfix(String exp){
		
		Stack<Integer> stack=new Stack<Integer>();
		for(int i=0;i<exp.length();i++){
			char c=exp.charAt(i);
			if(Character.isDigit(c)){
				stack.push(Character.getNumericValue(c));
			}
				
			else
			{
		            int val1 = stack.pop();
		            int val2 = stack.pop();
		            switch (c)
		            {
		             case '+': stack.push(val2 + val1); break;
		             case '-': stack.push(val2 - val1); break;
		             case '*': stack.push(val2 * val1); break;
		             case '/': stack.push(val2/val1);   break;
		            }
		        }
		}
		return stack.pop();
	}

	public static void main(String[] args) {
	String expr="231*+9-";
	System.out.println(expr+" = "+evaluatePostfix(expr));
	}

}

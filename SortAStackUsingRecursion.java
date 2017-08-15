package stack;

import java.util.Stack;

public class SortAStackUsingRecursion {

	public static void main(String[] args) {
		Stack<Integer> stack=new Stack<Integer>();
		stack.push(40);
		stack.push(20);
		stack.push(60);
		stack.push(35);
		stack.push(50);
		System.out.println("Before Sorting:"+stack);	
		sortStack(stack);
		System.out.println("After Sorting:"+stack);
	}

	 static void sortStack(Stack<Integer> stack) {
		if(!stack.isEmpty()){
			int x=stack.pop();
			sortStack(stack);
			sortedInsert(stack,x);
		}
	}

	 static void sortedInsert(Stack<Integer> stack, int x) {
		if(stack.isEmpty()||x>stack.peek()){
			stack.push(x);
			return;
		}
			int temp=stack.pop();
			sortedInsert(stack,x);
			stack.push(temp);
		
	}

}

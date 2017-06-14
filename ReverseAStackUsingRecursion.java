package stack;

import java.util.Stack;

public class ReverseAStackUsingRecursion {
	static Stack<Integer> stack;
	static void reverse(Stack<Integer> stack){
		if(!stack.isEmpty())
		{
			int x=(int) stack.peek();
			stack.pop();
			reverse(stack);
			insert_at_bottom(x);
		}
	}
	static void insert_at_bottom(int x){
        if(stack.isEmpty())
            stack.push(x);
        else{
            int a = stack.peek();
            stack.pop();
            insert_at_bottom(x);
            stack.push(a);
        }
    }
	public static void main(String[] args) {
		stack=new Stack<Integer>();
		stack.push(4);
		stack.push(3);
		stack.push(2);
		stack.push(1);
		System.out.println(stack);
		reverse(stack);
		System.out.println(stack);
	}

}

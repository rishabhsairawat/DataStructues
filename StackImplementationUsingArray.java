package stack;

public class StackImplementationUsingArray {
	static int MAX=1000;
	int top;
	StackImplementationUsingArray(){
		top=-1;
	}
	int a[]=new int[MAX];
	boolean isEmpty(){
		return top<0;
	}
	boolean push(int x){
		if(top==MAX){
			System.out.println("OVERFLOW !");
			return false;
		}
		else{
			a[++top]=x;
			System.out.println(x+" pushed to stack");
			return true;
		}		
	}
	int pop(){
		if(top<0){
			System.out.println("UNDERFLOW !");
			return 0;
		}
		else
		{
			int x=a[top--];
			System.out.println(x+" popped from stack");
			return x;
		}
	}
	public static void main(String[] args) {
		StackImplementationUsingArray stack=new StackImplementationUsingArray();
		System.out.println("Stack is EMPTY??? "+stack.isEmpty());
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.pop();
	}

}

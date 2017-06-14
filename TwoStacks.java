package stack;

public class TwoStacks {
	int size,top1,top2;
	int arr[];
	TwoStacks(int n){
		arr=new int[n];
		top1=-1;
		top2=n;
		size=n;
	}
	void push1(int x) {
		if(top1<top2-1){
			arr[++top1]=x;
		}
		else
			System.out.println("Stack Overflow");
	}
	void push2(int x){
		if(top2>top1+1){
			arr[--top2]=x;
		}
		else
			System.out.println("Stack Overflow");
	}
	int pop1(){
		if(top1!=-1){
			int x=arr[top1];
			top1--;
			return x;
		}
		else
		{
			System.out.println("Stack Underflow");
			return 0;
		}
	}
	int pop2(){
		if(top2!=size){
			int x=arr[top2];
			top2++;
			return x;
		}
		else
		{
			System.out.println("Stack Underflow");
			return 0;
		}
	}
	public static void main(String[] args) {
		
		TwoStacks stacks=new TwoStacks(10);
		stacks.push1(10);
		stacks.push1(20);
		stacks.push1(30);
		stacks.push1(40);
		stacks.push2(100);
		stacks.push2(90);
		stacks.push2(80);
		stacks.push2(70);
		System.out.println("Popped element is:"+stacks.pop1());
		System.out.println("Popped element is:"+stacks.pop2());
	}

}

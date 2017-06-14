package stack;


public class StackImplementationUsingLinkedList {
	
	Node head;
	class Node{
		int data;
		Node next;
		Node(int x){
			data=x;
			next=null;
		}
	}
	public void push(int newData){
		
		if(head==null){
			head=new Node(newData);
		}
		else{
			Node newNode=new Node(newData);
			newNode.next=head;
			head=newNode;
		}
	}
	public void pop(){
		if(head!=null)
		head=head.next;
		else
		System.out.println("STACK IS EMPTY");		
	}
	public boolean isEmpty(){
		if(head==null)
			return true;
		else
			return false;
	}
	public void printStack(){
		Node tnode=head;
		while(tnode!=null){
			System.out.print(tnode.data+" ");
			tnode=tnode.next;
		}
	}

	public static void main(String[] args) {
		StackImplementationUsingLinkedList stacks=new StackImplementationUsingLinkedList();
		stacks.push(10);
		stacks.push(9);
		stacks.push(8);
		stacks.push(7);
		stacks.push(6);
		stacks.push(5);
		stacks.push(4);
		stacks.push(3);
		stacks.push(2);
		stacks.push(1);
		System.out.println("STACK BEFORE POPING HEAD:");
		stacks.printStack();
		stacks.pop();
		System.out.println("");
		System.out.println("STACK AFTER POPING HEAD:");
		stacks.printStack();
	}

}

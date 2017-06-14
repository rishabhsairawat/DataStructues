package circularLinkList;

public class CircularLinkList {
	static Node last=null;
	class Node{
		int data;
		Node next;
		Node(int x){
			data=x;
			next=null;
		}
	}
	//Insertion in an empty List
	public  void addToEmpty(int newData){
		if(last==null){
			Node newNode=new Node(newData);
			last=newNode;
			last.next=last;
		}
		else
		{
			System.out.println("List isn't Empty");
		}
	}
	//Insertion at the beginning of the list
	public void addToBegin(int newData){
		Node newNode=new Node(newData);
		newNode.next=last.next;
		last.next=newNode;	
	}
	//Insertion at the end of the list
	public void addToEnd(int newData){
		Node newNode=new Node(newData);
		newNode.next=last.next;
		last.next=newNode;
		last=newNode;
	}
	//Insertion after a Node
	public void addAfter(Node prevNode,int newData){
		Node newNode=new Node(newData);
		if(prevNode==last){
			last=newNode;
		}
		newNode.next=prevNode.next;
		prevNode.next=newNode;
		
	}
	//printing list
	public void printList(){
		if(last==null){
			System.out.println("List is Empty");
			return;
		}
		Node temp=last.next;
		do{
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
		while(temp!=last.next);
	}
	public static void main(String[] args) {
		CircularLinkList list=new CircularLinkList();
		list.addToEmpty(10);
		list.addAfter(last, 15);
		list.addToEnd(20);
		list.addToBegin(5);
		list.addToBegin(0);
		list.printList();
	}

}

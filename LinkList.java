package linkList;

public class LinkList {
	 Node head;
	 class Node{
		int data;
		Node next;
		Node(int x){
			data=x;
			next=null;
		}
	}
	//insertion at first
	public void push(int newData){
		Node newNode=new Node(newData);
		newNode.next=head;
		head=newNode;
	}
	//insertion after a given Node
	public void insertAfter(Node prevNode,int newData){
		if(prevNode==null){
			System.out.println("PrevNode can't be null");
		}
		else
		{
			Node newNode=new Node(newData);
			newNode.next=prevNode.next;
			prevNode.next=newNode;
		}	
	}
	//insertion at Last
	public void append(int newData){
		
		if(head==null){
			head=new Node(newData);
		}
		else{
			Node newNode=new Node(newData);
			newNode.next=null;
			Node last=head;
			while(last.next!=null)
				last=last.next;
			last.next=newNode;
		}
	}
	
	//deletion of a node
	public void deleteNode(int delData){
		Node temp=head, prev=null;
		if(temp!=null && temp.data==delData){
			head=temp.next;
		}
		
		while (temp != null && temp.data != delData)
        {
            prev = temp;
            temp = temp.next;
        }  
		if (temp==null) {
			System.out.println("");
			System.out.println(delData+" was not present in Linked List");
		}
		else
			prev.next=temp.next;
	}
	//deletion of a node at given position
	public void deletePos(int pos){
		if(head==null)
			System.out.println("Empty Link list. Deletion not possible");
		else
		{
			Node temp=head;
			if(pos==0){
				head=temp.next;
			}
			else
			{
				for(int i=0;temp!=null&&i<pos-1;i++){
					temp=temp.next;
				}
				if(temp==null||temp.next==null){
					System.out.println("Can't be deleted as position is exceeding the size of the link list");
				}
				else
					temp.next=temp.next.next;
			}
		}
	}
	
	//length of a linked list
	public void length(){
		Node temp=head;
		int count=0;
		while(temp!=null){
			count++;
			temp=temp.next;
		}
		System.out.println("");
		System.out.println("Length of the Link list is: "+count);
	}
	
	//swap nodes without changing data
	public void swapNodes(int x,int y){
		//if both positions are same
		if(x==y)
			return;
		//check if x is present in linked list or not
		Node currentX=head, previousX=null;
		while(currentX!=null && currentX.data!=x){
			previousX=currentX;
			currentX=currentX.next;
		}
		//check if y is present in linked list or not
		Node currentY=head, previousY=null;
		while(currentY!=null && currentY.data!=y){
			previousY=currentY;
			currentY=currentY.next;
		}
		//if any of x or y is not present
		if(currentX==null||currentY==null)
			return;
		//if x is not the head of linked list
		if(previousX!=null)
			previousX.next=currentY;
		else
			head=currentY;
		//if y is not the head of linked list
		if(previousY!=null)
			previousY.next=currentX;
		else
			head=currentX;
		//swapping pointers
		Node temp=currentX.next;
		currentX.next=currentY.next;
		currentY.next=temp;
	}
	
	//get middle of the link list
	public void getMiddle(){
		Node slow=head,fast=head;
		if(head!=null){
			while(fast!=null&&fast.next!=null){
				fast=fast.next.next;
				slow=slow.next;
			}
			System.out.println();
			System.out.println("Middle of the link list is :"+slow.data);
		}
	}
	//print List
	public void printList(){
		Node tnode=head;
		while(tnode!=null){
			System.out.print(tnode.data+" ");
			tnode=tnode.next;
		}
	}
	//reverse of link list
	Node reverse(Node node) {
        Node prev = null;
        Node current = node;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }
	//nth node from last
	 void printNthFromLast(int n) {
		Node temp=head;
		int length=0;
		while(temp!=null){
			temp=temp.next;
			length++;
		}
		if(n>length)
			return;
		temp=head;
		for(int i=1;i<length-n+1;i++)
			temp=temp.next;
		System.out.println();
		System.out.println(n+"th Element from Last is: "+temp.data);
		
	}
	
	public static void main(String[] args) {
		LinkList list=new LinkList();
		list.append(5);
		list.push(3);
		list.push(1);
		list.append(9);
		list.append(2);
		list.append(11);
		list.insertAfter(list.head.next.next, 4);
		//List should be 1,3,5,4,9,2
		System.out.println("Linked List is:");
		list.printList();
		list.deleteNode(6);
		System.out.println("Linked List after deletion is:");
		list.printList();
		list.deletePos(3);
		System.out.println("");
		System.out.println("Linked List after deletion is:");
		list.printList();
		list.length();
		list.swapNodes(1, 5);
		System.out.println("Linked List after swapping is:");
		list.printList();
		list.getMiddle();
		list.head = list.reverse(list.head);
		System.out.println("Linked List after reverse is:");
		list.printList();
		list.printNthFromLast(1);
	}
	

}

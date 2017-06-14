package doublyLinkList;

public class DoublyLinkList {
		static Node head;
		class Node{
			int data;
			Node next;
			Node prev;
			Node(int x){
			data=x;
			next=null;
			prev=null;
			}
		}
		//Adding a node at the starting of the list
		public void push(int newData){
			Node newNode=new Node(newData);
			newNode.next=head;
			newNode.prev=null;
			if(head!=null){
				head.prev=newNode;
			}
			head=newNode;
		}
		
		//Adding a node after a given node
		public void addAfter(Node prevNode,int newData){
			if(prevNode==null){
				System.out.println("Insertion can't be done for "+newData);
				return;
			}
			Node newNode=new Node(newData);
			newNode.prev=prevNode;
			newNode.next=prevNode.next;
			prevNode.next=newNode;
			if(newNode.next!=null)
				newNode.next.prev=newNode;
		}
		
		//Adding a node at the end of the linked list
		public void append(int newData){
			Node newNode=new Node(newData);
			newNode.next=null;
			if(head==null){
				newNode.prev=null;
				head=newNode;
				return;
			}
			Node last=head;
			while(last.next!=null){
				last=last.next;
			}
			last.next=newNode;
			newNode.prev=last;
			return;
		}
		//Adding a node before a given node;
		public void addBefore(Node afterNode,int newData){
			Node newNode=new Node(newData);
			if(afterNode==head){
				newNode.prev=null;
				newNode.next=head;
				afterNode.prev=newNode;
				head=newNode;
				return;
			}
			else if(afterNode==null){
				System.out.println("Insertion Not Possible for "+newData);
				return;
			}
			newNode.next=afterNode;
			newNode.prev=afterNode.prev;
			afterNode.prev.next=newNode;
			afterNode.prev=newNode;
		}
		//printing linkList
		public void printList(){
			Node temp=head;
			Node last=null;
			System.out.println("Link list in forward direction:");
			while(temp!=null){
				System.out.print(" "+temp.data);
				last=temp;
				temp=temp.next;
			}
			System.out.println();
			System.out.println("Link list in backward direction:");
			while(last!=null){
				System.out.print(" "+last.data);
				last=last.prev;
			}	
		}
		//deleting a node
		public boolean deleteNode(Node delNode){
			if(delNode==null||head==null){
				System.out.println();
				System.out.println("Deletion not possible");
				return false;
			}
			else if(delNode==head){
				delNode.next.prev=null;
				head=delNode.next;
				return true;
			}
			else if(delNode.next!=null){
				delNode.next.prev=delNode.prev;
				delNode.prev.next=delNode.next;
				return true;
			}
			else if(delNode.next==null){
				delNode.prev.next=null;
				return true;
			}
			return true;
		}
		//reversing link list
		public void reverseList(){
			Node temp=null;
			Node current=head;
			while(current!=null){
				temp=current.prev;
				current.prev=current.next;
				current.next=temp;
				current=current.prev;
			}
			if(temp!=null){
				head=temp.prev;
			}
		}
	public static void main(String[] args) {
		DoublyLinkList list=new DoublyLinkList();
		list.append(6);
		list.push(7);
		list.push(1);
		list.append(4);
		list.addAfter(head.next,8);
		list.addBefore(head, 10);
		list.addAfter(null, 50);
		list.printList();
		if(list.deleteNode(head.next.next))
		{
			System.out.println();
			list.printList();	
		}
		list.reverseList();
		System.out.println();
		list.printList();
	}

}

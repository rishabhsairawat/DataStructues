package circularLinkList;

public class SortedInsertForCircularLinkList {
	static Node head;
	class Node{
		int data;
		Node next;
		Node(int x){
			data=x;
			next=null;
		}
	}
	public void sortedInsert(int newData){
		Node temp=head;
		Node newNode=new Node(newData);
		if(head==null){
			head=newNode;
			newNode.next=newNode;
		}
		else if(temp.data>=newNode.data){
			while(temp.next!=head){
				temp=temp.next;
			}
			temp.next=newNode;
			newNode.next=head;
			head=newNode;
		}
		else
		{
			while(temp.next!=head&&temp.next.data<newNode.data)
				temp=temp.next;
			newNode.next=temp.next;
			temp.next=newNode;
		}
	}
	//print function to print list
	void printList(Node node) {
        Node temp = node;
        if (node != null) {
            do {
                System.out.print(temp.data + " ");
                temp = temp.next;
            } while (temp != node);
        }
    }
	public static void main(String[] args) {
		SortedInsertForCircularLinkList list=new SortedInsertForCircularLinkList();
		list.sortedInsert(50);
		list.sortedInsert(150);
		list.sortedInsert(10);
		list.sortedInsert(100);
		list.sortedInsert(20);
		list.printList(head);
		
	}

}

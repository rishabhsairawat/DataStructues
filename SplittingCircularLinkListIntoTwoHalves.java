package circularLinkList;

 class SplittingCircularLinkListIntoTwoHalves {
	 static Node head,head1,head2,last;
	class Node{
		int data;
		Node next;
		Node(int x){
			data=x;
			next=null;
		}
	}
	//split function
	public void splitList(){
		Node slowPtr=head;
		Node fastPtr=head;
		while(fastPtr.next!=head && fastPtr.next.next!=head){
			fastPtr=fastPtr.next.next;
			slowPtr=slowPtr.next;
		}
		if(fastPtr.next.next==head){
			fastPtr=fastPtr.next;
		}
		head1=head;
		if(head.next!=head){
			head2=slowPtr.next;
		}
		fastPtr.next=slowPtr.next;
		slowPtr.next=head;
	}
	//print function to print lists
	void printList(Node node) {
        Node temp = node;
        if (node != null) {
            do {
                System.out.print(temp.data + " ");
                temp = temp.next;
            } while (temp != node);
        }
    }
	//adding elements
	public void insert(int newData){
		Node newNode=new Node(newData);
		if(head==null){
			head=newNode;
			last=newNode;
			newNode.next=head;
			return;
		}
		last.next=newNode;
		newNode.next=head;
		last=newNode;
	}
	public static void main(String[] args) {
		SplittingCircularLinkListIntoTwoHalves list=new SplittingCircularLinkListIntoTwoHalves();
		list.insert(10);
		list.insert(20);
		list.insert(30);
		list.insert(40);
		System.out.println("Original list");
		list.printList(head);
		System.out.println();
		list.splitList();
		System.out.println("List after splitting:");
		list.printList(head1);
		System.out.println();
		list.printList(head2);
	}

}

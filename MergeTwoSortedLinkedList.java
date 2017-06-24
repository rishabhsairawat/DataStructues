package linkList;
class Node{
	int data;
	Node next;
	Node(int x){
		data=x;
		next=null;
	}
}
public class MergeTwoSortedLinkedList {
	Node head;
	
	 static Node sortedMerge(Node head1, Node head2) {
			Node result=null;
			if(head1==null)
				return head2;
			if(head2==null)
				return head1;
			if(head1.data<=head2.data){
				result=head1;
				result.next=sortedMerge(head1.next, head2);
			}
			else{
				result=head2;
				result.next=sortedMerge(head1, head2.next);
			}
			return result;
		}
	 static void printList(Node node){
		 Node temp=node;
		 while(temp!=null){
			 System.out.print(temp.data+" ");
			 temp=temp.next;
		 }
		 System.out.println();
	 }

	public static void main(String[] args) {
		MergeTwoSortedLinkedList list1=new MergeTwoSortedLinkedList();
		MergeTwoSortedLinkedList list2=new MergeTwoSortedLinkedList();
		list1.head=new Node(5);
		list1.head.next=new Node(10);
		list1.head.next.next=new Node(15);
		System.out.println("List 1 is:");
		printList(list1.head);
		list2.head=new Node(2);
		list2.head.next=new Node(3);
		list2.head.next.next=new Node(20);
		System.out.println("List 2 is:");
		printList(list2.head);
		Node res=sortedMerge(list1.head,list2.head);
		System.out.println("Merged List is:");
		printList(res);
	}


}

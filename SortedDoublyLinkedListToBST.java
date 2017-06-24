package binarySearchTree;

public class SortedDoublyLinkedListToBST {
	Node head;
	class Node
	{
	    int data;
	    Node next, prev;
	 
	    Node(int x){
	        data = x;
	        next = prev = null;
	    }
	}
	Node sortedDoublyLinkedListToBST(){
		int n=countNodes(head);
		return sortedDLLtoBST(n);
	}
	  int countNodes(Node head) {
		Node temp=head;
		int count=0;
		while(temp!=null){
			count++;
			temp=temp.next;
		}
		return count;
	}
	Node sortedDLLtoBST(int n) {
		if(n<=0)
			return null;
		Node left=sortedDLLtoBST(n/2);
		Node root=head;
		root.prev=left;
		head=head.next;
		root.next=sortedDLLtoBST(n-n/2-1);
		return root;
	}
	void push(int new_data)
    {
        Node new_node = new Node(new_data);
        new_node.prev = null;
        new_node.next = head;
 
        if (head != null)
            head.prev = new_node;
 
        head = new_node;
    }
	void printList()
    {
        Node node = head;
        System.out.println("Doubly Linked List is: ");
        while (node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }
	 void preOrderTraversal(Node node)
	    {
	        if (node == null)
	            return;
	        System.out.print(node.data + " ");
	        preOrderTraversal(node.prev);
	        preOrderTraversal(node.next);
	    }
 
	 

	public static void main(String[] args) {
		SortedDoublyLinkedListToBST dlist=new SortedDoublyLinkedListToBST();
		dlist.push(7);
		dlist.push(6);
		dlist.push(5);
		dlist.push(4);
		dlist.push(3);
		dlist.push(2);
		dlist.push(1);
		dlist.printList();
		Node root=dlist.sortedDoublyLinkedListToBST();
		System.out.println("Preorder Traversal of tree is:");
		dlist.preOrderTraversal(root);
	}

}

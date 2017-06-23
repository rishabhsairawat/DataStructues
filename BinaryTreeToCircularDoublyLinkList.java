package binaryTree;

public class BinaryTreeToCircularDoublyLinkList {
	Node root;
	class Node{
		int key;
		Node left,right;
		Node(int data){
			key=data;
			left=right=null;
		}
	}
	Node concatenate(Node leftList,Node rightList){
		if(leftList==null)
			return rightList;
		if(rightList==null)
			return leftList;
		Node leftLast=leftList.left;
		Node rightLast=rightList.left;
		
		leftLast.right=rightList;
		rightList.left=leftLast;
		
		leftList.left=rightLast;
		rightLast.right=leftList;
		
		return leftList;
	}
	Node binaryTreeToCLinkList(Node node){
		if(node==null)
			return null;
		Node left=binaryTreeToCLinkList(node.left);
		Node right=binaryTreeToCLinkList(node.right);
		node.left=node.right=node;
		return concatenate(concatenate(left, node), right);
		
	}
	void printList(Node head){
		Node temp=head;
		System.out.println("Circular Link List of the binary tree is: ");
		do{
			System.out.print(temp.key+" ");
			temp=temp.right;
		}
		while(temp!=head);
	}
	void makeBinaryTree(){
		this.root = new Node(10);
		this.root.left = new Node(12);
		this.root.right = new Node(15);
		this.root.left.left = new Node(25);
		this.root.left.right = new Node(30);
		this.root.right.left = new Node(36);
	}
	
	public static void main(String[] args) {
		BinaryTreeToCircularDoublyLinkList tree=new BinaryTreeToCircularDoublyLinkList();
		tree.makeBinaryTree();
		Node head=tree.binaryTreeToCLinkList(tree.root);
		tree.printList(head);
	}

}

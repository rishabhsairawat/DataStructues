package binarySearchTree;

public class CheckIfBinaryTreeIsBST {
	static int index=0;
	Node root;
	class Node{
		int key;
		Node left,right;
		Node(int data){
			key=data;
			left=right=null;
		}
	}
	void makeBinaryTree(){
		this.root=new Node(4);
		this.root.left=new Node(2);
		this.root.right=new Node(5);
		this.root.left.left=new Node(1);
		this.root.left.right=new Node(3);
	}
	boolean isBST(Node node){
		Node prev=null;
		if(node != null)
		{
			if(!isBST(node.left))
				return false;
			if(prev!=null && node.key <= prev.key)
				return false;
			prev=node;
			return isBST(node.right);
		}
		return true;
	}
	public static void main(String[] args) {
		CheckIfBinaryTreeIsBST tree=new CheckIfBinaryTreeIsBST();
		tree.makeBinaryTree();
		if(tree.isBST(tree.root)){
			System.out.println("This binary tree is a Binary Search Tree");
		}
		else
			System.out.println("This binary tree is not a Binary Search Tree");
		
	}

}

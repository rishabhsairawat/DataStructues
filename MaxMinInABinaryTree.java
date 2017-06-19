package binaryTree;

public class MaxMinInABinaryTree {

	Node root;
	class Node{
		int key;
		Node left;
		Node right;
		Node(int data){
			key=data;
			left=right=null;
		}
	}
	void makeTree(){
		 this.root = new Node(1);
		 this.root.left = new Node(2);
		 this.root.right = new Node(3);
		 this.root.right.left = new Node(4);
		 this.root.right.right = new Node(5);
	}
	 int getMax(Node node) {
			if(node==null)
				return Integer.MIN_VALUE;
			else
				return Math.max(node.key, Math.max(getMax(node.left), getMax(node.right)));
	 }
	 int getMin(Node node) {
			if(node==null)
				return Integer.MAX_VALUE;
			else
				return Math.min(node.key, Math.min(getMin(node.left), getMin(node.right)));
	 }
	public static void main(String[] args) {
		MaxMinInABinaryTree tree=new MaxMinInABinaryTree();
		tree.makeTree();
		System.out.println("Maximum in the tree is: "+tree.getMax(tree.root));
		System.out.println("Minimum in the tree is: "+tree.getMin(tree.root));
		
	}
	

}

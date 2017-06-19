package binaryTree;

public class SizeOfABinaryTree {
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
	 int getSize(Node node) {
		if(node==null)
			return 0;
		else
			return getSize(node.left)+getSize(node.right)+1;
	}

	public static void main(String[] args) {
		SizeOfABinaryTree tree=new SizeOfABinaryTree();
		tree.makeTree();
		System.out.println("Size of tree is : "+tree.getSize(tree.root));

	}

	

}

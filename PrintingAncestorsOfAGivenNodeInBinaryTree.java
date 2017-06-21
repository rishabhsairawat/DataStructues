package binaryTree;

public class PrintingAncestorsOfAGivenNodeInBinaryTree {
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
		 this.root.left.left = new Node(4);
		 this.root.left.right = new Node(5);
		 this.root.left.left.left=new Node(6);
	}
	boolean printAncestors(Node node,int k){
		if(node==null){
			return false;
		}
		if(node.key==k){
			return true;
		}
		
		if(printAncestors(node.left, k) || printAncestors(node.right, k)){
			System.out.print(node.key+" ");
			return true;
		}
		return false;	
	}
	

	public static void main(String[] args) {
		PrintingAncestorsOfAGivenNodeInBinaryTree tree=new PrintingAncestorsOfAGivenNodeInBinaryTree();
		tree.makeTree();
		tree.printAncestors(tree.root, 6);

	}

}

package binaryTree;


public class CheckingIfGivenBinaryTreeIsASubtreeOfAnotherBinaryTree {

	Node root1,root2;
	class Node{
		int key;
		Node left;
		Node right;
		Node(int data){
			key=data;
			left=right=null;
		}
	}
	
	Node makeTree1(){
		 this.root1 = new Node(10);
		 this.root1.left = new Node(4);
		 this.root1.right = new Node(6);
		 this.root1.left.right = new Node(30);
		 return this.root1;
	}
	Node makeTree2(){
		this.root2=new Node(26);
		this.root2.left = new Node(10);
		this.root2.right = new Node(3);
		this.root2.right.right=new Node(3);
		this.root2.left.left = new Node(4);
		this.root2.left.right = new Node(6);
		this.root2.left.left.right = new Node(30);
		return this.root2;
	}
	boolean isSubtree(Node tree1,Node tree2){
		if(tree1==null)
			return true;
		if(tree2==null)
			return false;
		if(areIdentical(tree1,tree2))
			return true;
		return isSubtree(tree1,tree2.left)||isSubtree(tree1, tree2.right);
	}
	 boolean areIdentical(Node tree1, Node tree2) {
		if(tree1==null && tree2==null)
			return true;
		if(tree1==null || tree2==null)
			return false;
		
		return (tree1.key==tree2.key && areIdentical(tree1.left, tree2.left) && areIdentical(tree1.right, tree2.right));
	}
	public static void main(String[] args) {
		CheckingIfGivenBinaryTreeIsASubtreeOfAnotherBinaryTree trees =new CheckingIfGivenBinaryTreeIsASubtreeOfAnotherBinaryTree();
		Node tree1=trees.makeTree1();
		Node tree2=trees.makeTree2();
		if(trees.isSubtree(tree1, tree2))
			System.out.println("Tree 1 is a subtree of Tree 2");
		else
			System.out.println("Tree 1 is not a subtree of Tree 2");
		
		
	}

}

package binaryTree;

public class LeftViewOfABinaryTree {
	Node root;
	static int max_level=0;
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
		 this.root = new Node(12);
		 this.root.left = new Node(10);
		 this.root.right = new Node(30);
		 this.root.right.left = new Node(25);
		 this.root.right.right = new Node(40);
	}
	void getLeftView(Node node, int level) {
		if(node==null)
			return;
		if(max_level<level){
			System.out.print(node.key+" ");
			max_level=level;
		}
		getLeftView(node.left,level+1);
		getLeftView(node.right,level+1);
	}
	public static void main(String[] args) {
		LeftViewOfABinaryTree tree=new LeftViewOfABinaryTree();
		tree.makeTree();
		System.out.println("Left View is: ");
		tree.getLeftView(tree.root, 1);
	}
	

}

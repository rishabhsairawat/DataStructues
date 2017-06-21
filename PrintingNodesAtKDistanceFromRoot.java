package binaryTree;

public class PrintingNodesAtKDistanceFromRoot {

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
	void printKDistantNodes(Node node,int k){
		if(node==null)
			return;
		if(k==0){
			System.out.print(node.key+" ");
			return;
		}
		else{
			printKDistantNodes(node.left,k-1);
			printKDistantNodes(node.right, k-1);
		}
	}
	void makeTree(){
		 this.root = new Node(12);
		 this.root.left = new Node(10);
		 this.root.right = new Node(30);
		 this.root.right.left = new Node(25);
		 this.root.right.right = new Node(40);
	}
	
	public static void main(String[] args) {
		PrintingNodesAtKDistanceFromRoot tree =new PrintingNodesAtKDistanceFromRoot();
		tree.makeTree();
		tree.printKDistantNodes(tree.root, 2);

	}

}

package binaryTree;


class Node{
	int key;
	Node left;
	Node right;
	Node(int data){
		key=data;
		left=right=null;
	}
}
public class TreeTraversal {
	Node root;
	public static void main(String[] args) {
		TreeTraversal tree=new TreeTraversal();
		tree.root=new Node(1);
		tree.root.left=new Node(2);
		tree.root.right=new Node(3);
		tree.root.left.left=new Node(4);
		tree.root.left.right=new Node(5);
		System.out.println("Preorder traversal of binary tree is ");
        tree.printPreorder(tree.root);
        System.out.println("\nInorder traversal of binary tree is ");
        tree.printInorder(tree.root);
        System.out.println("\nPostorder traversal of binary tree is ");
        tree.printPostorder(tree.root);
	}
	private void printPostorder(Node node) {
		if(node==null)
		return ;
		
		printPostorder(node.left);
		printPostorder(node.right);
		System.out.print(node.key+" ");
	}
	private void printInorder(Node node) {
		if(node==null)
			return ;
			
			printInorder(node.left);
			System.out.print(node.key+" ");
			printInorder(node.right);
	}
	private void printPreorder(Node node) {
		if(node==null)
			return ;
			System.out.print(node.key+" ");
			printPreorder(node.left);
			printPreorder(node.right);
		
	}

}

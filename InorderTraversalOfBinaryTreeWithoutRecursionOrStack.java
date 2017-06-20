package binaryTree;

public class InorderTraversalOfBinaryTreeWithoutRecursionOrStack {

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
	//inorder traversal using threaded binary tree
	void inorderTraversal(Node node) {
		if(node==null)
			return;
		Node current=node;
		while(current!=null){
			//if node doesn't have any left child, print data and move to right side
			if(current.left==null){
				System.out.print(current.key+" ");
				current=current.right;
			}
			else
			{   
				
				Node pre=current.left;
				//Go more the inorder predecessor of the current
				while(pre.right!=null && pre.right!=current){
					pre=pre.left;
				}
				//making current as the right child of the inorder predecessor of current
				if(pre.right==null){
					pre.right=current;
					current=current.left;
				}
					//if the right child of the inorder predecessor is not null i.e. It is already assigned 
				else{
					pre.right=null;
					System.out.print(current.key+" ");
					current=current.right;
				}
			}
		}
		
	}

	
	public static void main(String[] args) {
		InorderTraversalOfBinaryTreeWithoutRecursionOrStack tree=new InorderTraversalOfBinaryTreeWithoutRecursionOrStack();
		tree.makeTree();
		tree.inorderTraversal(tree.root);

	}

	
}

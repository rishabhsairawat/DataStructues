package binaryTree;

public class ThreadedBinaryTree {
	Node root;
	class Node{
		int key;
		Node left;
		Node right;
		boolean r_thread;
		
		Node(int data){
			key=data;
			left=right=null;
			r_thread=false;
		}
	}
	
	void makeThreadedTree(){
		 this.root = new Node(1);
		 this.root.left = new Node(2);
		 this.root.left.r_thread=true;
		 this.root.left.right=this.root;
		 this.root.right = new Node(3);
		 this.root.right.left = new Node(4);
		 this.root.right.left.r_thread=true;
		 this.root.right.left.right=this.root.right;
		 this.root.right.right = new Node(5);
	}
	Node leftMostNode(Node n){
		if(n==null)
			return null;
		while(n.left!=null){
			n=n.left;
		}
		return n;
	}
	void inOrderTraversal(Node node){
		Node current=leftMostNode(node);
		while(current!=null){
			System.out.print(current.key+" ");
			if(current.r_thread){
				current=current.right;
			}
			else{
				current=leftMostNode(current.right);
			}
		}
	}
	public static void main(String[] args) {
		ThreadedBinaryTree tree=new ThreadedBinaryTree();
		tree.makeThreadedTree();
		tree.inOrderTraversal(tree.root);
	}

}

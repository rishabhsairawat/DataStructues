package binaryTree;

public class ConnectingNodesAtSameLevel {
	Node root;
	class Node{
		int key;
		Node left,right,nextRight;
		Node(int data){
			key=data;
			left=right=null;
			nextRight=null;
		}
	}
	
	void makeTree(){
		 this.root=new Node(1);
		 this.root.left=new Node(2);
		 this.root.right=new Node(3);
		 this.root.left.left=new Node(4);
		 this.root.left.right=new Node(5);
		 this.root.right.left=new Node(6);
		 this.root.right.right=new Node(7);
		 this.root.left.left.left=new Node(8);
		 this.root.left.left.right=new Node(9);
		 this.root.right.right.left=new Node(10);
		 this.root.right.right.left=new Node(11);
	}
	
	void connect(Node node){
		if(node==null)
			return;
		if(node.nextRight!=null)
			connect(node.nextRight);
		if(node.left!=null){
			if(node.right!=null){
				node.left.nextRight=node.right;
				node.right.nextRight=getNextRight(node);
			}
			else
				node.left.nextRight=getNextRight(node);
			
			connect(node.left);
		}
		else if(node.right!=null){
			node.right.nextRight=getNextRight(node);
			connect(node.right);
		}
		else
			connect(getNextRight(node));
		
	}
	

	Node getNextRight(Node node) {
		Node temp=node.nextRight;
		while(temp!=null){
			if(temp.left!=null)
				return temp.left;
			if(temp.right!=null)
				return temp.right;
			temp=temp.nextRight;
		}
		return null;
	}

	public static void main(String[] args) {
		ConnectingNodesAtSameLevel tree=new ConnectingNodesAtSameLevel();
		tree.makeTree();
		tree.connect(tree.root);
	}
}

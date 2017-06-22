package binarySearchTree;

public class InorderPredecessorAndSuccessorForAGivenKeyInBST {
	Node root;
	static Node pre=null;
	static Node succ=null;
	class Node{
		int key;
		Node left,right;
		Node(int data){
			key=data;
			left=right=null;
		}
	}
	InorderPredecessorAndSuccessorForAGivenKeyInBST(){
		root=null;
	}
	void insert(int key){
		root=insertAt(root,key);
	}
	Node insertAt(Node node,int key){
		if(node==null){
			node=new Node(key);
			return node;
		}
		if(key<node.key)
			node.left=insertAt(node.left,key);
		else if(key>node.key)
			node.right=insertAt(node.right,key);
		return node;
	}
	void findPredecessorAndSuccessor(Node root,int key){
		findPreAndSucc(root,key);
		if(pre!=null)
			System.out.println("Predecessor is: "+pre.key);
		else
			System.out.println("No Predecessor");
		if(succ!=null)
			System.out.println("Successor is: "+succ.key);
		else
			System.out.println("No Successor");
	}
	void findPreAndSucc(Node root,int key){
		if(root==null)
			return;
		//If key is present at root
		if(root.key==key){
			//Inorder predecessor if there is left child
			if(root.left!=null){
				Node temp=root.left;
				while(temp.right!=null)
					temp=temp.right;
				pre=temp;
			}
			//Inorder successor if there is right child
			if(root.right!=null){
				Node temp=root.right;
				while(temp.left!=null)
					temp=temp.left;
				succ=temp;
			}
			return;
		}
		if(root.key>key){
			succ=root;
			findPreAndSucc(root.left, key);
		}
		else{
			pre=root;
			findPreAndSucc(root.right, key);
		}
	}
	public static void main(String[] args) {
		InorderPredecessorAndSuccessorForAGivenKeyInBST tree=new InorderPredecessorAndSuccessorForAGivenKeyInBST();
		tree.insert(20);
		tree.insert(30);
		tree.insert(40);
		tree.insert(50);
		tree.insert(60);
		tree.insert(70);
		tree.insert(80);
		tree.findPredecessorAndSuccessor(tree.root, 100);
	}

}

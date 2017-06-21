package binarySearchTree;


public class DeletionInBST {
	Node root;
	class Node{
		int key;
		Node left,right;
		Node(int data){
			key=data;
			left=right=null;
		}
	}
	
	public DeletionInBST() {
		root=null;
	}
	void delete(int key){
		deleteNode(root,key);
	}
	
	 Node deleteNode(Node node, int key) {
		 if(node==null)
			 return node;
		 if(key<node.key)
			 node.left=deleteNode(node.left, key);
		 else if(key>node.key)
			 node.right=deleteNode(node.right, key);
		 else{
			 if(node.left==null)
				 return node.right;
			 else if(node.right==null)
				 return node.left;
			 
			 node.key=minValue(node.right);
			 node.right=deleteNode(node.right, node.key);
		 }
		return node;
	}
	 int minValue(Node node) {
		int minV=node.key;
		while(node.left!=null){
			minV=node.left.key;
			node=node.left;
		}
		return minV;
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
	void insert(int key){
		root=insertAt(root,key);
	}
	void inorderTraverse(Node node){
		if(node==null)
			return;
		inorderTraverse(node.left);
		System.out.print(node.key+" ");
		inorderTraverse(node.right);
	}
	
	public static void main(String[] args) {
		DeletionInBST tree=new DeletionInBST();
		tree.insert(50);
		tree.insert(20);
		tree.insert(70);
		tree.insert(60);
		tree.insert(40);
		tree.insert(10);
		tree.insert(80);
		tree.insert(90);
		tree.insert(30);
		tree.inorderTraverse(tree.root);
		tree.delete(40);
		System.out.println();
		tree.inorderTraverse(tree.root);
		tree.delete(50);
		System.out.println();
		tree.inorderTraverse(tree.root);
	}

}

package binarySearchTree;

public class InsertionAndSearchingInBST {
	Node root;
	class Node{
		int key;
		Node left,right;
		Node(int data){
			key=data;
			left=right=null;
		}
	}
	InsertionAndSearchingInBST(){
		root=null;
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
	Node search(Node root,int key){
		if(root==null||root.key==key)
			return root;
		if(root.key>key)
			return search(root.left,key);
		else
			return search(root.right,key);
	}
	void searchKey(int key){
		if(search(this.root,key)!=null)
			System.out.println("\n"+key+" is in the tree.");
		else
			System.out.println("\n"+key+" is not in the tree.");
	}
	public static void main(String[] args) {
		InsertionAndSearchingInBST tree=new InsertionAndSearchingInBST();
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
		tree.searchKey(10);
	}
}

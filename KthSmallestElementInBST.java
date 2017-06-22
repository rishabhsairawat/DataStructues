package binarySearchTree;

public class KthSmallestElementInBST {
	static int x=0;
	Node root;
	class Node{
		int key;
		Node left,right;
		Node(int data){
			key=data;
			left=right=null;
		}
	}
	KthSmallestElementInBST(){
		root=null;
	}
	void insert(int key){
		root=insertAt(root,key);
	}
	Node insertAt(Node root,int key){
		if(root==null){
			root=new Node(key);
			return root;
		}
		if(root.key>key)
			root.left=insertAt(root.left, key);
		if(root.key<key)
			root.right=insertAt(root.right, key);
		
		return root;
	}
	void kthSmallestElement(Node node,int k){
		if(node==null)
			return;
		kthSmallestElement(node.left, k);
		x++;
		if(x==k){
			System.out.println(node.key);
			return;
		}
		kthSmallestElement(node.right, k);
	}
	public static void main(String[] args) {
		KthSmallestElementInBST tree=new KthSmallestElementInBST();
		tree.insert(20);
		tree.insert(8);
		tree.insert(22);
		tree.insert(4);
		tree.insert(12);
		tree.insert(10);
		tree.insert(14);
		tree.kthSmallestElement(tree.root, 5);
	}

}

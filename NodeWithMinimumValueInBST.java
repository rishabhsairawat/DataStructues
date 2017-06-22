package binarySearchTree;

public class NodeWithMinimumValueInBST {
	Node root;
	class Node{
		int key;
		Node left,right;
		Node(int data){
			key=data;
			left=right=null;
		}
	}
	public NodeWithMinimumValueInBST() {
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
			node.left= insertAt(node.left,key);
		else if(key>node.key)
			node.right= insertAt(node.right, key);
		return node;
	}
	int minValue(Node node){
		Node temp=node;
		while(temp.left!=null){
			temp=temp.left;
		}
		System.out.println("Minimum Value Node in tree has value: "+temp.key);
		return temp.key;
	}
	
	public static void main(String[] args) {
		NodeWithMinimumValueInBST tree=new NodeWithMinimumValueInBST();
		tree.insert(20);
		tree.insert(10);
		tree.insert(14);
		tree.insert(12);
		tree.insert(22);
		tree.insert(4);
		tree.insert(8);
		tree.minValue(tree.root);

	}

}

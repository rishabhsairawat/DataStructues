package binarySearchTree;

public class LowestCommonAncestorInBST {
	Node root;
	class Node{
		int key;
		Node left,right;
		Node(int data){
			key=data;
			left=right=null;
		}
	}
	LowestCommonAncestorInBST(){
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
			node.left=insertAt(node.left, key);
		if(key>node.key)
			node.right=insertAt(node.right, key);
		
		return node;
	}
	Node lca(Node root,int n1,int n2){
		while(root!=null){
			if(root.key>n1 && root.key>n2)
				root=root.left;
			else if(root.key<n1 && root.key<n2)
				root=root.right;
			else
				break;
		}
		return root;
	}
	
	public static void main(String[] args) {
		LowestCommonAncestorInBST tree=new LowestCommonAncestorInBST();
		tree.insert(20);
		tree.insert(8);
		tree.insert(22);
		tree.insert(4);
		tree.insert(12);
		tree.insert(10);
		tree.insert(14);
		int n1=10;
		int n2=14;
		System.out.println("LCA of "+n1+" and "+n2+" is : "+tree.lca(tree.root, n1, n2).key);

	}

}

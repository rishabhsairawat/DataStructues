package binaryTree;

public class DiameterOfABinaryTree {

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
	class Height{
		int h;
	}
	void makeTree(){
		 this.root = new Node(1);
		 this.root.left = new Node(2);
		 this.root.right = new Node(3);
		 this.root.right.left = new Node(4);
		 this.root.right.right = new Node(5);
	}
	 
	 int getDiameter(Node node,Height height){
		 Height lh=new Height();
		 Height rh=new Height();
		 if(node==null){
			 height.h=0;
			 return 0;
		 }
			lh.h++;
			rh.h++;
		 int l_diameter=getDiameter(node.left,lh);
		 int r_diameter=getDiameter(node.right,rh);
		 
		 height.h=Math.max(lh.h,rh.h)+1;
		
		 return Math.max(lh.h+rh.h+1, Math.max(l_diameter, r_diameter));
	 }
	 
	public static void main(String[] args) {
		DiameterOfABinaryTree tree=new DiameterOfABinaryTree();
		tree.makeTree();
		System.out.println("Diameter of tree is: "+tree.diameter());
	}

	int diameter() {
		Height height=new Height();
		return getDiameter(this.root,height);
	}

}

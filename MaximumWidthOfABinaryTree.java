package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidthOfABinaryTree {
	Node root;
	class Node{
		int key;
		Node left,right;
		Node(int data){
			key=data;
			left=right=null;
		}
	}
	 static int maxwidth(Node root) {
		if(root==null)
			return 0;
		int maxWidth=0;
		Queue<Node> q=new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()){
			int count=q.size();
			maxWidth=Math.max(maxWidth, count);
			while(count>0){
				Node temp=q.remove();
				if(temp.left!=null)
					q.add(temp.left);
				if(temp.right!=null)
					q.add(temp.right);
				
				count--;
			}
		}
		return maxWidth;
	}
	 
	void makeTree(){
		 this.root = new Node(1);
		 this.root.left = new Node(2);
		 this.root.right = new Node(3);
		 this.root.left.left = new Node(4);
		 this.root.left.right = new Node(5);
		 this.root.right.right=new Node(8);
		 this.root.right.right.left=new Node(6);
		 this.root.right.right.left=new Node(7);
	}
	public static void main(String[] args) {
		MaximumWidthOfABinaryTree tree=new MaximumWidthOfABinaryTree();
		tree.makeTree();
		System.out.println("Maximum width = " + maxwidth(tree.root));

	}
	

}

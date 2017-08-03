package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class RightViewOfABinaryTree {
	Node root;
	static int max_level=0;
	class Node{
		int key;
		Node left;
		Node right;
		Node(int data){
			key=data;
			left=right=null;
		}
	}
	void makeTree(){
		 this.root = new Node(12);
		 this.root.left = new Node(10);
		 this.root.right = new Node(30);
		 this.root.right.left = new Node(25);
		 this.root.right.right = new Node(40);
	}
	void rightViewUsingRecursion(Node node, int level) {
		if(node==null)
			return;
		if(max_level<level){
			System.out.print(node.key+" ");
			max_level=level;
		}
		rightViewUsingRecursion(node.right,level+1);
		rightViewUsingRecursion(node.left,level+1);
	}
	
	void rightViewWithoutUsingRecursion(Node node){
		if(node==null)
			return;
		Queue<Node> q=new LinkedList<Node>();
		q.add(node);
		q.add(null);
		boolean isLast=true;
		while(!q.isEmpty()){
			Node temp=q.peek();
			q.poll();
			if(temp!=null && isLast){
				System.out.print(temp.key+" ");
				if(temp.right!=null)
					q.add(temp.right);
				if(temp.left!=null)
					q.add(temp.left);
				isLast=false;
			}
			else if(temp!=null){
				if(temp.right!=null)
					q.add(temp.right);
				if(temp.left!=null)
					q.add(temp.left);
			}
			else if(temp==null && q.size()>1){
				q.add(null);
				isLast=true;
			}
		}
	}
	public static void main(String[] args) {
		RightViewOfABinaryTree tree=new RightViewOfABinaryTree();
		tree.makeTree();
		System.out.println("Right View Using Recursion");
		tree.rightViewUsingRecursion(tree.root, 1);
		System.out.println("\nRight View Without Using Recursion");
		tree.rightViewWithoutUsingRecursion(tree.root);
	}

}

package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class LeftViewOfABinaryTree {
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
	void getLeftView(Node node, int level) {
		if(node==null)
			return;
		if(max_level<level){
			System.out.print(node.key+" ");
			max_level=level;
		}
		getLeftView(node.left,level+1);
		getLeftView(node.right,level+1);
	}
	void leftView2(Node node){
		if(node==null)
			return;
		Queue<Node> q=new LinkedList<Node>();
		q.add(node);
		q.add(null);
		boolean isFirst=true;
		while(!q.isEmpty()){
			Node temp=q.peek();
			q.poll();
			if(isFirst&&temp!=null){
				System.out.print(temp.key+" ");
				if(temp.left!=null)
					q.add(temp.left);
				if(temp.right!=null)
					q.add(temp.right);
				isFirst=false;
			}
			else if(temp==null && q.size()>1){
				isFirst=true;
				q.add(null);
			}
			else if(temp!=null){
				if(temp.left!=null)
					q.add(temp.left);
				if(temp.right!=null)
					q.add(temp.right);
			}
		}
	}
	
		
	
	public static void main(String[] args) {
		LeftViewOfABinaryTree tree=new LeftViewOfABinaryTree();
		tree.makeTree();
		System.out.println("Left View is: ");
		tree.getLeftView(tree.root, 1);
		System.out.println("\nLeft View without using recursion is: ");
		tree.leftView2(tree.root);
	}
	

}

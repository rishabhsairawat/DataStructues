package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversalOfABinaryTree {
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
	public void makeTree(){
		this.root=new Node(1);
		this.root.left=new Node(2);
		this.root.right=new Node(3);
		this.root.left.left=new Node(4);
		this.root.left.right=new Node(5);
	}
	public void levelOrderTraversal(){
		Queue<Node> queue=new LinkedList<Node>();
		Node temp=root;
		
		while(temp!=null){
			System.out.print(temp.key+" ");
			if(temp.left!=null){
				queue.add(temp.left);
			}
			if(temp.right!=null){
				queue.add(temp.right);
			}
			temp=queue.poll();
		}
	}
	public static void main(String[] args) {
		LevelOrderTraversalOfABinaryTree tree =new LevelOrderTraversalOfABinaryTree();
		tree.makeTree();
		tree.levelOrderTraversal();
	}

}

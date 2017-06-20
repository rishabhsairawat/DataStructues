package binaryTree;

import java.util.Stack;

public class InorderTraversalWithoutRecursion {
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
		
		void makeTree(){
			 this.root = new Node(1);
			 this.root.left = new Node(2);
			 this.root.right = new Node(3);
			 this.root.right.left = new Node(4);
			 this.root.right.right = new Node(5);
		}
		
		void inorderTraversal(Node node){
			if(node==null)
				return;
			Stack<Node> stack=new Stack<Node>();
			Node currentNode=node;
			while(currentNode!=null){
				stack.push(currentNode);
				currentNode=currentNode.left;
			}
			while(!stack.isEmpty()){
					currentNode=stack.pop();
					System.out.print(currentNode.key+" ");
					if(currentNode.right!=null){
						currentNode=currentNode.right;
						while(currentNode!=null){
							stack.push(currentNode);
							currentNode=currentNode.left;
						}
					}
			}
			
			
		}
		public static void main(String[] args) {
			InorderTraversalWithoutRecursion tree=new InorderTraversalWithoutRecursion();
			tree.makeTree();
			tree.inorderTraversal(tree.root);
	}

}

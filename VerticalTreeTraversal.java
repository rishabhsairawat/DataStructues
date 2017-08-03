package binaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;


public class VerticalTreeTraversal {
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
		 this.root.left.left = new Node(4);
		 this.root.left.right = new Node(5);
		 this.root.right.left =new Node(6);
		 this.root.right.right =new Node(7);
		 this.root.right.left.right=new Node(8);
		 this.root.right.right.right=new Node(9);
		 this.root.right.right.left=new Node(10);
		 this.root.right.right.left.right=new Node(11);
		 this.root.right.right.left.right.right=new Node(12);
	}
	void verticalTraverse(Node node){
		if(node==null)return;
		Queue<Node> queue=new LinkedList<Node>();
		Queue<Integer> distanceQueue =new LinkedList<Integer>();
		TreeMap<Integer,LinkedList<Node>> map=new TreeMap<>();
		distanceQueue.add(0);
		queue.add(node);
		while(!queue.isEmpty()){
			Node temp=queue.poll();
			int distance=distanceQueue.poll();
			if(map.get(distance)==null){
				map.put(distance, new LinkedList<Node>());
			}
			map.get(distance).add(temp);
			if(temp.left!=null){
				distanceQueue.add(distance-1);
				queue.add(temp.left);
			}
			if(temp.right!=null){
				distanceQueue.add(distance+1);
				queue.add(temp.right);
			}
		}
		for(Integer key:map.keySet()){
			for(Node n:map.get(key)){
				System.out.print(n.key+" ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		VerticalTreeTraversal tree=new VerticalTreeTraversal();
		tree.makeTree();
		tree.verticalTraverse(tree.root);
	}

}

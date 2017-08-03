package binaryTree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;



public class TopViewOfABinaryTree {
	Node root;
	class Node{
		int key;
		Node left,right;
		Node(int data){
			this.key=data;
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
	void topView(Node node){
		if(node==null)
			return;
		if(node==null)return;
		Queue<Node> queue=new LinkedList<Node>();
		Queue<Integer> distanceQueue =new LinkedList<Integer>();
		queue.add(node);
		distanceQueue.add(0);
		HashSet<Integer> set = new HashSet<>();
		TreeMap<Integer,Node> map=new TreeMap<>();
		while(!queue.isEmpty()){
			Node temp=queue.poll();
			int distance=distanceQueue.poll();
			if(!set.contains(distance)){
				set.add(distance);
				map.put(distance,temp);
			}
			if(temp.left!=null){
				distanceQueue.add(distance-1);
				queue.add(temp.left);
			}
			if(temp.right!=null){
				distanceQueue.add(distance+1);
				queue.add(temp.right);
			}
		}
		for(Integer key:map.keySet())
			System.out.print(map.get(key).key+" ");
	}

	public static void main(String[] args) {
		TopViewOfABinaryTree tree=new TopViewOfABinaryTree();
		tree.makeTree();
		tree.topView(tree.root);
	}

}

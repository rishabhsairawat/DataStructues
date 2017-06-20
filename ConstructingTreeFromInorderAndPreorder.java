package binaryTree;

public class ConstructingTreeFromInorderAndPreorder {

	static int p_index=0;
	Node root;
	class Node{
		char key;
		Node left;
		Node right;
		Node(char data){
			key=data;
			left=right=null;
		}
	}
	Node buildTree(char[] in,char[] pre,int in_start,int in_end){
		if(in_start>in_end)
			return null;
		Node tNode=new Node(pre[p_index++]);
		if(in_start==in_end)
			return tNode;
		int in_index=search(in,in_start,in_end,tNode.key);
		tNode.left=buildTree(in,pre,in_start,in_index-1);
		tNode.right=buildTree(in, pre, in_index+1, in_end);
		
		return tNode;
	}
	 int search(char[] in, int in_start, int in_end, char key) {
		int i;
		for(i=in_start;i<=in_end;i++){
			if(key==in[i]){
				return i;
			}
		}
		return i;
	}
	void printInorder(Node node) {
		if(node==null)
			return;
		printInorder(node.left);
		System.out.print(node.key+" ");
		printInorder(node.right);	
	}
	public static void main(String[] args) {
		char in[] = new char[]{'D', 'B', 'E', 'A', 'F', 'C'};
	    char pre[] = new char[]{'A', 'B', 'D', 'E', 'C', 'F'};
		ConstructingTreeFromInorderAndPreorder tree =new ConstructingTreeFromInorderAndPreorder();
		Node root=tree.buildTree(in, pre, 0, in.length-1);
	    tree.printInorder(root);
	}
	

}

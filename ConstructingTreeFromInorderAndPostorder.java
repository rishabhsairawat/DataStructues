package binaryTree;

class Index 
{
    int index;
}
public class ConstructingTreeFromInorderAndPostorder {

	Node root;
	class Node{
		int key;
		Node left,right;
		Node(int data){
			key=data;
			left=right=null;
		}
	}
	
	Node buildTree(int[] in,int[] post,int in_start,int in_end,Index p_index){
		
		if(in_start>in_end)
			return null;
		Node t_node=new Node(post[p_index.index]);
		(p_index.index)--;
		if(in_start==in_end)
			return t_node;
		int in_index=search(in, in_start, in_end, t_node.key);
		t_node.right=buildTree(in, post, in_index+1, in_end, p_index);
		t_node.left=buildTree(in, post, in_start, in_index-1, p_index);
		
		return t_node;
	}
	 int search(int[] in, int in_start, int in_end, int key) {
			int i;
			for(i=in_start;i<=in_end;i++){
				if(key==in[i]){
					break;
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
		ConstructingTreeFromInorderAndPostorder tree=new ConstructingTreeFromInorderAndPostorder();
		int in[] = new int[]{4, 8, 2, 5, 1, 6, 3, 7};
        int post[] = new int[]{8, 4, 5, 2, 6, 7, 3, 1};
        int n=in.length;
        Index pIndex = new Index();
        pIndex.index = n-1;
        Node root=tree.buildTree(in, post, 0, n-1,pIndex );
        tree.printInorder(root);
	}
}

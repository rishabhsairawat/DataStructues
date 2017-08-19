package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class BFSOfAGraph {
	int V;
	LinkedList<Integer> adj[];
	BFSOfAGraph(int v){
		V=v;
		adj=new LinkedList[v];
		for(int i=0;i<v;i++)
			adj[i]=new LinkedList<>();	
	}
	void addEdge(int u,int v){
		adj[u].add(v);
	}
	
	void BFS(int s){
		boolean visited[]=new boolean[V];
		Queue<Integer> queue=new LinkedList<Integer>();
		visited[s]=true;
		queue.add(s);
		while(!queue.isEmpty()){
			int temp=queue.poll();
			System.out.print(temp+" ");
			for(Integer i:adj[temp]){
				if(!visited[i]){
					queue.add(i);
					visited[i]=true;
				}
			}
		}
	}
	public static void main(String[] args) {
		BFSOfAGraph g=new BFSOfAGraph(4);
		 	g.addEdge(0, 1);
	        g.addEdge(0, 2);
	        g.addEdge(1, 2);
	        g.addEdge(2, 0);
	        g.addEdge(2, 3);
	        g.addEdge(3, 3);
	    g.BFS(2);

	}

}

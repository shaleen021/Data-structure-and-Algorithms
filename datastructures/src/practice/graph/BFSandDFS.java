package practice.graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Graph {
	
	int V;
	LinkedList<Integer>[] edge;
	
	public Graph(int v){
		this.V = v;
		edge = new LinkedList[v];
		for(int i =0;i<v;i++){
			edge[i] = new LinkedList<>();
		}
	}
	
	public void addEdge(int u,int v){
		this.edge[u].add(v);
	}
	
	public void BFS(int s) {
		
		Queue queue = new LinkedList<>();
		boolean[] visited = new boolean[V];
		
		queue.add(s);
		visited[s] = true;
		
		while(!queue.isEmpty()) {
			int st = (int) queue.poll();
			System.out.print(st + " ");
			
			LinkedList<Integer> list = edge[st];
			
			for(Integer i:list){
				
				if(!visited[i]){
					visited[i] = true;
					queue.add(i);
				}
			}
		}
	}
	
public void DFS(int s) {
		
		Stack stack = new Stack();
		boolean[] visited = new boolean[V];
		
		stack.push(s);
		visited[s] = true;
		
		while(!stack.isEmpty()) {
			int st = (int) stack.pop();
			System.out.print(st + " ");
			
			LinkedList<Integer> list = edge[st];
			
			for(Integer i:list){
				
				if(!visited[i]){
					visited[i] = true;
					stack.push(i);
				}
			}
		}
	}

    public void topologicalSortUtil(int i, Stack s, boolean[] visited){
    	
    	visited[i] = true;
    	Iterator iter = edge[i].iterator();
    	while(iter.hasNext()){
    		int next = (int) iter.next();
    		if(!visited[next]){
    			topologicalSortUtil(next, s, visited);
    		}
    	}
    	s.push(i);
    }
    
	public void topologicalSort() {
		boolean[] visited = new boolean[V];
		 for (int i = 0; i < V; i++)
	            visited[i] = false;
		 
		Stack s = new Stack();
		for(int i=0;i<V;i++) {
			if(!visited[i])
			topologicalSortUtil(i, s, visited);
		}
		
		while(!s.isEmpty()){
			System.out.print(s.pop() + " ");
		}
	}
}

public class BFSandDFS {

	public static void main(String args[]){
		Graph g = new Graph(6);
		g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        g.addEdge(1, 4);
        g.addEdge(3, 5);
        
//        g.BFS(2);
//        System.out.println("  DFS is ");
//        g.DFS(2);
        
        Graph g1 = new Graph(6);
        g1.addEdge(5, 2);
        g1.addEdge(5, 0);
        g1.addEdge(4, 0);
        g1.addEdge(4, 1);
        g1.addEdge(2, 3);
        g1.addEdge(3, 1);
        
        g1.topologicalSort();
	}
}

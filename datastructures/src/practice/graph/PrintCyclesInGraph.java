package practice.graph;

public class PrintCyclesInGraph {
	
	static int V = 5;
	static int count = 0;
	public static void DFS(int[][] graph, boolean[] marked, int n, int vert, int start) {
		marked[vert] = true;
		//System.out.print(vert + " " );
		
		if(n==0){
			marked[vert] = false;
            if (graph[vert][start] == 1) {
                count++;
                return;
            } else
                return;
		}
		for(int i =0;i<V;i++){
			if(!marked[i] && graph[vert][i]==1){
				DFS(graph,marked,n-1,i,start);
			}
		}
		marked[vert] = false;
	}
	
	public static void main(String args[]) {
		int graph[][] = {{0, 1, 0, 1, 1},
                {1, 0, 1, 0, 1},
                {0, 1, 0, 1, 0},
                {1, 0, 1, 0, 1},
                {1, 1, 0, 1, 0}};
		boolean[] marked = new boolean[V];
		int n = 5;
		
		for(int i=0;i<V-(n-1);i++){
			DFS(graph, marked, n-1, i,i);
			marked[i] = true;
		}
		System.out.println(count/2);
		
	}

}

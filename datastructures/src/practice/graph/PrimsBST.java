package practice.graph;

public class PrimsBST {

	static int V = 5;

	public static int findMinimum(int[] key, boolean[] bst) {
		int minimumIndex = -1;
		int min = Integer.MAX_VALUE;
		for (int v = 0; v < V; v++) {
			if (!bst[v] && key[v] < min) {
				min = key[v];
				minimumIndex = v;
			}
		}
		return minimumIndex;
	}

	public static void printMST(int parent[], int n, int graph[][]) {
		System.out.println("Edge   Weight");
		for (int i = 1; i < V; i++)
			System.out.println(parent[i] + " - " + i + "    " + graph[i][parent[i]]);
	}

	public static void primsAlgo(int[][] graph) {

		int[] parent = new int[V];
		int[] key = new int[V];

		boolean[] bst = new boolean[V];

		for (int i = 0; i < V; i++) {
			bst[i] = false;
			key[i] = Integer.MAX_VALUE;
		}

		parent[0] = -1;
		key[0] = 0;

		for (int count = 0; count < V - 1; count++) {
			int u = findMinimum(key, bst);

			bst[u] = true;
			for (int v = 0; v < V; v++) {
				if (!bst[v] && graph[u][v] != 0 && graph[u][v] < key[v]) {
					key[v] = graph[u][v];
					parent[v] = u;
				}
			}
		}

		printMST(parent, V, graph);
	}

	public static void main(String args[]) {
		/*
		 * Let us create the following graph 2 3 (0)--(1)--(2) | / \ | 6| 8/ \5
		 * |7 | / \ | (3)-------(4) 9
		 */

		int graph[][] = new int[][] { { 0, 2, 0, 6, 0 }, { 2, 0, 3, 8, 5 }, { 0, 3, 0, 0, 7 }, { 6, 8, 0, 0, 9 },
				{ 0, 5, 7, 9, 0 }, };
				primsAlgo(graph);
	}
}

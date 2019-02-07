package practice.sorting;

class HeapNode {
	int data;
	int index;
	int row;
}

class MaxHeap {

	HeapNode[] nodeArray;
	int length;

	public MaxHeap(int length) {
		this.length = length;
		this.nodeArray = new HeapNode[length];
	}

	public HeapNode getMin() {
		for (int i = length / 2; i >= 0; i--) {
			heapify(this.nodeArray, length, i);
		}

		

		return this.nodeArray[0];

	}

	public static void heapify(HeapNode[] array, int n, int i) {
		int largest = i;
		int left = 2 * i + 1;
		int right = 2 * i + 2;

		if (left < n && array[left].data < array[largest].data) {
			largest = left;
		}

		if (right < n && array[right].data < array[largest].data) {
			largest = right;
		}

		if (i != largest) {
			HeapNode temp = array[i];
			array[i] = array[largest];
			array[largest] = temp;
			heapify(array, n, largest);
		}
	}
}

public class HeapSort {

	public static int[] sort(int[] array, int n) {

		for (int i = n / 2; i >= 0; i--) {
			heapify(array, n, i);
		}
		for (int j = n - 1; j >= 0; j--) {
			int temp = array[0];
			array[0] = array[j];
			array[j] = temp;
			heapify(array, j, 0);
		}

		return array;
	}

	public static int[] findKLargesrElement(int[] array, int n, int k) {

		for (int i = n / 2; i >= 0; i--) {
			heapify(array, n, i);
		}
		int j = n - 1;
		for (int i = 1; i <= k; i++) {
			System.out.println(array[0]);
			int temp = array[0];
			array[0] = array[j];
			array[j] = temp;
			heapify(array, j, 0);
			j--;
		}

		return array;
	}

	public static void heapify(int[] array, int n, int i) {
		int largest = i;
		int left = 2 * i + 1;
		int right = 2 * i + 2;

		if (left < n && array[left] > array[i]) {
			largest = left;
		}

		if (right < n && array[right] > array[largest]) {
			largest = right;
		}

		if (i != largest) {
			int temp = array[i];
			array[i] = array[largest];
			array[largest] = temp;

			heapify(array, n, largest);
		}
	}

	public static void main(String args[]) {
		int arr[] = { 12, 11, 13, 5, 6, 7 };
		int n = arr.length;
		int[] array = sort(arr, n);
		for (int i = 0; i < n; ++i)
			System.out.print(array[i] + " ");
		System.out.println();
		findKLargesrElement(arr, n, 4);

		int[][] doublyArray = {  { 6, 9, 15, 18 }, { 11, 13, 14, 19 },{ 1, 2, 3, 4 } };
		int[] sortedArray = new int[doublyArray.length * doublyArray[0].length];
		MaxHeap m = new MaxHeap(doublyArray.length);
		for (int i = 0; i < doublyArray.length; i++) {

			HeapNode heapNode = new HeapNode();
			heapNode.index = 0;
			heapNode.data = doublyArray[i][0];
			heapNode.row = i;
			m.nodeArray[i] = heapNode;

		}
		for (int i = 0; i < sortedArray.length; i++) {
			HeapNode minNode = m.getMin();
			sortedArray[i] = minNode.data;

			HeapNode heapNode = new HeapNode();
			if (minNode.index >= doublyArray.length) {
				heapNode.data = Integer.MAX_VALUE;
			}
			else{
			heapNode.data = doublyArray[minNode.row][minNode.index+1];
			heapNode.index = minNode.index + 1;
			heapNode.row = minNode.row;
			}

			m.nodeArray[0] = heapNode;
		}

		for (int i = 0; i < sortedArray.length; ++i)
			System.out.print(sortedArray[i] + " ");

	}

}

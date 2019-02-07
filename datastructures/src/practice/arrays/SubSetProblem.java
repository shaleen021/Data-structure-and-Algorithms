package practice.arrays;

import java.util.ArrayDeque;
import java.util.Deque;

public class SubSetProblem {

	private static void printAnswer(Deque<Integer> xs) {
		for (int x : xs) {
			System.out.print(x + " ");
		}
		System.out.println();
	}

	private static void findSubSet(int targetedSum, int[] array, Deque<Integer> xs, int i) {
		
		if(targetedSum == 0){
			printAnswer(xs);
		}
		if(targetedSum<0 || i>=array.length){return;}
		xs.addLast(array[i]);
		findSubSet(targetedSum-array[i], array, xs, i+1);
		xs.removeLast();
		findSubSet(targetedSum, array, xs, i+1);
	
	}

	public static void main(String[] args) {
		int array[] = { 1, 8, 7, 9, 5, 2 };
		findSubSet(12,array, new ArrayDeque<Integer>(),0);
	}
}

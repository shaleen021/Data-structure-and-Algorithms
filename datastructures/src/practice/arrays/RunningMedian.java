package practice.arrays;

import java.util.Comparator;
import java.util.PriorityQueue;

public class RunningMedian {

	public static double[] getMedians(int[] array) {
		/* max heap to keep highest element on the top */
		PriorityQueue<Integer> lowers = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return (o2.compareTo(o1));
			}
		});

		/* min heap */
		PriorityQueue<Integer> highers = new PriorityQueue<>();

		double[] medians = new double[array.length];

		for (int i = 0; i < array.length; i++) {
			int number = array[i];
			addNumber(number, lowers, highers);
			rebalanceHeap(lowers, highers);
			double median = getMedian(lowers, highers);
			medians[i] = median;
		}

		return medians;
	}

	private static double getMedian(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
		if (lowers.size() != highers.size()) {
			PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers : highers;
			return biggerHeap.peek();
		} else {
			return ((double) (lowers.peek() + highers.peek()) / 2);
		}

	}

	private static void rebalanceHeap(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
		if (lowers.size() != highers.size()) {
			PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers : highers;
			PriorityQueue<Integer> smallerHeap = lowers.size() < highers.size() ? lowers : highers;
			if (biggerHeap.size() - smallerHeap.size() >= 2) {
				smallerHeap.add(biggerHeap.poll());
			}
		}
	}

	public static void addNumber(int number, PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
		if (lowers.size() == 0 || lowers.peek() > number) {
			lowers.add(number);
		} else {
			highers.add(number);
		}
	}

	public static void main(String[] args) {
		int A[] = { 5, 15, 1, 3, 2, 8, 7, 9, 10, 6, 11, 4 };
		double[] median = getMedians(A);
		for (int i = 0; i < median.length; i++) {
			System.out.print(median[i] + "   ");
		}
	}
}

package practice.threads;

public class PrintEvenOddByTwoThreads {

	public static void main(String args[]) {
		Printer print = new Printer();
		Thread t1 = new Thread(new TaskEvenOdd(10, true, print));
		Thread t2 = new Thread(new TaskEvenOdd(10, false, print));
		t1.start();
		t2.start();
	}

}

class TaskEvenOdd implements Runnable {

	boolean isEvenNumber;
	int max;
	Printer print;

	public TaskEvenOdd(int max, boolean isEvenNumber, Printer print) {
		this.isEvenNumber = isEvenNumber;
		this.max = max;
		this.print = print;
	}

	@Override
	public void run() {
		int number = isEvenNumber == true ? 2 : 1;
		while (number <= max) {

			if (isEvenNumber) {
				print.printEven(number);
			} else {
				print.printOdd(number);
			}
			number += 2;
		}

	}

}

class Printer {

	boolean isOdd = false;

	synchronized void printEven(int number) {
		while (isOdd == false) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("Even :->" + number);
		isOdd = false;
		notifyAll();
	}

	synchronized void printOdd(int number) {
		while (isOdd == true) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("Odd :->" + number);
		isOdd = true;
		notifyAll();
	}
}

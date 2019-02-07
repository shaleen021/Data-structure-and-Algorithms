package practice;

import java.util.Arrays;
import java.util.Scanner;
/**
 * 
Aakash has invented a new kind of Web Browser known as an Integer Browser.

It downloads files in integer speeds.

The way it works is as follows:

Suppose there are 12 files downloading with an internet speed of 100 kb/s. Then the speed of download for each file is the floor of 100/12 i.e. 8 kb/s.
Now suppose we have a file of 27 kb downloading at a speed of 8 kb/s. The time taken for the download of this file is the ceiling of 27/8 which is 4 seconds.
Now, let’s assume that we have 8 files of different sizes, and an internet speed of 23 kb/s. 
The file sizes are 84, 53, 96, 101, 53, 87, 89, and 42 KB respectively.

How long will it take for the files to download? Note that once a file has finished downloading, 
then the speed of download increases for the other files.

The calculation is outlined in the diagram below:
 * */
public class IntegerBrowserSocGen {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int noOfTestCases = scanner.nextInt();
		while (noOfTestCases > 0) {
			int n = scanner.nextInt();
			int s = scanner.nextInt();
			int[] array = new int[n];
			for (int i = 0; i < n; i++) {
				array[i] = scanner.nextInt();
			}
			
			Arrays.sort(array);
			int index = 0;
			int time = 0;
			
			while (index < array.length) {
				int speed = s / (array.length - index);
				int currElement = array[index];
				time = time + (int) Math.ceil((1.0 * currElement) / (speed * 1.0));
				for (int i = index; i < array.length; i++) {
					array[i] = array[i] - currElement;

				}
				index++;
			}

			noOfTestCases--;
			System.out.println(time);
		}
	}
}

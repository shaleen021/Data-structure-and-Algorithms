package practice;

import java.util.Scanner;

public class Employee {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T > 0) {
			int E = sc.nextInt();
			int C = sc.nextInt();
			int threshold = sc.nextInt();
			int[] resignedEmployee = new int[C];
			for (int i = 0; i < C; i++) {
				resignedEmployee[i] = sc.nextInt();
			}

			int[][] employees = new int[E][C];
			for (int i = 0; i < E; i++) {
				for (int j = 0; j < C; j++) {
					employees[i][j] = sc.nextInt();
				}
			}
			int count = 0;
			for (int i = 0; i < E; i++) {
				int bd = 0;
				int[] emp = employees[i];
				for(int j=0;j<C;j++){
					if(resignedEmployee[j] != emp[j]){
						bd++;
					}
				}
				if(bd <= threshold) {
					count++;
				}
			}
			System.out.println(count);

			T--;
		}
	}

}

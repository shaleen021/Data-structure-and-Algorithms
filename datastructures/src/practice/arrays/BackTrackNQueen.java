package practice.arrays;

import java.util.Scanner;

public class BackTrackNQueen {
	
	private static boolean isSafe(int[][] arr,int row,int col, int n){
        /* Check for horizontal */
		int i,j;
        int sum = 0;
        for ( i = 0; i < arr.length; i++) {
               sum += arr[i][col];
        }
        if (sum >= 1)
               return Boolean.FALSE;
        /* check for diagonal */
        // upper left
        for (i=row, j=col; i>=0 && j>=0; i--, j--)
            if (arr[i][j] == 1)
                return false;
 
        /* Check lower diagonal on left side */
        for (i=row, j=col; j>=0 && i<n; i++, j--)
            if (arr[i][j] == 1)
                return false;
 
        return true;

	}
	private static boolean solveNQueen(int[][] array, int n, int row){
		if(row >= n){
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++)
					System.out.print(array[i][j]+ " ");
				System.out.println();
			}
			return true;
		} else {
			for(int i=0;i<n;i++){
				if(isSafe(array, row, i,n)){
					array[row][i] = 1;
					boolean isSolved = solveNQueen(array, n, row+1);
					if(isSolved)
						return true;
					array[row][i] = 0;
				}
			}
		}
		return false;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		//int n=4;
		int[][] array = new int[n][n];
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				array[i][j] = 0;
			}
		}
		solveNQueen(array,n,0);
	}

}

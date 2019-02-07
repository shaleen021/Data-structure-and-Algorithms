package practice.dp;

import java.util.Arrays;

public class CountAllPaths {
	
	public static void findAllPath(int[][] a){
		int[][] count = new int[a.length][a[0].length];
		Arrays.sort(count);
		
		for(int i=0;i<a.length;i++){
			count[i][0] = 1;
		}
		
		for(int i=0;i<a[0].length;i++){
			count[0][i] = 1;
		}
		
		for(int i=1;i<a.length;i++){
			for(int j=1;j<a[0].length;j++){
				count[i][j] = count[i-1][j-1] + count[i][j-1] + count[j][i-1];
			}
		}
		
		System.out.println(count[a.length-1][a[0].length-1]);
	}
 
	public static void main(String args[]){
		int[][] a = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		findAllPath(a);
		
	}
}

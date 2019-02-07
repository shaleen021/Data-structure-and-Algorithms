package practice.arrays;

public class SpiralMatrix {
	
	 static void spiralPrint(int row, int col, int a[][]) {
		 int i, k = 0, l = 0;
		 while(k<row && l<col) {
			 
			 for(i=k;i<col;i++) {
				 System.out.print(a[k][i] + " ");
			 }
			 k++;
			 
			 for(i=l+1;i<row;i++){
				 System.out.print(a[i][col-1] + " ");
			 }
			 col--;
			 
			 if(k<row) {
				 for (i = col-1; i >= l; i--) {
					 System.out.print(a[row-1][i] + " ");
				 }
			 }
			 row--;
			 
			 if (l < col)
		        {
		            for (i = row-1; i >= k; i--)
		            {
		            	System.out.print(a[i][l] + " ");
		            }
		        }  
			 l++;
		 }
		 
	 }
	
	public static void main(String args[]) {
		int a[][] = { {1,  2,  3,  4,  5,  6},
                {7,  8,  9,  8, 7, 3},
                {1,  2,  3,  4,  5,  6},
                {7,  8,  9,  8, 7, 3},
                {5,  2,  1,  8, 7, 9}
              };
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a[0].length;j++){
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("-----------------------------------------");
		spiralPrint(5,6,a);
	}

}

package practice.dp;

public class MinimumCutsPallindromDP {
	
	public static void findMinimumCuts(String pallindrom){
		int n = pallindrom.length();
		boolean[][] P = new boolean[n][n];
		int i,j,l;
		for(i=0;i<n;i++){
			P[i][i] = true;
		}
		for(l=2;l<=n;l++){
			for(i= 0;i<=n-l;i++){
				j = i+l-1;
				if(l == 2){
					P[i][j] = (pallindrom.charAt(i) == pallindrom.charAt(j));
				} else {
					P[i][j] = (pallindrom.charAt(i) == pallindrom.charAt(j) && P[i+1][j-1]);  
				}
			}
		}
		
		for(i=0;i<n;i++){
			for(j = 0;j<n;j++) {
				System.out.print(P[i][j] + " ");
			}
			System.out.println();
		}
		
		int[] c = new int[n];
		
		for(i=0;i<n;i++){
			if(P[0][i] == true){
				c[i] = 0;
			}else {
				c[i] = Integer.MAX_VALUE;
				for(j=0;j<i;j++){
					if(P[j+1][i] == true && c[j]+1 < c[i]){
						c[i] = 1+c[j];
					}
				}
			}
		}
		System.out.println(c[n-1]);
	}

	public static void main(String[] args){
		String a = "nitin";
		findMinimumCuts(a);
	}
}

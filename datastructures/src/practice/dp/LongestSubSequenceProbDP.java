package practice.dp;

public class LongestSubSequenceProbDP {
	
	public static int findMaxSubSequence(String str1, String str2, int m, int n){
		int[][] P = new int[m+1][n+1];
		for(int i = 0; i<=m;i++){
			for(int j=0;j<=n;j++){
				if(i == 0 || j ==0){
					P[i][j] = 0;
				}else if(str1.charAt(i-1)  == str2.charAt(j-1)){
					P[i][j] = P[i-1][j-1]+1;
				}else {
					P[i][j] = Math.max(P[i-1][j],P[i][j-1]);
				}
			}
		}
		return P[m][n];
	}

	public static void main(String args[]){
		String str1 = "shaleen";
		String str2 = "agarwaleen";
		
		System.out.println(findMaxSubSequence(str1, str2, str1.length(), str2.length()));
	}
}

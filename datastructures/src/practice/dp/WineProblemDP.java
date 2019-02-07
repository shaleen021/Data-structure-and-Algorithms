package practice.dp;


public class WineProblemDP {
	
	
	public static int maxProfit(int N, int[] pricePerBottle, int leftIndex, int rightIndex){
		if(rightIndex < leftIndex){
			return 0;
		}
		
		int year = N - (rightIndex-leftIndex +1) + 1;
		return Math.max(maxProfit(N,pricePerBottle,leftIndex+1,rightIndex) + pricePerBottle[leftIndex]*year ,
						maxProfit(N,pricePerBottle,leftIndex,rightIndex-1)  + pricePerBottle[rightIndex]*year);
	}

	
	public static void main(String args[]){
		
		int N = 5;
		int[] pricePerBottle = {2,3,5,1,4};
		
		int profit = maxProfit(N,pricePerBottle,0,4);
		System.out.println(profit);
		
	}
}

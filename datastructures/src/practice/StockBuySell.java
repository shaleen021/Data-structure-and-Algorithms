package practice;

import java.util.ArrayList;

public class StockBuySell {
	
	static class Interval {
		int buy,sell;
	}

	static void stockBuySell(int price[], int n) {
		if (n == 1) 
            return; 
		
		int count = 0;
		ArrayList<Interval> pairs = new ArrayList<>();
		int i =0;
		while(i<n-1){
			while(i<n-1 && price[i+1] < price[i])
				i++;
			
			if(i == n-1)
				break;
			
			Interval e = new Interval();
			e.buy = i++;
			
			while(i<=n-1 && price[i] > price[i-1])
				i++;
			
			e.sell = i-1;
			
			pairs.add(e);
			count++;
			
			
			
		}
		
		if(count ==0){
			System.out.println("There are no pairs");
		} else {
	            for (int j = 0; j < count; j++) 
	                System.out.println("Buy on day: " + pairs.get(j).buy 
	                        +"        " + "Sell on day : " + pairs.get(j).sell); 
		}
		
		
	}

	public static void main(String[] args) {
		int price[] = { 100, 180, 260, 310, 100,40, 535, 695 };
		int n = price.length;
		stockBuySell(price, n);
	}
}

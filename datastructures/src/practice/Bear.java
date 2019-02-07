package practice;


public class Bear {

	public static void printArray(int[] array){
		for(int i =0 ;i<array.length;i++){
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
	public static int maxRepeating(int[] arr)
	{
	    int len= arr.length;
	    for (int i = 0; i< len; i++)
	        arr[arr[i]%len] += len;
	    int max = arr[0], result = 0;
	    for (int i = 1; i < len; i++)
	    {
	        if (arr[i] > max)
	        {
	            max = arr[i];
	            result = i;
	        }
	    }
	    
	    for (int i = 0; i< len; i++)
	          arr[i] = arr[i]%len; 
	    return result;
	}
	
	public static void main(String[] args){
		
		int n = 13;
		int[] length = {2,4,4,2,4};
		int[] time = {1,4,1,6,4};
		
//		int[] length = {1,1, 1, 1, 1, 1, 1, 1, 1, 2, 4, 5, 9};
//		int[] time = {3, 5, 5, 6, 7, 7, 9, 9, 9, 6, 2, 4, 1};
		
		int[] endPoint = new int[n];
		printArray(time);
	
		int[] count = new int[n];
		for(int i = 0; i<n; i++){
			endPoint[i] = length[i] + time[i];
			count[i] = 0;
		}
		
		printArray(endPoint);
		
	}
}

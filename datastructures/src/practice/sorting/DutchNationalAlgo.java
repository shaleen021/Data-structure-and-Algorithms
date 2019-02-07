package practice.sorting;

public class DutchNationalAlgo {
	
	public static void main(String args[]){
		int[] array = {1,0,1,1,0,1,2,0,2,0,1,2,0,0,1};
		
		int low = 0;
		int high = array.length-1;
		int mid = 0;
		int temp;
		
		while(mid<=high){
			switch(array[mid]){
			case 0: temp = array[low];
					array[low] = array[mid];
					array[mid] = temp;
					low++;
					mid++;
					break;
			case 1: mid++;
					break;
			case 2: temp = array[mid];
					array[mid] = array[high];
					array[high] = temp;
					high--;
					break;
			}
		}
		for (int i = 0; i < array.length; ++i)
			System.out.print(array[i] + " ");
	}

}

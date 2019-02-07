package practice.linkedlist;

public class PrintZeroInLast {
	
	public static void moveZeroToLast(int[] array){
		int countZero = 0; int lastNonZeroIndex = 0;
		
		for(int i=0;i<array.length;i++){
			if(array[i] == 0){
				countZero++;
			}else {
				if(i != lastNonZeroIndex){
					array[lastNonZeroIndex] = array[i];
					lastNonZeroIndex = lastNonZeroIndex+1;
				}
			}
			
			
		}
		
		for(int i = array.length-countZero ;i<array.length;i++){
			array[i] =0;
		}
		
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+ " ");
			}
	}
	
	public static void main(String args[]){
		int[] araay =  {0,1,3,4,5,6,7,0,4,8,0,3,2};
		moveZeroToLast(araay);
		
		
	}

}

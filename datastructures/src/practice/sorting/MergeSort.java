package practice.sorting;


public class MergeSort {
	
	public static void mergeSort(int[] a,int left, int right){
		if(left<right){
			int mid = (left+right)/2;
			mergeSort(a, left, mid);
			mergeSort(a, mid+1, right);
			merge(a,left,mid,right);
		}
		
	}
	
	public static void merge(int[] a, int left, int mid, int right){
		int i = left;
		int count = 0;
		int j = mid+1;
		int[] sortedArray = new int[right-left +1];
		
		while(i <= mid && j <= right){
			if(a[i] <= a[j]){
				sortedArray[count] = a[i];
				count = count + 1;
				i = i +1;
			}else {
				sortedArray[count] = a[j];
				j = j + 1;
				count = count + 1;
			}
		}
		
		while(i <= mid){
			sortedArray[count] = a[i];
			count =count + 1;
			i = i + 1;
		}
		
		while(j <= right){
			sortedArray[count] = a[j];
			j = j + 1;
			count = count +1;
		}
		
		for(int k =left;k<=right;k++){
			a[k]= sortedArray[k-left];
		}
		
	}
	
	public static void main(String args[]){
		int[] a =  {0,6,9,1,5,4,8,3};
		mergeSort(a, 0,  a.length-1);
		for(int i =0;i<a.length;i++){
			System.out.print(a[i] + " ");
		}
	}

}

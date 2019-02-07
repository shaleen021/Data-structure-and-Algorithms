package practice.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class SolutionOverlap {
	
	public static void printArray(Integer[] array){
		for(int i =0 ;i<array.length;i++){
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
 
    static void findMaxGuests(Integer arrl[], Integer exit[],
    		Integer n,Integer newarrl[], Integer newexit[])    
    {   
    // Sort arrival and exit arrays
    Arrays.sort(arrl);
    Arrays.sort(exit);
 
    // guests_in indicates number of guests at a time
    int guests_in = 1, max_guests = 1, time = arrl[0];
    int i = 1, j = 0;
 
    // Similar to merge in merge sort to process
    // all events in sorted order
    while (i < n && j < n)
    {
        // If next event in sorted order is arrival,
        // increment count of guests
        if (arrl[i] <= exit[j])
        {
            guests_in++;
 
            // Update max_guests if needed
            if (guests_in > max_guests)
            {
                max_guests = guests_in;
                time = arrl[i];
            }
            i++; //increment index of arrival array
        }
        else // If event is exit, decrement count
        { // of guests.
            guests_in--;
            j++;
        }
    }
 
    System.out.println("Maximum Number of Guests = "+
                    max_guests + " at time " + time);
    int maxGuest = max_guests;
    List<Integer> entryList = new ArrayList<>();
    List<Integer> exitList = new ArrayList<>();
    
    for(i=0;i<n;i++){
    	if(newarrl[i] <= time && newexit[i] >= time){
    		
    	}else {
    		entryList.add(newarrl[i]);
    		exitList.add(newexit[i]);
    	}
    }
    
    Integer[] entArray = new Integer[entryList.size()];
    entArray = entryList.toArray(entArray);
    printArray(entArray);
    Integer[] exitArray = new Integer[exitList.size()];
    exitArray = exitList.toArray(exitArray);
    printArray(exitArray);
    
    Arrays.sort(entArray);
    Arrays.sort(exitArray);
    
    guests_in = 1;
    max_guests = 1;
    time = entArray[0];
    i = 1; j = 0;
 
    // Similar to merge in merge sort to process
    // all events in sorted order
    while (i < entArray.length && j < exitArray.length)
    {
        // If next event in sorted order is arrival,
        // increment count of guests
        if (entArray[i] <= exitArray[j])
        {
            guests_in++;
 
            // Update max_guests if needed
            if (guests_in > max_guests)
            {
                max_guests = guests_in;
                time = entArray[i];
            }
            i++; //increment index of arrival array
        }
        else // If event is exit, decrement count
        { // of guests.
            guests_in--;
            j++;
        }
    }
    
    System.out.println("Maximum Number of Guests = "+
            max_guests + " at time " + time);
    
    System.out.println(maxGuest + max_guests);
    
    }
    
    
 
    // Driver program to test above function
    public static void main(String[] args)
    {
    	
    	Scanner sc = new Scanner(System.in);
        int N = 5;
       // Integer arrl[] = {1, 2, 2, 5, 5};
       // Integer exit[] = {4, 5, 3, 9, 12};
        
        
//        for (Integer i = 0; i < N; i++) {
//        	arrl[i] = sc.nextInt();
//        }
//        for (Integer i = 0; i < N; i++) {
//        	exit[i] = sc.nextInt();
//        }
//       

        
    //    int[] arrl = {1,1, 1, 1, 1, 1, 1, 1, 1, 2, 4, 5, 9};
    //    int[] exit = {3, 5, 5, 6, 7, 7, 9, 9, 9, 6, 2, 4, 1};
        
        Integer[] arrl = {2,4,4,2,4};
        Integer[] exit = {1,4,1,6,4};
		
        Integer[] endPoint = new Integer[arrl.length];
		for(int i = 0; i<arrl.length; i++){
			endPoint[i] = arrl[i] + exit[i];
		}
		printArray(exit);
		printArray(endPoint);
		
		Integer[] newaarl = new Integer[arrl.length];
		Integer[] newexit = new Integer[exit.length];
        
        
        for(int i=0;i<exit.length;i++){
        	newaarl[i]=exit[i];
        	newexit[i] = endPoint[i];
        }
        int n = arrl.length;
        findMaxGuests(exit, endPoint, n,newaarl,newexit);
    }
}

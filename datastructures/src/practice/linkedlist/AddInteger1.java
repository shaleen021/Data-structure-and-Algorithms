package practice.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class AddInteger1 {
	
	public static List<Integer> newList = new ArrayList<>();
	
	public static void addNumber(List<Integer> list , int index, Integer number){
		
		if(list.size() > 0){
			if(number > 0 ){
				int sum = list.get(index) + number;
				list.remove(index);
				if(sum / 10 == 0){
					newList.add(sum);
					addNumber(list, index-1, 0);
				} else {
					newList.add(sum%10);
					addNumber(list, index-1, sum/10);
				}
			} else {
				newList.add(list.get(index));
				list.remove(index);
				addNumber(list, index-1, 0);
			}
		} else if(number > 0){
			newList.add(number);
		}
		
	}

	public static void main(String args[]){
		List<Integer> list = new ArrayList<>();
		
		for(int i=0;i<500000;i++){
			list.add(9);	
		}
		int length = list.size();
		System.out.println(list);
		addNumber(list, length-1 , 1);
		//System.out.println(newList);
		List<Integer> finalList = new ArrayList<>();
		for(int i = newList.size()-1;i>=0;i-- ){
			finalList.add(newList.get(i));
		}
		System.out.println(finalList);
	}
}

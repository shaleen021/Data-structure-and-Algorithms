package practice.arrays;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class FrequencyComparator {
	
	static void sort(Integer[] array) {
		Map<Integer,Integer> map = new HashMap<>();
		for(Integer a : array){
			if(map.containsKey(a)){
				map.put(a,map.get(a)+1);
			} else {
				map.put(a,1);
			}
		}
		
		
	}
	void test(){
		System.out.println("super class");
	}
	
	public static void main(String args[]){
		Integer[] array = {8,8,8,1,1,1,4,1,7,7,9,9,9,9,9,5,4,4,4,4,4,4,4,4};
		sort(array);
	}
	
}

class B extends FrequencyComparator {
	void test(){
		System.out.println("sub class");
	}
	
	public static void main(String args[]){
		FrequencyComparator f = new B();
		f.test();
		B b = new B();
		b.test();
		FrequencyComparator f1 = new B();
		f1.test();
	}
}
class ValueComparator<T1,T2 extends Comparable<T2>> implements Comparator<T1> {

	Map<T1,T2> base;
	public ValueComparator(Map<T1,T2> base) {
		this.base = base;
	}
	
	@Override
	public int compare(T1 o1, T1 o2) {
		return base.get(o1).compareTo(base.get(o2));
	}
	
}

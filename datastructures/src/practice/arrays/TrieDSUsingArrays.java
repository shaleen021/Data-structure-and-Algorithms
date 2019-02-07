package practice.arrays;

import java.util.ArrayList;
import java.util.List;

class TrieContainer {
	boolean isEnd;
	TrieContainer[] series = new TrieContainer[26];
}

public class TrieDSUsingArrays {

	public static void printWords(TrieContainer start, String toPrint, List<String> list) {

		if (start == null) {
			return;
		}
		if (start.isEnd) {
			list.add(toPrint);
			System.out.println(toPrint);
		}

		for (int i = 0; i < start.series.length; i++) {
			TrieContainer t = start.series[i];
			if (t != null) {
				printWords(t, toPrint + (char) (97 + i),list);
			}
		}
	}
	
	public static void findPattern(TrieContainer start, String pattern, List<String> list){
		if(start == null){
			return;
		}
		
		int count = 0;
		for(int j =0 ;j< pattern.length();j++){
			char character = pattern.charAt(j);
			if(start.series[character-97] != null){
				count++;
				start = start.series[character-97];
			}
		}
		
		if(count != pattern.length()){
			return;
		}
		if(start.isEnd){
			list.add(pattern);
			System.out.println(pattern);
		}
		
		if(start != null){
			for (int i = 0; i < start.series.length; i++) {
				TrieContainer t = start.series[i];
				if (t != null) {
					printWords(t, pattern + (char) (97 + i),list);
				}
			}
		}
	}

	public static void storeWords(TrieContainer start, String word) {
		for (int i = 0; i < word.length(); i++) {
			char character = word.charAt(i);

			if (start.series[character-97] != null) {
				if (i == word.length() - 1) {
					start.series[character-97].isEnd = true;
				}
				start = start.series[character-97];
			} else {
				TrieContainer tier = new TrieContainer();
				tier.isEnd = (i == word.length() - 1 ? true : false);
				start.series[character-97] = tier;
				start = start.series[character-97];
			}
		}
	}

	public static void main(String args[]) {
		TrieContainer start = new TrieContainer();
		storeWords(start, "hack");
		storeWords(start, "hackerrank");
		storeWords(start, "soumitera");
//		storeWords(start, "shal");
//		//storeWords(start, "sh");
//		storeWords(start, "gaurav");
		List<String> list1 = new ArrayList<String>();
		printWords(start, "",list1);
//		List<String> list = new ArrayList<String>();
//		findPattern(start,"hac",list);
//		System.out.println(list.size());
	}

}

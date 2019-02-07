package practice.arrays;

public class Permutation {
	
	public static void permute(String str, int l, int r){
		if(l == r){
			System.out.println(str);
		} else {
			for(int i= l;i<=r;i++){
				str = swap(str, l,i);
				permute(str,l+1,r);
				str = swap(str,l,i);
			}
		}
	}
	
	public static String swap(String temp, int m, int n){
		char[] charArray = temp.toCharArray();
		char a = charArray[m];
		charArray[m] = charArray[n];
		charArray[n] = a;
		return String.valueOf(charArray);
	}
	
	public static void main(String args[]){
		String array = "ABCD";
		permute(array, 0, array.length()-1);
	}

}

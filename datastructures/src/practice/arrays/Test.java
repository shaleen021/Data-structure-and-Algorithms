package practice.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Test {
	
 public static void main(String[] args) throws IOException {
 
	  BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	  String line = reader.readLine();
	  String[] array = new String[6];
	  array = line.split(" ");
	  System.out.println(array.length);
	  for(int i =0;i<array.length;i++){
		  System.out.println(array[i]);
	  }
}
}

package practice;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDate {

	public static void main(String[] args) {
		
		Date today = new Date();
		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("DD-MM-YYYY");
        String date = DATE_FORMAT.format(today);
		System.out.println(date);
		// TODO Auto-generated method stub

	}

}

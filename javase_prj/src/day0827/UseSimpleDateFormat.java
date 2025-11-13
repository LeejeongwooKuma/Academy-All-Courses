package day0827;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * SimpleDateFormat, Date 클래스를 사용.
 */
public class UseSimpleDateFormat {

	public UseSimpleDateFormat() {
		//1.객체 생성
		Date date = new Date();//날짜정보가 simple~~엔 없으니 date에서 받아오기위해
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy a H,k,K,h:mm:ss E요일");
		SimpleDateFormat sdf2 = 
				new SimpleDateFormat("MM-dd-yyyy a H,k,K,h:mm:ss EEEEE", Locale.JAPAN);
		
		//2. method 호출
		System.out.println(date);
		System.out.println(sdf.format(date));
		
		System.out.println(sdf2.format(date));
	}//UseSimpleDateFormat
	
	public static void main(String[] args) {
		new UseSimpleDateFormat();
	}//main

}//class

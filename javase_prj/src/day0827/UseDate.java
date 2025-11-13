package day0827;

import java.util.Date;

//import static java.lang.System.currentTimeMillis;
/**
 * 시스템의 날짜 정보를 얻기 위해 java.util.Date 클래스를 사용 
 */
public class UseDate {

	public UseDate() {
		
		//java에서 유일하게 시간을 알고있는 클래스의 method는 System.currentTimeMillis()
		long currentTime = System.currentTimeMillis();
		System.out.println(currentTime);
		
		//1. 객체생성)
		Date date = new Date();//시스템의 현재 날짜 정보를 얻을 수 있다.
		System.out.println(date);
		
		Date date2 = new Date(System.currentTimeMillis() + (1000L * 60 * 60 * 24 * 30 * 12) );//연산한 날짜정보를 얻기, int 범위 넘으니 L넣음
		System.out.println(date2);
		
	}//UseDate
	
	public static void main(String[] args) {
		new UseDate();
	}//main

}//class

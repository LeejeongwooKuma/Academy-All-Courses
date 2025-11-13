package day0827;

import java.util.Calendar;
import java.util.GregorianCalendar;


/**
 * Calendar 객체의 사용
 */
public class UseCalendar {

	public UseCalendar() {
		// 1.객체화
		Calendar cal = Calendar.getInstance();
		Calendar cal2 = new GregorianCalendar();

		System.out.println(cal);
		System.out.println(cal2);

		// 2.method 사용
		System.out.println(cal.get(1));// 상수를 직접 사용하면 가독성 바닥
		System.out.println(Calendar.YEAR);// 상수 1 대신 Constant를 써서 가독성 향상 가능
		System.out.println(cal.get(Calendar.YEAR));// Constant와 method를 조합하여 업무를 처리한다.-> 가독성 향상

		StringBuilder calFormat = new StringBuilder();
		calFormat.append(cal.get(Calendar.YEAR)).append("-")
		.append(cal.get(Calendar.MONTH) + 1).append("-").
		append(cal.get(Calendar.DAY_OF_MONTH)).append("-").
		append(cal.get(Calendar.AM_PM));

		
		//오전 오후 switch ~ case 사용하여 문자열로 출력
		switch (cal.get(Calendar.AM_PM)) {//0,1해도 되지만 가독성 떨어짐.
		case Calendar.AM : System.out.println("오전");break;
		case Calendar.PM : System.out.println("오후");break;
		}//end switch
		//위 switch문과 같은 거
		System.out.println(cal.get(Calendar.AM_PM) == Calendar.AM?"오전":"오후");
		//위 switch 및 ?과 같은 거
		String[] amPmArr = {"오전", "오후"};
		System.out.println(amPmArr[cal.get(Calendar.AM_PM)]);
		
		String[] weekArr = ",일,월,화,수,목,금,토".split(","); //DAY_OF_WEEK은 1부터 시작
		calFormat.append(amPmArr[cal.get(Calendar.AM_PM)]).append(" ").
		append(cal.get(Calendar.DAY_OF_YEAR)).append(" ").append(weekArr[cal.get(Calendar.DAY_OF_WEEK)])
		.append(" ").append(cal.get(Calendar.HOUR)).append(" (").
		append(cal.get(Calendar.HOUR_OF_DAY)).append("): ").
		append(cal.get(Calendar.MINUTE)).append(":").
		append(cal.get(Calendar.SECOND)).append(":");

		System.out.println(calFormat);
	}// UseCalnedar

	public void useSet() {
		//1. 객체 얻기)
		Calendar cal = Calendar.getInstance();
		System.out.println(cal);
		//2. method 호출)
		//년만 변경 : 2025 -> 2026
//		cal.set(Calendar.YEAR, 2026);//2026-8-27
//		cal.set(Calendar.MONTH, 6 - 1);//2026-6-27
//		cal.set(Calendar.DAY_OF_MONTH, 1);//2026-6-1
		
		//년-월-일을 한번에 변경
		cal.set(2026, 6-1, 1);
		
		StringBuilder calFormat = new StringBuilder();
		calFormat.append(cal.get(Calendar.YEAR)).append("-")
		.append(cal.get(Calendar.MONTH) + 1).append("-")
		.append(cal.get(Calendar.DAY_OF_MONTH)).append(" ")
		.append(",일,월,화,수,목,금,토".split(",")[cal.get(Calendar.DAY_OF_WEEK)])
		.append(cal.get(Calendar.DAY_OF_YEAR)).append("번 째날");
		
		System.out.println(calFormat);
		
		
	}//useSet
	
	
	public static void main(String[] args) {
		new UseCalendar().useSet();;
	}// main

}// class

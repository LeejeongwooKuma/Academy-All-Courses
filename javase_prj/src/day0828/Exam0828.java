package day0828;

import java.sql.Date;
import java.util.Calendar;

/**
 * 원하는 년도와 월은 String형 매개변수로 입력 받아 해당 년, 월의 달력을 String으로 반환하는 method 작성
 * Calendar클래스를 사용하여 입력된 년 월에 해당하는 달력은 StringBuilder에 저장하고 String으로 반환한다. 만약에
 * 년이나 월이 입력되지 않는 경우에는 현재 년, 월로 달력을 생성한다.(int형이면 상관이 없는데 String이면 null,”” 2가지 경우
 * 걸러줘야함. 위에 method를 호출하여 반환되는 달력의 문자열을 받아 콘솔에 출력하는 method 작성
 */
public class Exam0828 {
	private static final int YEAR = 0;

	public String makeCalendar(String year, String month) {
		Calendar cl = Calendar.getInstance();
		StringBuilder sb = new StringBuilder();
		if (year.equals(null) || year.equals("") || month.equals(null) || month.equals("")) {//파라메터 값이 없다면 올해,이번달로 값 초기화
			year = Integer.toString(cl.get(Calendar.YEAR));
			month = Integer.toString(cl.get(Calendar.MONTH) + 1);
		} // end if
		int intYear = Integer.parseInt(year); // year값 int형으로
		int intMonth = Integer.parseInt(month) - 1; // month값 int형으로. Calendar 월 0 시작해서 -1
		cl.set(intYear, intMonth + 1, 0); // 입력받은 다음 달에서 하루 전날 => 입력받은 달 마지막 날 추출
		int countWeek = cl.get(Calendar.WEEK_OF_MONTH);// 입력받은 달에 몇 주 존재하는지
		int countLastDay = cl.get(Calendar.DAY_OF_MONTH);// 입력받은 달의 마지막 날.
		cl.set(intYear, intMonth, 1); // 입력 받은 날짜로 초기화
		int countFistDay = cl.get(Calendar.DAY_OF_WEEK);// 1일이 무슨 요일인지 값 얻기/ 1-일 2-월 3-화...4-토
		int day = 1;// 날짜
		System.out.println("\t\t\t" + (intMonth + 1) + "월");
		System.out.println("일" + "\t" + "월" + "\t" + "화" + "\t" + "수" + "\t" + "목" + "\t" 
				+ "금" + "\t" + "토" );
		for (int i = 0; i < countWeek; i++) { // i주 반복
			for (int j = 0; j < 7; j++) { // 7일 반복
				countFistDay--;
				if (countFistDay > 0) {// 처음 빈공간
					sb.append("\t");
				} else if (day > countLastDay) {// 마지막 날이면 끝내기
					break;
				} else {// 날짜 추가하기
					sb.append(day);
					sb.append("\t");
					day++;
				} // end else
			} // end for
			sb.append("\n");
		} // end for
		String calendar = sb.toString();
		return calendar;
	}// makeCalendar

	public void printCalendar(String calendar) {
		System.out.println(calendar);
	}// printCalendar

	public static void main(String[] args) {
		Exam0828 ex0828 = new Exam0828();
		ex0828.printCalendar(ex0828.makeCalendar("2025", "08"));
	}// main

}// class

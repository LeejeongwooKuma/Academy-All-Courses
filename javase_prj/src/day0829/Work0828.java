package day0829;

import java.util.Calendar;

import static java.lang.Integer.parseInt;
/**
 * 달력을 생성하여 문자열로 반환하는 일들을 가지고 있는 클래스
 */
public class Work0828 {
	/**
	 * 입력된 년 월일을 사용하여 해당 년,월의 달력을 생성하고 문자열로 반환하는 일.
	 * 년과 월이 입력되지 않으면 현재 년, 현재 월의 달력을 생성하여 반환합니다.
	 * @param year 년
	 * @param month 월
	 * @return 달력
	 */
	public String createCalendar(String year, String month) {
		StringBuilder tempCalendar = new StringBuilder();
		Calendar cal = Calendar.getInstance();//2025-08-29
		
		//문자열이 존재하는지 비교
		if( year == null || "".equals(year) ) {//year객체가 생성되어 있지 않고,
			//year객체가 ""면 현재년도 설정
			year =String.valueOf(cal.get(Calendar.YEAR));
			System.out.println("객체가 존재, \"\"인 경우 => 현재년도 설정");//null
		}//end if
		
		if( month == null || "".equals(month) ) {//month객체가 생성되어 있지 않고,
			//month객체가 ""면 현재년도 설정
			month =String.valueOf(cal.get(Calendar.MONTH)+1);
			System.out.println("객체가 존재, \"\"인 경우 => 현재년도 설정");//null
		}//end if
		
		tempCalendar.append("\t\t").append(year).append("-").append(month)
		.append("\n")
		.append("일\t월\t화\t수\t목\t금\t토\n");
		
		cal.set(Calendar.YEAR, parseInt(year));//입력되었거나 초기화된 년도 달력객체 재설정
		cal.set(Calendar.MONTH, parseInt(month) - 1);//입력되었거나 초기화된 월로 달력객체 재설정
		//1일을 출력하기 전 공백 생성 => 1일의 요일수 (Calendar.DAY_OF_WEEK)
		//현재 달력 객체의 요일을 1일로 변경
		cal.set(Calendar.DAY_OF_MONTH, 1);
		int startDayOfWeek = cal.get(Calendar.DAY_OF_WEEK);//시작일의 요일
		//시작일의 요일을 출력하기 전에 공백을 설정
		for(int i = 1; i < startDayOfWeek; i++) {
			tempCalendar.append("\t");
		}//end for
		
		//요일 추가 : 끝 일을 알 수 없다.
		for(int tempDay = 1; ; tempDay++) {
			//설정된 요일이 현재월에 없으면 calendar객체는 자동으로 다음달 1로 설정한다.
			cal.set(Calendar.DAY_OF_MONTH, tempDay); //임시증가하는 일을 달력객체 설정.
			if(tempDay != cal.get(Calendar.DAY_OF_MONTH)) {
				//임시증가 일자와 달력에 설정된 날짜가 다르면 현재월의 종료일.
				break;
			}//end if
			
			//날짜를 추가
			tempCalendar.append(tempDay).append("\t");
			//설정된 날짜가 토요일이면 줄 변경
			switch( cal.get(Calendar.DAY_OF_WEEK)) { //일치하는 거 찾을땐 if보다 스위치
			case Calendar.SATURDAY : 
				tempCalendar.append("\n");
			}//end if
			
		}//end for
		
//		System.out.println(cal.get(Calendar.DAY_OF_MONTH) + " " + cal.get(Calendar.DAY_OF_WEEK));
		
		return tempCalendar.toString();
	}//createCalendar
	
}//class

package day0903;

import static java.lang.Integer.parseInt;

import java.util.Calendar;

public class Work0902Model {
	public String[][] createCalendar(String year, String month) {
		String[][] calArr = null;
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
		
		
		cal.set(Calendar.YEAR, parseInt(year));//입력되었거나 초기화된 년도 달력객체 재설정
		cal.set(Calendar.MONTH, parseInt(month) - 1);//입력되었거나 초기화된 월로 달력객체 재설정
		//1일을 출력하기 전 공백 생성 => 1일의 요일수 (Calendar.DAY_OF_WEEK)
		//현재 달력 객체의 요일을 1일로 변경
		cal.set(Calendar.DAY_OF_MONTH, 1);
		
		//Calendar 클래스를 사용한 월에 주차(주수)를 얻을 수 있다.
		int weekCnt = cal.getActualMaximum(Calendar.WEEK_OF_MONTH);
		calArr = new String[weekCnt][Calendar.SATURDAY];
		
//		System.out.println(calArr.length+" / " + calArr[0].length);
		weekCnt = 0;
		int dayCnt = 0;
		int startDayOfWeek = cal.get(Calendar.DAY_OF_WEEK);//시작일의 요일
		//시작일의 요일을 출력하기 전에 공백을 설정
		for(int i = 1; i < startDayOfWeek; i++) {
			calArr[weekCnt][dayCnt++] = "";
		}//end for
		
		//요일 추가 : 끝 일을 알 수 없다.
		for(int tempDay = 1; ; tempDay++) {
			//설정된 요일이 현재월에 없으면 calendar객체는 자동으로 다음달 1로 설정한다.
			cal.set(Calendar.DAY_OF_MONTH, tempDay); //임시증가하는 일을 달력객체 설정.
			if(tempDay != cal.get(Calendar.DAY_OF_MONTH)) {
				//임시증가 일자와 달력에 설정된 날짜가 다르면 현재월의 종료일.
				for(int blank = cal.get(Calendar.DAY_OF_WEEK); blank < Calendar.SATURDAY+1; blank++ ) {
				calArr[weekCnt][dayCnt++] = "";
				}
				break;
			}//end if
			
			//날짜를 추가
			calArr[weekCnt][dayCnt++] = String.valueOf(tempDay);
			//설정된 날짜가 토요일이면 줄 변경
			switch( cal.get(Calendar.DAY_OF_WEEK)) { //일치하는 거 찾을땐 if보다 스위치
			case Calendar.SATURDAY : 
				weekCnt++;//행증가
				dayCnt = 0;//0열
			}//end if
			
		}//end for
		
//		System.out.println(cal.get(Calendar.DAY_OF_MONTH) + " " + cal.get(Calendar.DAY_OF_WEEK));
		
		return calArr;
	}//createCalendar
}

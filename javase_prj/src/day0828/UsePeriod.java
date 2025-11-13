package day0828;

import java.time.LocalDate;
import java.time.Period;

public class UsePeriod {

	public UsePeriod() {
		//1.날짜객체 얻기
		LocalDate ld = LocalDate.now(); // 2025-8-28
		LocalDate ld2 = LocalDate.now(); // 2025-8-28 
//		LocalDate ld2 = LocalDate.of(2026,9,30); // 2025-8-28
		//LocalDate로 날짜연산.
		ld2 = ld2.plusYears(1);
		ld2 = ld2.plusMonths(2);
		ld2 = ld2.plusDays(6); // 현재월에 없는 날이 입력되면 다음 월에 반영된다.
		
		
		System.out.println("ld : " + ld);
		System.out.println("ld2 : " + ld2);
		
		//2. 날짜 객체를 연산할 수 있는 has a 관계를 설정하여 객체 얻기
		Period p = Period.between(ld, ld2);
		System.out.println("년도 차 : " + p.getYears() + "\n월 차 : " + p.getMonths() + "\n일 차 : " + p.getDays());
	}//UsePeriod
	public static void main(String[] args) {
		new UsePeriod();
		
		
	}//main

}//class

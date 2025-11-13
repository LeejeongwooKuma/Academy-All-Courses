package day0813;

import java.util.Scanner;

/**
 * 아래의 일을 할 수 있는 instance method를 구현하고 호출해 보세요.<br>
 * 1. 자신의 이름을 콘솔에 출력하는 method - 고정일<br>
 * 
 * 2. 자신의 "성씨"를 반환하는 method - 고정 값<br>
 * 
 * 3. 점수를 입력 받아서 점수의 판정을 콘솔에 출력하는 method - 가변 일<br>
 * 점수는 0~100 사이일 때만 판정을 한다. 그렇지 않으면 "잘못된 점수"를 출력(유효성 검증)<br>
 * 0~39점 - "과락" 출력. 40~59점 - "다른 과목 참조" 출력, 60~100점 - "합격"을 출력 Flow chart도 그려보자
 * 
 * 4.문자를 입력 받아서 해당 문자가 "대문자"인지 "소문자"인자 "숫자"인지 판단하여 콘솔에 출력하는 일을 하는 method - 가변
 * 일<br>
 * 출력 : 'A'가 입력되면 "A는 대문자"의 형식으로 출력.<br>
 * 
 * 5.태어난 해를 입력받아서 나이를 반환하는 일을 하는 method - 가변 값
 * 
 * 6.정수로 월,끝일,1일의 요일의 숫자를(일요일 1, 월 2, 화 3, 수 4, 목 5, 금 6 토 7) 입력받아서 달력을 콘솔에 출력하는
 * 일을 하는 method -가변 일<br>
 * printCalendar(8, 1, 31, 6)
 */
public class Exam0813 {

	/**
	 * 문제1.
	 */
	public void name() {
		System.out.println("내 이름은 : 이정우");
	}// name

	/**
	 * 문제2.
	 * 
	 * @return
	 */
	public char lastName() {
		return '이';
	}// lastName

	/**
	 * 문제3.
	 * 
	 * @param score
	 */
	public void calculatorScore(int score) {
		System.out.print("결과 : ");
		if (score > -1 && score < 101) {
			if (score < 40) {
				System.out.println("과락");
			} else if (score < 60) {
				System.out.println("다른 과목 참조");
			} else {
				System.out.println("합격");
			}
		} else {
			System.out.println("잘못된 점수");
		} // end else
	}// calculatorScore

	/**
	 * 문제4.
	 * 
	 * @param c
	 */
	public void checkChar(char c) {
		if ((int) c > 64 && (int) c < 91) { // 대문자인가?
			System.out.println(c + "는 대문자");
		} else if ((int) c > 96 && (int) c < 123) { // 소문자인가?
			System.out.println(c + "는 소문자");
		} else if ((int) c > 47 && (int) c < 58) { // 숫자인가?
			System.out.println(c + "는 숫자");
		} else {
			System.out.println("입력값을 다시 확인하시오.");
		} // end else
	}// end checkChar

	/**
	 * 문제 5.
	 * 
	 * @param birthYear
	 * @return
	 */
	public int calculatorYear(int birthYear) {
		int age = 2025 - birthYear + 1;
		return age;
	}// calculatorYear

	/**
	 * 문제 6.
	 */
	public void calculatorCalender(int month, int lastDay, int startDayNum) {
		int day = 0; // 달력 날짜
		int findWeek = (startDayNum - 1 + lastDay); // 몇 주 존재하는지 찾기
		System.out.println("\t\t\t" + month + "월");

		// 몇 주 존재하는지 찾기
		if (findWeek % 7 == 0) {
			findWeek = findWeek / 7;
		} else {
			findWeek = (findWeek / 7) + 1;
		} // end else

		for (int i = 0; i < findWeek; i++) { // 주만큼 반복
			for (int j = 0; j < 7; j++) { // 요일(7일)만큼 반복
				startDayNum--;
				if (startDayNum < 1) { // 빈공간 이후 날짜 적기 시작
					day++;
					if (day > lastDay) { // 마지막 날이면 끝내기
						break;
					} // end if
					System.out.print(day + "\t");
				} else { // 시작 요일 전에 있는 빈공간
					System.out.print("\t");
				} // end else

			} // end for
			System.out.println();
		} // end for
	}// calculatorCalender

	public static void main(String[] args) {

		Exam0813 ex = new Exam0813();
		// 문제 1
		ex.name();
		System.out.println("--------------------------------------------------------");

		// 문제 2
		System.out.println("성씨 : " + ex.lastName());
		System.out.println("--------------------------------------------------------");

		// 문제 3
		ex.calculatorScore(90);
		System.out.println("--------------------------------------------------------");

		// 문제 4
		ex.checkChar('A');
		System.out.println("--------------------------------------------------------");

		// 문제 5
		int age = ex.calculatorYear(1995);
		System.out.println("귀하의 나이는 : " + age + "살");
		System.out.println("--------------------------------------------------------");

		// 문제 6
		ex.calculatorCalender(8, 31, 6);
	}// main

}// class

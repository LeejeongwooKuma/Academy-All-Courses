package day0811;

/**
 * else if(다중 if) : 연관된 여러 조건을 비교할 때 사용.<br>
 * 문법<br>
 * if ( 조건식 ) { <br>
 * 조건에 맞을 때 수행될 문장들...;<br>
 * } else if {<br>
 * 조건에 맞을 때 수행될 문장들...;<br>
 * } else if {<br>
 * 조건에 맞을 때 수행될 문장들...;<br>
 * } else {<br>
 * 모든 조건에 맞지 않을 때 수행될 문장들...<br>
 * }
 */
public class TestElseIf {

	public static void main(String[] args) {

		int score = 0;
		score = Integer.parseInt(args[0]);
		System.out.print(score + "점은 ");
		// 점수에 대한 유효성 검증
		if (score < 0) {
			System.out.println("0보다 작아서 실패");
		} else if (score > 100) {
			System.out.println("100보다 커서 실패");
		} else {
			System.out.println("유효점수");
		} // end else

		// 0 - 원숭이, 1-닭, 2-개, 3-돼지, 4-쥐, 5-소, 6-호랑이, 7-토끼,
		// 8-용, 9-뱀, 10-말, 11-양

		// 태어난 해를 저장하는 변수를 만들고, args[1]의 값을 할당하고
		// 태어난 해에 대한 띠를 콘솔에 출력하는 코드를 작성해보시오
		int birthYear = Integer.parseInt(args[1]);
		System.out.print(birthYear + "년 생의 띠는 : ");
		if (birthYear % 12 == 0) {
			System.out.println("원숭이");
		} else if (birthYear % 12 == 1) {
			System.out.println("닭");
		} else if (birthYear % 12 == 2) {
			System.out.println("개");
		} else if (birthYear % 12 == 3) {
			System.out.println("돼지");
		} else if (birthYear % 12 == 4) {
			System.out.println("쥐");
		} else if (birthYear % 12 == 5) {
			System.out.println("소");
		} else if (birthYear % 12 == 6) {
			System.out.println("호랑이");
		} else if (birthYear % 12 == 7) {
			System.out.println("토끼");
		} else if (birthYear % 12 == 8) {
			System.out.println("용");
		} else if (birthYear % 12 == 9) {
			System.out.println("뱀");
		} else if (birthYear % 12 == 10) {
			System.out.println("말");
		} else if (birthYear % 12 == 11) {
			System.out.println("양");
		} else {
			System.out.println("잘못 입력하였습니다.");
		}//end else

	}// main

}// class

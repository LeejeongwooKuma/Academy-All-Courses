package day0811;

/**
 * if~else : 둘 중 하나의 코드를 실행해야 할 때.<br>
 * 문법)<br>
 * if( 조건식 ){<br>
 * 조건에 맞을 때 수행될 문장...<br>
 * }else{<br>
 * 조건에 맞지 않을 때 수행될 문장들...<br>
 * }
 */
public class TestIfElse {

	public static void main(String[] args) {
		////////////// 입력된 수가 홀,짝수/////////////
		int num = 0;
		num = Integer.parseInt(args[0]);

		System.out.print(num + "은(는) ");
		// 필수코드 끝

		// 선택코드
		if (num % 2 == 0) {
			System.out.println("짝수");
		} else {
			System.out.println("홀수");
		} // end if

		///////////// 입력된 문자열을 둘 중 하나로 비교//////////
		System.out.print(args[1] + " ");
		if (args[1].equals("자바") || args[1].equals("java") || args[1].equals("Java")) {
			System.out.println("WORA, 완벽한 OOP언어");
		} else {
			System.out.println("자바는 아니지만 좋은 언어입니다.");
		} // end if
		
		/////////// 입력된 점수가을 유효 점수, 무효 점수 비교//////////
		int score = Integer.parseInt(args[0]);
		System.out.println("점수 : " + score);
		
		if ( score > -1 && score < 101) { // >=는 >와 = 2번 처리함. >은 1번만 비교
			//경계값 테스트 필요. -1, 101, 0
			System.out.println("유효점수");
		} else {
			System.out.println("무효점수");
		}
		
	}// main

}// class

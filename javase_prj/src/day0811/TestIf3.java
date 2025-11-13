package day0811;

/**
 *	문자열의 비교. ( 같은지만 비교하는 게 기본. ==을 사용하지 말고, .equals method 사용) 
 */
public class TestIf3 {

	public static void main(String[] args) {
		
		System.out.println(args[1]);
		
		
		System.out.println( args[0].equals("자바") );
		System.out.println( !args[0].equals("자바") );
		
		System.out.println(args[0]);
		if( args[0].equals("자바")) {
			System.out.println("WORA, 완벽한 OOP언어");
		}//end if
		
		if( !args[0].equals("자바")) {
			System.out.println("자바는 아니지만 좋은 언어입니다.");
		}//end if
		
		//main method에 두번째 arguments 임의의 수를 입력하고 점수를 출력한다.
		//해당 숫자가 0~100 사이 일때만 "유효점수를"를 콘솔에 출력하는 코드 작성. 
		int num = Integer.parseInt(args[1]);
		System.out.println("점수 : " + num);
		
		if ( num > -1 && num < 101) { // >=는 >와 = 2번 처리함. >은 1번만 비교
			//경계값 테스트 필요. -1, 101, 0
			System.out.println("유효점수");
		}//end if
		
		
	}//main

}//class

package day0811;

/**
 * 입력되는 수가 홀수, 짝수
 */
public class TestIf2 {

	public static void main(String[] args) {
		//필수코드
		int num = 0;
		num = Integer.parseInt(args[0]);
		
		System.out.print( num +"은(는) " );
		//필수코드 끝
		
		//선택코드
		if( num % 2 == 0 ) {
			System.out.println("짝수");
		}//end if
		
		if( num % 2 == 1 ) {
			System.out.println("홀수");
		}//end if
		//선택코드 끝
		
	}//main

}//class

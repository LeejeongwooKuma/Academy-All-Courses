package day0811;

/**
 * 단일 if : 조건에 맞을 때에만 코드를 실행해야할 때<br>
 * 문법)<br>
 * if( 조건식) {<br>
 *    조건에 맞을 때 수행될 문장들...<br>
 *    } 
 */
public class TestIf {

	public static void main(String[] args) {
		//절대값을 구하는 코드
		int tempNum = -11;
		int abs = 0;
		
		if( tempNum < 0 ) {
		abs = -tempNum;
		}//end if
		
		System.out.println(tempNum + "의 절대값 : " + abs + "입니다.");
	}//main

}//class

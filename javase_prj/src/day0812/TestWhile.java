package day0812;

/**
 * while : 시작과 끝을 모를 때 사용하는 반복문<br>
 * 최소 0번 수행, 최대 조건까지 수행<br>
 * 문법)<br>
 * 초기값;,<br>
 * while( 조건식 ) {<br>
 * 반복수행 문장들...<br>
 * 증.감소식<br>
 * }
 */
public class TestWhile {

	public static void main(String[] args) {
		int i = 0;// 초기값
		while (i < 10) {// 조건식
			System.out.println("i : " + i);// 반복수행 문장들;
			i++;
		} // end while
		
		//while을 사용하여 구구단 5단 출력
		int num1 = 1;
		while (num1 < 10) {
			System.out.println("5 X " + num1 + " = " + 5 * num1);
			num1++;
		} // end while

	}// main

}// class

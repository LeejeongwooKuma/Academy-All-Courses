package day0812;

/**
 * do~while : 시작과 끝을 모를 때 사용하는 반복문<br>
 * 최소 1번 실행, 최대 조건까지 실행 ex) 은행 cd기 문법)<br>
 * do<br>
 * 반복수행문장들...<br>
 * while( 조건식 ); <br>
 */
public class TestDoWhile {

	public static void main(String[] args) {

		int i = 10; //초기값
		do {
			System.out.println(i);//반복수행문장들
			i++;//증.감소식
//			break;
		} while (i < 10); //조건
		System.out.println("안녕 하세요? 2025 8월 ");
		System.out.println("안녕 하세요? 2025 11월 ");
	}// main

}// class

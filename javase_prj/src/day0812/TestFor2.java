package day0812;

/**
 * 다중 for 사용<br>
 * 문법) for(초기값 ; 조건식 ; 증감소식) {<br>
 * 단일 for 영역<br>
 * for(초기값 ; 조건식 ; 증감소식) {<br>
 * 다중 for 영역<br>
 * }<br>
 * }<br>
 */
public class TestFor2 {

	public static void main(String[] args) {

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 6; j++) {
				System.out.println("i = " + i + ", j = " + j);
			} // end for
			System.out.println("-------------------------------");
		} // end for

		System.out.println("구구단 전단 출력");
		for (int i = 1; i < 10; i++) { // 단
			System.out.println(i + " 단 시작");
			for (int j = 1; j < 10; j++) { // 곱해지는 수
				System.out.println(i + " x " + j + " = " + i * j);
			} // end for
			System.out.println(i + " 단 끝\n");
		} // end for

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print(i + " " + j + " ");
			} // end for
			System.out.println();
		} // end for

		for (int i = 0; i < 4; i++) {
			for (int j = i + 1; j < 5; j++) {
				System.out.print(i + " " + j + " ");
			} // end for
			System.out.println();
		} // end for

	}// main

}// class

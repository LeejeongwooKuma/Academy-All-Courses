package day0812;

/**
 * for문의 다양한 형태
 */
public class TestFor3 {

	public static void main(String[] args) {

		// 여러개의 초기값을 가지는 for
		for (int i = 0, j = 50, k = 10; i < 10; i++, j--, k *= 2) {
			System.out.println("i : " + i + " j : " + j + " k : " + k);
		} // end for

		for (int i = 0;; i++) {
			System.out.println(i);
			if (i == 10) {
				break; // break를 사용하면 가장 가까운 switch~case, 반복문을 빠져 나간다.
			} // end if
		} // end for
		System.out.println("안녕");

		// 인덱스를 사용하지 않는 무한루프
		for (;;) {
			System.out.println("ㅎㅇ");
			break;
		} // end for

		// continue
		// 1에서 부터 100까지 짝수만 출력하는 코드
		for (int i = 1; i < 101; i++) {
			System.out.println(); // 필수 반복 코드
			if (i % 2 == 1) {
				continue;
			} // end if
			System.out.print(i + " "); // 선택 반복 코드
		} // end for

	}// main

}// class

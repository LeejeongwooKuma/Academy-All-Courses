package day0820;

/**
 * 일차원 배열의 사용
 */
public class UseArray2 {
	public UseArray2() {
		// char의 배열은 배열명을 출력하면 문자열로 출력된다.
		char[] arr = { 'a', 'b', 'c', 'd', 'e', 'f' };
		for (char temp : arr) {
			System.out.print(temp);
		}
		System.out.println();
		System.out.println(arr);// char데이터 형으로 배열을 만들고 배열명을 출력하면 주소가
		// 아닌 문자열로 출력된다. 얘만 특이하게 이렇게 됨.

		int[] score = { 50, 69, 91, 99, 84, 77 };
		//배열의 방의 값 중에 가장 큰 값을 출력
		int max = 0; 
		for(int num : score) {
			if(max < num) {
				max = num;
			}
		}
		System.out.println("max : " + max);

	}// UseArray2

	public static void main(String[] args) {
		new UseArray2();
	}// main

}// class

package day0812;

import day0813.TestModifierA;

/**
 * 문제1.<br>
 * 구구단 전체단을 출력하는 코드<br>
 * 2 x 1 = 2 3 x 1 = 3 4 x 1 = 4.... 9 x 1 = 9<br>
 * 2 x 2 = 4 3 x 2 = 6 4 x 2 = 8 ...<br>
 * ..<br>
 * 2 x 9 = 18 3 x 9 = 27 ... 9 x 9 = 81<br>
 * 
 * 문제2.<br>
 * 아래와 같은 형태로 출력 될 수 있도록 for문을 구성<br>
 * 0<br>
 *  1(공백1칸)<br>
 *   2(공백2칸)<br>
 *    3(공백3칸..)<br>
 *     4<br>
 *      5<br>
 * 문제3.<br>
 * 1~100까지 수 중 3의 배수를 합을 누적합 한 결과를 출력.<br>
 * <br>
 * 문제4. 콘솔에서 8월달 달력을 출력
 */
public class Exem0812 {

	public static void main(String[] args) {

		// --------------1번 문제---------------------
		System.out.println("--------1번 문제----------");
		for (int i = 1; i < 10; i++) {
			for (int j = 2; j < 10; j++) {
				System.out.print(j + "x" + i + " = " + j * i + " ");
			}
			System.out.println();
		}
		
		// --------------2번 문제--------------------- 
		System.out.println("--------2번 문제----------");
		for(int i = 0; i < 6; i++) {
			for(int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			System.out.println(i);
		}
		
		// --------------3번 문제---------------------
		System.out.println("--------3번 문제----------");
		int sum = 0;
		for(int i = 1; i < 101; i++) {
			if(i % 3 == 0) {
				sum +=i;
			}
		}
		System.out.println(sum);
		
		// --------------4번 문제---------------------
		System.out.println("--------4번 문제----------");
		System.out.println("                        8월      ");
		int day = -4;
		for (int i = 1; i < 6; i++) {
			for (int j = 1; j < 8; j++) {
				day++;
				if(day > 0) {
					System.out.print(day + "\t");
				} else {
					System.out.print("\t");
				}
			}
			System.out.println();
		}
	}// main

}// class

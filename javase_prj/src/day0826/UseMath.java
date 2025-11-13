package day0826;

import static java.lang.Math.abs;
/**
 * 수학관련 클래스 : Math 사용. 
 */
public class UseMath {

	private UseMath() {
//		Math m = new Math();//생성자가 보이지 않으므로 객체화할 수 없다.
		int i = -8;
		double d = -2025.08;
		
		int absI = abs(i);
		double absD = abs(d);
		System.out.println(i + " 의 절대값 " + absI);
		System.out.println(d + " 의 절대값 " + absD);
		
		d = 2025.5;
		System.out.println(d + " 의 반올림 " + Math.round(d));
		
		d = 10.1;
		System.out.println(d + " 의 올림 " + Math.ceil(d));

		d = 10.9;
		System.out.println(d + " 의 내림 " + Math.floor(d));

		d = 2025.08;
		System.out.println(d + " 의 실수 절사 " + (int)d);
		
		d = Math.random();
		System.out.println("난수 " + d);
		
		d = Math.random();
		System.out.println("발생한 난수 " + d);
		System.out.println("범위 난수 " + d * 10);
		System.out.println("범위 난수 중 정수 : " + (int)(d * 10));
		
		//알파뱃 대문자 중 하나를 출력(A-Z) 
		d = Math.random();
		System.out.println("발생한 난수 " + d);
		System.out.println("범위 난수 " + d * 26);
		System.out.println("범위 난수 중 정수 : " + (char)(d * 26 + 65));
		
	}//UseMath
	public static void main(String[] args) {
		UseMath um = new UseMath();
	}//main

}//class

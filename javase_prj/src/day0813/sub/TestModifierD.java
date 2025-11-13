package day0813.sub;

import day0813.TestModifierA;

/**
 * 다른 패키지에 존재하는 클래스 사용
 */
public class TestModifierD {

	public static void main(String[] args) {
		TestModifierA tma = new TestModifierA();
		System.out.println("tma객체의 public : " + tma.a);
//		System.out.println("tma객체의 protected : " + tma.b);//사용불가
//		System.out.println("tma객체의 default : " + tma.c);//사용불가
//		System.out.println("tma객체의 private : " + tma.d);//사용불가
		
//		TestModifierB tmb = new TestModifierB(); //package 접근지정자를 가진 클래스는 외부패키지에서 접근할 수 없다.
		
		
		
	}//main

}//class

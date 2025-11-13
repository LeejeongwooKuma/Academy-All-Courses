package day0813.sub;

import day0813.TestModifierA;

/**
 * TestModifierA 클래스의 자식클래스
 */
public class TestModifierE extends TestModifierA {

	public static void main(String[] args) {
		
		//상속관계에 있을 때에는 자식클래스로 객체화를 한다.
		TestModifierE tme = new TestModifierE();
		System.out.println("tme public : " + tme.a); //부모꺼를 자식이 씀 : 자원의 재사용성 향상
		System.out.println("tme protected : " + tme.b); 
//		System.out.println("tme default : " + tme.c);//상속이어도 못 씀 
//		System.out.println("tme private : " + tme.d);//상속이어도 못 씀 
		
	}//main

}//class

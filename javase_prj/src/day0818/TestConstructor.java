package day0818;

import day0813.test;

/**
 * 생성자 연습<br>
 * 코드에서 생성자를 하나도 정의하지 않으면 compiler가 기본생성자를 만들어준다.<br>
 * overload 된다. ( 매개변수만 다르게 작성 )<br>
 * 개발자가 생성자를 하나라도 정의하면 기본생성자를 compiler는 생성하지 않는다<br>
 * 생성자는 method 호출하는 문법으로 직접 호출할 수 없다.(new에 의해서만 호출 가능)
 * this(), super()로 생성자 호출도 가능하긴 함.
 */
public class TestConstructor {

	public TestConstructor() {
		System.out.println("default constructor");
		method();
	}// TestConstructor

	public TestConstructor(int i) {
		this();
		System.out.println("Overloding된 생성자 " + i);
		method();
//		TestConstructor(); //생긴거는 method인데 생성자는 직접 호출이 불가능.
//		new TestConstructor(); //new를 통해서만 호출 가능
	}// TestConstructor

	public void method() {
		System.out.println("instance method");
	}
	
	public static void main(String[] args) {

		new TestConstructor(8);

	}// main

}// class

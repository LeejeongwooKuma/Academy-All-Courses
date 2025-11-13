package day0813;

/**
 * static method : instance variable를 사용하지 않고 입력되는 값으로 업무를 처리해야 하는 경우.
 */
public class TestStaticMethod {
	
	//1. 업무를 구현할 method 정의.
	/**
	 * 두 정수를 입력받아서 console에 출력하는 일.
	 * @param num 수1
	 * @param num2 수2
	 */
	public static void plus(int num, int num2) {
		int result = 0;
		result = num + num2;
		System.out.println( num + " + " + num2 + " = " + result);
	}//plus
	
	/**
	 * java application
	 * @param args 외부값...
	 */
	public static void main(String[] args) {
		//2.method 호출 : 매개변수의 데이터형,개수를 주의해야함. 맞춰줘야함.
		//호출 방법1) method명(값,,,);<같은 스태틱 메소드 끼리 방법2) 클래스명.method(값,,,); <<다른 클래스의 메소드
		plus(8,13);//방법1
		TestStaticMethod.plus(8, 13);
	}//main

}//class

package day0814;

/**
 * 가변인수 ( Variable Arguments )의 사용.<br>
 * method parameter는 하나인데, arguments을 여러개 입력할 수 있는 기능.<br>
 * parameter 정의할 때 "데이터형 ... 매개변수명" 의 형식으로 선언
 */
public class UseVariableArguments {

	/**
	 * 가변 인수형을 가진 method
	 * @param va
	 */
	public void methodA(int ... va) {
		System.out.println( va );//V.A는 method안에서 배열로 사영된다. 배열 -> 참조형 데이터형 -> 찍으면 주소 나옴
		for (int i = 0; i < va.length; i++) {
			System.out.println(va[i]);
		}// end for
		
	}// methodA

	//V.A는 가장 마지막에만 정의할 수 있다.
//	public void test(int ... i , int j) {//처음 매개변수로 정의 -> 에러 
//	public void test(int i , int ... j, int k) {//중간 매개변수로 정의 -> 에러 
//	}

	public void test(int i, char ... c) {
		System.out.println("test : " +  i );
		for (int j = 0; j < c.length; j++) {
			System.out.println("test : " + c[j]);
		}// end for
	}// test
	
	public static void main(String[] args) {

		UseVariableArguments uva = new UseVariableArguments();
		uva.methodA();
		System.out.println("------------------------------");
		uva.methodA(1);
		System.out.println("------------------------------");
		uva.methodA(2025, 8, 14, 10, 3);
		System.out.println("------------------------------");
		uva.test(1,'a','b','c','z');
	}// main

}// class

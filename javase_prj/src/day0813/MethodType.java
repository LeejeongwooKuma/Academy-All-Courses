package day0813;

/**
 * method의 4가지 형태.<br>
 * 고정일, 가변일, 고정 값, 가변 값
 */
public class MethodType {

	/**
	 * 고정일 : 반환형 없고, 매개변수 없는 형<br>
	 * 입력 받는 값이 없어서 호출하면 항상 같은 일을 한다.
	 */
	public void typeA() {
		System.out.println("고정일 : 오늘은 수요일 입니다.");
	}// typeA

	/**
	 * 가변 일 : 반환형 없고, 매개변수 있는 형 입력 받는 값에 따라 다른 일을 수행함.
	 * 
	 * @param i
	 */
	public void typeB(int i) {
		System.out.println("가변일 : i = " + i);
	}// typeB

	/**
	 * 고정 값 : 반환형 있고, 매개변수는 없는 형.
	 * 
	 * @return 13일 반환
	 */
	public int typeC() {
		int day = 13;
		return day;
	}// typeC

	/**
	 * 가변 값 : 반환형 있고, 매개변수 있는 형
	 * 
	 * @param d : 실수값
	 * @return 캐스팅된 정수값
	 */
	public int typeD(double d) {
		return (int) d; // double은 8바이트, int는 4바이트므로 casting 해줘야함
	}// typeD

	public static void main(String[] args) {
		// 객체화 : 클래스명 객체명 = new 클래스명();
		MethodType mt = new MethodType();
		for (int i = 0; i < 5; i++) {
			mt.typeA();
			mt.typeB(i);
		} // end for

		// 고정 값의 method는 값이므로 값이 사용되는 모든 코드에 사용할 수 있다.
		int i = mt.typeC();
		System.out.println("고정값 : " + (mt.typeC() + 1));

		//가변 값의 method는 값이므로 값이 사용되는 모든 코드에 사용할 수 있다.
		i = mt.typeD(8.13);
		System.out.println("가변값 : " + i);
		System.out.println("가변값 : " + (mt.typeD(2025.08) + 1)); //++은 못 씀. 왜? 저기서 나온 return 값은 literal에 저장되고 
		//literal은 상수이기에 상수는 ++ 못 씀

		Integer in = new Integer( 10 );//객체 생성 => 입력값이 instance variable에 저장
		//instance method를 호출하면, 객체에 저장된 값이 나온다.
		byte b = in.byteValue();
		byte b2 = in.byteValue();
		byte b3 = in.byteValue();
		System.out.println(b + " " + b2 + " " + b3);//전부 10 10 10 나옴.그 이유는 고정값이므로. 몇 번 실행하던 나오는 값이 똑같음.
		
	}// main

}// class

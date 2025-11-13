package day0813;

/**
 * instance method 사용<br>
 * -instance variable, static variable, local variable, parameter를 사용하여 업무를 구현할
 * 때 사용하는 method.
 */
public class TestInstanceMethod {

	int day;// instance vairable. 자동초기화 0

	/**
	 * instance variable에 설정된 값을 콘솔에 출력하는 일
	 */
	public void printDay() {
		System.out.println(day + "일");
	}// printDay

	public static void main(String[] args) {

		// printDay();//instance method는 직접호출 불가능.하나는 static 메소드라 영역이 다름

		// 객체화
		TestInstanceMethod tim = new TestInstanceMethod();
		// 객체명으로 method를 호출 사용.
		tim.printDay();
		// instance variable에 값 할당
		tim.day = 13;
		tim.printDay(); // 13일
		tim.day++;// instance variable의 특징 중 하나인 객체가 소멸(Garbage Collector)하기 전에는 값이 유지된다는 특징.  
		tim.printDay(); // 14일
		
		TestInstanceMethod tim2 = new TestInstanceMethod();
		tim2.printDay(); //0일
		tim2.day++;
		tim2.printDay();
	}// main

}// class

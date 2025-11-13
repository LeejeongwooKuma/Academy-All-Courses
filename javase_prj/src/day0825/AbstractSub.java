package day0825;

/**
 * 추상클래스를 부모로 하는 자식 클래스<br>
 * 자식클래스에서 부모클래스의 정의된 모든 abstract method를 Override 해야한다.(구현의 강제성)
 */
public class AbstractSub extends AbstractSuper {

	public AbstractSub() {
		System.out.println("자식 클래스의 기본 생성자");
	}// AbstractSub

	@Override // 구현의 강제성
	public void methodA() { // override의 접근지정자는 광의의로만 가능하기에 abstract 사라지고
		// public만 남음.애초에 abstract는 추상클래스에서 명시할려고 쓴거.
		//부모 methodA 호출 하는 방법
//		super.methodA(); //추상메소드는 바디가 없기에 super로 직접 호출할 수 없다. 에러 뜸.
		System.out.println("Override된 methodA");
	}// methodA

	public int methodB(double d) {
		return (int) d;
	}// methodB

	public static void main(String[] args) {
//		//추상클래스는 직접 객체화되지 않는다. => 자식클래스가 생성될때에만 객체가 생성
//		AbstractSuper as = new AbstractSuper(); //오류
		AbstractSub as = new AbstractSub(); //추상클래스의 객체는 자식클래스가 객체화 될 때에만 만들어짐
		//이러면 부모 변수가 메모리에 올라가니 this로 부모 변수 사용 가능.
		as.methodA(); //Override된 메소드는 무조건 자식클래스의 메소드 먼저 호출
		System.out.println(as.methodB(8.25));
		
		//is a 관계의 객체화 : 부모의 method를 자식이 override 했다면 자식이
		//override 한 method가 최우선적으로 호출된다. -> 에러 방지
		AbstractSuper asu = new AbstractSub();
		asu.methodA();
	}// main

}// class

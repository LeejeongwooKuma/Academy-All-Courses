package day0825;

/**
 * 
 */
public class TestSuper {
	int i;
	int j;

	public TestSuper() {
		//super();//super는 안 보여도 기본적으로 깔려있음 
		this(25);
		System.out.println("부모클래스 기본생성자");
		i = 25;
	}//TestSuper

	public TestSuper(int i) {
//		this();
		this.i = i;
		System.out.println("부모클래스 매개변수 있는 생성자" + i);
	}//TestSuper

}// class

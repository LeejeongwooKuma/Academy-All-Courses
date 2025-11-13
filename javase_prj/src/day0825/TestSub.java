package day0825;

public class TestSub extends TestSuper{
	
	int i; //부모와 같은 이름의 변수 선언
	
	public TestSub() {
		//super();//super는 안 보여도 기본적으로 깔려있음
//		super();
//		this(20);
//		System.out.println(i + " super.j = " + super.j + " this.j = " + this.j + ", " + super.i);//j는 부모 클래스에만 있음
//		super(25);
		this(30);
		System.out.println("자식클래스의 기본생성자");
	}//TestSub
	
	public TestSub(int i) {
//		this();
		super();
		System.out.println("자식클래스의 매개변수 있는 생성자" + i);
	}
}//class

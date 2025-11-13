package day0825;

public class NestedOuter {

	int outI;
	static int outJ;

	public void outInsMethod() {
		System.out.println("바깥클래스의 instance method");
		Inner.inI = 200;
	}// outInsMethod

	public static void outStaMethod() {
		System.out.println("바깥클래스의 statice method");
	}// outStaMethod

	//////// Nested class 시작///////////
	static class Inner{
		//여기서는 static을 붙여서 static으로만 구성해야한다.
		//그렇기에 생성자도 안 만듬. 만들 수는 있음(일단은 인스턴스 영역이기 때문에). 그럴거면 nested안 쓰고 inner클래스가 되는거임.
		static int inI;
		
		public static void inStaMethod() {
			System.out.println("안쪽 클래스의 method");
			//static 영역에서는 instance 영역을 사용할 수 없다. 밑에 2개 전부 에러
//			outI = 20;
//			outInsMethod();
			outJ = 2025;//이건 static 변수이기에 사용 가능.
			outStaMethod();
			
			
			
		}//inStaMethod
		
	}//class
	////////Nested class 끝///////////

	public static void main(String[] args) {
		//안쪽클래스의 자원은 static 문법으로 사용가능.
		Inner.inI = 2025;
		Inner.inStaMethod();
		
	}// main

}// class

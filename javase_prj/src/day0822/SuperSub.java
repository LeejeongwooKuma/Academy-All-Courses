package day0822;

public class SuperSub extends SuperParent{

	int i; // 부모클래스와 같은 이름의 변수
	int k;

	@Override
	public String toString() {
		//부모클래스와 자식클래스가 같은 이름 method를 가지면 super로 구분하여 호출한다.
		return super.toString() + " 안녕하세요? " + hashCode() + Integer.toHexString(hashCode()) + " / " + getClass(); //이러면 주소도 받을 수 있음.
		
	} //toString
//	int cnt = 0;
	public void printVariable() {
		System.out.println("오늘은 금요일" /*+ ++cnt*/);
		super.printVariable(); //부모의 printVariable() 호출하고 싶음.
	}//printVariable
	
	
	public void test() {
		System.out.println(this);
//		System.out.println(super);//super : 부모객체의 주소를 가지고 있는데 출력은 되지 않는다(보안상의 이유)
		i = 100; //부모와 자식에 같은 이름에 변수가 있다면 자신의 변수를 먼저 사용한다.
		super.i = 52;
		System.out.printf("test method i : %d, k : %d, 부모변수 j : %d, i : %d", i, k, j, super.i );
	}//test
	
	public static void main(String[] args) {
		SuperSub ss = new SuperSub();
		ss.test();
		System.out.println("-------------");
		ss.printVariable();
		
		System.out.println(ss);
	}// class
}//main

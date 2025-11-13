package day0813;

/**
 * instance ( member ) variable <br>
 * 객체화하여 사용하는 변수, 자동초기화가능, 객체마다 같은 이름의 변수를 가지고 있다.
 */
public class UseInstanceVariable {
	//1. 변수의 선언) default value가 할당되고 자동초기화 됨
	private int i;
	private char c;
	private double d;
	private boolean b;
	
	public static void main(String[] args) {
		//instance 변수는 직접 사용할 수 없다. 
//		System.out.println(i); //instance variable은 static variable이랑 다르게 직접 사용 불가
		//클래스명으로도 사용할 수 없다.
//		System.out.println(UseInstanceVariable.i); //
		
		//2.객체화한다. (instance variable이 생성되고 객체에 member로 들어간다.)
		//문법) 클래스명 객체명 = new 클래스명();
		UseInstanceVariable uiv = new UseInstanceVariable();
		UseInstanceVariable uiv2 = new UseInstanceVariable();
		
		System.out.println(" 객체의 주소 : " + uiv);//참조형이므로 주소가 저장되어 있음.
		System.out.println(" 객체의 주소 : " + uiv2);//주소는 유일하기에 같은 클래스를 가진 객체래도 주소는 다름
		
		//3. 객체에 포함된 변수를 사용하여 값 할당)
		uiv.i = 2025;// 다른 객체의 변수에는 영향 안 줌
		
		//4. 값 사용)객체에 포함된 변수를 사용.
		System.out.println("uiv.i = " + uiv.i);//uiv.i = 2025 객체마다 같은 이름의 변수가 존재
		System.out.println("uiv2.i = " + uiv2.i);//uiv2.i = 0 객체마다 같은 이름의 변수가 존재
		
		System.out.println("uiv.c = " + uiv.c);//'\u0000'
		System.out.println("uiv.d = " + uiv.d);//0.0
		System.out.println("uiv.b = " + uiv.b);//false
		
	}//main

}//class

package day0813;

/**
 * static (class) variable 사용<br>
 * -공용변수(모두가 하나의 변수를 돌려 씀), class field선언, 자동초기화, 외부클래스에서도 사용 가능<br>
 */
public class UseStaticVariable {
	
	//1.선언) 접근지정자 static 데이터형 변수명;
	//지역변수랑 이름 겹쳐도 괜찮음(사용하는 메모리가 다름)
	//----기본형-----
	public static int i; // 자동초기화 : 정수 0
	public static char c;//자동초기화 : 문자 '\u0000'
	public static double d;//자동초기화 : 실수 0.0
	public static boolean b;//자동초기화 : false;
	// ----참조형----
	public static UseStaticVariable usv;//참조형 : null
	public static String s;//참조형 : null
	public static int[] arr;//참조형 : null
	
	public static void main(String[] args) {
		//2. 값할당) 클래스명.변수명, 변수명
		UseStaticVariable.i = 13; // == i = 13;
		
		//3. 값사용) //값 할당을 하지 않으면 자동초기화가 된다.(default value가 할당된다.)  
		System.out.println("정수 변수 : " + UseStaticVariable.i);
		System.out.println("문자 변수 : [" + c + "]");//\u0000은 해당하는 문자가 없음
		System.out.println("실수 변수 : " + d);
		System.out.println("불린 변수 : " + b);
		System.out.println("참조형 class : " + usv);
		System.out.println("참조형 String : " + s);
		System.out.println("참조형 array : " + arr);
		
		
		//공용변수 : 여러객체가 하나의 변수를 사용하는 것.
		//객체생성 : 클래스명 객체명 = new 클래스명(); //객체는 주소(유일한)를 가진다.
		UseStaticVariable usv2 = new UseStaticVariable();
		usv2.i = 2025; //특정객체로 접근하여 변수의 값을 변경하더라도(올바른 문법 아님) 다른 객체로 접근하면 변경된 값을 일괄적용 받는다.(usv2에서 i를 바꿨는데 usv3.i 값도 바뀜.. 집전화 일괄 바뀜)
		UseStaticVariable usv3 = new UseStaticVariable();
		System.out.println(usv2 + " static 변수 " + usv2.i); //내 집 전화는..의미. 우리집이 아니라.(특정객체만 가지고 있다는 의미)..공용의 의미랑은 거리가 멀음.
		//static 공용(우리) : 같이 사용하는 의미로 변수를 사용해야한다.
		//usv2.i는 특정객체에 속한 변수라는 의미이고, UseStaticVariable.i는 클래스안에 변수.이게 올바름.
		//객체명.변수로 쓸 수 있긴 한데 좀 애매함. static은 공용인데 usv2만의 변수로 사용할려고 하니 워링뜸.
		//쓸 순 있는데 올바른 표현은 아님. 올바른 표현은 클래스명.변수명
		System.out.println(usv3 + " static 변수 " + usv3.i);
	}// main

}// class

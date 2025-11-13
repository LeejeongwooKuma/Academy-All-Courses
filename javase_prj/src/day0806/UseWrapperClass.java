package day0806;
/**
	Wrapper class 사용 : 기본형 데이터형과 같은 이름이거나 유사한 이름을 가진 class들.<br>
	기본형 데이터형은 변수의 선언, 값할당, 사용의 일만 하는데<br>
	Wrapper class는 객체가 제공하는 다양한 기능을 사용할 수 있다.<br>
		byte b = 10;
		String s = b; <<할 수 없다.
		Byte bObj = new Btye(b);//레퍼 클래스로 객체 생성 // 또는
		or Byte bObj = Byte.valueOf(b);// 이렇게 메소드로 사용 <<2가지 생성 방법은 JDK 버전 차이
		
		String s = bObj.toString(); //byte의 값을 String에 할당 가능.
		
*/

class UseWrapperClass{
	public static void main(String[] args){
	float b = 8.6f; //기본형 데이터형 : 딱히 기능 없음.
	Float fObj = new Float(b); //JAVA SE8까지 생성자를 사용하여 객체를 생성하던 방법. <<지금 쓰면 경고 뜸. 쓸 수는 있음
	Float fObj2 = Float.valueOf(b); //Java SE9부터 생성자가 아닌 valueOf method를 사용하여 객체를 얻어서 사용.
	
	//wrapper class는 다양한 기능을 갖고 있음.
	//int i = b; //에러 뜸. 캐스팅 필요. byte는 같으나 데이터형이 다름.
	//wrapper class의 기능을 사용하여 다양한 일을 수행할 수 있다.
	int i = fObj.intValue(); //캐스팅 안 해도 intValue메소드 사용하면 끝.
	//String s = b;//얘도 똑같이 오류
	String s = fObj2.toString();//wrapper클래스 메소드 사용하여 캐스팅 없이 쉽게 가능
	System.out.println("i : " + i + ", s : " + s);
	}
}

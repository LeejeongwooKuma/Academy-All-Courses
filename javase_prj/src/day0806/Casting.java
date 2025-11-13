package day0806;
/**
강제 형 변환
개발자가 원하는 데이터 형으로 일시적인 변환을 하는 것
*/
class Casting{
	public static void main(String[] args){
	
		float f = (float)8.06;	
		
		//강제형변환으로 값 손실
		int i = 0;
		//i = f; //byte는 똑같이 4 4이지만 값이 정수와 실수로 달라서 에러
		i = (int)f; //강제형변환 하여 에러는 사라지지만 실수 사라지고 정수만 살음
		System.out.println("int i = " + i + ", float f = " + f);
		
		byte b = 10, b2 = 20, result = 0;
		
		//result = b + b2;//promotion이 알아서 돌아가서 에러뜸
		//result = (byte)(b + b2);//promotion이 일어나도 다시 byte로 강제형변환 해줘서 이번엔 돌아감
		System.out.println(result);
		
		char c = 'A';//unicode 값이 c로 할당
		System.out.println("unicode에 해당되는 문자가 출력 : " + c + ", unicode 값 : " + (int)c);
		
		//기본형 데이터 형(값) <-> 참조형 데이터 형(주소) 으로는 강제형 병환이 되지 않는다.
		String s = "8"; //문자열의 8
		int j = 0; // 정수 0
		//j = (int)s; //참조형(s)를 기본형(int)로 변환할 수 없다.
		//s = (String)j; //기본형(j)을 참조형(s)로 변환할 수 없다.
		
		//boolean형은 다른 데이터 형으로 강제형변환 될 수 없다.
		boolean bl = true, bl2 = false;
		bl2 = (boolean)bl;//이건 가능. boolean형은 동일 형으로만 강제 형 변환이 되긴 하는데 할 이유가 아예 없음.
		System.out.println(bl2);
		//j = bl;
		
		//long l = (long)2147483648; //오류 뜸. 왜? 뒤 214~숫자 자체는 리터널이 4byte인데 casting은 리터널의 크기를 못 바꿔줌. 
		
	}//main
}//class

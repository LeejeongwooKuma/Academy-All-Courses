package day0806;
/**
기본형 데이터형 : 변수에 값을 저장하는 데이터 형.
*/

class  PrimitiveDataType{
	public static void main(String[] args){
		//정수 상수를 저장하는 데이터 형 : byte, short, int, long
		System.out.println("-----정수 상수를 저장할 수 있는 데이터형-----");
		byte b = 127;//숫자는 초기화 값. -128~ +127
		System.out.println("byte : " + b);
		short s = 32767;// -32768 ~ +32767
		System.out.println("short : " + s);
		int i = 6;
		System.out.println("int : " + i);
		long l = 6;
		System.out.println("long : " + l);
		//30억 예금을 저장할 변수 설정
		long myMoney = 3000000000L;
		System.out.println("내 미래 돈 : " + myMoney);
		
		System.out.println("-----문자 상수를 저장할 수 있는 문자형 데이터형-----");		
		/*
		char c = 'A'; // == 65, '\u0041'
		char c2 = '0';
		char c3 = '가';
		*/
		char c = 65; // unicode값을 직접 할당 할 수 있음
		char c2 = 48;
		char c3 = 44032;
		char c4 = '\u0041';
		System.out.println(c + " / " + c2 + " / " + c3 + " / " + c4);

		float f = 8.6F; //실수 literal은 8byte가 기본크기이고 float은 4byte의 크기이므로 
		//그냥 할당하면 크기가 다르므로 에러가 발생 => 형명시 필요
		double d = 8.6d; //형명시 생략 가능
		System.out.println("float : " + f + "\n" + "double : " + d);
			
			
		System.out.println("-----불린 상수를 저장할수 있는 불린형 데이터형-----");
		boolean b1 = true;
		boolean b12 = false;
		System.out.println("boolean : " + b1 + " / " + b12);
	}
}

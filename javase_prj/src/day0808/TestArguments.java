package day0808;

/**
 * main method의 arguments 받기
 */
public class TestArguments {

	public static void main(String[] args) {
		
		System.out.println(args[0]);
		System.out.println(args[1]);
		System.out.println(args[2]);
		System.out.println(args[0] + args[1]); //숫자여도 문자열로 인식

		//int i = args[0]; //참조형은 기본형으로 형변환 불가. 이럴땐 레퍼클래스 사용
		int i = Integer.parseInt(args[0]);
		int j = Integer.parseInt(args[1]);
		System.out.println(i+j);
		
		int k = Integer.valueOf(args[0]);//이것도 가능. 언박싱.
	}//main

}//class

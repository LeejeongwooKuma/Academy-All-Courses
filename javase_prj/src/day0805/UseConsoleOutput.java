package day0805;
class UseConsoleOutput{
	public static void main(String[] args){
		//System.out.print("안녕");
		//System.out.print("하세요?");
		
		//상수 출력
		System.out.println(2025); //정수 상수(값이 정해진 정수)
		System.out.println(2025.08); //실수 상수
		System.out.println('A'); //문자 상수(문자 한개만 가능)
		//System.out.println('AB'); //에러 뜸(한글자 이상이라)
		System.out.println('가'); //문자 상수
		System.out.println('0'); //문자 상수
		System.out.println("오늘은 8월 5일 화요일"); //문자열 상수
		System.out.println(true); //boolean(불린) 상수
		
		//연산식 : 연산된 결과가 출력
		System.out.println(8+5);
		//System.out.println("8" * "5");//error : 문자열은 연산되지 않는다.
		
		//문자열에 +를 사용하면 붙여라 라는 의미.
		System.out.println("8" + "5 = " + 8 + 5);//문자열의 85. 팔실오 아님
		System.out.println("8" + "5 = " + (8 + 5));//13나옴
	}//main
}//class

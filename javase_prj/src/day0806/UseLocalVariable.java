package day0806;
/**
 지역변수의 사용법을 알기위한 클래스
*/
class  UseLocalVariable{
	
	/**
	Java Application으로 클래스를 만들기 위해서 main method를 선언
	*/
	public static void main(String[] args){ 
		//지역(local)변수 사용 - 메인메소드 안의 변수
		
		//1.선언) : 모양 = > 데이터형 변수명; 특징 : 자동초기화가 되지 않음
		int myAge;
		//현재 일자를 저장하는 변수 선언
		//int year, month, dayOfMonth;
		int dayOfMonth = 6; //초기화 값을 할당 가능
		
		//2.값 할당) 모양 = > 변수명 = 값;
		myAge=25;
		//현재 일자를 저장하는 변수에 값할당
		//year=2025; month=8; 
		dayOfMonth=7; //이전에 할당된 값을 저장하지 않고(6), 새로운 값으로 저장(7).
		
		//3.값 사용) : 출력, 연산, 재할당
		System.out.println("내 나이는 : " + myAge + "살 입니다"); //초기화(값할당) 되지 않은 변수를 사용하면 error 발생
		//현재 일자를 저장하는 변수를 사용
		System.out.println("오늘의 날짜는 : " + dayOfMonth + "일 입니다.");//7출력
		
		dayOfMonth = 8; //값할당은 필요한 만큼 가능
		System.out.println(dayOfMonth + "일");//8 출력
		
		//하나의 영역에서는 같은 이름의 변수를 선언할 수 없다. error
//		int myAge; //맨 처음에 선언했던 변수명 -> 컴파일 에러. 자바는 대소문자 구분함. a소문자 쓰면 ㄱㅊ
		//double myAge; //데이터형은 상관 없이 에러 뜸. 변수명이 중요
		
		//참조형 데이터 형
		UseLocalVariable ulv = new UseLocalVariable();
		System.out.println(ulv);
		
	}//main
}//class

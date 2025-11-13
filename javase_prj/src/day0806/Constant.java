package day0806;
/**
	변수를 상수 처럼 사용할 때,<br>
	프로그램 안에서 기준 값을 저장하고 사용해야할 때.
*/
class Constant{
	//Constant 선언 : class field에서만 가능
	
	public static final int MAX_SCORE = 100;
	public static final int MIN_SCORE = 0;
	
	public static void main(String[] args){
		//public static final int MIN_SCORE = 0; //constant는 local에 선언 불가. class filed에만 사용 가능
		int myScore=85;
		//constant 명으로만 사용 가능
		System.out.println("최고점 : " + MAX_SCORE + ", 최저점 : " + MIN_SCORE);
		//MAX_SCORE = 101;//constant는 final 때문에 값 못 바꿈.
		//클래스명.constant명 사용
		System.out.println("최고점에서 획득한 점수의 차 : " + (Constant.MAX_SCORE - myScore) + "점");
	}
}

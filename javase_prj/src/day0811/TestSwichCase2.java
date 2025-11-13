package day0811;

import kr.co.sist.util.Zodiac;

/**
 * 점수를 입력받아 학점을 구하는 switch~case<br>
 * if가 더 적합함. 이유는 학점은 범위를 구하는데 switch case는 범위도 가능은 한데
 * 딱 맞아 떨어지는 거 구하는데 특화됨
 */
public class TestSwichCase2 {
	//switch문의 가독성을 늘려주기 위해 상수는 constants 사용
	public static final int GRADE_A_PLUS = 10;
	public static final int GRADE_A = 9;
	public static final int GRADE_B = 8;
	public static final int GRADE_C = 7;
	public static final int GRADE_D = 6;
	
	public static void main(String[] args) {
//		int score = 75;
//		char grade = 'F';
//		switch ( score ) {
//		case 100:
//		case 99: 
//		case 98: 
//		case 97: 
//		case 96: 
//		case 95: 
//		case 94: 
//		case 93: 
//		case 92: 
//		case 91: 
//		case 90: grade = 'A'; break;
//		//범위를 할려면 노가다 수준. 굳이 할려면 /10해서 100은10, 99~90은 9, 89~80은 8..이렇게도 가능
//		}

//		switch ( score / 10 ) {
//		case GRADE_A_PLUS: //차피 밑에랑 겹치니 안 써도줘도 됨.
//		case GRADE_A: grade = 'A'; break;
//		case GRADE_B: grade = 'B'; break;
//		case GRADE_C: grade = 'C'; break;
//		case GRADE_D: grade = 'D'; break;
//		default : grade = 'F';
//		}//end switch
		int score = 75;
		char grade = 64;
		//break를 최소화한 코딩. 근데 위에가 더 좋은 코드임. 이유는 d학점 구한다 치면 얘는 여러번 일 해야함 
		switch ( score / 10 ) {
		case GRADE_D: grade++;//65
		case GRADE_C: grade++;//66
		case GRADE_B: grade++;//67
		case GRADE_A: 
		case GRADE_A_PLUS: grade++; break; 
		default : grade += 6;// grade = grade + 6
		}//end switch
		
		System.out.println(score + "점의 학점은 " + grade);
		
		int birthYear = 1995;
		int zodiacFlag = birthYear % 12;
		System.out.print(birthYear + "년 생의 띠는 : ");
		
		//if보다 switch가 이런 정해진 상수 문제에선 더 보기 좋다
		switch (zodiacFlag) {
		case Zodiac.MONKEY : System.out.println("원숭이"); break;
		case Zodiac.ROOSTER : System.out.println("닭"); break;
		case Zodiac.DOG : System.out.println("개"); break;
		case Zodiac.PIG : System.out.println("돼지"); break;
		case Zodiac.MOUSE : System.out.println("쥐"); break;
		case Zodiac.COW : System.out.println("소"); break;
		case Zodiac.TIGER : System.out.println("호랑이"); break;
		case Zodiac.RABBIT : System.out.println("토끼"); break;
		case Zodiac.DRAGON : System.out.println("용"); break;
		case Zodiac.SNAKE : System.out.println("뱀"); break;
		case Zodiac.HOURS : System.out.println("말"); break;
		default : System.out.println("양"); break;
		}
	}//main

}//class

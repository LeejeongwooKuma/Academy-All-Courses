package day0814;

/**
 * Variable Arguments가 도입된 method 사용.
 */
public class UsePrintf {

	
	public static void main(String[] args) {

		int year = 2025, month = 8, day = 14;
		//println은 출력 메시지와 값이 섞이게 됨.
		//계산 할 때도 string 강제 형변환 때메 ()해야하는데 f는 안 그래도 됨
		System.out.println("오늘은" + year + "년" + month + "월" + (day + 1) + "일 입니다.");
		//printf는 출력 메시지와 값이 분리가 됨 -> 정리된 느낌을 줌.
		System.out.printf("오늘은 %d년 %d월 %d일 입니다.", year, month, day+1);
		
		System.out.println("정수출력");
		System.out.printf("[%d][%7d][%-7d]\n",year, year, year);

		System.out.printf("문자출력[%c][%3c][%-3c]\n",'A', 'B', 'C');
		
		double d = 2025.08;
		System.out.printf("실수출력[%f][%10.3f][%.2f]\n",d, d, d);
		
		boolean b = true, b2 = false;
		System.out.printf("불린출력[%b][%7b][%-7b]\n",b, b2, b2);
		
		String msg = "java";
		System.out.printf("문자열 [%s][%10s][%-10s]\n", msg, msg, msg);
		
		String name = "신용권";
		int age = 25;
		double height = 180.4;
		System.out.format("이름 %s, 나이 %d, 키 %.1f", name, age, height);
		
	}//main

}//class

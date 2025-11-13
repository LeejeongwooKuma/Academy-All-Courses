package day0807;
class Exam0807{
	public static final int MONTH_MONEY = 800000;
	public static final int DAY_MONEY = MONTH_MONEY/20;
	public static void main(String[] args){
		//한달 용돈 xxx원 => constant;;; 하루 용돈은 20일(constant) 기준 xxx원(나누기,연산)
		//하루 지출 내역은 편도 교통비 xx원(변수)원, 왕복 교통비 xxx원(연산), 점심식대 xxx원(변수)으로
		//총 하루 xxx원 지출(지출) 된다. 
		//한달이 지났을 때 잔액은 xx원입니다.
		int oneBusFee = 5600, lunch = 9000, dayExpense = oneBusFee * 2 + 9000;
		
		System.out.println("한달 용돈은 " + MONTH_MONEY + "원, 하루 용돈은 " + DAY_MONEY
			+ "원 입니다.\n하루 지출 내역은 편도 교통비 " + oneBusFee + "원, 왕복 교통비 " + 
			(oneBusFee * 2) + "원, 점심식대 " + lunch + "원으로 총 " + dayExpense +
			"원 지출 된다.\n한달이 지났을 때의 잔액은 " + (MONTH_MONEY - dayExpense * 20) 
			+ "원 입니다.");
		
		
		//API에 존재하는 Wrapper class를 찾고 그 안에 최고값과 최소값을 가지는 constant를 찾아보고
		//Constant가 존재한다면 아래와같이 출력해라.
		// byte의 최소값은 -128~최대값 127
		
		
		System.out.println("Byte의 최소값 : " + Byte.MIN_VALUE + " ~ 최대값 : " + Byte.MAX_VALUE);
		System.out.println("Short의 최소값 : " + Short.MIN_VALUE + " ~ 최대값 : " + Short.MAX_VALUE);
		System.out.println("Integer의 최소값 : " + Integer.MIN_VALUE + " ~ 최대값 : " + Integer.MAX_VALUE);
		System.out.println("Long의 최소값 : " + Long.MIN_VALUE + " ~ 최대값 : " + Long.MAX_VALUE);
		System.out.println("Character의 최소값 : " + (int)Character.MIN_VALUE + " ~ 최대값 : " + (int)Character.MAX_VALUE);
		System.out.println("Float의 최소값 : " + Float.MIN_VALUE + " ~ 최대값 : " + Float.MAX_VALUE);
		System.out.println("Double의 최소값 : " + Double.MIN_VALUE + " ~ 최대값 : " + Double.MAX_VALUE);
		
		
		
		
	}
}

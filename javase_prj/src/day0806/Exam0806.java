package day0806;
class Exam0806{
	public static final int MONTH_WORK = 20; 
	public static void main(String[] args){
		char name1 = 'L';
		char name2 = 'J';
		char name3 = 'W';
		System.out.println("내 이름은 홍길동이고 이니셜은 : " + name1 + name2 + name3); //name끼리만 뽑아낼려면 + 사용시 유니코드끼리 더한 값만 나옴. 앞에 문자를 써줘서 문자열로 계산되게 ㄱㄱ. "" 쓰면 끝.
		
		double leftEye = 0.3, rightEye = 0.5;
		double allEye = (leftEye + rightEye) / 2;
		System.out.println("왼쪽 시력 : " + leftEye + " 오른쪽 시력 : " + 
			rightEye + " 양안 시력 : " + allEye);
		
		int oneFee = 2800, roundFee = oneFee * 2;
		System.out.println("편도 차비 : " + oneFee + "원, 왕복차비 : " + roundFee + 
			", 한달" + MONTH_WORK + "일 출근하면 월 교통비는 : " + (roundFee * MONTH_WORK) + "원 입니다.");
		
		char a = 'A';
		System.out.println("대문자 '" + a + "'의 unicode 값은 " + (int)a + "입니다.'" + a + "'에 32를 더하면 소문자 '" + (char)(a + 32) + "'를 만들 수 있다.");	
		
	}
}

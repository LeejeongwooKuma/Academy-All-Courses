package day0808;
/**
	char의 Wrapper class인 Charater class의 사용
*/
class  Test{
	public static void main(String[] args){
		//char minValue = '\u0000';//유니코드
		char maxValue = '\uFFFF';
		char minValue = Character.MIN_VALUE;//0
		//char maxValue = Character.MAX_VALUE;//65535
		System.out.println("문자 : [" + (int)minValue + "][" + (int)maxValue + "]" );//unicode값 65에 대응되는 문자를 출력. 
		//문제는 대응되는 문자가 없을 때 있음. 0같은 거. 이클립스는 문제 없음
		
		
		long st = System.currentTimeMillis();
		int total = 0;
		for (int i = 0; i < 500; i++) {
			total += i;
			System.out.println("total = " + total + ", i = " + i);
		}
		System.out.println("결과값 : " + total);
		long et = System.currentTimeMillis();
		System.out.println((et - st) + "ms");
	}
}

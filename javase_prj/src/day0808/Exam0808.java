package day0808;

/**문제1.
 * 1-1 정수를 저장할 수 있는 변수를 두개 선언하고, 각각의 변수에
 * main method의 arguments 0,1을 할당 하세요.
 * 1-2 위에서 선언된 변수에 할당된 값 중 "큰값"을 console에 출력하는 코드를 
 * 삼항연산자를 사용하 작성
 * 
 * 문제2.
 * 2-1 정수를 저장할 수 있는 변수 세개를 선언하고, 각각의 변수에 임의이 값을 할당하세요.
 * 2-2 세개의 숫자중에 가장 작은 값을 찾아서 출력하는 코드를 삼항연산자를 사용하여 작성하라.
 * 
 * 문제3.
 * int temp = 10, temp2 = 20;의 변수를 선언하고 아래의 코드를 작성했을 때
 * 어떤 값이 출력되는지 예상해보고,어떻게 그러한 결과가 도출되었는지 주석을 열고 이유를 기술해.
 * System.out.println(++temp + temp2--); //이유작성
 * System.out.println("temp : " + temp + ", temp2 : " + temp2);
 * 
 *  문제4. Integer.MAX_VALUE constant를 사용하여 Integer의 하위 2byte 값이 
 *  출력되도록 비트논리 연산자를 사용하여 출력해보세요. (결과 65535가 나와야 한다.)
 *  *하위 2byte란, int는 4바이트니 바이트(0000 0000)가 4개. 
 *  하위 2바이트는그중 오른쪽 2개의 byte를 말함. 반대는 상위 2바이트.
 */
public class Exam0808 {

	public static void main(String[] args) {
		System.out.println("-------문제1-------");
		int num1 = Integer.parseInt(args[0]), num2 = Integer.parseInt(args[1]);
		int largeNum = (num1 > num2) ? num1 : num2;
		System.out.println("main method의 arguments " + num1 + "과 " + num2 + "중 더 큰 값은 : " + largeNum);
		
		System.out.println("-------문제2-------");
		int num3 = 5, num4 = 2, num5 = 3;
		int minimum = (num3 > num4 ) ? ((num4 > num5) ? num5 : num4) : ((num3 > num5) ? num5 : num3); 
		System.out.println("가장 작은 수 : " + minimum);
		
		System.out.println("-------문제3-------");
		int temp = 10, temp2 = 20;
		System.out.println(++temp + temp2--); //이유작성 -> ++temp + temp2-- => 이니깐 앞은 11, temp2는 계산 후 대입이니 아직 20임. -> 11+20 -> 31.
		System.out.println("temp : " + temp + ", temp2 : " + temp2); //계산이 끝났으므로 temp는 11, temp2는 19
		
		System.out.println("-------문제4-------");
		int num6 = Integer.MAX_VALUE;
		System.out.println(num6 & 65535);
				
		
	}

}

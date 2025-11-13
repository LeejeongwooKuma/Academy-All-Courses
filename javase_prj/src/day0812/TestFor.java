package day0812;

/**
 * 반복문( looping statement )<br>
 * for문 : 시작과 끝을 알 때 사용하는 반복문<br>
 * 문법)<br>
 * for( 초기값 ; 조건식 ; 증.감소식){<br>
 * 반복수행 문장들 <br>
 */
public class TestFor {

	public static void main(String[] args) {
		// 0에서 부터 9까지 1씩 증가하는 값을 출력하는 반복문
		for (int i = 0; i < 10; i = i + 1) {
			System.out.println(" i : " + i);
		} // end for
		
		//1에서 부터 100까지 1씩 증가하는 값을 옆으로 출력하는 반복문
//		System.out.print("i : ");
//		for (int i = 1; i < 101; i++) {
//			System.out.print(i + " ");
//		}// end for
		
		System.out.print("i : ");
		//1에서 부터 100까지 홀수 만 옆으로 출력하는 반복문
		int cnt = 0;
		for (int i = 1; i < 101 ; i+=2) {
			//if(i % 2 == 1) { //if 쓰면 100번 돌지만 +2하면 50번만 돌음.
			System.out.print(i + " ");
			//}//end if
			++cnt;
		}//end for
		System.out.println("\n" + cnt + "번 반복");
		
		System.out.print("i : ");
		//1에서 부터 100까지 짝수 만 옆으로 출력하는 반복문
				for (int i = 1; i < 101 ; i+=1) {
					if(i % 2 == 0) { 
					System.out.print(i + " ");
					}//end if
				}//end for
				
				System.out.println("새로운");
				//1에서부터 9까지 1씩 증가하는 반복문
				for (int i = 1; i < 10; i++) {
					System.out.println("2 x " + i + " = " + i * 2);
				} //end for
				
				//main method arguments로 구구단을 입력받아서
				//입력된 구구단이 2~9단 인 경우 해당 단의 구구단을 콘솔에 출력하는 코드
				//단, 2~9단이 아니면 "입력하신 단은 없습니다" (flow chart 그린 후)
				int multiplicationTable = 0;
				multiplicationTable = Integer.parseInt(args[0]);
				
				if (multiplicationTable > 1 && multiplicationTable < 10) {
					for (int i = 1; i < 10; i++) {
						System.out.println(multiplicationTable + " x " + i + " = " +
					multiplicationTable * i);
					}//end if
				}else {
					System.out.println("입력하신 단은 없습니다.");
				}//end else
				
				//1에서 부터 100까지 누적합 5050
				int sum = 0;
				
				for (int i = 1; i < 101; i++) {
					sum = sum + i;
				}
				System.out.println("누적 합 : " + sum);
				
				
	}// main

}// class

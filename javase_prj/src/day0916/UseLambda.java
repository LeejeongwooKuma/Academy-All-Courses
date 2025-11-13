package day0916;

import day0813.MethodType;
import day0901.StudentDTO;

import java.util.Random;

public class UseLambda {

	public UseLambda() {
//		반환형 없고, 매개변수 없는 method를 가진 interface 사용
		MethodType1 mt = () -> {
			Random ran = new Random();
			int num = ran.nextInt(10);
			System.out.println(num);
		};
//		 호출
		mt.typeA();
		System.out.println("--반환형 없고 매개변수 있는 형-----------------");
		// 데이터형부터 기술할때에는 매개변수명 달라도 된다.
		// 데이터형은 생략 가능하다.
//		MethodType mt2 = (StudentDTO s, String n) -> {
		MethodType2 mt2 = (s, n) -> {
			System.out.println("DTO객체 : " + s.getName() + "," + s.getAge());
			System.out.println("단일형 : " + n);
		};
		// 호출
		StudentDTO sDTO = new StudentDTO("신용권", 20);
		mt2.typeB(sDTO, "테스트");

		System.out.println("--반환형 있고 매개변수 없는 형-----------------");
		MethodType3 mt3 = () -> {
			StudentDTO sDTO2 = new StudentDTO("루피", 21);
			return sDTO2;
		};
		// 호출
		StudentDTO sDTO3 = mt3.typeC();
		System.out.println(sDTO3);
		System.out.println("--반환형 있고 매개변수 있는 형-----------------");

		MethodType4 mt4 = (double d) -> {
			return (int) d;
		};
		// 호출
		int i = mt4.typeD(2025.09);
		System.out.println(i);

		// Thread로 1~100까지 옆으로 출력하는 코드를 Lambda식으로 구현.
//		Runnable run = () -> {
//			for(int i2 = 0; i2 < 101; i2++) {
//				System.out.printf("%-4d",i2);
//			}//end for
//		
//		};
//		여러개의 Thread로 돌려야할 때
//		Thread t = new Thread(run);
//		t.start();
//		Thread t2 = new Thread(run);
//		t2.start();
		
		//Thread로 실행되어야 하는 횟수가 한번이면... run = 뒤 값을 그대로 매개변수로 넣어버림.
		Thread t = new Thread(() -> {
			for(int i2 = 0; i2 < 101; i2++) {
				System.out.printf("%-4d",i2);
			}//end for
			
		});
		t.start();
	//이렇게도 가능;;;
	System.out.println("\n----------------------");
	new Thread(() -> {
		for(int i2 = 0; i2 < 101; i2++) {
			System.out.printf("%-4d",i2);
		}//end for
	}).start();
		
	}// UseLambda

	public static void main(String[] args) {
		new UseLambda();
	}

}

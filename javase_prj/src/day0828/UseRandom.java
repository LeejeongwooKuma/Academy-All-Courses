package day0828;

import java.util.Random;

/**
 * 난수를 얻기 위한 클래스
 */
public class UseRandom {
	public UseRandom() {
		Random r = new Random();// 객체 생성 하면서 난수의 셋 생성
		Random r2 = new Random(2025L);// 시드 랜덤 셋을 생성
		
		System.out.println(r.nextInt());//다음 수 예측가능
		System.out.println(r2.nextInt());//다음 수 예측 불가능
		int i = r.nextInt(); 
		System.out.println("발생한 수 : " + i);
		//연산 해야하니 밑에 방법이 훨 간단.
		System.out.println("범위 수를 양수로 얻기 : " + Math.abs(i % 10));
		//연산 x
		int j = r.nextInt(10);
		System.out.println("범위 수 얻기 : " + j);
		
		//실수 난수
		double d = r.nextDouble();
		System.out.println("발생한 수 : " + d);
		System.out.println("발생한 수 > 범위 수 : " + d * 10);
		System.out.println("발생한 수 > 범위 수 > 정수: " + (int)(d * 10));// 굳이.. 위에 int 쓰는게 더 좋음
		
		//불린 난수
		boolean flag = r.nextBoolean();
		boolean flag2 = r.nextBoolean();
		System.out.println(flag);
		System.out.println(flag2);
		
		
		
	}// UseRandom

	public static void main(String[] args) {
		new UseRandom();
	}// class

}// main

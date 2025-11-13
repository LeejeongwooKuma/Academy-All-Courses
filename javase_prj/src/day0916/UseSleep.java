package day0916;

import java.util.Random;

/**
 * running ( CPU사용 ) <-> block ( CPU 비사용 ) method 사용
 */
public class UseSleep implements Runnable {

	@Override
	public void run() {
		//동시에 처리되어야하는 코드 작성.
		for(int i = 0; i < 15; i++) {
//			System.out.println("i=" + (i*2));
			System.out.print(".");
			try {
				Thread.sleep(1000 * new Random().nextInt(3)); //지정한 시간동안 block 상태로 이동
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}//end for
		System.out.println("finish");
	}//run

	public static void main(String[] args) {
		//Runnable을 구현한 클래스를 객체화
		UseSleep us = new UseSleep();
		//Thread와 has a 설정
		Thread t = new Thread(us);
		//Thread의 start()
		t.start();
		
	}//main

}//class

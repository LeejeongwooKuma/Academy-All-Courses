package day0916;

/**
 * Runnable 구현
 */
//1. Runnalbe interface를 구현
public class UseRunnable implements Runnable {

	// 2.run() override
	@Override
	public void run() {
		// 3. Thread로 동작해야 하는 코드를 정의
		for (int i = 0; i < 500; i++) {
			System.out.println("run method i ------>" + i);
		} // end for
	}// run

	public void work () {
		for (int i = 0; i < 50; i++) {
			System.out.println("work method i ===========>" + i);
		}//end for
		
	}//work
	
	public static void main(String[] args) {
		//4.Runnable을 구현한 클래스를 객체화
		UseRunnable ur = new UseRunnable();
		//5.Thread 클래스를 has a 관계로 생성
		Thread thread = new Thread(ur);//ur을 빼고 돌리면 Thread의 run을 불러오는데 거기의 run엔 아무값도 없음.
		//6. Thread클래스의 객체에서 제공하는 start() 호출
		thread.start(); //start() -> has a 관계의 객체가 구현한 run()호출
		ur.work();
	}// class

}// main

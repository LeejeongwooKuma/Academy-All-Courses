package day0916;

/**
 * Thread를 상속받아서 사용하는 클래스.
 */
//1.Thread를 상속받는다.
public class UseThread extends Thread {

	// 2.run method를 Override
	@Override
	public void run() {
		// 3. Thread로 동작해야 하는 코드를 정의
		for (int i = 0; i < 500; i++) {
			System.out.println("run method i ------>" + i);
		}//end for
	}// run

	public void work () {
		for (int i = 0; i < 10; i++) {
			System.out.println("work method i ===========>" + i);
		}//end for
		
	}//end work
	public static void main(String[] args) {
		//4.자식클래스 객체화 (부모클래스부터 생성 > 자식은 부모의 자원을 사용할 수 있다.
		UseThread ut = new UseThread();
		//5. start()를 초훌하여 Thread로 코드가 실행되도록 한다.
		long st = System.currentTimeMillis();
		ut.start(); //??? 이게 thread로 호출해서 start하니 run이 튀어나옴(CPU Scheduling영향)
//		ut.run(); //run + work하면 우리가 알고 있는 run 끝내고 work불러오는 방식.
		ut.work();//실행할때마다 결과가 다른데, 서로 불규칙하게 번갈아서 실행됨
		long et = System.currentTimeMillis();
		System.out.println(et-st + "ms");//여러번 출력해보면 해당 syso이 중간에서 실행됨. ->끝나는 시간 찾기가 불가능. 랜덤;;
		
	}// main

}// class

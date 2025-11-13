package day1013;

/**
 * 실행중인 JVM에서 객체를 하나로 만들고 사용할 목적의 클래스.
 */
public class Singleton {
	private static Singleton single;

	/**
	 * 생성자의 접근 지정자를 private으로 설정.
	 */
	private Singleton() {

	}// Singleton

	/**
	 * 객체를 반환하는 일
	 * 
	 * @return 생성된 객체
	 */
	public static Singleton getInstance() {
		if (single == null) { // 객체가 생성되어 있지 않다면
			single = new Singleton(); //객체를 생성한다.
		}
		return single;
	}

}// class

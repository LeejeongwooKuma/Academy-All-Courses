package day0908;

/**
 * 사용자 정의 예외처리 클래스<br>
 * 내가 구현하는 업무가 java에서 제공하는 예외처리클래스와 유사한 이름이 없을 때<br>
 * 의미전달이 되지 않는다. => 내가 구현하는 업무와 맞는 예외처리클래스를 만들어서 사용한다.
 */
public class TabaccoException extends Exception{
	
	public TabaccoException() {
		this("흡연은 건강에 좋지 않습니다.");
	}//TabaccoException

	public TabaccoException(String msg) {
		super(msg);
	}//TabaccoException
	
}//class

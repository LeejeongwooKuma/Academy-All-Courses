package day0814;

/**
 * 마카펜을 객체모델링(추상화)하여 구현한 클래스.<br>
 * 명사적특징 : 뚜껑, 몸체, 색<br>
 * 동사적특징 : 쓰는일<br>
 * 일반 클래스로 객체화를 하여 사용한다.<br>
 * 객체 생성법)<br>
 *  MarkerPen 객체명 = new MarkerPen();
 */
public class MarkerPen {
	
	private int cap;
	private int body;
	private String color;
	
	//기본생성자 : 뚜껑 1개, 몸체 1개, 검은색
	public MarkerPen() {
		this(1, 1, "검은");
	}
	
	//매개변수 있는 생성자 정의( 뚜껑, 몸체, 색을 받는 일 ) 
	public MarkerPen(int cap, int body, String color) {
		//setter 쓰는 이유는 유효성검사 때메. 밑에 setter에 유효성 검사 있으니 굳이 2번 
		//안 할려고 this로 안 함.
		setCap(cap);
		setBody(body);
		setColor(color);
	}
	
	/**
	 * 생성된 마카펜 객체에 뚜껑의 수를 설정하는 일.
	 * @param cap 설정할 뚜껑의 수
	 */
	public void setCap(int cap) {
		if (cap > 10) {
			cap = 10;
		}
		this.cap = cap;
	}//setCap
	
	/**
	 * 생성된 마카펜 객체에 몸체의 수를 설정하는 일
	 * @param body 설정할 몸체의 수
	 */
	public void setBody( int body ) {
		this.body = body;
	}//setBody

	/**
	 * 생성된 마카펜 객체에 색을 설정하는 일<br>
	 * 색은 검은, 파란, 빨간색으로만 설정 가능하고, 다른 값이 입력되면 검은색으로 설정된다.
	 * @param color 설정할 색. 검은, 파란, 빨간 으로만 입력.
	 */
	public void setColor( String color ) {
		//유효성 검증. 마카펜은 검은, 파란, 빨간 으로만 설정할 수 있다.
		if(!(color.equals("검은") || color.equals("파란") || color.equals("빨간"))) { 
			color = "검은";
		}//end if
		this.color = color;
	}//setColor
	
	/**
	 * 생성된 마카펜 객체의 설정된 뚜껑 개수를 반환하는 일. 
	 * @return 뚜껑의 수
	 */
	public int getCap() {
		return cap;
	}//getCap
	
	/**
	 * 생성된 마카펜 객체의 몸체 개수를 반환하는 일
	 * @return 몸체의 개수
	 */
	public int getBody() {
		return body;
	}//getBody
	
	/**
	 * 생성된 마카펜 객체의 설정된 색을 반환하는 일
	 * @return 색
	 */
	public String getColor() {
		return color;
	}//getColor
	
	
	/**
	 * 마카펜의 동사적인 특징인 쓰는일을 구현한 method<br>
	 * 입력받은 메시지를 칠판에 쓰는 일.
	 * @param msg 칠판에 쓸 메시지
	 * @return 쓰는 행동.
	 */
	public String write(String msg) {
		return color + "색인 마카펜으로 칠판에 \"" + msg + "\"를 쓴다.";
	}//write
}//class

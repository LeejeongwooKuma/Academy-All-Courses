package day0811;

/**
 * switch~case : 일치하는 정수를 비교하기 위해 만들어진 조건문<br>
 * 
 * 문법)<br>
 * 	switch( 정수를 저장한 변수명 or 문자열) {<br>
 * 	case 상수 : 수행될 문장들...<br>
 *  case 상수 : 수행될 문장들...<br>
 *  case 상수 : 수행될 문장들...<br>
 * 	default : 일치하는 상수가 없을 때 수행될 문장들...;<br>
 * }
 */
public class TestSwichCase {
	public static final int ADD_EMP = 0;
	public static final int MODIFY_EMP = 1;
	public static final int SEARCH_EMP = 2;
	public static void main(String[] args) {
		
//		char i = 'B';
//		switch ( i ) { 
//		//case 128 : System.out.println("영");//swicth문의 변수가 byte인데 128은 byte 범위를 벗어나서 아예 에러가 나옴.
//		case 66 : System.out.println("영");
//		case 1 : System.out.println("일");
//		case 2 : System.out.println("이");
//		default : System.out.println("해당 case 없음");
//		}//end switch
		
		//JDK 1.7에서부터는 switch가 문자열을 비교할 수 있게 기능이 추가됨.
		String i = "자바";
		switch ( i ) { 
		//case 128 : System.out.println("영");//swicth문의 변수가 byte인데 128은 byte 범위를 벗어나서 아예 에러가 나옴.
		case "자바" : System.out.println("영");
		case "C" : System.out.println("일"); break;
		case "PyThon" : System.out.println("이");
		default : System.out.println("해당 case 없음");
		}//end switch
		
		//break를 사용한 switch~case 빠져 나가기
		int ind = 2;
		switch ( ind ) { //0, 1,2는 가독성이 떨어져서 constatnts를 써서 가독성 올림
		case ADD_EMP: add(); break;
		case MODIFY_EMP: modify(); break;
		case SEARCH_EMP: serch(); break;
		default : System.out.println("해당 case 없음");
		}//end switch
		
	}//main
	public static void add() {
		System.out.println("추가");
	}
	public static void modify() {
		System.out.println("변경");
	}
	public static void serch() {
		System.out.println("검색");
	}
}//class

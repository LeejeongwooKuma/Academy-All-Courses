package day0826;

//각각 클래스나 인터페이스를 import 할 수 있다.
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
//패키지명은 다른데 클래스나 인터페이스 이름이 같다면 둘 다 import는 불가능 -> 이럴땐 full path 사용.
//import java.sql.Date;
//이렇게 하면 편하긴 한데 속도가 느려져서 잘 안 씀
//import java.util.*;


public class UseImport {

	public static void main(String[] args) {
		Date d = new Date();// util패키지의 Date클래스
		//import할 클래스의 이름이 같고 패키지가 다르면 둘 중 하나는 import로
		//하나는 full path를 설정하여 클래스를 사용한다.
		java.sql.Date d2 = new java.sql.Date(1L); // sql패키지의 Date클래스. full path 방식
		
		List l = new ArrayList(); //is a 관계의 객체화
		
	}//main

}//class

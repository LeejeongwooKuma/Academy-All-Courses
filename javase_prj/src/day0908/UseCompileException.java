package day0908;

import java.util.Random;

/**
 * 실행시에 외부 클래스를 로딩하여 실행하고 싶다.
 */
public class UseCompileException {
	public static void main(String[] args) {
		try {
			String className = "java.lang.String";
			if (new Random().nextBoolean()) {
				className = "java.lang.String2";
			} // end if

			Class loadObj = Class.forName(className);// 코드상 error가 발생해서 누락 하고 싶어도 못 함.
			System.out.println("로딩한 객체 : " + loadObj);
		} catch (ClassNotFoundException cnfe) {
			// TODO Auto-generated catch block
			cnfe.printStackTrace();
		} catch (Exception e) {
			System.out.println("개발자가 인식하지 못한 예외");
			e.printStackTrace();
		} // end catch
	}// main

}// class

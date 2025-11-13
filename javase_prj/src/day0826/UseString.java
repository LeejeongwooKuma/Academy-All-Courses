package day0826;

/**
 * 긴 문자열을 다루는 클래스 사용. (StringBuffer - 속도가 느림, StringBuilder - 속도가 빠름)
 */
public class UseString {

	public void useStringBuffer() {
		// Overloading 된 생성자를 사용하여 여러 방식으로 객체 생성해보기
		// 1.클래스로부터 객체 생성
		StringBuffer sb = new StringBuffer(); // 기본 16개의 문자를 저장하는 생성자를 사용해서 객체 생성
		StringBuffer sb2 = new StringBuffer(20);// 20개의 문자열을 저장하는 생성자를 사용하여 객체 생성
		StringBuffer sb3 = new StringBuffer("오늘은 입니다.");// 오늘은 입니다 문자열 저장하는 생성자를 사용하여 객체 생성

		System.out.println(sb);
		System.out.println(sb2);
		System.out.println(sb3); // 주소가 아니라 문자열이 나옴. -> StringBuffer에서 toString을 오버라이딩 해놔서 그럼

		// 2. 클래스에서 제공하는 기능(일, method) 사용.
		// ------------------값 붙이기-------------------
		int day = 25;
//		sb.append(day); //붙여지는 값은 문자열로 붙는다.

		double weight = 8.26;
//		sb.append(weight);

		boolean flag = false;
//		sb.append(flag);

		char c = 'A';
//		sb.append(c);

		String str = "안녕 하세요? 오늘은 화요일입니다.";
//		sb.append(str);

		// append의 반환형은 객체(StringBuilder)임. 그렇기에 메소드 체인 사용 가능
		sb.append(day).append(weight).append(flag).append(c).append(str);
		System.out.println(sb + " / " + sb.capacity() + " / " + sb.length());

		// ---------------특정 위치에 값 넣기-------------
		//sb3 insert -> 오늘은 x요일 입니다.
		sb3.insert(4, "화요일");
		System.out.println(sb3);
		sb3.insert(4, 26);
		System.out.println(sb3);
		
		
		//----------------특정 위치에 값 삭제-----------------
		sb3.delete(4, 9);//끝 인덱스에 해당하는 문자열은 삭제하지 않는다.
		System.out.println(sb3);
		
		
		//---------------문자열 뒤집기---------------------
		sb3.reverse().reverse();
		System.out.println(sb3);
		
	}// useStringBuffer

	public void useStringBuilder() {//buffer꺼 그대로 복붙 가능

		// Overloading 된 생성자를 사용하여 여러 방식으로 객체 생성해보기
		// 1.클래스로부터 객체 생성
		StringBuffer sb = new StringBuffer(); // 기본 16개의 문자를 저장하는 생성자를 사용해서 객체 생성
		StringBuffer sb2 = new StringBuffer(20);// 20개의 문자열을 저장하는 생성자를 사용하여 객체 생성
		StringBuffer sb3 = new StringBuffer("hello");// 오늘은 입니다 문자열 저장하는 생성자를 사용하여 객체 생성

		System.out.println(sb);
		System.out.println(sb2);
		System.out.println(sb3); // 주소가 아니라 문자열이 나옴. -> StringBuffer에서 toString을 오버라이딩 해놔서 그럼

		// 2. 클래스에서 제공하는 기능(일, method) 사용.
		// ------------------값 붙이기-------------------
		int day = 25;
//		sb.append(day); //붙여지는 값은 문자열로 붙는다.

		double weight = 8.26;
//		sb.append(weight);

		boolean flag = false;
//		sb.append(flag);

		char c = 'A';
//		sb.append(c);

		String str = "안녕 하세요? 오늘은 화요일입니다.";
//		sb.append(str);

		// append의 반환형은 객체(StringBuilder)임. 그렇기에 메소드 체인 사용 가능
		sb.append(day).append(weight).append(flag).append(c).append(str);
		System.out.println(sb + " / " + sb.capacity() + " / " + sb.length());

		// ---------------특정 위치에 값 넣기-------------
		//sb3 insert -> 오늘은 x요일 입니다.
		sb3.insert(4, "화요일");
		System.out.println(sb3);
		sb3.insert(4, 26);
		System.out.println(sb3);
		
		
		//----------------특정 위치에 값 삭제-----------------
		sb3.delete(4, 9);//끝 인덱스에 해당하는 문자열은 삭제하지 않는다.
		System.out.println(sb3);
		
		
		//---------------문자열 뒤집기---------------------
		sb3.reverse().reverse();
		System.out.println(sb3);
		
		
		
	}// useStringBuffer

	public static void main(String[] args) {
		UseString us = new UseString();
		System.out.println("----------StringBuffer-----------");
		us.useStringBuffer();
		System.out.println("----------StringBuilder-----------");
		us.useStringBuilder();

	}// main

}// class

package day0819;

/**
 * 문자열( String )의 시작 주소를 저장할 수 있는 데이터 형인 java.lang.String 클래스 사용.<br>
 * 문자열은 문자열 저장소(String literal)에 유일하게 저장된다.
 */
public class UseString {

	public void useString() {
		// 기본형 형식 사용. String str = "문자열";
		String str = "abc";
		// 참조형 형식 사용. String str = new String("문자열");
		String str2 = new String("abc");

		// 관계연산자 ==을 사용하여 비교하면 기본형과 참조형이 다른 결과가 나온다.
		System.out.println("기본형 형식 == " + str + " / " + (str == "abc")); // str은 String literal의 주소 저장 중
		System.out.println("참조형 형식 == " + str + " / " + (str2 == "abc"));// str2는 heap의 주소를 저장 중이라 다름

		// equals method를 사용하면 기본형이든 참조형이든 같은 결과가 나온다.
		System.out.println("기본형 형식 == " + str + " / " + (str.equals("abc"))); // str은 String literal의 주소 저장 중
		System.out.println("참조형 형식 == " + str + " / " + (str2.equals("abc")));// str2는 heap의 주소를 저장 중이라 다름

		String temp = "abcDeFg";
		String email = new String("tkd@naver.com");
		System.out.println(temp);
		System.out.println(email);

		System.out.println("\"안녕하세요?\"의 글자수 : " + "+ 안녕하세요?".length());
		System.out.println(temp + " 의 글자수 : " + temp.length());
		System.out.println(email + " 의 글자수 : " + email.length());

		System.out.println(temp + "를 모두 대문자로 " + temp.toUpperCase());
		System.out.println(temp + "를 모두 소문자로 " + temp.toLowerCase());

		System.out.println(temp + "에서 3번째 인덱스에 해당하는 문자 : " + temp.charAt(1));

		// temp : abcDeFg
		System.out.println(temp + "에서 \"e\"에 해당하는 인덱스 " + temp.indexOf("e")); // 4
		System.out.println(temp + "에서 \"DeF\"에 해당하는 인덱스 " + temp.indexOf("DeF")); // 3
		System.out.println(temp + "에서 \"k\"에 해당하는 인덱스 " + temp.indexOf("k")); // -1

		temp = "java oracle";
		// 012345678910
		System.out.println(temp + "에서 뒤에서부터 \"a\"에 해당하는 인덱스 " + temp.lastIndexOf("a")); // 4

		temp = "반장 박상현님!";
		// 012345678 < String index
		// 가장 마지막 문자에 끝문자가 덮어 써진다. 그래서 끝인덱스 + 1 해줘여함.
		System.out.println(temp + "에서 3~5번째 인덱스에 해당하는 하위문자열 " + temp.substring(3, 6));

		// String email = new String("tkd@naver.com"); @전은 이메일 @후에는 도메인
		System.out.println("이메일 주소 : " + email.substring(0, (email.indexOf("@"))));
		// substring은 시작인데스만 설정하면 문자열의 끝까지 잘라낸다.
		System.out.println("도메인 주소 : " + email.substring(email.indexOf("@") + 1));

		temp = ""; // 문자열의 초기화 (empty로 초기화)
		System.out.println("[" + temp + "] 는 비어있니? " + (temp.length() == 0));// 이 방법도 가능하지만 밑에 메소드가 편함
		System.out.println("[" + temp + "] 는 비어있니? " + (temp.isEmpty()));

		temp = null; // 문자열 초기화 ( null로 초기화 )
		System.out.println("[" + temp + "] 는 객체로 생성되지 않았니? " + (temp == null));

		temp = "   A  BC   ";
		System.out.println("[" + temp + "] 의 앞,뒤 공백 제거 [" + temp.trim() + "]");

		temp = "abc";
		System.out.println(temp + "가 \"abc\"와 같니? [" + temp.equals("abc") + "]");
		System.out.println(temp + "가 \"abc\"와 같니? [" + temp.equals("abcd") + "]");

		temp = "서울시 강남구 역삼동";
		String temp2 = "서울시 동대문구 동대문동";
		String temp3 = "인천시 계양구 계양동";
		System.out.println(temp + "는 서울인가?" + temp.startsWith("서울시"));
		System.out.println(temp2 + "는 서울인가?" + temp2.startsWith("서울시"));
		System.out.println(temp3 + "는 서울인가?" + temp3.startsWith("서울시"));

		temp3 = "인천시 계양구 계양리";
		System.out.println(temp + "는 동인가?" + temp.endsWith("동"));
		System.out.println(temp2 + "는 동인가?" + temp2.endsWith("동"));
		System.out.println(temp3 + "는 동인가?" + temp3.endsWith("동"));

		temp3 = "인천시 강남구 계양동";
		System.out.println(temp + "는 \"강남구\"를 포함하고 있는가?" + temp.contains("강남구"));
		System.out.println(temp2 + "는 \"강남구\"를 포함하고 있는가?" + temp2.contains("강남구"));
		System.out.println(temp3 + "는 \"강남구\"를 포함하고 있는가?" + temp3.contains("강남구"));

		// contains 사용해서 특정 단어 거르기
		temp = "나 지금 피씨방이야 넌 어디니 씨방새야";
		if (temp.contains("씨방새")) {
			temp = "고운말 쓰시오";
		}
		System.out.println(temp);

		// replace
		temp = "Java Oracle";
		System.out.println(temp + "에서 'a'를 'A'로 변경 " + temp.replace("a", "AAA"));// 정규식 사용 불가
		System.out.println(temp + "에서 'a'를 'A'로 변경 " + temp.replaceAll("a", "AAA"));// 정규식 사용 가능

		temp = "   Java Oracle   ";
		System.out.println("[" + temp + "]에서 모든 공백 제거[" + temp.replaceAll(" ", "") + "]");

		temp = "나 지금 피씨방이야 넌 어디니 씨방새야"; // 씨 방 새 이러면 못 거르니 여러번 필터링함
		temp = temp.replaceAll("씨", "*").replaceAll("방", "*").replace("새", "*");// 메소드 연속 사용 가능한 이유 : 앞의 replaceAll이 결국
																				// String이기에 String.메소드가 되버림...메소드 체인
		System.out.println(temp);

		temp = "오늘은";
		temp2 = "화요일 입니다.";

//		temp3 = temp + temp2;//이렇게 해도 됨
		temp3 = temp.concat(temp2);
		System.out.println(temp3);

		int year = 2025;
		int month = 8;
		int day = 19;


		String name = "신용권";
		double height = 176.3;
		String msg = String.format("오늘은 %d년 %d월 %d일 입니다. 내 이름은 %s입니다.키는 %.1f", 
				year, month, day, name, height); // format은 static메소드이기에 객체화 없이 바로 String으로
		System.out.println(msg);
		
		 temp = String.valueOf(year);
		 System.out.println(temp);
	}// useString

	/**
	 * 입력되는 email의 유효성 검증을 수행하고 유효하면 true반환, 무효하면 false 반환하는 일을 하는 코드로 작성<br>
	 * 유효성 : 이메일의 길이는 5자 이상 이어야 하고, 이메일에 "@", "."이 포함되어있어야한다. "@"먼저 나와야 하고, "."은 나중에
	 * 나와야한다. 만족 true, 불만족 false 반환
	 * 
	 * @param email 유효성검증할 이메일
	 * @return 결과
	 */
	public boolean validateEmail(String email) {
		// 이 방법도 가능...변수 쓰면 더 깔금
//		int atInd = email.indexOf("@");
//		int dotInd = email.indexOf(".");
//		return email.length() > 5 && email.indexOf("@") != -1 && 
//				email.indexOf(".") != -1 && (email.indexOf("@") < email.indexOf("."));
//		
		if (email.length() > 5) {
			if (email.indexOf("@") != -1 && email.indexOf(".") != -1) {
				if (email.indexOf("@") < email.indexOf(".")) {
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		UseString us = new UseString();
		us.useString(); // 이렇게 써도 되지만 차피 메소드가 1개 뿐이라 밑에처럼 하면 편함. 2개 이상이면 위 방식으로 하는게 나음
//		new UseString().useString();//객체화 후 method 하나 호출
		System.out.println("-------------------------");
		String temp = "test@test.com";
		String temp2 = "testtest.com";
		String temp3 = "test@testcom";
		String temp4 = "a@b.c";
		String temp5 = "test.test@com";
		// validateEmail을 호출하여 위에 이메일로 테스트 수행.
		System.out.println(temp + " / " + us.validateEmail(temp));
		System.out.println(temp2 + " / " + us.validateEmail(temp2));
		System.out.println(temp3 + " / " + us.validateEmail(temp3));
		System.out.println(temp4 + " / " + us.validateEmail(temp4));
		System.out.println(temp5 + " / " + us.validateEmail(temp5));
	}// main

}// class

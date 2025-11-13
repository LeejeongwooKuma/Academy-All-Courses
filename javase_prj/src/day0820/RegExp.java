package day0820;

/**
 * 정규식의 사용
 */
public class RegExp {
	public RegExp() {
		String msg = "hell!자바 내 전화번호는 010-1234-5678이고, 내 나이는 25살, 우리집 번지는 20-1번지";
		msg +="\n친구의 전화번호 010-4321-9876 입니다.";
		System.out.println("원본문자열 " + msg);
		
		System.out.println(msg.replaceAll("(\\d{3})-(\\d{4})-(\\d{4})", "xxx-xxxx-xxxx"));
		//특정 그룹의 값을 노출 $그룹번호  -> ()가 그룹 단위. 앞에부터 1...2....3...
		System.out.println(msg.replaceAll("(\\d{3})-(\\d{4})-(\\d{4})", "$1-xxxx-$3"));
		//010-x234-5678 해보기
		System.out.println(msg.replaceAll("(\\d{3})-(\\d{1})(\\d{3}-\\d{4})", "$1-x$3"));
		//010-4321-x876
		System.out.println(msg.replaceAll("(\\d{3})-(\\d{4})-(\\d{1})", "$1-$2-x"));

		//긍정형 전방탐색(패턴)(?=문자열)
		System.out.println(msg.replaceAll("(\\d{2})(?=살)", "x"));
		System.out.println(msg.replaceAll("(\\d{2}-\\d{1})(?=번지)", "x"));
 
		//긍정형 후방탐색(?<=문자열)(패턴)
		System.out.println(msg.replaceAll("(?<=나이는 )(\\d{2})", "x"));//x살
		//전방,후방 탐색을 같이 사용하면 정교한 매칭이 가능해진다
		System.out.println(msg.replaceAll("(?<=나이는 )(\\d{2})", "x"));//x살
		
		msg="hello-HELLO-12e3456-자바 ㄱ 힣";
		System.out.println(msg);
		System.out.println(msg.replaceAll("[he]", ""));//각각의 글자의 패턴매칭..h랑 e 전부 날려버림.
		System.out.println(msg.replaceAll("[a-z]", ""));//범위 : 시작문자-끝문자
		System.out.println(msg.replaceAll("[A-Z]", ""));//범위 : 시작문자-끝문자
		System.out.println(msg.replaceAll("[0-9]", ""));//범위 : 시작문자-끝문자
		System.out.println(msg.replaceAll("[ㄱ-힣]", ""));//범위 : 시작문자-끝문자
		System.out.println(msg.replaceAll("[a-zA-Z0-9ㄱ-힣]", ""));//범위 : 시작문자-끝문자
		System.out.println(msg.replaceAll("[a-zA-Z0-9ㄱ-힣-]", ""));//범위 : 시작문자-끝문자

		msg = "안녕 29a 30b 20A 오늘은 20일 201z 3005c";
		System.out.println(msg.replaceAll("(\\d{2,})(?=[a-zA-Zㄱ-힣])", "x"));
		
		msg = "안녕 hello 오늘은 hell 내일은 heloo";
		System.out.println(msg);
		System.out.println(msg.replaceAll("\\bhello\\b", ""));//단어의 경계
		
		msg = "hello 내 이메을은 test@sist.com입니다.";
		System.out.println(msg);
		System.out.println(msg.replaceAll("\\b[A-Za-z0-9%_+-]+@", "")); //+는 한 글자 이상
		System.out.println(msg.replaceAll("\\b[A-Za-z0-9%_+-]+@[A-Za-z0-9._]+\\.[A-Za-z]{2,}", "xxx@xxx.xxx")); //
		
		
	}//RegExp
	
	public static void main(String[] args) {
		new RegExp();
		
	}

}

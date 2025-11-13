package day0814;

/**
 * 특수문자 : 문자열 안에서 사용하는 기능을 가진 문자
 */
public class UseEscapeCharacter {

	public static void main(String[] args) {
		//콘솔에 안녕하세요? 를 출력
		System.out.println("안녕하세요?");
		System.out.println("'안녕하세요?'");
		System.out.println( "\"안녕하세요?\""); // "" 출력하는 방법. \뒤에는 문자로 인식
		
//		System.out.println("c:\dev\env.bat"); 경로 표시할 때도 \쓰는데 그냥은 못 씀
		System.out.println("안녕\n하세요?");
		System.out.println("안녕\r하세요?"); //원래는 커서를 앞으로 땡기는데 windows에서 직접 쓰면 줄 바꿈;
		System.out.println("안녕\'하\'세요?");
		System.out.println("안녕\"하\"세요?");
		System.out.println("c:\\dev\\text.txt"); // \들어간 경로 쓸 때..
		System.out.println("오늘은\t목요일\t입니다."); 
		System.out.println("a\b");//a가 지워져야하는데 안 지워짐..작동 안 함;;윈도우는 안됨
	}// main

}// class
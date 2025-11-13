package day0826;

//다른 패키지의 클래스를 참조하여 사용할 때 import
import java.util.StringTokenizer;
//다른 클래스의 static 변수( constant ), method를 직접 사용 할 때는 static import

public class UseStringTokenizer {

	public void UseStringTokenizer() {
		String data = "자바 오라클 JDBC HTML CSS JavaScript";

		// 1.생성
		// 대상 문자열을 공백으로 토큰을 구분하는 객체화
		StringTokenizer stk = new StringTokenizer(data);
//		System.out.println(stk);//toString을 오버라이딩 안 해놔서..부모만 있어서.. 주소 나옴

		// 2.일 사용
		System.out.println("토큰의 수 " + stk.countTokens());
//		System.out.println(stk.hasMoreTokens());
//		System.out.println(stk.nextToken());
//		System.out.println("토큰의 수 " + stk.countTokens());//nextToken으로 꺼내 쓸때마다 하나씩 줄음
//		System.out.println(stk.hasMoreTokens());
//		System.out.println(stk.nextToken());
//		System.out.println(stk.hasMoreTokens());
//		System.out.println(stk.nextToken());
//		System.out.println(stk.hasMoreTokens());
//		System.out.println(stk.nextToken());
//		System.out.println(stk.hasMoreTokens());
//		System.out.println(stk.nextToken());
//		System.out.println(stk.hasMoreTokens());
//		System.out.println(stk.nextToken());
//		System.out.println(stk.hasMoreTokens());//토큰 소진. false
//		System.out.println(stk.nextToken());//토큰 없는 상태에서 nextToken => error

		// 이렇게 길게 노가다 할 짓 못 되니 반복문 ㄱㄱ
		while (stk.hasMoreElements()) {// 토큰이 존재한다면
			System.out.println(stk.nextToken());// 토큰을 가져오고, 포인터를 다음으로 이동
		} // end while

	}// UseStringTokenizer

	public void UseStringTokenizer2() {
		String data = "Java SE,Oracle DBMS,JDBC,HTML.CSS.JavaScript,Java EE,XML,JSON";
		// ,를 구분 문자열( delims )로 토큰을 생성하는 생성자. 기준문자열은 or기능을 가지므로 여러 문자를 넣으면 모든 문자를 다 토큰으로
		// 구분한다.
//			StringTokenizer stk =new StringTokenizer(data, ",.J E");
		// delims도 토큰에 포함
		StringTokenizer stk = new StringTokenizer(data, ",.J E", true);

		System.out.println(stk.countTokens());
		String token = "";
		while (stk.hasMoreTokens()) {// 토큰이 존재하면
			token = stk.nextToken(); // 토큰을 잘라내고, 포인터를 다음으로 이동시킨다.
			System.out.println(token);
		} // UseStringTokenizer2

		
		
		
	}// UseStringTokenizer2
	
	//	String data = 
	//			"서울시 강남구 역삼동,서울시 동대문구 동대문동,인천시 부평구 부평동.개포동 강남구 서울시~서초구 서울시 서초동 서울시";
	//	위 데이터를 String 배열로 만들어서 반환하는 일을 하는 method를 작성하고 
	//	호출하는 곳에서 배열을 받아서 모든 방의 값을 출력하고 서울시의 개수를 출력하는 일.
	
	//메소드 2개 1. 배열로 반환하는 일, 2. 배열의 값과 서울시의 개수를 출력하는 일
	//main method에서 2번 method를 호출해서 출력.
	
	public String[] addressProcess2() { //내가 한거
		String data = "서울시 강남구 역삼동,서울시 동대문구 동대문동,인천시 부평구 부평동.개포동 강남구 서울시~서초구 서울시 서초동 서울시"; 
		StringTokenizer stk = new StringTokenizer(data, ",.~");
		String[] strArr = new String[stk.countTokens()];
		int i = 0;
		while(stk.hasMoreTokens()) {
			strArr[i] = stk.nextToken();
			i++;
		}
		
		return strArr;
	}
	
	public String[] addressProcess() {//강사분이 한 거
		String[] addArr = null;
		String data = "서울시 강남구 역삼동,서울시 동대문구 동대문동,인천시 부평구 부평동.개포동 강남구 서울시~서초구 서울시 서초동 서울시";
		
		//data를 token으로 생성
		StringTokenizer stk = new StringTokenizer(data, ",.~");
		
		//토큰의 개수로 배열을 생성
		addArr = new String[ stk.countTokens() ];
		
		//배열의 각 방에 token을 저장
		int i = 0;
		while (stk.hasMoreTokens()) {//토큰이 존재하면
			addArr[i] = stk.nextToken();//토큰을 얻고 포인터를 당므으로 이동
			i++;
		}

		return addArr;
	}//addressProcess
	
	public void printAddr(String[] addrArr) {
		int seoulCnt = 0;
		for(String addr : addrArr) {
			if(addr.contains("서울시")) {
				seoulCnt++;
			}
			System.out.println(addr);
		}//end for
		System.out.printf("데이터 중 서울시는 [%d]개", seoulCnt);
	}//end printAddr
	
	public static void main(String[] args) {

		UseStringTokenizer ust = new UseStringTokenizer();
		ust.UseStringTokenizer();
		System.out.println("-----------------------------");
		ust.UseStringTokenizer2();
		System.out.println("-----------------------------");
		String[] addr = ust.addressProcess2(); //업무처리
		ust.printAddr(addr);//업무처리결과를 출력
		

	}// main

}// class

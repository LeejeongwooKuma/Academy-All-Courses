package day0814;

/**
 * 마카팬 클래스를 객체화하여 사용하는 클래스 
 */
public class UseMarkerPen {
	/**
	 * 마카펜을 사용하는 method
	 */
	private void useMarker() {
		//검은색 마카펜 생성
		MarkerPen black = new MarkerPen();
        //black.color = "검은" //instance variable의 접근지정자가 private이므로 외부에서 직접 접근 불가능
		//대신 setter method를 사용하여 외부에 값을 instance variable에 설정할 수 있다.
		//setter method를 호출하여 생성된 마카펜에 값을 설정한다.
//		black.setColor("검은");
//		black.setCap(1);
//		black.setBody(1);
		System.out.printf("마카펜 정보 : 색 : %s색, 뚜껑 : %d개, 몸체 : %d개\n", black.getColor(), black.getCap(), black.getBody());
		//검은색 마카펜 사용
		System.out.println(black.write("안녕 자바!"));
		
		
		MarkerPen blue = new MarkerPen(1, 3, "파란");
//		blue.setColor("파란");
//		blue.setCap(1003);
//		blue.setBody(1);
		System.out.printf("마카펜 정보 : 색 : %s색, 뚜껑 : %d개, 몸체 : %d개\n", blue.getColor(), blue.getCap(), blue.getBody());
		System.out.println( blue.write("쉬었다가 하시겠습니다."));
	}//useMarker
	
	public static void main(String[] args) {
		UseMarkerPen ump = new UseMarkerPen();
		ump.useMarker();
	}//main

}//class

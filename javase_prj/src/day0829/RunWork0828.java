package day0829;

/**
 * 생성된 달력을 사용하는 클래스 
 */
public class RunWork0828 {
	private Work0828 work;
	public RunWork0828() {
		work = new Work0828();
	}
	/**
	 * 달력객체 사용
	 */
	private void useCreateCalendar() {
		System.out.println( work.createCalendar(null, null));//현재 년, 월
		System.out.println("----------------------------------------------");
		System.out.println( work.createCalendar("", ""));//현재년도, 월
		System.out.println("----------------------------------------------");
		System.out.println( work.createCalendar("2025", "8"));
		System.out.println("----------------------------------------------");
		System.out.println( work.createCalendar("2026", "9"));
	}//useCreateCalendar
	
	public static void main(String[] args) {
		new RunWork0828().useCreateCalendar();
	}//main

}//class

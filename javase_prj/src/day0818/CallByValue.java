package day0818;

/**
 * method의 매개변수가 기본형 데이터형을 parameter로 정의하면 값은 복사되어 전달된다. 
 */
public class CallByValue {
	
	/**
	 * 매개변수로 입력된 값을 변경하는 일
	 * @param i
	 * @param j
	 */
	public void swap( int i, int j ) {
		int temp = 0;
		temp = i;
		i = j; 
		j = temp;
		System.out.println("swap method 안 i = " + i + ", j = " + j);
	}//swap
	
	public static void main(String[] args) {
		CallByValue cbv = new CallByValue();
		int i = 2025;
		int j = 8;
		System.out.println("swap method 호출 전 i = " + i + ", j = " + j); // i = 2025, j = 8
		cbv.swap(i, j);
		//swap메소드를 하면 값이 바껴야하는데 method의 매개변수가 기본형 데이터형을 parameter로
		//정의하면 값은 복사되기에 원본 값은 그대로 유지됨. swap의 값은 복사된 값임. 밑에서 부르는 
		//i, j는 원본 값을 물어보는 거
		System.out.println("swap method 호출 후 i = " + i + ", j = " + j); // i = 8, j = 2025
	}//class

}//main

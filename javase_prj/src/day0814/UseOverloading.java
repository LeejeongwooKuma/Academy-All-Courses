package day0814;

/**
 * Overload<br>
 * 하나의 클래스에서 같은 이름의 method를 여러개 만들기
 */
public class UseOverloading {

	/**
	 * 콘솔에 별을 하나 출력하는 일
	 */
	public void printStar() {
		System.out.print("☆");
	}//printStar
	
	/**
	 * 입력되는 수만큼 콘솔에 별을 출력하는 일
	 * Overloading된 method
	 * @param cnt 출력할 별의 개수
	 */
	public void printStar(int cnt) {
		for (int i = 0 ; i < cnt ; i++) {
			System.out.print("★");
		}//end for
	}//printStars
	
	public static void main(String[] args) {
		
		UseOverloading uo = new UseOverloading();
		uo.printStar();
		uo.printStar(5);
		uo.printStar();
		System.out.println("--------");
		for(int i = 0; i < 5; i++) {
			uo.printStar(i);;
			System.out.println();
		}//end for
		
		
		
	}//main

}//class

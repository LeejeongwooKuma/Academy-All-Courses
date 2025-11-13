package day0808;

/**
 * 삼항(조건)연산자<br>
 * ? : <br>
 * 연산식 ? 항1 : 항2
 */
public class Operator6 {

	/**
	 * main method
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number=02;
		System.out.println(number + " 는 " + (number >= 0 ? "양수" : "음수"));
		System.out.println(number + " 는 " + (number > -1 ? "양수" : "음수"));
		System.out.println(number + " 는 " + (number%2 == 0 ? "짝수" : "홀수"));
	}

}

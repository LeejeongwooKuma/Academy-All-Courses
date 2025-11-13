package day0908;

/**
 * 개발자가 예외처리(try~catch~finally)를 하지 않아도 코드상의 에러가 발생하지 않는 예외.<br>
 * main method에 arguments로 숫자 두개를 받아서 두수를 나눈 결과를 저장하고 출력하는 일.
 */
public class UseRuntimeException {

	public static void main(String[] args) {
		try {
			int i = Integer.parseInt(args[0]);// ArrayIndexOutOfBoundsException, NumberFormatException
			int j = Integer.parseInt(args[1]);// ArrayIndexOutOfBoundsException, NumberFormatException
			int result = 0;

			result = i / j;// ArithmeticException
			System.out.println(i + " / " + j + " = " + result);
		} catch (ArrayIndexOutOfBoundsException aioobe) {
			System.out.println("사용법 : java UseRuntimeException 값 값");

			System.err.println("간단한 예외 메시지 : " + aioobe.getMessage());
			System.err.println("예외처리 객체와 간단한 예외 메시지 : " + aioobe);
			aioobe.printStackTrace();
		} catch (ArithmeticException ae) {
			System.out.println("0으로는 나눌 수 없습니다.");

			System.err.println("간단한 예외 메시지 : " + ae.getMessage());
			System.err.println("예외처리 객체와 간단한 예외 메시지 : " + ae);
			ae.printStackTrace();
		} catch (NumberFormatException nfe) {
			System.out.println("사용예) 값은 숫자형태만 입력할 수 있습니다.");

			System.err.println("간단한 예외 메시지 : " + nfe.getMessage());
			System.err.println("예외처리 객체와 간단한 예외 메시지 : " + nfe);
			nfe.printStackTrace();
		} catch (Exception e) {// 내가 예상하지 못 한 모든 예외를 처리하겠다. is a관계. 모든 Exceptionㅇ 부모는 Exception이라 가능
			System.out.println("개발자가 예측하지 못한 예외가 발생했을 때 사용자에게 제공할 메시지");
			e.printStackTrace();
		} finally {
			System.out.println("예외가 발생하든 정상적으로 동작하든 사용자에게 반드시 제공할 코드");
			System.out.println("ㄳ");
		}//end catch

	}// class

}// main

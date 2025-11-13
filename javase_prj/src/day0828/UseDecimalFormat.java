package day0828;

import java.text.DecimalFormat;

public class UseDecimalFormat {
	/**
	 * 숫자(1234)를 문자열(1,234)로 변경
	 */
	public UseDecimalFormat() {
		int num = 2_500_000;//JDK1.7에서부터 추가된 문법. _는 syso로 출력시 안 보임.
		System.out.println(num);

		//0패턴
		DecimalFormat df = new DecimalFormat("0,000,000,000");
		//#패턴
		DecimalFormat df2 = new DecimalFormat("#,###,###,###");
		
		int tempNum = 2025;
		
		System.out.println(df.format(tempNum));
		System.out.println(df2.format(tempNum));
		
		double tempNum2 = 2025.0828;
		DecimalFormat df3 = new DecimalFormat("0,000,000,000.00");//소수점 이하 2자리
		System.out.println(df3.format(tempNum2));
		
		DecimalFormat df4 = new DecimalFormat("#,###");// 3자리 마다 알아서 ,를 넣어 출력
		System.out.println(df4.format(2025));
		System.out.println(df4.format(1111111111));
		
	}// UseDecimalFormat

	public static void main(String[] args) {
		new UseDecimalFormat();
	}// main

}// class

package day0814;

public class UseCalculatorNumber {
	public void check() {
		CalculatorNumber cn = new CalculatorNumber();
		System.out.println("1번 문제");
		cn.printNum(0);
		System.out.println("2번 문제");
		cn.printTable(5);
		System.out.println("3번 문제");
		cn.printfullTable();
		System.out.println("4번 문제");
		cn.reverseAlp();
		}
	
	public static void main(String[] args) {
		UseCalculatorNumber ucn = new UseCalculatorNumber();
		ucn.check();
	}//main

}//class

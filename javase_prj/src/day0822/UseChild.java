package day0822;

public class UseChild {

	public static void main(String[] args) {
		Child c = new Child();//봉인해제된 클래스(non-sealed)
		Child2 c2 = new Child2();//봉인해제된 클래스(non-sealed)
		
		Parents c3 = new Child();
		
	}//main

}//class

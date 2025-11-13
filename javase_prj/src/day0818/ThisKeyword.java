package day0818;

/**
 * this의 keyword형식<br>
 * 사용할 때 : 지역변수의 이름과 인스턴스 변수의 이름이 같을 때 각각의 변수를 식별하여 사용하기 위해서<br>
 * this 키워드는 instance 영역에서만 사용됨. (static 영역은 객체를 사용하지 않고 호출되기 때문에 생성된 객체의 주소 정보를
 * 얻을 수 없기에 this를 static 영역에서 사용할 수 없다.)
 */
public class ThisKeyword {

	int i; //heap에 저장

	//this 안 쓰고 매개변수의 변수명이 똑같을 때 인스턴스 값 바꾸는 방법. 이게 어려우니 this 만듦.
	//this를 사용하지 않으면 객체의 주소를 전달할 수 있는 데이터형으로 매개변수를 선언하고
	//호출하는 곳에서 객체를 argument로 입력하면 된다. -> 근데 불편하다.
//	public void setI(int i, ThisKeyword tk) { //tk는 객체의 주소를 받을 파라메터
//		tk.i = i;
//	}// end setI
	
	public void setI(int i) { 
		System.out.println(this); //method를 호출하는 객체의 주소로 변환
		this.i = i;
	}// end setI

	public int getI() {
		return i;
	}// getI

	public void printThis() {
		// this는 method를 호출하는 객체의 주소로 변환된다.
		System.out.println(this);//tk의 주소일 수도 있고, tk2의 주소일 수도 있다.
	}

	public static void main(String[] args) {
		ThisKeyword tk = new ThisKeyword();
		ThisKeyword tk2 = new ThisKeyword();
		System.out.println("생성된 객체" + tk ) ;
		System.out.println("생성된 객체2" + tk2 ) ;
//		System.out.println(this); //static 영역에서는 this를 사용할 수 없다.
		tk.printThis();
		tk2.printThis();
		
		//tk.setI(2025, tk);
		tk.setI(2025); // method안에서 this가 호출하는 객체의 주소로 변환된다
		System.out.println(tk.getI()); //
	}// main

}// class

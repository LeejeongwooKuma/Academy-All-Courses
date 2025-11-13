package day0818;

/**
 * 
 */
public class ThisMethod {
	
	int i;
	
	public ThisMethod() {
		System.out.println("기본 생성자" + this);
		//생성자 안에서 다른 생성자를 호출하기 위해 객체화를 하면 있던 객체를 쓰는게 아니라 
		//객체가 다른 주소로 새로 하나 더 만들어진다. ->그렇기에 값의 유지가 안됨.다른 객체에 값이 들어가므로 값이 밖에서 사용도리 수 없다.
		// ===>>> 이럴 때 this();를 사용한다. 
		ThisMethod tm = new ThisMethod(2025);
		System.out.println("생성자에서 생성된 객체의 주소 : " + tm);
	}//ThisMethod
	
	public ThisMethod(int i) {
		this.i = i;
		System.out.println("Overloading 생성자 " + i);
	}//ThisMethod
	
	public int getI() {
//		return i; //this.i랑 같은 의미. 기본적으로 instance 메소드는 this가 깔려있음.
		return this.i;
	}
	
	public static void main(String[] args) {
		ThisMethod tm = new ThisMethod();
		System.out.println("tm객체 주소 : " + tm);
		System.out.println(tm.getI() + " / " + tm.i); //2025가 안 나옴. 그 이유는 
		//tm객체를 만들어서 생성자를 불렀는데 생성자에 가보니 거기서 또 객채를 만듦. 
		//tm과 저기서 만든 객체는 다른 주소를 갖는거임.
	}//main

}//class

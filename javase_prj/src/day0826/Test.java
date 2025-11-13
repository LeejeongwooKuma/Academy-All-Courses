package day0826;

import day0825.Clark;
import day0825.Fly;

public class Test {

	public void useFly(Fly fly) {
		System.out.println(fly.lift() + " / " + fly.thrust());
	}//useFly
	
	public static void main(String[] args) {
		//useFly method 호출
		//1.클래스 객체화
		Test t = new Test();
		//2.FlyImpl 객체화 ( is a 관계의 클래스를 객체화)
		FlyImpl fi = new FlyImpl(); //FlyImpl은 Fly이다.
		//3.Fly를 매개변수로 받는 method 호출.
		t.useFly(fi);
		//Test와 FlyImpl은 has a 관계. 
		
		
		//clark도 Fly를 implement 했었음.
		//2.Clark 객체화 ( is a 관계의 클래스를 객체화)
		Clark cl = new Clark(); //Clark은 Fly이다.
		//3.Fly를 매개변수로 받는 method 호출.
		t.useFly(cl);
		
		
	}//main

}//class

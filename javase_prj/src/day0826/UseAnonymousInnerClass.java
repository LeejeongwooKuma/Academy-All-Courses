package day0826;

import day0825.Fly;

/**
 * 익명 클래스의 사용
 */
public class UseAnonymousInnerClass {

	public void useFly(Fly fly) {
		System.out.println(fly.lift() + " / " + fly.thrust());
	}// useFly

	public static void main(String[] args) {
		// useFly 호출
		UseAnonymousInnerClass uaic = new UseAnonymousInnerClass();
		uaic.useFly(new Fly() {

			@Override
			public String lift() {
				// TODO Auto-generated method stub
				return "추진력";
			}

			@Override
			public String thrust() {
				// TODO Auto-generated method stub
				return "양력";
			}

		});
	}// main

}// class

package day0826;

import day0825.Fly;

/**
 * Fly를 구현한 FlyImpl 클래스를 작성 ( is a 관계 FlyImpl은 Fly 이다. -> 자식은 부모이다.)
 */
public class FlyImpl implements Fly {

	@Override
	public String lift() {
		// TODO Auto-generated method stub
		return "양력";
	}

	@Override
	public String thrust() {
		// TODO Auto-generated method stub
		return "추진력";
	}

}

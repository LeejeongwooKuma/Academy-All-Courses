package day0822;

public class Dog {
	private int eye, leg, ear, tail;

	public Dog(int eye, int leg, int ear, int tail) {
		this.eye = eye;
		this.leg = leg;
		this.ear = ear;
		this.tail = tail;
	}

	public int getEye() {
		return eye;
	}

	public void setEye(int eye) {
		this.eye = eye;
	}

	public int getLeg() {
		return leg;
	}

	public void setLeg(int leg) {
		this.leg = leg;
	}

	public int getEar() {
		return ear;
	}

	public void setEar(int ear) {
		this.ear = ear;
	}

	public int getTail() {
		return tail;
	}

	public void setTail(int tail) {
		this.tail = tail;
	}

	public String eat() {
		return "강아지들은 사료를 좋아한다.";
	}

	public String eat(String menu) {
		return "강아지들은 " + menu + " 사료를 좋아한다.";
	}

}

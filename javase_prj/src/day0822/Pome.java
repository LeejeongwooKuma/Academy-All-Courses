package day0822;

public class Pome extends Dog {

	private int jump = 0;

	public Pome(int eye, int leg, int ear, int tail) {
		super(eye, leg, ear, tail);
		jump = 2;
	}

	public void setJump(int jump) {
		this.jump = jump;
	}

	public int getJump() {
		return jump;
	}

	public void walking(int time) {
		String result = "";
		if (time > 3) {
			jump += 4;
		} else if (time > 0) {
			jump += 2;
		} else {
			jump -= 3;
			if (jump < 1) {
				jump = 1;
			}
		}
	}

	public String jumpBed() {
		String result = "";
		if (jump > 15) {
			result = "제자리 점프로 침대 올라가기 가능";
		} else if (jump > 7) {
			result = "달려서 점프로 침대 올라가기 가능 ";
		} else {
			result = "점프로는 침대를 못 올라간다";
		}
		return result;
	}

}

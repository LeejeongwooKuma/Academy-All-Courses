package day0822;

public class Pooldle extends Dog {
	private int level = 0;

	public Pooldle(int eye, int leg, int ear, int tail) {
		super(eye, leg, ear, tail);
		level = 2;
	}

	public void setlevel(int level) {
		this.level = level;
	}

	public int getlevel() {
		return level;
	}

	public void training(int time) {
		String result = "";
		if (time > 3) {
			level += 4;
		} else if (time > 0) {
			level += 2;
		} else {
			level -= 3;
			if (level < 1) {
				level = 1;
			}
		}
	}

	public String trainingLevel() {
		String result = "";
		if (level > 15) {
			result = "레벨이 높기에 여러가지 물건 가져오기, \"손\" 가능";
		} else if (level > 7) {
			result = "레벨이 평균이기에 \"손\" 가능";
		} else {
			result = "레벨이 낮기에 \"손\"불가능";
		}
		return result;
	}

	public String eat() {
		return "푸들은 사료를 그닥 좋아하지 않는다.";
	}

	@Override
	public String eat(String menu) {
		return "푸들은 입맛이 까다롭기에 " + menu + "가 들어간 사료만 먹는다.";
	}

}

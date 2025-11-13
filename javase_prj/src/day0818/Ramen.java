package day0818;

public class Ramen {
	String name; // 라면 이름
	int spicy; // 맵기 정도
	boolean noodle, soup; // 라면 면발이 굵나 얇나, 국물이 있나 없나
	String StringNoodle, StringSoup;

	public Ramen() {
		this("신라면 블랙", 2, false, true);
	}

	public Ramen(String name, int spicy, boolean noodle, boolean soup) {
		this.name = name;
		this.spicy = spicy;
		this.noodle = noodle;
		this.soup = soup;
	}

	public String eat() {
		if(noodle == true) {
			StringNoodle = "굵은 면";
		} else {
			StringNoodle = "얇은 면";
		}
		
		if( soup == true) {
			StringSoup = "국물 라면";
		} else {
			StringSoup = "국물 없는 라면";
		}
		return "먹을 라면 : " + name + " 맵기 수준(1약~5강) : " + spicy + " 면 종류 : " + StringNoodle 
				+ " 국물 유무 : " + StringSoup;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSpicy() {
		return spicy;
	}

	public void setSpicy(int spicy) {
		this.spicy = spicy;
	}

	public boolean isNoodle() {
		return noodle;
	}

	public void setNoodle(boolean noodle) {
		this.noodle = noodle;
	}

	public boolean isSoup() {
		return soup;
	}

	public void setSoup(boolean soup) {
		this.soup = soup;
	}

}// class

package day0822;

/**
 * Person 클래스의 자식클래스<br>
 * 사람의 공통 특징은 부모클래스에서 가져다 사용(코드의 재사용성) 자식클래스는 자신만의 특징(힘이 쎄다)을 정의.<br>
 * 사용법)<br>
 * Clark 객체명 = new Clark(); 객체명.자신metod();<br>
 * 객체명.부모method(); // 코드의 재사용성
 */
public final class Clark extends Person {
	public int power; // 외부 개입으로 힘이 변화함. 무슨 돌맹이 만지면 약해짐

	/**
	 * 힘레벨 1~10까지 존재하며 일반인은 2정도의 힘레벨을 가지고 클락은 9정도의 레벨을 가짐.
	 */
	public Clark() {
		power = 9;
	}// Clark

	/**
	 * 돌에 따라 힘이 변하는 일 크립토나이트 - 1힘, 다이아몬드 - 9힘, 짱돌 - 12힘
	 * 
	 * @param stone 던져진 돌의 종류
	 * @return 결과
	 */
	public String power(String stone) {
		String result = "";

		if (stone.equals("크립톤나이트")) {// 힘빠짐
			result = "~(_-_)~";
			power = 1;
		} else if (stone.equals("다이아몬드")) {// ㄳ
			result = "o(^^O)(O^^)o";
			power = 9;
		} else {// 힘상승
			result = "ㅡㅡ+;;";
			power = 12;
		} // end else

		return result;
	}//power
	
	@Override
	public String eat() {
		return getName() + "가 집에서 \"빵\"을 먹는다.";
	}
	
	@Override
	public String eat(String menu, int price) {
		return String.format("%s가 \"레스토랑\"에서 %s인 음식을 %d$로 사먹는다.", 
				getName(), menu, price);
	}
}//class

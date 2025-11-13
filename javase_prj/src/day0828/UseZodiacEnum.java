package day0828;

public class UseZodiacEnum {
	public UseZodiacEnum() {

	}

	public static void main(String[] args) {
		// 이넘 요소 하나 출력
		System.out.println(Zodiac.HOURS);
		System.out.println("-----------------------------------");
		System.out.println(Zodiac.HOURS + "요소의 번호 " + Zodiac.HOURS.ordinal());
		System.out.println("-----------------------------------");

		for (Zodiac z : Zodiac.values()) {
			System.out.println(z + " / " + z.ordinal());
		} // end for

	}// main

}// class

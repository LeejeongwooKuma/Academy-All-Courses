package day0819;

public class UseResidentNumber {

	public static void main(String[] args) {

		String ssn = "950513-1111111";
		ResidentNumber rdn = new ResidentNumber(ssn);
		if (rdn.checkNumberLength()) {
			if (rdn.checkNumberHyphen()) {
				System.out.println(rdn.calculBirthday());
				System.out.println(rdn.calculAge() + "살");
				System.out.println(rdn.checkGender());
				System.out.println(rdn.checkNationality());
				System.out.println(rdn.checkZodiac());
			} else {
				System.out.println("주민번호의 - 위치를 재확인 해주세요.");
			}//else
		} else {
			System.out.println("주민번호 글자 수를 확인해주세요.");
		}//else

	}//main

}//class

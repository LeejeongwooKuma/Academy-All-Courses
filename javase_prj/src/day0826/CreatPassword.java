package day0826;

public class CreatPassword {
	// 영문자 소문자, 영문자 대문자, 숫자로 이루어진 8자리의 비밀번호를 생성하여 StringBuilder에 저장하고 반환하는 일 method

	public StringBuilder createPassword() {
		int randomNum; // 소,대문자 총 52개 + 숫자 10개 -> 랜덤 범위는 총 62
		char password; // int로 받은 숫자를 아스키코드 기반으로 해서 영어 소,대문자 및 숫자로 바꿔줌. 0~9 -> 그대로 , 10 ~ 35 ->영어 대문자, 36 ~ 61 -> 소문자
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 8; i++) {
			randomNum = (int) (Math.random() * 62);
			sb.append(changeAsc(randomNum));
		} // end for
		return sb;
	}// createPassword

	public char changeAsc(int randomNum) {// 랜덤 숫자 가지고 아스키 코드 기반으로 해서 영어 소,대문자 및 숫자로 변환해주는 메소드
		char c;
		if (randomNum > -1 && randomNum < 10) { // 0~9
			return c = (char) (randomNum + 48);
		} else if (randomNum > 9 && randomNum < 36) {// A~Z
			return c = (char) (randomNum + 55);
		} else {// a~z
			return c = (char) (randomNum + 61);
		} // end else
	}// changeAsc

	public void printPassword(StringBuilder sb) {
		System.out.println("생성된 비밀번호 : " + sb);
	}// end printPassword

	public static void main(String[] args) {
		CreatPassword cp = new CreatPassword();
		cp.printPassword(cp.createPassword());
	}// main
}// class

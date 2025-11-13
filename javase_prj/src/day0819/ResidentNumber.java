package day0819;

public class ResidentNumber {
	private int age;
	private String number;
	private String gender;
	private String nationality;

	int year;
	String subYear, subMonth, subDay;
	char standardNum;// 주민번호 - 다음에 오는 숫자. 성별 및 나이 등의 기준에 사용

	public ResidentNumber(String number) {
		this.number = number;
		subYear = number.substring(0, 2);
		subMonth = number.substring(2, 4);
		subDay = number.substring(4, 6);
		standardNum = number.charAt(7);
	}

	public String getNumber() {
		return number;
	}// getNumber

	public void setNumber(String number) {
		this.number = number;
	}// setNumber

	public int getAge() {
		return age;
	}// getAge

	public void setAge(int age) {
		this.age = age;
	}// setAge

	public String getGender() {
		return gender;
	}// getGender

	public void setGender(String gender) {
		this.gender = gender;
	}// setGender

	public String getNationality() {
		return nationality;
	}// getNationality

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}// setNationality

//	 3. instance variable에 저장된 주민번호의 글자수가 14자리인지 체크하여 boolean으로 
//	 * 반환하는 일을 하는 method 작성. ( 14자리 true/ 아니면 false)
	public boolean checkNumberLength() {
		if (number.length() == 14) {
			return true;
		} else {
			return false;
		} // else
	}// checkNumberLength

//	  4. instance variable에 저장된 주민번호 6번째 인덱스의 문자가 '-'인지를 체크하여 boolean
//	  으로 반환하는 일을 하는 method 작성.
	public boolean checkNumberHyphen() {
		if (number.charAt(6) == '-') {
			return true;
		} else {
			return false;
		} // else
	}// checkNumberHyphen
//	5. 인스턴스 변수에 저장된 주민번호에서 생년월일을 연산하여 문자열로 반환하는 일을 하는
//	  method 작성(반환 예시 : 1995년 01월 21일). 판단기준 : -뒤의 문자	가 1,2,5,6(외쿡인)1900
//	  년대생, 3,4,7,8은 2000년대생. 0,9은 1800년대생.

	public String calculBirthday() {
		if (standardNum == '1' || standardNum == '2' || standardNum == '5' || standardNum == '6') {// 90년대생
			year = 19;
			return year + subYear + "년 " + subMonth + "월 " + subDay + "일";
		} else if (standardNum == '3' || standardNum == '4' || standardNum == '7' || standardNum == '8') {// 2000년대생
			year = 20;
			return year + subYear + "년 " + subMonth + "월 " + subDay + "일";
		} else {// 1800년대생
			year = 18;
			return year + subYear + "년 " + subMonth + "월 " + subDay + "일";
		} // else
	}// calculBirthday

//	6.인스턴스 변수에 저장된 주민번호에서 나이를 구하여 정수로 반환하는 일을 하는 method 작성
	public int calculAge() {
		int numAge = Integer.parseInt(subYear);
		if (standardNum == '1' || standardNum == '2' || standardNum == '5' || standardNum == '6') {// 90년대생
			return 100 - Integer.parseInt(subYear) + 26;
		} else if (standardNum == '3' || standardNum == '4' || standardNum == '7' || standardNum == '8') {// 2000년대생
			return 25 - Integer.parseInt(subYear) + 1;
		} else {// 1800년대생
			return 100 + 100 - Integer.parseInt(subYear) + 26;
		} // else
	}// calculAge

//	7.인스턴스 변수에 저장된 주민번호에서 성별을 구하여 문자열로 반환하는 일을 하는 method 작성 
//	  판단기준 : -뒤 문자가 0,2,4,6,8이면 여자, 1,3,5,7,9면 남자
	public String checkGender() {
		if (standardNum == '0' || standardNum == '2' || standardNum == '4' || standardNum == '6'
				|| standardNum == '8') {
			return gender = "여자";
		} else {
			return gender = "남자";
		} // else
	}// checkGender

//	 8.인스턴스 변수에 저장된 주민번호에서 내국인인지 외국인인지를 구하여 문자열로 반환하는 일을 하는
//	 method 작성. 판단기준 : -뒤 문자가 0,1,2,3,4,9면 내국인. 5,6,7,8 - 외국인
	public String checkNationality() {
		if (standardNum == '0' || standardNum == '1' || standardNum == '2' || standardNum == '3' || standardNum == '4'
				|| standardNum == '9') {
			return gender = "내국인";
		} else {
			return gender = "외국인";
		} // else
	}// checkNationality
	
	// 9. 인스턴스 변수에 저장된 주민번호에서 띠를 구하여 문자열로 반환하는 일을 하는 method 작성
	public String checkZodiac() {
		year = Integer.parseInt((year + subYear)) % 12;
		if (year == 0) {
			return "원숭이";
		} else if (year == 1) {
			return"닭";
		} else if (year == 2) {
			return"개";
		} else if (year == 3) {
			return"돼지";
		} else if (year == 4) {
			return"쥐";
		} else if (year == 5) {
			return"소";
		} else if (year == 6) {
			return"호랑이";
		} else if (year == 7) {
			return "토끼";
		} else if (year == 8) {
			return"용";
		} else if (year == 9) {
			return"뱀";
		} else if (year == 10) {
			return"말";
		} else if (year == 11) {
			return"양";
		} else {
			return "잘못 입력하였습니다.";
		}//end else
	}//checkZodiac

}// class

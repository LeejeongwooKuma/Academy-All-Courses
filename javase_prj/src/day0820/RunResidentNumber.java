package day0820;

public class RunResidentNumber {
	public void runResidentNumber(String residentNumber) {
		//업무를 제공하는 클래스를 객체화
		ResidentNumber rn = new ResidentNumber(residentNumber);
		//생성자를 통해서 입력된 값이 rn객체에 instance 변수에 할당됨.
		System.out.println("입력 주민번호" + rn.getResidentNumber());
		
		if(rn.checkResidentNumberLength()) {
			if( rn.checkResidentNumberDash()) {
				System.out.println("생년월일 " + rn.birthDay());
				System.out.println("나이 : " + rn.age());
				System.out.println("성별 : " + rn.gender());
				System.out.println("구분 : " + rn.checkLocal());
				System.out.println("띠 : " + rn.birthYearAnimal());
				
			} else {
				System.out.println("-가 없거나 정상위치가 아닙니다.");
			}
			
		} else {
			System.out.println("주민번호 14자리 아닙니다.");
		}
		
	}//runResidentNumber
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RunResidentNumber rrn = new RunResidentNumber();
		String residentNumber = "950513-1111111";
//		String residentNumber = "950513-1111111";
//		String residentNumber = "95051-1111111";
		rrn.runResidentNumber(residentNumber);
		
	}//main

}//class

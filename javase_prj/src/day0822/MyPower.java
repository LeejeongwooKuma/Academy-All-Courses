package day0822;

public class MyPower extends Person{
	int passion = 0;
	
	public String Study(String state) {
		String s = "";
		if (state.equals("졸림")) {
			passion -= 5;
			if (passion < 1) {
				passion = 1;
			}//end if
			s = "졸린 상태";
		} else if (state.equals("평범") ) {
			passion += 3;
			s = "평범한 상태, 복습 가능";
		} else if (state.equals("의욕적")) {
			passion += 7;
			s = "의욕적인 상태";
		}
		return s;
	}
	
	public String checkStudy() {
		String s = "";
		if (passion < 5) {
			s = "의욕이 없는 상태이므로 잡니다.";
		} else if (passion < 10) {
			s = "의욕이 적당해서 복습합니다.";
		} else if(passion > 10) {
			s = "의욕이 많아서 복습및 공부를 합니다.";
		}
		return s;
	}
}

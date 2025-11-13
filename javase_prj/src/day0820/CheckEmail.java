package day0820;

public class CheckEmail {

	public CheckEmail() {
	}

	String data = "test@test.com,kim@sist.co.kr,lee12@naver.com,parktest.com,kim123@com,test1234@gmail.com";
	String[] email = data.split(",");// 이메일 값들을 입력 받아 ,로 나눠서 배열로 넣기
	String[] passedEmailarr; // 유효성 검사 통과한 이메일 넣을 배열. 크기 아직 미정
	String passedEmail = ""; // 유효성 검사 통과한 이메일 임시로 넣을 문자열

	public String checkEmail(String[] email) {//이메일 유효성 검사
		for (String element : email) {
			if (element.length() > 5) {
				if (element.indexOf("@") != -1) {
					if (element.indexOf(".") != -1) {
						if (element.indexOf("@") < element.indexOf(".")) {
							passedEmail = passedEmail + element + ",";
						} else {
							System.out.println(element + " 메일은 @와 .의 순서가 맞지 않습니다.");
						}
					} else {
						System.out.println(element + " 메일에 .이 없습니다.");
					}
				} else {
					System.out.println(element + " 메일에 @이 없습니다.");
				}
			} else {
				System.out.println(element + " 메일의 글자수가 충분하지 못합니다.");
			}
		} // end for
		passedEmail = passedEmail.substring(0, passedEmail.length() - 1); // 필요 없는 마지막 , 삭제
		return "유효한 이메일 : " + passedEmail;
	}// checkEmail

	public int checkEmailNum(String email) {//유효한 이메일 개수
		return passedEmail.length() - email.replace("@", "").length();
	}//checkEmailNum

	public int checkGtld(String email) {// gTLD 이메일 개수 찾기
		return passedEmail.length() - email.replace("com", "  ").length();
	}//checkGtld

	public static void main(String[] args) {
		CheckEmail ce = new CheckEmail();
		System.out.println(ce.checkEmail(ce.email));
		System.out.println("유효한 메일 주소의 개수 : " + ce.checkEmailNum(ce.passedEmail) + "개");
		System.out.println("gTLD 이메일 개수 : " + ce.checkGtld(ce.passedEmail) + "개");
	}

}

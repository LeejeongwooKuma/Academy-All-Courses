package day0827;

/**
 * 업무를 제공하는 클래스
 */
public class Work0827 {

	/**
	 * 영문자대문자, 소문자, 숫자로 구성된 8글자의 임시비밀번호를 생성하여 반환하는 일
	 * 
	 * @return 생성된 임시비밀번호
	 */
	public String createTempPassword() {
		// 긴 문자열( + 연산 포함된 문자열 )을 처리
		StringBuilder tempPass = new StringBuilder();
//		while(tempPass.length()<8) {
//	         char d= (char)(Math.random()*123);
//	       if((d>='0'&&d<='9')||(d>='a'&&d<='z')||(d>='A'&&d<='Z')) {
//	    	   tempPass.append(d);
//	       }//end if
//	      }// end while

		String passwordChar = "1234567890qwesadwqehfgASDEGTHZXCXSA";
		int randomInd = 0;
		for (int i = 0; i < 8; i++) {
			randomInd = (int) (Math.random() * passwordChar.length());
			tempPass.append(passwordChar.charAt(randomInd));
		} // end for

		return tempPass.toString();// toString 쓴 이유는 반환형이 String이기 때문에
	}// createTempPassword

	/**
	 * 로또번호 6개를 생성하고, 오름차순 정렬하여 반환하는 일.
	 * 
	 * @return
	 */
	public int[] createLotto() {
		int[] tempLotto = new int[6];

		for (int i = 0; i < tempLotto.length; i++) {
			tempLotto[i] = ((int) (Math.random() * 45)) + 1;

			for (int j = 0; j < i; j++) {
				if (tempLotto[j] == tempLotto[i]) {
					i--;
					break;
				} // end if
			} // end for
		} // end for

		for (int j = 0; j < tempLotto.length - 1; j++) {
			for (int k = j + 1; k < tempLotto.length; k++) {
				if (tempLotto[j] > tempLotto[k]) {
					int temp = tempLotto[k];
					tempLotto[k] = tempLotto[j];
					tempLotto[j] = temp;
				}
			}
		}
		return tempLotto;
	}// createLotto

}// class

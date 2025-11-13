package day0829;

import java.util.ArrayList;
import java.util.List;

public class Exam0829DTO {
	private List<String> infoList = new ArrayList<String>();
	private boolean checkInfo = false; // 프로그램에 값이 정상적으로 입력된 적이 있는지 확인

	public boolean getCheckInfo() {
		return checkInfo;
	}//getCheckInfo

	public void setCheckInfo(boolean checkInfo) {
		this.checkInfo = checkInfo;
	}//setCheckInfo

	public void addInfo(String[] inpStrArr) {// 입력받은 정보 배열을 리스트에 추가
		for (int i = 0; i < inpStrArr.length; i++) {
			infoList.add(inpStrArr[i]);
		} // end for
		checkInfo = true;
	}// addInfo

	public void printInfo() {// 입력받은 리스트의 정보를 정리해서 출력
		int i = 0;// 위치 확인용 변수
		int num = 1;// 번호에 넣을 숫자
		int sumAge = 0;
		int avgAge;
		System.out.println("번호\t" + "이름\t" + "나이\t");
		for (String inpEle : infoList) {
			if (i % 2 == 0) {
				System.out.print(num + "\t");
				System.out.print(inpEle + "\t");
				num++;
			} else if (i % 2 == 1) {
				System.out.print(inpEle);
				System.out.print("\n");
				sumAge += Integer.parseInt(inpEle);
			} // end if
			i++;
		} // end for
		avgAge = sumAge / (infoList.size() / 2);
		System.out.println("-------------------------------");
		System.out.println("평균나이 : " + avgAge + "살\n");
	}// printInfo

}// Exam0829DTO

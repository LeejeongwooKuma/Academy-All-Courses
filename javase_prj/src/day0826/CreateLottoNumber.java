package day0826;

import java.util.Arrays;

public class CreateLottoNumber {
//	- 로또 번호 : 1~45 까지 의 수 중 중복되는 값 없이 6개 수 나와야한다.
//	- 로또 번호를 생성하여 int[]로 반환하는 일 method
	public int[] randomLottoNumber() {
		int[] lottoNum = new int[6];
		int tempNum; // 로또번호 중복 확인용
		boolean checkNum;// 로또번호 중복 확인용

		for (int i = 0; i < 6; i++) {
			checkNum = true; // 중복 확인용 boolean 초기화
			tempNum = ((int) (Math.random() * 45)) + 1;
			for (int arr : lottoNum) {// 로또 중복 번호 확인
				if (arr == tempNum) {
					checkNum = false;
					i--;
					break;
				} // end for
			} // end for
			if (checkNum == true) {
				lottoNum[i] = tempNum;
			} // end if
		} // end for
		return lottoNum;
	}// randomLottoNumber

	public void printLotto(int[] lottoNum) { // 오름차순 정렬
		Arrays.sort(lottoNum);
		for (int arr : lottoNum) {
			System.out.println(arr);
		} // end for
	}// printLotto

	public static void main(String[] args) {
		CreateLottoNumber cln = new CreateLottoNumber();
		int[] lottoNum = cln.randomLottoNumber();
		cln.printLotto(lottoNum);
	}// main

}// class

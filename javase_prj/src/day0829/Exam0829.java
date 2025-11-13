package day0829;

import java.util.List;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Exam0829 {
	String input = "";
	boolean exitFlag = false;
	Exam0829DTO eDTO = new Exam0829DTO();

	public Exam0829() {
		do {
			input = JOptionPane.showInputDialog("아래의 메뉴를 입력해주세요.\n1.입력, 2.출력, 3.종료");
			if ("".equals(input) || input == null) {
				JOptionPane.showMessageDialog(null, "입력 값이 존재하지 않습니다. 종료를 원하시면 3을 입력해주세요.");
				continue;
			}//end if
			switch (input) {
			case "1":
				oneProcess();
				break;
			case "2":
				twoProcess();
				break;
			case "3":
				System.out.println("감사합니다.");
				exitFlag = true;
				break;
			default:
				JOptionPane.showMessageDialog(null, "입력은 1이나 2이나 3으로 해주세요.");
			}// end switch
		} while (!exitFlag);
	}// Test

	public void oneProcess() {
		input = JOptionPane.showInputDialog("이름과 점수를 CSV형식으로 입력해주세요.\n입력 예) 이름, 나이, 한번에 여러명 입력 가능, 전단계 : 0");
		String[] inpStrArr = input.split(",");
		
		if(input.equals("0")) { //값을 입력하지 않고 전단계로 넘어가고 싶을 경우
			return;
		}//end if

		if (!(inpStrArr.length % 2 == 0)) {// 입력 값을 이름,점수 맞춰서 입력하였는가?
			System.out.println("잘 못 입력하셨습니다. 다시 입력하세요.");
			oneProcess();
			return;
		} // end if
		
		
		for (int i = 0; i < inpStrArr.length; i++) { //
			if (i % 2 == 0 && !(inpStrArr[i].matches("[a-zA-Zㄱ-힣]+"))) {// 이름이 문자로만 입력되었나?
				JOptionPane.showMessageDialog(null, "이름 입력 칸에는 문자만 넣어주세요.");
				oneProcess();
				return;
			} else if (i % 2 == 1 && !(inpStrArr[i].matches("\\d+"))) {// 나이가 숫자로만 입력되었나?
				JOptionPane.showMessageDialog(null, "나이 입력 칸에는 숫자만 입력해주세요.");
				oneProcess();
				return;
			} // end if
		} // end for
		eDTO.addInfo(inpStrArr);
	}// oneProcess

	public void twoProcess() {
		if (eDTO.getCheckInfo() == false) {//입력된 값이 없는데 바로 출력할 경우
			JOptionPane.showMessageDialog(null, "입력된 값이 존재하지 않습니다.");
			return;
		}//end if
		eDTO.printInfo();
	}// twoProcess

	public static void main(String[] args) {
		new Exam0829();
	}// main

}// class

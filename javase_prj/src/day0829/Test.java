package day0829;

import javax.swing.JOptionPane;

public class Test {
	public Test() {
		String input = "";
		boolean exitFlag = false;
		do {
			input = JOptionPane.showInputDialog("아래의 메뉴를 입력해주세요.\n1.입력, 2.종료");
			System.out.println(input);
			switch(input) {
			case "1" : oneProcess();break;
			case "2" : exitFlag = true;break;
			default : JOptionPane.showMessageDialog(null, "입력은 1이나 2로 해주세요.");
			}//end while
		}while(!exitFlag);				
		
		// 1을 입력하면 showInputDialog를 계속 보여주고
		// 2를 입력하면 종료.
	}// Test

	public void oneProcess() {
		System.out.println("1입력");
	}

	public static void main(String[] args) {
		new Test();
	}// main

}// class

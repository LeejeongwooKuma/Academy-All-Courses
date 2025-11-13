package day0903;

import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Work0902View extends JFrame {

	public Work0902View() {
		super("달력만들기");

		Work0902Model model = new Work0902Model();
		// 달력배열 얻기
		String[][] calArr = model.createCalendar("2025", "8");

		setLayout(new GridLayout(calArr.length, calArr[0].length));

		JButton[] jbtnArr = new JButton[calArr.length * calArr[0].length];

		int btnInd = 0;
		for (int i = 0; i < calArr.length; i++) {
			for (int j = 0; j < calArr[i].length; j++) {
				//이차원 배열의 달력으로 JButton 생성
				jbtnArr[btnInd] = new JButton(calArr[i][j]);
				//윈도우 컴포넌트에 컴포넌트를 배치
				add(jbtnArr[btnInd]);
				btnInd++;
			} // end for
		} // end for

		setBounds(100,100,700,500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}// Work0902View

	public static void main(String[] args) {
		new Work0902View();
	}// main

}// class

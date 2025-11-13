package day0902;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

//1. 윈도우 컴포넌트 상속
public class MakeCalcul extends JFrame {
	public MakeCalcul() {
		super("계산기");
		// 2.일반컴포넌트를 생성
		String[] btnLableArr = "7,8,9,4,5,6,1,2,3,+/-,0,.".split(",");
		JButton[] jbtnNumberPad = new JButton[btnLableArr.length];
		JTextField jtfNumberView = new JTextField();

		// 3.컨테이너 컴포넌트를 생성(JPanel : GridLayout(4,3)
		JPanel jpNumberPad = new JPanel();
		jpNumberPad.setLayout(new GridLayout(4, 3));
		// 4.일반컴포넌트를 컨테이너 컴포넌트에 배치
		for (int i = 0; i < jbtnNumberPad.length; i++) {
			// JButton의 각 방을 생성
			jbtnNumberPad[i] = new JButton(btnLableArr[i]);
			// 컨테이너 컴포넌트에 배치
			jpNumberPad.add(jbtnNumberPad[i]);
		} // end for
		jtfNumberView.setFont(new Font("맑은고딕", Font.BOLD, 30));
		// 5.컴포넌트를 배치

		add(BorderLayout.NORTH, jtfNumberView);
		add(BorderLayout.CENTER, jpNumberPad);
		// 6.윈도우 크기 설정
		setSize(280, 340);
		// 7.윈도우 가시화
		setVisible(true);
		// 8.윈도우 종료 처리
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new MakeCalcul();

	}

}

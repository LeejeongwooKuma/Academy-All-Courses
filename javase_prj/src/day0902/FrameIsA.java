package day0902;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FrameIsA extends JFrame {

	// TODO Auto-generated method stub
	public FrameIsA() {
		super("frame is a 사용");
		// 컴포넌트 생성
		JButton jbtn = new JButton("나는 버튼!!");
		// 3.배치
		add("North",jbtn);// 코드의 재사용
		// 4.윈도우 크기 설정
		setSize(300, 250);// 코드의 재사용
		// 5.윈도구 가시화
		setVisible(true);// 코드의 재사용
		// 6윈도우 종료 처리
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 코드의 재사용
	}



	public static void main(String[] args) {
		new FrameIsA();// 부모클래스부터 생성.

	}
}
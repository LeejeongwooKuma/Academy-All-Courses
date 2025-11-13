package day0902;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

//1. 윈도우 컴포넌트를 상속
public class UseBorderLayout extends JFrame {

	public UseBorderLayout() {
		super("BorderLayout11");
		//2. 사용자에게 제공할 컴포넌트를 생성
		JButton jbtnNorth = new JButton("North");
		JButton jbtnWest = new JButton("West");
		JLabel jlblEast = new JLabel("East"); 
		JLabel jlblSouth = new JLabel("South");
		
		JTextArea jtaCenter = new JTextArea("Center");
		//3. 배치관리자 설정(Window Component의 기본 Layout : BorderLayout
		setLayout(new BorderLayout());
		//4.윈도우에 컴포넌트를 배치(위치 설정)
		//상수사용
		add("North", jbtnNorth);
		//Constant 사용
		add(BorderLayout.WEST, jbtnWest);
		
		add(BorderLayout.CENTER, jtaCenter);
		add("East", jlblEast);
		add(BorderLayout.SOUTH, jlblSouth);
		
		//5.윈도우에 크기 설정
		setSize(500, 500);
		//6. 윈도우 사용자에게 보여주기
		setVisible(true);
		//7. 윈도우 종료 처리
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//UseBorderLayout
	
	public static void main(String[] args) {
		new UseBorderLayout();
	}//main

}//class

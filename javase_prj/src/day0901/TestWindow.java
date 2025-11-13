package day0901;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Window;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//1. Window Component 상속 : TestWindow클래스가 Window Component가 된다. (is a)
public class TestWindow extends JFrame {
	// 2.생성자에서 사용자에게 제공할 Component를 생성
	public TestWindow() {
		super("Hello Swing");// JFrame의 생성자는 title bar에 메시지를 보여줄 수 있다.
		JButton jbtn = new JButton("스윙의 버튼");//일반컴포넌트
		Button btn = new Button("AWT 버튼");
		
		JPanel jp = new JPanel(); // Container component : 일반컴포넌트를 배치
		jp.add(jbtn);//has a
		jp.add(btn);// has a
		
		//3.컴포넌트를 배치 ( 일반컴포넌트를 배치한 Container Component 배치)
		add(jp); //코드의 재사용성
		
		//4.윈도우의 크기 설정
		setSize(400, 300);//코드의 재사용성

		//5.사용자에게 보여주
		setVisible(true);//코드의 재사용성
		
		//6.윈도우 종료 처리
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//코드의 재사용성
		
	}// TestWindow

	public static void main(String[] args) {
		new TestWindow();
	}// main

}// class

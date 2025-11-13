package day0904;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

//1. Window Component 상속 : TestWindow클래스가 Window Component가 된다. (is a)
public class HasaDesign extends JFrame {
	// 2.생성자에서 사용자에게 제공할 Component를 생성
	public HasaDesign() {
		super("Has a 관계로 이벤트를 처리");// JFrame의 생성자는 title bar에 메시지를 보여줄 수 있다.
		JButton jbtn = new JButton("스윙의 버튼");//일반컴포넌트
		
		HasaEvent he = new HasaEvent(this);//이벤트에서 쓸건데 안에꺼느 디자인의 값을 쓸거니 this인듯?
		//2-1. 컴포넌트가 이벤트를 발생시킬 수 있도록 리스너에 등록(이거 안 하면 Y/N에서 N으로 빠지는 거)
		jbtn.addActionListener(he);//has a이므로 this못 쓰고 hasaevent를 서야함.
		
		
		//3.컴포넌트를 배치 ( 일반컴포넌트를 배치한 Container Component 배치)
		add(jbtn); //코드의 재사용성
		
		//4.윈도우의 크기 설정
		setSize(400, 300);//코드의 재사용성

		//5.사용자에게 보여주
		setVisible(true);//코드의 재사용성
		
		//6.윈도우 종료 처리
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//코드의 재사용성
		
	}// TestWindow

	//3.인터페이스의 이벤트 발생시 호출되는 method를 Override
	public static void main(String[] args) {
		new HasaDesign();
	}// main
	
	

}// class

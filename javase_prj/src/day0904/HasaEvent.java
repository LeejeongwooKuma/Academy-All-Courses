package day0904;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

//1. Event처리 리스너를 상속, 구현
public class HasaEvent implements ActionListener{
	// 2.생성자에서 사용자에게 제공할 Component를 생성
	//밑에 매개변수로 쓰면 actionPerformed안에서 this로 못 쓰니 변수로 만들어서 씀
	HasaDesign hd;//이벤트는 디자인을 가지고 있다.(이벤트는 디자인에 존재하는 컴포넌트를 사용할 수 있다.)
	public HasaEvent(HasaDesign hd) {
		this.hd = hd;
	}
	//3.인터페이스의 이벤트 발생시 호출되는 method를 Override
	@Override
	public void actionPerformed(ActionEvent e) {//액션이벤트 객체는 JVM이 자동생성
		System.out.println("이벤트 객체 + " + e);
		//이벤트가 발생했을 때 사용자에게 제공할 코드
		JOptionPane.showMessageDialog(hd , "버튼이 눌렸습니다.!!!");
	}//actionPerformed
	
}// class

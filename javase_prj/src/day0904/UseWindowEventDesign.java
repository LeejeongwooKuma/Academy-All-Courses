package day0904;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

//인터페이스를 구현하면, 추상 메소드를 모두 Override 해야한다.
public class UseWindowEventDesign extends Frame /*implements WindowListener*/{
	public UseWindowEventDesign() {
		
		super("윈도우 이벤트 처리");
		
		//윈도우 이벤트 등록
//		addWindowListener(this);
		UseWindowEvent uwe = new UseWindowEvent(this);
		addWindowListener(uwe);
		
		setBounds(100,100,500,400);
		setVisible(true);
		
	}//UseWindowEvent
	public static void main(String[] args) {
		new UseWindowEventDesign();
	}//main
	
//	@Override
//	public void windowOpened(WindowEvent e) {
//		// TODO Auto-generated method stub
//		System.out.println("windowOpened");
//		
//	}
//	@Override
//	public void windowClosing(WindowEvent e) {
//		// TODO Auto-generated method stub
//		System.out.println("windowClosing");
//		dispose();
//	}
//	@Override
//	public void windowClosed(WindowEvent e) {
//		// TODO Auto-generated method stub
//		System.out.println("windowClosed");
//	}
//	@Override
//	public void windowIconified(WindowEvent e) {
//		// TODO Auto-generated method stub
//		System.out.println("windowIconified");
//	}
//	@Override
//	public void windowDeiconified(WindowEvent e) {
//		// TODO Auto-generated method stub
//		System.out.println("windowDeiconified");
//	}
//	@Override
//	public void windowActivated(WindowEvent e) {
//		// TODO Auto-generated method stub
//		System.out.println("windowActivated");
//	}
//	@Override
//	public void windowDeactivated(WindowEvent e) {
//		// TODO Auto-generated method stub
//		System.out.println("windowDeactivated");
//	}

}//class

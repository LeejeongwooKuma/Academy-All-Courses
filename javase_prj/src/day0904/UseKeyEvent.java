package day0904;

import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class UseKeyEvent extends JFrame implements KeyListener {

	private JTextField jtfID;
	JPasswordField jtPassword;

	public UseKeyEvent() {
		super("윈도우 컴포넌트");
		jtfID = new JTextField();
		jtPassword = new JPasswordField();
		JLabel jlblResult = new JLabel();

		jtfID.setBorder(new TitledBorder("아이디"));
		jtPassword.setBorder(new TitledBorder("비밀번호"));
		jlblResult.setBorder(new TitledBorder("결과"));

		setLayout(new GridLayout(3, 1));
		add(jtfID);
		add(jtPassword);
		add(jlblResult);

		jtfID.addKeyListener(this);
		jtPassword.addKeyListener(this);

		setSize(300, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}// Exam0903_2

	public static void main(String[] args) {
		new UseKeyEvent();
	}// main

	@Override
	public void keyTyped(KeyEvent e) {
	}// keyTyped

	@Override
	public void keyPressed(KeyEvent e) {
	}// keyPressed

	@Override
	public void keyReleased(KeyEvent e) {
		//어떤 컴포넌트가 이벤트를 발생했는지 비교.(아이디? 패스워드? 뭐 눌러서 이게 실행된거지?)
		if(e.getSource() == jtfID) {
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {//esc누르면 꺼져라
			dispose();
		} // end if
		}
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {//엔터누르면 포커스 맞춰라
			jtPassword.requestFocus();
		} // end if
		System.out.println("keyReleased : "+ jtfID.getText()+ " keycode : " + e.getKeyCode()+", keyChar : " + e.getKeyChar());
	}// keyReleased

}// class

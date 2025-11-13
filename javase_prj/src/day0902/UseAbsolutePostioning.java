package day0902;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPasswordField;

//1.윈도우 컴포넌트 상속
public class UseAbsolutePostioning extends JFrame {
	public UseAbsolutePostioning() {
		super("수동패치");
		
		//2.컴포넌트를 생성
		JButton jbtn = new JButton("버튼");
		JComboBox<String> jcb = new JComboBox<String>();
		jcb.addItem("JButton - 눌러서 일을 할 수");
		jcb.addItem("JLabel - 특정 컴포넌트의 이름표");
		jcb.addItem("JTextArea - 여러 줄의 입력을 받거나, 보여줄 때");
		jcb.addItem("JTextField - 한 줄의 입력을 받거나, 보여줄 때");
		jcb.addItem("JPasswordField- 비밀번호를 입력을 받거나, 보여줄 때");
		JPasswordField jpf = new JPasswordField();
		JCheckBox jcheckb = new JCheckBox();
		
		//3.배치관리자를 해제
		setLayout(null);//BorderLayout => 수동배치로 됨

		//4.컴포넌트의 크기설정
		jbtn.setSize(80,30);
		jcb.setSize(250,35);
//		jpf.setSize(120,35);
		//5.컴포넌트의 배치 위치를 설정
		jbtn.setLocation(50, 60);
		jcb.setLocation(150, 140);
//		jpf.setLocation(300, 358);
		jpf.setBounds(300, 350, 120, 35);
		jcheckb.setBounds(120, 333, 30, 30);
		//6.배치
		add(jbtn);
		add(jcb);
		add(jpf);
		add(jcheckb);
		//윈도우의 크기를 변경하지 못하게 막기.
		setResizable(false);
		
		//7.윈도우 크기 설정
		setSize(500,500);
		//8.윈도우 가시화
		setVisible(true);
		//9.윈도우 종료처리
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}//UseAbsolutePostioning
	public static void main(String[] args) {
		new UseAbsolutePostioning();
	}//main

}//class

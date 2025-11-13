package day0904;

import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class ExLoginDesign extends JFrame{
	private JTextField jtfID;
	private JPasswordField jtPassword;
	private JLabel jlblResult;
	private Map<String, String> loginMap = new HashMap<String,String>();
	
	public ExLoginDesign() {
		super("윈도우 컴포넌트");
		
		loginMap.put("kim", "1234");
		loginMap.put("kim2", "Lee1234");
		loginMap.put("park", "q1w2e3r4");
		
		jtfID = new JTextField();
		jtPassword = new JPasswordField();
		jlblResult = new JLabel();

		jtfID.setBorder(new TitledBorder("아이디"));
		jtPassword.setBorder(new TitledBorder("비밀번호"));
		jlblResult.setBorder(new TitledBorder("결과"));

		setLayout(new GridLayout(3, 1));
		add(jtfID);
		add(jtPassword);
		add(jlblResult);
		
		ExLoginEvent ele = new ExLoginEvent(this);
		jtfID.addKeyListener(ele);
		jtPassword.addKeyListener(ele);

		setSize(300, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}// Exam0903_2

	public JTextField getJtfID() {
		return jtfID;
	}

	public JPasswordField getJtPassword() {
		return jtPassword;
	}

	public JLabel getJlblResult() {
		return jlblResult;
	}

	public Map<String, String> getLoginMap() {
		return loginMap;
	}

	public static void main(String[] args) {
		new ExLoginDesign();
	}// main


}// class

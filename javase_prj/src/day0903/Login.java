package day0903;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class Login extends JFrame {
	public Login() {
		TitledBorder tbId = new TitledBorder("아이디");
		TitledBorder tbPassword = new TitledBorder("비밀번호");
		TitledBorder tbResult = new TitledBorder("결과");
		
		JTextField jtfId = new JTextField();
		JPasswordField jpwfPassword = new JPasswordField();
		JLabel jlbResult = new JLabel();
		
		
		jtfId.setBorder(tbId);
		jpwfPassword.setBorder(tbPassword);
		jlbResult.setBorder(tbResult);
		
		
		setLayout(new GridLayout(3,1));
		
		add(jtfId);
		add(jpwfPassword);
		add(jlbResult);
		
		
		setSize(800,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Login();
	}

}

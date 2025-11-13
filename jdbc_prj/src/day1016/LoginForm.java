package day1016;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import kr.co.sist.pstmt.dao.GetConnection;

public class LoginForm extends JFrame implements KeyListener,ActionListener{

	private JTextField jtfID;
	private JPasswordField jtPassword;
	private JLabel jlblResult;
	
	public LoginForm() {
		super("윈도우 컴포넌트");
		jtfID = new JTextField();
		jtPassword = new JPasswordField();
		jlblResult = new JLabel();
		
		jtfID.setBorder(new TitledBorder("아이디"));
		jtPassword.setBorder(new TitledBorder("비밀번호"));
		jlblResult.setBorder(new TitledBorder("결과"));
		
		setLayout(new GridLayout(3,1));
		add(jtfID);
		add(jtPassword);
		add(jlblResult);
		
		jtfID.addKeyListener(this);
		jtPassword.addKeyListener(this);
		jtPassword.addActionListener(this);
		
		setSize(300, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}// Exam0903_2

	public static void main(String[] args) {
		new LoginForm();
	}// main

	@Override
	public void keyTyped(KeyEvent e) {
//		System.out.println("keyTyped : "+ jtfID.getText()
//			+" keyCode : "+e.getKeyCode() +", keyChar : "+ e.getKeyChar());
	}//keyTyped[

	@Override
	public void keyPressed(KeyEvent e) {
//		System.out.println("keyPressed : "+ jtfID.getText()
//			+" keyCode : "+e.getKeyCode()+", keyChar : "+ e.getKeyChar() );
	}//keyPressed

	@Override
	public void keyReleased(KeyEvent e) {
		//어떤 컴포넌트가 이벤트를 발생했는지 비교.
//		System.out.println( jtfID );
//		System.out.println("키가 눌렸음."+ e.getSource());
		
		if( e.getSource() == jtfID ) {
			if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
				dispose();
			}//end if
		}//end if
		
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			jtPassword.requestFocus();
		}//end if
//		System.out.println("keyReleased : "+ jtfID.getText()
//			+" keyCode : "+e.getKeyCode() +", keyChar : "+ e.getKeyChar());
	}//keyReleased

	public String login() throws SQLException, IOException{
		String name = "";
		String id = jtfID.getText().trim();
		String pass =new String(jtPassword.getPassword()).trim();
		
		Connection con = null;
//		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		GetConnection gc = GetConnection.getInsance();
		try {
			con = gc.getConn();
//			pstmt = con.createStatement();
//			StringBuilder selectName = new StringBuilder();
//			selectName
//			.append("	select name	")
//			.append("	from temp_login	")
//			.append("	where id='").append(id)
//			.append("' and pass='").append(pass).append("'");
			StringBuilder selectName = new StringBuilder();
			selectName
			.append("	select name	")
			.append("	from temp_login	")
			.append("	where id=? and pass=? ");
			
			
			pstmt = con.prepareStatement(selectName.toString());
//			System.out.println(selectName);
			
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
			
			rs=pstmt.executeQuery();
			
//			rs=stmt.executeQuery(selectName.toString());
			
			if( rs.next() ) {
				name = rs.getString("name");
			}//end if
			
		}finally {
			gc.dbClose(null, pstmt, rs);
		}//end finally
		
		return name;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			String name = login();
			
			if(name.isEmpty()) {
				JOptionPane.showMessageDialog(this, "아이디나 비밀번호를 확인해 주세요.");
				return;
			}//end if
			
			jlblResult.setText(name+"님 어서오고!");
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}// class

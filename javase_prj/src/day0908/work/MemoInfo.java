package day0908.work;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MemoInfo extends JDialog{
	private JButton jbtnConfirm;
	private JavaMemo jm;
	private JButton jbtnOk;
	private JPanel jplButton;
	public MemoInfo(JavaMemo jm) {
		super(jm,"메모장정보");
		this.jm = jm;
		jbtnOk = new JButton("확인");
		jplButton = new JPanel();
		jplButton.add(jbtnOk);
		JLabel txtInfo = new JLabel("<HTML>Java 메모장 Version 1.0<br>이 메모장은"
				+ "PL(Public License)로<br>아무나 자유롭게 배포, 수정이<br> 가능합니다."
				+ "편하게 사용해주세요.</HTML>");
		Font font = new Font("맑은 고딕", Font.BOLD, 20);
		txtInfo.setFont(font);
		add("Center",txtInfo);
		add("South", jplButton);
		
		MemoInfoEvt mie = new MemoInfoEvt(this);
		jbtnOk.addActionListener(mie);
		
		setBounds(jm.getX() + 100, jm.getY() + 50, 400, 300);// x,y,w,h
		setVisible(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}//MemoInfo
	
	public JButton getJbtnConfirm() {
		return jbtnConfirm;
	}//getJbtnConfirm
	
	public JavaMemo getJm() {
		return jm;
	}//getJm

	public JButton getJbtnOk() {
		return jbtnOk;
	}

	public JPanel getJplButton() {
		return jplButton;
	}
	
}//MemoInfo

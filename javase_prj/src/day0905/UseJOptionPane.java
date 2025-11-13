package day0905;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class UseJOptionPane extends JFrame implements ActionListener {
	private JButton jbtnInput, jbtnMessage, jbtnConfirm;
	public UseJOptionPane() {
		super("JOptionPane에서 제공하는 dialog 사용");
		jbtnInput = new JButton("Input Dialog");
		jbtnMessage = new JButton("Message Dialog");
		jbtnConfirm = new JButton("Confirm Dialog");
		
		JPanel jpCenter = new JPanel();
		jpCenter.setBorder(new TitledBorder("JOptionPane"));
		
		jpCenter.add(jbtnInput);
		jpCenter.add(jbtnMessage);
		jpCenter.add(jbtnConfirm);
		
		add("Center", jpCenter);
		
		jbtnInput.addActionListener(this);
		jbtnMessage.addActionListener(this);
		jbtnConfirm.addActionListener(this);
		
		setBounds(100, 100, 400, 200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}//UseJOptionPane
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == jbtnInput) {
			useInputDialog();
		}//end if
		
		if(ae.getSource() == jbtnMessage) {
			useMessageDialog();
		}//end if
		
		if(ae.getSource() == jbtnConfirm) {
			useConfirmDialog();
		}//end if
		
	}//actionPerformed

	public void useInputDialog() {
		String name = JOptionPane.showInputDialog(this, "당신의 이름을 입력해주세요.",
				"이름이 궁금해요.", JOptionPane.ERROR_MESSAGE);
		if("이정우".equals(name)) {
			new LoginForm();
			this.dispose();
		} else {
			JOptionPane.showMessageDialog(this, name+"님 안녕하세요?");
		}//end if
	}//useInputDialog
	
	public void useMessageDialog() {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd a EEEE 입니다.");
			JOptionPane.showMessageDialog(this, sdf.format(new Date()));
	}//useMessageDialog
	
	public void useConfirmDialog() {
		int selectedInd = JOptionPane.showConfirmDialog(this, "9월 10일은 쉴까요?");
		String msg = "";
		switch(selectedInd) {
		case JOptionPane.OK_OPTION : msg = "그날 뭐하지? Nice"; break;
		case JOptionPane.NO_OPTION : msg = "ㅈㅈ"; break;
		case JOptionPane.CANCEL_OPTION : msg = "안 들려"; break;
		}//end switch
		JOptionPane.showMessageDialog(this, msg);
	}//useMessageDialog
	
	public static void main(String[] args) {
//		new UseJOptionPane();
		int[] arr = new int[3];
		arr[0] = 2025;
		arr[1] = 9;
		arr[2] = 5;
		arr[3] = 15; //문법적으로는 문제가 없음, CPU/ memory를 사용해보니 문제 발생. => Run time Exception
	}//main

}//class

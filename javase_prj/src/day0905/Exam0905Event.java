package day0905;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class Exam0905Event implements ActionListener, MouseListener {
	private Exam0905Form exForm;

	public Exam0905Event(Exam0905Form exForm) {
		this.exForm = exForm;
	}// Exam0905Event

	JList<String> jlistInfo;
	JTextField jtfNum;
	JTextField jtfName;
	JTextField jtfAge;
	JTextField jtfPhoneNum;

	@Override
	public void actionPerformed(ActionEvent ac) {
		jtfNum = exForm.getJtfNum();
		jtfName = exForm.getJtfName();
		jtfAge = exForm.getJtfAge();
		jtfPhoneNum = exForm.getJtfPhoneNum();
		JButton jbtinput = exForm.getJbtinput();
		JButton jbtDelete = exForm.getJbtDelete();
		JButton jbtOut = exForm.getJbtOut();
		jlistInfo = exForm.getJlistInfo();
		DefaultListModel<String> dlm = exForm.getDlm();
		StringBuilder sbinput = new StringBuilder();

		String result = "";

		// 입력버튼 눌러서 제이리스트에 값 추가
		if (ac.getSource() == jbtinput) {
			// 입력 값 체크
			if (!(jtfNum.getText().equals("") || jtfName.getText().equals("") || jtfAge.getText().equals("")
					|| jtfPhoneNum.getText().equals(""))) {
				sbinput.append(jtfNum.getText().trim() + ",").append(jtfName.getText().trim() + ",")
						.append(jtfAge.getText().trim() + ",").append(jtfPhoneNum.getText().trim());// 입력 눌러지면 값 추가
				result = sbinput.toString();
			} else {
				JOptionPane.showMessageDialog(null, "입력값을 확인해주세요.");
			} // end if

			// result값이 비어 있는지 확인
			if (!result.equals("")) {
				// 이상 없으면 값 추가
				dlm.addElement(result);
				exForm.setDlm(dlm);
				jtfNum.setText("");
				jtfName.setText("");
				jtfAge.setText("");
				jtfPhoneNum.setText("");
				jtfNum.requestFocus();
			} // end if
		} // end if

		// 삭제버튼 눌러서 제이르스트 값 삭제,제이리스트의 값 클릭 했는지 확인
		if (ac.getSource() == jbtDelete && clickedList != -1) {
			dlm.remove(clickedList);
			clickedList = -1;
		} else if (ac.getSource() == jbtDelete && clickedList == -1) {
			JOptionPane.showMessageDialog(null, "삭제할 아이템을 먼저 선택해 주세요.");
		} // end if

		if (ac.getSource() == jbtOut) {
			exForm.dispose();
		} // end if

//		checkListClick = true;
	}// actionPerformed

//	boolean checkListClick = false;// 리시트를 누른 상태인지 확인
	int clickedList = -1; // 몇 번째 제이르스트를 눌렀는지 저장

	@Override
	public void mouseClicked(MouseEvent me) {
		jlistInfo = exForm.getJlistInfo();
		String[] inpJtext = null;

		// 제이리스트 값 누르면 해당 값을 택스트 필드에 넣어주기
		if (me.getSource() == jlistInfo) {
			inpJtext = jlistInfo.getSelectedValue().split(",");
			jtfNum.setText(inpJtext[0]);
			jtfName.setText(inpJtext[1]);
			jtfAge.setText(inpJtext[2]);
			jtfPhoneNum.setText(inpJtext[3]);
			// 제이르스트를 눌렀으므로 상태 변경
//			checkListClick = true;
			// 제이르스트 위치 기억
			clickedList = jlistInfo.getSelectedIndex();
//			return;
		} // end if

	}

	@Override
	public void mousePressed(MouseEvent e) {
	}// mousePressed

	@Override
	public void mouseReleased(MouseEvent e) {
	}// mouseReleased

	@Override
	public void mouseEntered(MouseEvent e) {
	}// mouseEntered

	@Override
	public void mouseExited(MouseEvent e) {
	}// mouseExited

}// class

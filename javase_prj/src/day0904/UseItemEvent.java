package day0904;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JTextField;

/**
 * UseItemDesign 윈도우에 아이템 이벤트(JComboBox), 액센이벤트(JTextField)를 처리하는 클래스
 */
public class UseItemEvent implements ActionListener, ItemListener {

	private UseItemDesign uid;

	public UseItemEvent(UseItemDesign uid) {// has a 관계 성립
		this.uid = uid;
	}// UseItemEvent

	private boolean flag;

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (flag) {// 클릭 떌떄랑 누를떄 2번 호출돼서 1번만 돌게 하기.

			// JComboBox가 선택되고, 0번 인덱스가 아니라면
			int ind = uid.getJcbTld().getSelectedIndex();
			if (ind != 0) {

				// 선택한 인덱스(view) 번째 값을(model) 가져오고
				String selectedTld = uid.getDcbmTld().getElementAt(ind);
				// JTextFeild 설정
				uid.getJtfDomain().setText(selectedTld);
				// jTextFiel에 커서를 위치.
				uid.getJtfDomain().requestFocus();
			} // end if

		} // end if
		flag = !flag;
	}// itemStateChanged

	@Override
	public void actionPerformed(ActionEvent e) {
		// 메일과 도메인을 얻어서
		JTextField jtfEmail = uid.getJtfEmail();
		JTextField jtfDomain = uid.getJtfDomain();

		String mail = jtfEmail.getText();
		String domain = jtfDomain.getText();
		if (!"".equals(mail)) {
			// JLabel의 \n으로 줄을 변경할 수 없다
//			uid.getJlblOutput().setText("입력메일 : \n" + mail + "@" + domain);
			//HTML tag<br>사용하면 줄 변경 가능
			uid.getJlblOutput().setText("<html>입력메일 : <br>" + mail + "@" + domain + "<br>오늘은 목요일</html>");
			jtfEmail.setText("");
			jtfDomain.setText("");
			jtfEmail.requestFocus();
		} // end if
	}// actionPerformed

}// class

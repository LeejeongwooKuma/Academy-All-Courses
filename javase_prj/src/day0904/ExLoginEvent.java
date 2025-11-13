package day0904;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ExLoginEvent implements KeyListener {

	private ExLoginDesign eld;

	public ExLoginEvent(ExLoginDesign eld) {
		this.eld = eld;
	}// ExLoginDesign

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}//keyTyped

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}//keyPressed

	@Override
	public void keyReleased(KeyEvent e) {

		JTextField jtfId = eld.getJtfID();
		JPasswordField jpfpass = eld.getJtPassword();
		JLabel jlblResult = eld.getJlblResult();
		Map<String, String> loginMap = eld.getLoginMap();
//		System.out.println("맵사이즈 : " + loginMap.get("kim23"));
//		System.out.println("택스트 값 : " + e.getSource() + "\n2번값 : " + jtfId);
		if (e.getSource() == jtfId) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER && !jtfId.getText().isEmpty()) {
				jpfpass.requestFocus();
			} else {
				jtfId.requestFocus();
			}//end if
		}//end if
		if (e.getSource() == jpfpass) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER && !jpfpass.getText().isEmpty() && jtfId.getText().isEmpty()) {
				jtfId.requestFocus();
			} else if (e.getKeyCode() == KeyEvent.VK_ENTER && jpfpass.getText().isEmpty()){
				jpfpass.requestFocus();
			} else if (e.getKeyCode() == KeyEvent.VK_ENTER && !jpfpass.getText().isEmpty() && !jtfId.getText().isEmpty()) {
				if(loginMap.containsKey(jtfId.getText()) && loginMap.get(jtfId.getText()).equals(jpfpass.getText())) {
				jlblResult.setText("성공");
				} else {
					jlblResult.setText("실패");
					jtfId.setText("");
					jpfpass.setText("");
					jtfId.requestFocus();
					
				}
			}//end if
		}//end if

	}//keyReleased

}

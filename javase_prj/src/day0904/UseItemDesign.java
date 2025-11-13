package day0904;

import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 * 메일주소 @ 도메인주소 도메인선택 출력
 */
public class UseItemDesign extends JFrame {

	// 이벤트 처리와 관련있는 Component를 선언
	private JTextField jtfEmail, jtfDomain;
	private JLabel jlblOutput;
	private DefaultComboBoxModel<String> dcbmTld;
	private JComboBox<String> jcbTld;

	public UseItemDesign() {
		super("액션이벤트, 아이템이벤트 처리");

		jtfEmail = new JTextField(15);
		jtfDomain = new JTextField(7);
		jlblOutput = new JLabel();

		String[] strTld = { "---선택---", "gmail.com", "naver.com", "hotmail.com", "daum.net", "nate.com" };
		dcbmTld = new DefaultComboBoxModel<String>(strTld);
		jcbTld = new JComboBox<String>(dcbmTld);

		Font fontInput = new Font("맑은 고딕", Font.PLAIN, 20);
		JLabel jlblMail = new JLabel("메일");
		JLabel jlblAt = new JLabel("@");

		jlblMail.setFont(fontInput);
		jtfEmail.setFont(fontInput);
		jlblAt.setFont(fontInput);
		jtfDomain.setFont(fontInput);
		jcbTld.setFont(fontInput);

		jlblOutput.setFont(new Font("맑은 고딕", Font.BOLD, 25));

		JPanel jpNorth = new JPanel();
		jpNorth.add(jlblMail);
		jpNorth.add(jtfEmail);
		jpNorth.add(jlblAt);
		jpNorth.add(jtfDomain);
		jpNorth.add(jcbTld);

		jpNorth.setBorder(new TitledBorder("메일입력"));
		jlblOutput.setBorder(new TitledBorder("출력"));

		add("North", jpNorth);
		add("Center", jlblOutput);

		// 이벤트 등록(has a)
		UseItemEvent uie = new UseItemEvent(this);
		jcbTld.addItemListener(uie);
		jtfDomain.addActionListener(uie);

		setBounds(100, 100, 700, 350);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}// UseItemEvent

	public JTextField getJtfEmail() {
		return jtfEmail;
	}

	public JTextField getJtfDomain() {
		return jtfDomain;
	}

	public JLabel getJlblOutput() {
		return jlblOutput;
	}

	public DefaultComboBoxModel<String> getDcbmTld() {
		return dcbmTld;
	}

	public JComboBox<String> getJcbTld() {
		return jcbTld;
	}

}// class

package day0908.work;

import java.awt.Label;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class MemoFont extends JDialog {
	private JavaMemo jm;

	private JTextField jtfFont;
	private JTextField jtfStyle;
	private JTextField jtfSize;

	private DefaultListModel<String> dlmFont;
	private DefaultListModel<String> dlmStyle;
	private DefaultListModel<String> dlmSize;

	private JList<String> jlFont;
	private JList<String> jlStyle;
	private JList<String> jlSize;

	private Label jlblPreview;
	private JLabel jlblPre;
	
	private JButton jbtnConfirm;
	private JButton jbtnCancel;
	
	
	
	public MemoFont() {
		System.out.println("실행");
	}

	public MemoFont(JavaMemo jm) {
		super(jm, "글꼴");
		this.jm = jm;

		jtfFont = new JTextField();
		jtfStyle = new JTextField();
		jtfSize = new JTextField();

		dlmFont = new DefaultListModel<String>();
		dlmStyle = new DefaultListModel<String>();
		dlmSize = new DefaultListModel<String>();

		jlFont = new JList<String>(dlmFont);
		jlStyle = new JList<String>(dlmStyle);
		jlSize = new JList<String>(dlmSize);

		JScrollPane jspFont = new JScrollPane(jlFont);
		JScrollPane jspStyle = new JScrollPane(jlStyle);
		JScrollPane jspSize = new JScrollPane(jlSize);

		dlmFont.addElement("고딕체");
		dlmFont.addElement("궁서체");
		dlmFont.addElement("Consolas");
		dlmFont.addElement("맑은 고딕");
		dlmStyle.addElement("보통");
		dlmStyle.addElement("기울임꼴");
		dlmStyle.addElement("굵게");
		dlmStyle.addElement("굵은 기울음꼴");

		JLabel jlblFont = new JLabel("글꼴");
		JLabel jlblStyle = new JLabel("글꼴스타일");
		JLabel jlblSize = new JLabel("크기");
		jlblPre = new JLabel("AaBbYyZz");
		jlblPre.setBorder(new TitledBorder("보기"));

		jbtnConfirm = new JButton("확인");
		jbtnCancel = new JButton("취소");

		setLayout(null);
		jlblFont.setBounds(20, 20, 40, 20);
		jtfFont.setBounds(20, 50, 120, 40);
		jspFont.setBounds(20, 100, 120, 100);
		jlblStyle.setBounds(160, 20, 70, 20);
		jtfStyle.setBounds(160, 50, 120, 40);
		jspStyle.setBounds(160, 100, 120, 100);
		jlblSize.setBounds(300, 20, 70, 20);
		jtfSize.setBounds(300, 50, 120, 40);
		jspSize.setBounds(300, 100, 120, 100);
		jlblPre.setBounds(200, 200, 220, 100);
		jbtnConfirm.setBounds(270, 300, 70, 50);
		jbtnCancel.setBounds(350, 300, 70, 50);

		add(jlblFont);
		add(jtfFont);
		add(jspFont);
		add(jlblStyle);
		add(jtfStyle);
		add(jspStyle);
		add(jlblSize);
		add(jtfSize);
		add(jspSize);
		add(jlblPre);
		add(jbtnConfirm);
		add(jbtnCancel);

		String size = "";
		for (int i = 8; i < 81; i++) {
			size = String.valueOf(i);
			if (i < 12) {
				dlmSize.addElement(size);
			} else {
				dlmSize.addElement(size);
				i++;
			} // end if
		} // end for

		MemoFontEvt mfe = new MemoFontEvt(jm, this);
		jlFont.addListSelectionListener(mfe);
		jlStyle.addListSelectionListener(mfe);
		jlSize.addListSelectionListener(mfe);
		jbtnConfirm.addActionListener(mfe);
		jbtnCancel.addActionListener(mfe);

		setBounds(jm.getX() + 100, jm.getY() + 50, 500, 400);// x,y,w,h
		setVisible(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}// MemoFont

	public JavaMemo getJm() {
		return jm;
	}// getJm

	public JTextField getJtfFont() {
		return jtfFont;
	}// getJtfFont

	public JTextField getJtfStyle() {
		return jtfStyle;
	}// getJtfStyle

	public JTextField getJtfSize() {
		return jtfSize;
	}// getJtfSize

	public DefaultListModel<String> getDlmFont() {
		return dlmFont;
	}// getDlmFont

	public DefaultListModel<String> getDlmStyle() {
		return dlmStyle;
	}// getDlmStyle

	public DefaultListModel<String> getDlmSize() {
		return dlmSize;
	}// getDlmSize

	public JList<String> getJlFont() {
		return jlFont;
	}// getJlFont

	public JList<String> getJlStyle() {
		return jlStyle;
	}// getJlStyle

	public JList<String> getJlSize() {
		return jlSize;
	}// getJlSize

	public Label getJlblPreview() {
		return jlblPreview;
	}// getJlblPreview

	public JButton getJbtnConfirm() {
		return jbtnConfirm;
	}// getJbtnConfirm

	public JButton getJbtnCancel() {
		return jbtnCancel;
	}// getJbtnCancel

	public JLabel getJlblPre() {
		return jlblPre;
	}

	public void setDlmFont(DefaultListModel<String> dlmFont) {
		this.dlmFont = dlmFont;
	}

	
	
}// MemoFont

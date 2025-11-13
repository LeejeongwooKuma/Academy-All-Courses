package day0908.work;

import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MemoFontEvt extends WindowAdapter implements ActionListener, ItemListener, ListSelectionListener {
	private JavaMemo jm;
	private MemoFont mf;

	private JTextField jtfFont;
	private JTextField jtfStyle;
	private JTextField jtfSize;
	private DefaultListModel<String> dlmFont;
	private DefaultListModel<String> dlmStyle;
	private DefaultListModel<String> dlmSize;
	private JList<String> jlFont;
	private JList<String> jlStyle;
	private JList<String> jlSize;
	private JLabel jlblPre;
	private JButton jbtnConfirm;
	private JTextArea jtaMemo;
	
	public MemoFontEvt(JavaMemo jm, MemoFont mf) {
		this.jm = jm;
		this.mf = mf;
	}// MemoFontEvt

	@Override
	public void windowClosing(WindowEvent e) {
		super.windowClosing(e);
	}// windowClosing

	@Override
	public void itemStateChanged(ItemEvent e) {
		System.out.println("아이템");
	}// itemStateChanged

	@Override
	public void actionPerformed(ActionEvent e) {
		jbtnConfirm = mf.getJbtnConfirm();
		if(e.getSource()== jbtnConfirm) {
			setFont();
		}
			mf.dispose();
		
	}// actionPerformed

	public void setPreview() {
		Font font = new Font(inputFont, style, Integer.parseInt(size));
		jlblPre = mf.getJlblPre();
		jlblPre.setFont(font);
	}// setPreview

	public void setFont() {
		jtaMemo = jm.getJtaMemo();
		Font font = new Font(inputFont, style, Integer.parseInt(size));
		jtaMemo.setFont(font);
	}// setFont
	String inputFont = "";
	int style = 0;
	String size = "10";
	@Override
	public void valueChanged(ListSelectionEvent me) {
		jlFont = mf.getJlFont();
		jlStyle = mf.getJlStyle();
		jlSize = mf.getJlSize();
		if (me.getSource() == jlFont) {
			jtfFont = mf.getJtfFont();
			dlmFont = mf.getDlmFont();
			jtfFont.setText(jlFont.getSelectedValue());
			inputFont = jlFont.getSelectedValue();
		}
		if (me.getSource() == jlStyle) {
			jtfStyle = mf.getJtfStyle();
			dlmStyle = mf.getDlmStyle();
			jtfStyle.setText(jlStyle.getSelectedValue());
			switch (jlStyle.getSelectedValue()) {
			case "보통" : style = Font.PLAIN; break;
			case "기울임꼴" : style = Font.ITALIC; break;
			case "굵게" :  style = Font.BOLD; break;
			case "굵은 기울음꼴" :  style = Font.BOLD | Font.ITALIC; break;
			}
			
		}
		if (me.getSource() == jlSize) {
			jtfSize = mf.getJtfSize();
			dlmSize = mf.getDlmSize();
			jtfSize.setText(jlSize.getSelectedValue());
			size = jlSize.getSelectedValue();
		}
		setPreview();
	}

}// MemoFontEvt

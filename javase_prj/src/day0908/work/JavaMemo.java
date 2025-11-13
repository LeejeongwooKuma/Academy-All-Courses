package day0908.work;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class JavaMemo extends JFrame {
	private JTextArea jtaMemo;
	private JScrollPane jsp;
	private JMenuBar jmb;
	
	private JMenu jmbFile;
	private JMenu jmbForm;
	private JMenu jmbHelp;
	
	private JMenuItem jmiNew;
	private JMenuItem jmiOpen;
	private JMenuItem jmiSave;
	private JMenuItem jmiEnd;
	private JMenuItem jmiFont;
	private JMenuItem jmiInfo;
	
	public JavaMemo() {
		super("자바 메모장");
		
		jtaMemo = new JTextArea();
		jsp = new JScrollPane(jtaMemo);
		jmb = new JMenuBar();
		
		jmbFile = new JMenu("파일");
		jmbForm = new JMenu("서식");
		jmbHelp = new JMenu("도움말");
		
		jmiNew = new JMenuItem("새글");
		jmiOpen = new JMenuItem("열기");
		jmiSave = new JMenuItem("저장");
		jmiEnd = new JMenuItem("종료");
		jmiFont = new JMenuItem("글꼴");
		jmiInfo = new JMenuItem("메모장정보");
		
		jmbFile.add(jmiNew);
		jmbFile.addSeparator();
		jmbFile.add(jmiOpen);
		jmbFile.add(jmiSave);
		jmbFile.addSeparator();
		jmbFile.add(jmiEnd);
		jmbForm.add(jmiFont);
		jmbHelp.add(jmiInfo);
		
		jmb.add(jmbFile);
		jmb.add(jmbForm);
		jmb.add(jmbHelp);
		
		JavaMemoEvt jme = new JavaMemoEvt(this);
		addWindowListener(jme);
		jmiNew.addActionListener(jme);
		jmiOpen.addActionListener(jme);
		jmiSave.addActionListener(jme);
		jmiEnd.addActionListener(jme);
		jmiFont.addActionListener(jme);
		jmiInfo.addActionListener(jme);
		
		
		add("Center", jsp);
		add("North", jmb);
		
		setSize(700,500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//JavaMemo

	public JTextArea getJtaMemo() {
		return jtaMemo;
	}//getJtaMeomo

	public JMenuItem getJmiNew() {
		return jmiNew;
	}//getJmiNew

	public JMenuItem getJmiOpen() {
		return jmiOpen;
	}//getJmiOpen

	public JMenuItem getJmiSave() {
		return jmiSave;
	}//getJmiSave

	public JMenuItem getJmiEnd() {
		return jmiEnd;
	}//getJmiEnd

	public JMenuItem getJmiFont() {
		return jmiFont;
	}//getJmiFont

	public JMenuItem getJmiInfo() {
		return jmiInfo;
	}//getJmiInfo
	
	
}// JavaMemo

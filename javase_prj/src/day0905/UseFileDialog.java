package day0905;

import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class UseFileDialog extends JFrame implements ActionListener {

	private JButton jbtnOpen, jbtnSave, jbtnOpenFileChooser, jbtnSaveFileChooser;

	public UseFileDialog() {
		super("파일 다이얼로그 연습");

		jbtnOpen = new JButton("열기");
		jbtnSave = new JButton("저장");
		jbtnOpenFileChooser = new JButton("열기");
		jbtnSaveFileChooser = new JButton("저장");

		JPanel jpCenter = new JPanel();
		jpCenter.setBorder(new TitledBorder("파일다이얼로그"));

		jpCenter.add(jbtnOpen);
		jpCenter.add(jbtnSave);
		jpCenter.add(jbtnOpenFileChooser);
		jpCenter.add(jbtnSaveFileChooser);

		add("Center", jpCenter);

		jbtnOpen.addActionListener(this);
		jbtnSave.addActionListener(this);
		jbtnOpenFileChooser.addActionListener(this);
		jbtnSaveFileChooser.addActionListener(this);

		setBounds(100, 100, 400, 200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}// UseFileDialog

	@Override
	public void actionPerformed(ActionEvent ae) {
//		System.out.println(ae.getActionCommand());
//		ae.getActionCommand()//이벤트를 발생시킨 대상의 Label(열기,저장 등..)을 문자열로 얻는 일. 단점은 똑같은 문자열이면 비교가 힘들어짐. 그래서 권장하진 않음.
		if (ae.getSource() == jbtnOpen) {
			openFileDialog();
		} // end if

		if (ae.getSource() == jbtnSave) {
			saveFileDialog();
		} // end if

		if (ae.getSource() == jbtnOpenFileChooser) {
			openFileChooser();
		} // end if

		if (ae.getSource() == jbtnSaveFileChooser) {
			saveFileChooser();
		} // end if

	}// actionPerformed

	public void openFileDialog() {
		FileDialog fdOpen = new FileDialog(this, "자바 파일- 열기", FileDialog.LOAD);// this=>나=>JFram
		fdOpen.setVisible(true);

		String dir = fdOpen.getDirectory();
		String file = fdOpen.getFile();
		// 파일을 선택한 경우에만 타이틀바에 설정
		if (file != null) {
			setTitle("열기 : " + dir + file);
		} // end if

	}// openFileDialog

	public void saveFileDialog() {
		FileDialog fdSave = new FileDialog(this, "자바 파일- 저장", FileDialog.SAVE);// this=>나=>JFram
		fdSave.setVisible(true);

		String dir = fdSave.getDirectory();
		String file = fdSave.getFile();
		// 파일을 선택한 경우에만 타이틀바에 설정
		if (file != null) {
			setTitle("저장 : " + dir + file);
		} // end if
	}// saveFileDialog

	public void openFileChooser() {
		//생성
		JFileChooser jfcOpen = new JFileChooser();
		//보여주기
		jfcOpen.showOpenDialog(this);
		
		File file = jfcOpen.getSelectedFile();
		if(file != null) {
		setTitle("jfc 열기 " + file.getAbsolutePath());
		//콘솔에 파일의 크기, 권한정보 (읽기가능,쓰기가능,실행가능)를 문자열로 출력
		System.out.println("크기 : " + file.length());
		System.out.println(file.canRead() ? "읽기가능" : "불가능");
		System.out.println(file.canWrite() ? "쓰기가능" : "불가능");
		System.out.println(file.canExecute() ? "실행가능" : "불가능");
		}//end if
	}// openFileChooser

	public void saveFileChooser() {
		//생성
		JFileChooser jfcSave = new JFileChooser();
		//보여주기
		jfcSave.showOpenDialog(this);
		
	}// saveFileChooser

	public static void main(String[] args) {
		new UseFileDialog();
	}// main
}// class

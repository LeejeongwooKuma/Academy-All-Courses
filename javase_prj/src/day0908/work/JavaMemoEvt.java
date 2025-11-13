package day0908.work;

import java.awt.FileDialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class JavaMemoEvt extends WindowAdapter implements ActionListener {
	private JTextArea jtaMemo;
	private JavaMemo jm;
	private JMenuItem jmiNew;
	private JMenuItem jmiOpen;
	private JMenuItem jmiSave;
	private JMenuItem jmiEnd;
	private JMenuItem jmiFont;
	private JMenuItem jmiInfo;
	private String dir;
	private String file;
	private boolean newBoolean = false;
	private boolean openBoolean = false;
	private boolean loginc = false;

	public JavaMemoEvt(JavaMemo jm) {
		this.jm = jm;
	}// JavaMemoEvt

	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("디스포즈");
	}// windowClosing

	@Override
	public void actionPerformed(ActionEvent me) {
		jtaMemo = jm.getJtaMemo();
		jmiNew = jm.getJmiNew();
		jmiOpen = jm.getJmiOpen();
		jmiSave = jm.getJmiSave();
		jmiEnd = jm.getJmiEnd();
		jmiFont = jm.getJmiFont();
		jmiInfo = jm.getJmiInfo();

		if (me.getSource() == jmiNew) {
			try {
				newMemo();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} // end if

		if (me.getSource() == jmiOpen) {
			openMemo();
		} // end if

		if (me.getSource() == jmiSave) {
			try {
				saveMemo();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} // end if

		if (me.getSource() == jmiEnd) {
			try {
				closeWin();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} // end if

		if (me.getSource() == jmiFont) {
			setFont();
		} // end if

		if (me.getSource() == jmiInfo) {
			memoInfo();
		} // end if

	}// actionPerformed

	public void newMemo() throws IOException {
		if (jtaMemo.getText().isEmpty()) {
			jtaMemo.setText("");
		} else {
			compareFile();
			jtaMemo.setText("");
		}
	}// newMemo

	public void openMemo() {
		FileDialog fdOpen = new FileDialog(jm, "자바 파일- 열기", FileDialog.LOAD);
		fdOpen.setVisible(true);
		
		dir = fdOpen.getDirectory();
		file = fdOpen.getFile();
		if (file != null) {
			jm.setTitle("자바 메모장 - 열기 " + dir + file);
		} // end if
		File openFile = new File(dir + file);

		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(dir + file)))) {
			String temp = "";
			String saveTemp = "";
			String[] loadFont = br.readLine().split(",");
			Font font = new Font(loadFont[0],Integer.parseInt(loadFont[1]), Integer.parseInt(loadFont[2]));
			jtaMemo.setFont(font);
			
			while ((temp = br.readLine()) != null) {
				saveTemp += temp;
			} // end while
			compareFile();
			jtaMemo.setText(saveTemp);
		} catch (IOException ie) {
			ie.printStackTrace();
		} // end catch

	}// openMemo
	
	public void saveMemo() throws IOException {
		String fontSave = jm.getJtaMemo().getFont().getName() + "," + jm.getJtaMemo().getFont().getStyle() + "," + jm.getJtaMemo().getFont().getSize();
		System.out.println("폰트 : " + jm.getJtaMemo().getFont().getName() + jm.getJtaMemo().getFont().getStyle() + jm.getJtaMemo().getFont().getSize());
		FileDialog fdSave = new FileDialog(jm, "자바 파일- 저장", FileDialog.SAVE);
		fdSave.setVisible(true);

		dir = fdSave.getDirectory();
		file = fdSave.getFile();
		if (file != null) {
			jm.setTitle("자바 메모장 - 저장 " + dir + file);
		} // end if

		// 파일 저장하기
		File saveFile = new File(dir + file);
		OutputStreamWriter osw = null;

		try {
			osw = new OutputStreamWriter(new FileOutputStream(saveFile));
			// 2.스트림에 목적지 파일에 기록될 내용쓰기
//			String msg = "오늘은 목요일 입니다. 예비군 시즌.";
			osw.write(fontSave+"\n"+jtaMemo.getText());
			// 3.스트림의 내용을 목적지 파일로 분출
			osw.flush();// 이걸 안 하면 write한 내용을 파일에 못 보낸 상태임. 기본형은 알아서 보내는데 참조형(문자)는 크기를 몰라서 안됨.

		} finally {
			// 4.연결 끊기
			if (osw != null) {
				osw.close();
			} // end if
			jtaMemo.setText("");
		} // end finally
	}// saveFileDialog

	public void closeWin() throws IOException {
		compareFile();
		jm.dispose();
	}// closeWin

	MemoFont mf;

	public void setFont() {
		mf = new MemoFont(jm);
	}// setFont

	MemoInfo mi;

	public void memoInfo() {
		mi = new MemoInfo(jm);
	}// memoInfo

	public void compareFile() throws IOException {
		if (!jtaMemo.getText().equals("")) { // jta에 내용이 있다면,
			File openFile = new File(dir + file);
			try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(openFile)))) {// 파일 내용
																												// 불러오기
				String temp = "";
				String saveTemp = "";
				while ((temp = br.readLine()) != null) {
					saveTemp += temp;
				} // end while
				if (saveTemp.equals(jtaMemo.getText())) {// JTA에 내용이 존재하고, 해당 내용이 읽어들인 내용과 같다면,
//					jtaMemo.setText("");
					return;
				} else {// JTA 내용이 존재하는데 해당 내용이 읽어들인 내용과 다르다면
					int checkAgreed = JOptionPane.showConfirmDialog(jm, "새로운 내용으로 저장할까요?");
					if (checkAgreed == JOptionPane.OK_OPTION) {// 새 파일이니 새로 저장할게.
						saveMemo();
					} else if (checkAgreed == JOptionPane.CANCEL_OPTION) {// 새 파일이니 걍 내용 지울게.
						return;
					}
				}
			} catch (IOException ie) {
				ie.printStackTrace();
			} // end catch
			jtaMemo.setText("");
		} else {// JTA에 내용이 없다면,
			int checkAgreed = JOptionPane.showConfirmDialog(jm, "새로운 내용으로 저장할까요?");
			if (checkAgreed == JOptionPane.OK_OPTION) {// 새 파일이니 새로 저장할게.
				saveMemo();
			} else if (checkAgreed == JOptionPane.NO_OPTION) {// N선택.
				return;
			} else {// 취소 버튼

			} // end if
		} // end if
	}

}// JavaMemoEvt

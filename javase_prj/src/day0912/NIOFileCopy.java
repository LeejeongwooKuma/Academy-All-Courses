package day0912;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class NIOFileCopy extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4248101895823334311L;

	public NIOFileCopy() {
		super("파일복사");
		JButton jbtn = new JButton("파일을 선택해주세요.");

		JPanel jpCenter = new JPanel();
		jpCenter.add(jbtn);

		add("Center", jpCenter);

		jbtn.addActionListener(this);

		setBounds(100, 100, 400, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}// FileCopy

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			fileCopy();
		} catch (IOException ie) {
			JOptionPane.showMessageDialog(this, "파일이 복사되지 않았다.");
			ie.printStackTrace();
		}
	}// actionPerformed

	public void fileCopy() throws IOException {
		JFileChooser jfc = new JFileChooser("c:/dev/temp");
		jfc.showOpenDialog(this);
		
		
		//선택한 파일을 받는다.
		File selectedFile =  jfc.getSelectedFile();
		if(selectedFile != null) {//파일을 정상적으로 선택 했을 때
			StringBuilder copyFileName = new StringBuilder(selectedFile.getAbsolutePath());
			copyFileName.insert(copyFileName.lastIndexOf("."),"_copy");
			
			File copyFile = new File(copyFileName.toString());
			//NIO를 사용한 파일 복사
			//1.원본 Path 얻기
			Path originalPath = Path.of(selectedFile.getAbsolutePath());
			//2.복사할 파일
			Path copyPath = Path.of(copyFile.getAbsolutePath());
			
			//3.복사
			Files.copy(originalPath, copyPath, StandardCopyOption.COPY_ATTRIBUTES);//원본파일 옵션으로
			
			JOptionPane.showMessageDialog(this, "복사되었습니다.");
			
			
			
		}//end if
	}// fileCopy

	public static void main(String[] args) {
		new NIOFileCopy();
	}// main

}// class

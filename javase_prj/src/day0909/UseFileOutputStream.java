package day0909;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;


public class UseFileOutputStream {

	public void useFileOutputStream() throws IOException {

		// 0.디렉토리가 존재하니?
		// 디렉토리가 존재하지 않으면 디렉토리를 생성하고, 존재하면 생성작업 실행하지 않는다.
		File dir = new File("c:/dev/temp/");
		if (!dir.exists()) {
			dir.mkdirs();
			return;
		} // end if

		boolean createFlag = false;
		// 1. 파일은 존재하니?
		// 덮어쓸것인지 여부를 confirmDialog로 물어본 후 확인이면 덮어쓰고 "아니오"나 "취소"라면
		// 덮어쓰지 않는다.
		// 파일이 존재하지 않으면 파일을 생성.
		File createFile = new File(dir.getAbsolutePath() + File.separator + "java_write.txt");
		if (createFile.exists()) {
			int selectedBtn = JOptionPane.showConfirmDialog(null, createFile.getName() + "파일이 존재합니다. 덮어쓰겠습니까?");
			switch (selectedBtn) {
			case JOptionPane.OK_OPTION:
				createFlag = false;
				break;
			case JOptionPane.NO_OPTION:
				createFlag = true;
				break;
			case JOptionPane.CANCEL_OPTION:
				createFlag = true;
				break;
			}// end switch
		} // end if

		// 2.목적지 파일에 스트림을 연결한다. -> 파일이 없으면 생성하고, 있으면 덮어씌운다.
		if (createFlag) {// false
			return;// early return ->if문을 이렇게 따로 빼주는게 코드 보기 편함.
		} // end if
		FileOutputStream fos = null;
//			if (!createFlag) {//false
		try {
			fos = new FileOutputStream("c:/dev/temp/java_write.txt");
			int writeData = 65;
			//3.스트림에 데이터를 기록
			fos.write(writeData);//65가 fos에 기록
			//4.스트림에 기록된 데이터를 목직지로 분출한다.
			fos.flush();
			System.out.println("목적지 파일에 데이터를 기록하였습니다.");
		} finally {
			if (fos != null) {
				fos.close();
			} // end if
		} // end fianlly
//	} // end if
	}// useFileOutputStream

	public static void main(String[] args) {
		UseFileOutputStream ufos = new UseFileOutputStream();
		try {
			ufos.useFileOutputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}// main

}// class

package day0909;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Exam0909 {
	public void searchInfo() {
		String inputDirectory = JOptionPane.showInputDialog("디렉토리를 입력해주세요.");
		File file = new File(inputDirectory);
		if(!file.isDirectory()) {
			return;
		}
		File[] listFile = file.listFiles();
		Date date = new Date(listFile[0].lastModified());
		date = new Date(listFile[0].lastModified());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd EEEE a hh:mmm:ss");
		StringBuffer sb = new StringBuffer();
		sb.append("이름\t\t").append("수정한 날짜\t\t\t").append("유형\t").append("크기\n");
		String checkFile = "";
		String format = "";
		for (int i = 0; i < listFile.length; i++) {
			if (listFile[i].isFile() == true) {
				checkFile = "파일";
			} else {
				checkFile = "폴더";
			} // end if
			if (listFile[i].getName().length() > 10) {// 15글자 이상이면 12글자에서 짜르고 ... 넣기
				format = listFile[i].getName().substring(0, 10) + "...";
			} else {// 파일명이 15글자 미만이면 공백 추가
				format = String.format("%-10s", listFile[i].getName());
			} // end if
			sb.append(format + "\t\t").append(sdf.format(new Date(listFile[i].lastModified())) + "\t\t")
					.append(checkFile + "\t").append(listFile[i].length() + " byte\n");
		} // end for
		JTextArea jta = new JTextArea(sb.toString());
		JOptionPane.showMessageDialog(null, jta);
	}// searchInfo

	public static void main(String[] args) {
		Exam0909 ex0909 = new Exam0909();
		ex0909.searchInfo();
	}// main

}// class

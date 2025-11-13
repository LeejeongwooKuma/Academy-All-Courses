package day0909;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

/**
 * 
 */
public class UseFile {

	public UseFile() {
		// 1. 생성)
		File file = new File("c:/dev/temp/java_read.txt");
		System.out.println(file);// File클래스에서 toString() Override해서 주소대신 메시지 나옴

		if (file.exists()) { // 파일이 존재하는 지? file.length() != 0
			System.out.println("파일의 크기 : " + file.length() + "byte");
			System.out.println("디렉토리인가? " + file.isDirectory());
			System.out.println("파일? " + file.isFile());
			System.out.println("읽기 권한이 있니? " + file.canRead());
			System.out.println("쓰기 권한이 있니? " + file.canWrite());
			System.out.println("실행권한이 있니? " + file.canExecute());
			System.out.println("절대경로? " + file.getAbsolutePath());// 여러개의 경로로 사용가능
			try {
				System.out.println("규범경로? " + file.getCanonicalPath());// 하나의 경로로 사용
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // end try
			System.out.println("부모디렉토리? " + file.getParent());
			System.out.println("파일명? " + file.getName());
			System.out.println(file.getParent() + File.separator + file.getName());
			System.out.println("숨김파일? " + file.isHidden());
			System.out.println("파일이 마지막으로 수정된 날짜? " + file.lastModified());
			// 우리가 보기 편한 날짜로 보기.
			Date date = new Date(file.lastModified());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd EEEE a HH:mm:ss");
			System.out.println("파일이 마지막으로 수정된 날짜? " + sdf.format(date));
		} // end if

	}// UseFile

	public void fileInfo() {
		// 1. 생성)
		File file = new File("c:/dev/temp/java_read.txt");
		System.out.println(file);// File클래스에서 toString() Override해서 주소대신 메시지 나옴

		if (file.exists()) { // 파일이 존재하는 지? file.length() != 0
			System.out.println("파일의 크기 : " + file.length() + "byte");
			System.out.println("디렉토리인가? " + file.isDirectory());
			System.out.println("파일? " + file.isFile());
			System.out.println("읽기 권한이 있니? " + file.canRead());
			System.out.println("쓰기 권한이 있니? " + file.canWrite());
			System.out.println("실행권한이 있니? " + file.canExecute());
			System.out.println("절대경로? " + file.getAbsolutePath());// 여러개의 경로로 사용가능
			try {
				System.out.println("규범경로? " + file.getCanonicalPath());// 하나의 경로로 사용
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // end try
			System.out.println("부모디렉토리? " + file.getParent());
			System.out.println("파일명? " + file.getName());
			System.out.println(file.getParent() + File.separator + file.getName());
			System.out.println("숨김파일? " + file.isHidden());
			System.out.println("파일이 마지막으로 수정된 날짜? " + file.lastModified());
			// 우리가 보기 편한 날짜로 보기.
			Date date = new Date(file.lastModified());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd EEEE a HH:mm:ss");
			System.out.println("파일이 마지막으로 수정된 날짜? " + sdf.format(date));
		} // end if
	}// fileInfo

	public void createDirectory() {
		//1.생성할 디렉토리명을 저장할 파일 생성
		File file = new File("C:/dev/temp2/kws");
		//2.생성
//		System.out.println("디렉토리 생성 : " + file.mkdir());//부모 디렉토리가 존재하지 않으면
		//하위 디렉토리를 생성하지 않는다.
		System.out.println("디렉토리 생성 : " + file.mkdirs());
	}// createDirectory
	
	public void delleteFile() {
		//1.삭제할 파일명을 가진 파일 생성
		File file = new File("c:/dev/temp/java_read3.txt");
		//2. 삭제
//		if(file.exists() && JOptionPane.showConfirmDialog(null, "파일을 삭제?" ) == JOptionPane.OK_OPTION) {
			System.out.println("파일삭제 : " + file.delete());
//		}//end if
		
	}//delleteFile

	public static void main(String[] args) {
		UseFile uf = new UseFile();
		uf.createDirectory();
		uf.delleteFile();
	}// main

}// class

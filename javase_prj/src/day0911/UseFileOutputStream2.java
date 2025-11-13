package day0911;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * 
 */
public class UseFileOutputStream2 {
	public void useFileOutputStreamAndOutputStreamWriter() throws IOException {
		File file = new File("c:/dev/temp/java_write.txt");

		// 파일이 있는지? Y(덮어쓸것인지?) : N(파일생성) 정의

		// 1.스트림 생성
		OutputStreamWriter osw = null;

		try {
			osw = new OutputStreamWriter(new FileOutputStream(file));
			// 2.스트림에 목적지 파일에 기록될 내용쓰기
			String msg = "오늘은 목요일 입니다. 예비군 시즌.";
			osw.write(msg);
			// 3.스트림의 내용을 목적지 파일로 분출
//			osw.flush();//이걸 안 하면 write한 내용을 파일에 못 보낸 상태임. 기본형은 알아서 보내는데 참조형(문자)는 크기를 몰라서 안됨.

		} finally {
			// 4.연결 끊기
			if (osw != null) {
				osw.close();
			} // end if
		} // end finally
	}// useFileOutputStreamAndOutputStreamWriter

	public void useFileWriter() {
		File file = new File("c:/dev/temp/java_write2.txt");
		// try~with~resoures : 스트림의 연결이 자동으로 끊어지기에 static은 쓰면 안됨.
		// 1.파일에 스트림을 연결 : 파일이 없으면 생성하고, 있으면 덮어쓴다.
		try (FileWriter fw = new FileWriter(file)) {
			// 2.스트림에 기록
			String msg = "내일은 금요일 입니다.";
			fw.write(msg);
			// 3.스트림의 내용을 목적지로 분출
			fw.flush();//얘 없어도 close를 알아서 해주기 실행 잘 됨.
			System.out.println("파일에 기록 되었습니다.");

		} catch (IOException ie) {
			ie.printStackTrace();
		} // end catch
	}// FileWriter

	public static void main(String[] args) {
		UseFileOutputStream2 ufos2 = new UseFileOutputStream2();
		try {
			ufos2.useFileOutputStreamAndOutputStreamWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("--------------------------------");
		ufos2.useFileWriter();
	}// class

}// main

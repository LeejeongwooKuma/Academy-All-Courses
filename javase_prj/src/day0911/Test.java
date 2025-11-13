package day0911;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.swing.JOptionPane;

import day0908.TabaccoException;

public class Test {

	public void work() throws TabaccoException {
		if (new Random().nextBoolean()) {
			throw new TabaccoException();
		} // end if
		System.out.println("예외가 발생하지 않은 정상적인 상황");
	}// work

	public static void main(String[] args) {
		Test t = new Test();

		try {
			t.work();
			System.out.println("정상적으로 업무를 처리 이후 코드");
		} catch (TabaccoException e) {
			JOptionPane.showMessageDialog(null, "ㅈㅅ; ㄱㄷㄱㄷ ㄱㄱ");
			System.err.println("업무 처리 method에서 문제(정상적으로 처리되지 않은 예외)" + "가 발생했을 때 코드");

			// 예외가 발생했을 때 c:dev/temp/err_20250911.log" 파일을 만들고
			// 예외의 내용을 출력해보세요. (hint : printStackTrace()를 잘사용하면 됨.)
			File dir = new File("c:/dev/temp");
			if (!dir.exists()) {
				dir.mkdirs();
			} // end if

			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			File file = new File(dir.getAbsolutePath() + File.separator + sdf.format(new Date()) + ".log");
			System.out.println(file);
			try (PrintWriter pw = new PrintWriter(new FileWriter(file))) {
				e.printStackTrace(pw);

			} catch (IOException ie) {
				//로그파일이 정상적으로 생성되지 않았을때
			}//end catch

		} // end catch
	}// main
}// class

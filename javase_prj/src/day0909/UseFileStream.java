package day0909;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class UseFileStream {
	public void useFileInputStream() throws IOException {
		File file = new File("C:/dev/temp/java_read.txt");
		if (!file.exists()) {
			System.out.println(file + "파일의 경로를 확인해주세요");
			return;
		} // end if
		FileInputStream fis = null;
		try {
			// 1.목적지 파일에 스트림 연결
			fis = new FileInputStream(file);// FileNotFoundException. 위의 if문때메 이 error가 뜰 확률은
											// 낮음. 그래서 io익셉셥으로 해도 ㄱ
			// 2.연결된 파일의 내용을 읽어 들이기(한자만)
//			int readData = fis.read();// IOException
//			System.out.println(readData);

			int readData = 0;
			//스트림에서 읽어 들인 값이 EOF(-1)이 아니라면
			while((readData = fis.read()) != -1) {
				System.out.print(readData);//한글이 깨진다.
			}//end while
			
		} finally {
			// 반드시 연결을 끊기

		}

	}// useFileInputStream

	/**
	 * 8bit stream과 16bit stream을 연결하여 사용( 한글을 제대로 읽어들일 수 있다.)
	 * try~with~resources 사용
	 */
	public void useBinaryStreamJoinStringStream() {
		
		//0.File 객체 사용(File 정보 얻기)
		File file  = new File("c:/dev/temp/java_read.txt");
		if(!file.exists()) {//파일이 존재하지 않으면
			return;
		}//end if
		//1.스트림을 연결하여 확장한다.
		try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
			//2.파일에서 한줄을 읽어 들인다.
//			System.out.print(br.readLine());
			//파일의 끝(EOF-null)까지 읽어 들인다.
			String temp = "";
			
			
			//읽어들인 파일에 내용이 주민번호 형식을 가지고 있다면 주민번호를 제거하여 보여준다.
			while((temp = br.readLine()) != null) {
				System.out.println(temp.replaceAll("(\\d{6})-(\\d{7})",""));
			}//end while
		}catch(IOException ie) {
			ie.printStackTrace();
		}//end catch
	}//useBinaryStreamJoinStringStream
	
	public void useFileReader() {
		//0.File과 연결
		File file = new File("c:/dev/temp/java_read.txt");
		 
		//1.16bit stream을 연결 : 독자포멧이 없는 txt파일을 읽기 위해서 사용.
		try(BufferedReader br = new BufferedReader(new FileReader(file))) {
			String readData = "";
			StringBuilder sbData = new StringBuilder();
			while ( (readData = br.readLine()) != null ) {
				sbData.append(readData).append("\n");
			}//end while
//			System.out.println(sbData); //이렇게 자료를 계속 모았다 한번에 출력하는게 훨 빠르고 좋음.
			JTextArea jta = new JTextArea(sbData.toString(), 10, 40);
//			jta.setEditable(false);//수정불가능
			jta.setLineWrap(true);//행의 단어가 지정한 컬럼수와 같다면 자동 줄변경
			jta.setWrapStyleWord(true);//단어를 보호하는 것(단어별로 줄 변경- 한글 x.띄어쓰기 기준)
			
			JScrollPane jsp = new JScrollPane(jta);
			JOptionPane.showMessageDialog(null, jsp);
			
			
			JOptionPane.showMessageDialog(null, sbData);
		}catch(IOException ie) {
			
		}//end catch
	}// useFileReader

	public static void main(String[] args) {
		UseFileStream ufs = new UseFileStream();
		try {
			ufs.useFileInputStream();//한글이 깨짐
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("\n----------------------------");
		ufs.useBinaryStreamJoinStringStream();
		System.out.println("----------------------------");
		ufs.useFileReader();
	}// main

}// class

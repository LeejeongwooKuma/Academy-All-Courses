package day0912;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * NIO를 사용한 대용량 파일읽기
 */
public class UseNIO {
	
	public UseNIO() {
	//1.파일과 연결
		File file = new File("c:/dev/temp/big.txt");
		//파일이 존재하는지? 전처리.
//		Path path = Paths.get(file.getAbsolutePath());//JDK1.7 : Path, Paths 사용
		Path path = Path.of(file.getAbsolutePath());//JDK 11부터는 Path만 사용할 수 있다. 
		System.out.println(path.getFileName());
		//2. 파일과 NIO를 사용하여 모든 행을 읽어 들인다.
		
		try {
			List<String> list = Files.readAllLines(path);
			//3.반복
			for(String line : list) {
				System.out.println(line);
			}//end for
		} catch (IOException e) {
			e.printStackTrace();
		}//catch
		
	}//UseNIO
	public static void main(String[] args) {
		new UseNIO();
	}//main

}//class

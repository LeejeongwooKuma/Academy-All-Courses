package day0912;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class SimpleClient {
	public SimpleClient() throws UnknownHostException, IOException {
	//소캣 생성) 설정한 ip와 port를 사용하여 서버 컴퓨터에 접속을 시도.
		Socket client = new Socket("192.168.10.75",65520);
		System.out.println("서버에 접속하였습니다.");
	}//SimpleClient
	public static void main(String[] args) {
		try {
			new SimpleClient();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//end catch
	}//main

}//class

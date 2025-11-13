package day0915;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public class SimpleMsgClient {
	public SimpleMsgClient() throws UnknownHostException, IOException {
		// 1,3번은 server에 있음.
		// 소캣 생성) 설정한 ip와 port를 사용하여 서버 컴퓨터에 접속을 시도.
		// Socket client = new Socket("192.168.10.76",54000);
		Socket client = null; // 서버와 연결하기 위한 소켓
		DataInputStream dis = null; // 서버의 데이터를 읽기 위한 스트림
		DataOutputStream dos = null; // 서버에 데이터를 보내기 위한 스트림
		try {
			// 2.소켓생성 : 서버와 회선확립을 수행.
			String ip = JOptionPane.showInputDialog("서버의 ip 입력(68~93)");
			client = new Socket("192.168.10."+ip, 54000);
			System.out.println("서버에 접속하였습니다.");
			// 4.서버에서 pactet에 실어서 보내온 데이터를 받기위해 소켓으로 부터 스트림을 얻기
			dis = new DataInputStream(client.getInputStream());
			// 5.서버에서 보내온 메시지 읽기
			String revMsg = dis.readUTF();// 서버로부터 들어온 인코딩된 데이터인 %ED%DF%3D => '가' decoding된 데이터로 변환
			//System.out.println("서버에서 온 메시지 : "+ revMsg);
			String sendMsg = JOptionPane.showInputDialog("서버에서 온 메시지 : \n" + revMsg);
			//메시지리를 보내기 위한 스트림 연결
			dos = new DataOutputStream(client.getOutputStream());
			//메시지를 스트림에 기록
			dos.writeUTF(sendMsg);
			//스트림의 내용을 목적지(소켓)로 분출
			dos.flush();
			System.out.println("서버로 메시지 전송완료");
		} finally {
			if (dos != null) {
				dos.close();
			} // end if
			if (dis != null) {
				dis.close();
			} // end if
			if (client != null) {
				client.close();
			} // end if
		} // end finally
	}// SimpleClient

	public static void main(String[] args) {
		try {
			new SimpleMsgClient();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} // end catch
	}// main

}// class

package day0916;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class SimpleThreadChatClient extends JFrame implements ActionListener, Runnable {

	private JTextArea jtaTalkDisplay;
	private JScrollPane jspJtaTalkDisplay;
	private JTextField jtfTalk;

	private Socket client;// 서버에 접속하기 위한 소켓: TCP/IP 사용
	private DataInputStream disReadStream; // 접속자의 메시지를 읽기 위한 스트림 생성
	private DataOutputStream dosWriteStream; // 접속자에게 메시지를 보내기 위한 스트림 생성

	public SimpleThreadChatClient() {
		super(":::::::::채팅 클라이언트:::::::::");

		jtaTalkDisplay = new JTextArea();
		jspJtaTalkDisplay = new JScrollPane(jtaTalkDisplay);
		jtfTalk = new JTextField();

		jtaTalkDisplay.setEditable(false);

		jspJtaTalkDisplay.setBorder(new TitledBorder("대화"));
		jtfTalk.setBorder(new TitledBorder("대화입력"));

		add("Center", jspJtaTalkDisplay);
		add("South", jtfTalk);

		setBounds(100, 100, 400, 600);
//    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		// 디자인 종료

		// 서버로 연결
		try {
			connectToServer();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		jtfTalk.addActionListener(this);
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				try {
					if (disReadStream != null) {
						disReadStream.close();
					}
					if (dosWriteStream != null) {
						dosWriteStream.close();
					}
					if (client != null) {
						client.close();
					}
				} catch (IOException ie) {
					ie.printStackTrace();
				} finally {
					System.exit(0);
				} // end finally
			}// windowClosing
		});

//      setBounds(100, 100, 400, 600);
////      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//      setVisible(true);

		jtfTalk.requestFocus();

	}// SimpleChatServer

	/**
	 * 소켓을 생성하여 서버에 연결하고, 대화를 읽거나 보내기위한 스트림을 생성한다. 메세지를 무한루프로 읽어들이는 일
	 */
	public void connectToServer() throws UnknownHostException, IOException {
		String ip = JOptionPane.showInputDialog("서버의 ip주소를 입력", "192.168.10.");
		client = new Socket(ip, 50000);
		disReadStream = new DataInputStream(client.getInputStream());
		dosWriteStream = new DataOutputStream(client.getOutputStream());
		jtaTalkDisplay.setText(ip + "서버에 접속하였습니다.\n");

//		revMsg();// 메시지를 무한 루프로 읽어들임.
		//현재 객체와 Thread클래스를 has a 관계로 설정해서 객체화
		Thread t = new Thread(this);
		//start() -> run()
		t.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			sendMsg();
		} catch (IOException ie) {
			jtaTalkDisplay.append("대화상대가 접속중이 아닙니다.\n");
			scrollMove();
			ie.printStackTrace();
		} // end catch

	}// actionPerformed

	/**
	 * 메시지 읽기: 메시지를 계속 읽어들인다.
	 */
	@Override
	public void run() {
		try {
			while (true) {
				jtaTalkDisplay.append(disReadStream.readUTF() + "\n");
				scrollMove();
			} // end while
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this,	"대화상대가 접속을 종료하였습니다.");
			e.printStackTrace();
		}//end catch
	}// revMsg

	/**
	 * 메시지 보내기
	 * 
	 * @throws IOException
	 */
	public void sendMsg() throws IOException {
		String msg = "[ 이정우 ]: " + jtfTalk.getText();
		if (dosWriteStream != null) {
			jtaTalkDisplay.append(msg + "\n");
			scrollMove();
			dosWriteStream.writeUTF(msg);
			dosWriteStream.flush();
		} // end if
		jtfTalk.setText("");
	}// sendMsg

	private void scrollMove() {
		jspJtaTalkDisplay.getVerticalScrollBar().setValue(jspJtaTalkDisplay.getVerticalScrollBar().getMaximum());
	}// scrollMove

	public static void main(String[] args) {
		new SimpleThreadChatClient();
//      SimpleChatClient scc=new SimpleChatClient();
//      try {
//         scc.connectToServer();
//      } catch (UnknownHostException e) {
//         // TODO Auto-generated catch block
//         e.printStackTrace();
//      } catch (IOException e) {
//         // TODO Auto-generated catch block
//         e.printStackTrace();
//      }
	}// main

}// class

package day0915;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class SimpleChatServer extends JFrame implements ActionListener {
   
   private JTextArea jtaTalkDisplay;
   private JScrollPane jspJtaTalkDisplay;
   private JTextField jtfTalk;
   
   private ServerSocket server;
   private Socket client;
   private DataInputStream disReadStream;
   private DataOutputStream dosWriteStream;
   
   public SimpleChatServer() {
      super(":::::::::채팅 서버:::::::::");
      
      jtaTalkDisplay=new JTextArea();
      jspJtaTalkDisplay=new JScrollPane(jtaTalkDisplay);
      jtfTalk=new JTextField();
      
      jtaTalkDisplay.setEditable(false);
      
      jspJtaTalkDisplay.setBorder(new TitledBorder("대화"));
      jtfTalk.setBorder(new TitledBorder("대화입력"));
      
      add("Center",jspJtaTalkDisplay);
      add("South", jtfTalk);
      
      setBounds(100, 100, 400, 600);
//    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
      //디자인 끝
      
    //서버 실행
    try {
    	openServer();
    } catch (IOException e) {
    	// TODO Auto-generated catch block
    	e.printStackTrace();
    }
      //이벤트 등록
      jtfTalk.addActionListener(this);
      addWindowListener(new WindowAdapter() {
         @Override
         public void windowClosing(WindowEvent e) {
            try {
            if(disReadStream != null) { disReadStream.close();}//end if
            if(dosWriteStream != null) { dosWriteStream.close();}//end if
            if(client != null) { client.close();}//end if
            if(server != null) { server.close();}//end if
      } catch(IOException e1) {
         e1.printStackTrace();
      } finally {
         System.exit(0); //JVM에서 동작중인 모든 instance를 종료시킨다.
      }//end finally
      }//windowClosing
   });
      
//      setBounds(100, 100, 400, 600);
////      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//      setVisible(true);

      
      jtfTalk.requestFocus();
      
   }//SimpleChatServer
   
   @Override
   public void actionPerformed(ActionEvent e) {
      try {
         sendMsg();
      } catch(IOException e1) {
         JOptionPane.showMessageDialog(this, "대화상대가 접속상태가 아닙니다.");
         jtaTalkDisplay.append("대화상대가 접속중이 아닙니다.");
         e1.printStackTrace();
      }//end catch
   }//actionPerformed
   
   /**
    * 서버소켓을 생성하여 포트를 열고, 접속자소켓이 들어오면 메시지를 무한루프로 읽어들이는 코드
    */
   private void openServer() throws IOException{
      //1.서버소켓 생성
      server=new ServerSocket(50000);
      jtaTalkDisplay.setText("서버가 가동중입니다.\n 접속자 대기중");
      //3.접속자소켓을 받는다.
      client=server.accept();
      //4.메시지를 보내고, 읽기위한 스트림을 소켓에서 열기
      disReadStream=new DataInputStream(client.getInputStream());
      dosWriteStream=new DataOutputStream(client.getOutputStream());
      
      revMsg();
   }//openServer
   
   /**
    * 메시지 읽기
    * @throws IOException 
    */
   public void revMsg() throws IOException {
      while(true) {
         jtaTalkDisplay.append(disReadStream.readUTF()+"\n");
         scrollMove();
      }//end while
   }//revMsg
   
   /**
    * 메시지 보내기 J.T.F에서 이벤트가 발생하면 입력된 메시지를 내 대화창에 올리고, 접속자에게
    * 보낸다.
    * @throws IOException 
    */
   public void sendMsg() throws IOException {
      String sendMsg="[아직도 월요일] :"+jtfTalk.getText().trim();
      if(dosWriteStream != null) {
         jtaTalkDisplay.append(sendMsg+"\n"); //내 대화창에 메시지를 올리고
         scrollMove();
         dosWriteStream.writeUTF(sendMsg); //스트림에 대화기록
         dosWriteStream.flush(); //스트림에 남아있는 데이터를 소켓으로 기록
      }
      jtfTalk.setText("");
   }//sendMsg
   
   private void scrollMove() {
      jspJtaTalkDisplay.getVerticalScrollBar().setValue(
            jspJtaTalkDisplay.getVerticalScrollBar().getMaximum());
      
   }//scrollMove

   public static void main(String[] args) {
	   new SimpleChatServer();
//      SimpleChatServer scs=new SimpleChatServer();
//      try {
//         scs.openServer();
//      } catch (IOException e) {
//         e.printStackTrace();
//      }
   }//main

}//class

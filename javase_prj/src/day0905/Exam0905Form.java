package day0905;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class Exam0905Form extends JFrame {
	private DefaultListModel<String> dlm;
	private JList<String> jlistInfo;
	private JTextField jtfNum;
	private JTextField jtfName;
	private JTextField jtfAge;
	private JTextField jtfPhoneNum;
	private JButton jbtinput;
	private JButton jbtDelete;
	private JButton jbtOut;
	
	public Exam0905Form() {
		super("정보입력기");
		
		//모델 객체 생성
		dlm= new DefaultListModel<String>();
		//뷰 객체 생성(has a)
		jlistInfo = new JList<String>(dlm);
		
		//볼더
		LineBorder lb = new LineBorder(Color.BLUE);
		
		//컴포넌트들 생성
		JLabel jlNum = new JLabel("번호");
		JLabel jlName = new JLabel("이름");
		JLabel jlAge = new JLabel("나이");
		JLabel jlPhoneNum = new JLabel("전화번호");
		
		//볼더적용
		jlNum.setBorder(lb);
		jlName.setBorder(lb);
		jlAge.setBorder(lb);
		jlPhoneNum.setBorder(lb);
		
		jtfNum = new JTextField();
		jtfName = new JTextField();
		jtfAge = new JTextField();
		jtfPhoneNum = new JTextField();
		//볼더적용
		jtfNum.setBorder(lb);
		jtfName.setBorder(lb);
		jtfAge.setBorder(lb);
		jtfPhoneNum.setBorder(lb);
		
		jbtinput = new JButton("입력");
		jbtDelete = new JButton("삭제");
		jbtOut = new JButton("종료");
		
		jlistInfo.setBorder(lb);
		
		//색 넣기
		jbtinput.setBackground(Color.blue);
		jbtDelete.setBackground(Color.blue);
		jbtOut.setBackground(Color.blue);
		
		jbtinput.setForeground(Color.white);
		jbtDelete.setForeground(Color.white);
		jbtOut.setForeground(Color.white);
		
		
		//모델에 값 넣기
//		dlm.addElement("1,루피,20,010-1234-5678");
		
		//중앙 패널
		JPanel jpCenter = new JPanel();
		jpCenter.setLayout(new GridLayout(1,2));
		//왼쪽 패널(중앙에 넣을거)
		JPanel jpWest = new JPanel();
		jpWest.setLayout(new GridLayout(4,2));
		
		//오른쪽 패널(중앙에 넣을거)
		JPanel jpEast = new JPanel();
		jpEast.setLayout(new BorderLayout());
		
		//하단 패널
		JPanel jpSouth = new JPanel();
		jpSouth.setLayout(new FlowLayout());
		
		
		//레이아웃 설정
		setLayout(new BorderLayout());
		
		//왼쪽배치
		jpWest.add(jlNum);
		jpWest.add(jtfNum);
		jpWest.add(jlName);
		jpWest.add(jtfName);
		jpWest.add(jlAge);
		jpWest.add(jtfAge);
		jpWest.add(jlPhoneNum);
		jpWest.add(jtfPhoneNum);
		//오른쪽 배치
		jpEast.add(jlistInfo);
		//중앙배치
		jpCenter.add(jpWest);
		jpCenter.add(jpEast);
		//하단 배치
		jpSouth.add(jbtinput);
		jpSouth.add(jbtDelete);
		jpSouth.add(jbtOut);
		
		//윈도우 컴퍼넌트에 배치
		add(BorderLayout.CENTER, jpCenter);
		add(BorderLayout.SOUTH, jpSouth);
		

		Exam0905Event exEvent = new Exam0905Event(this);
		jbtinput.addActionListener(exEvent);
		jbtDelete.addActionListener(exEvent);
		jbtOut.addActionListener(exEvent);
		jlistInfo.addMouseListener(exEvent);
		
		
		setSize(800,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}//Exam0903

	public DefaultListModel<String> getDlm() {
		return dlm;
	}//getDlm

	public JList<String> getJlistInfo() {
		return jlistInfo;
	}//getJlistInfo

	public JTextField getJtfNum() {
		return jtfNum;
	}//getJtfNum

	public JTextField getJtfName() {
		return jtfName;
	}//getJtfName

	public JTextField getJtfAge() {
		return jtfAge;
	}//getJtfAge

	public JTextField getJtfPhoneNum() {
		return jtfPhoneNum;
	}//getJtfPhoneNum

	public JButton getJbtinput() {
		return jbtinput;
	}//getJbtinput

	public JButton getJbtDelete() {
		return jbtDelete;
	}//getJbtDelete

	public JButton getJbtOut() {
		return jbtOut;
	}//getJbtOut

	public void setDlm(DefaultListModel<String> dlm) {
		this.dlm = dlm;
	}//setDlm
	
	
}//class

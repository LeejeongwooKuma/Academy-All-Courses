package day0903;

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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Exam0903 extends JFrame implements ListSelectionListener{
	private DefaultListModel<String> dlm;
	private JList<String> jlistInfo;
	public Exam0903() {
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
		
		JTextField jtfNum = new JTextField();
		JTextField jtfName = new JTextField();
		JTextField jtfAge = new JTextField();
		JTextField jtfPhoneNum = new JTextField();
		//볼더적용
		jtfNum.setBorder(lb);
		jtfName.setBorder(lb);
		jtfAge.setBorder(lb);
		jtfPhoneNum.setBorder(lb);
		
		JButton jbtinput = new JButton("입력");
		JButton jbtDelete = new JButton("삭제");
		JButton jbtChange = new JButton("변경");
		JButton jbtOut = new JButton("종료");
		
		jlistInfo.setBorder(lb);
		
		//색 넣기
		jbtinput.setBackground(Color.blue);
		jbtDelete.setBackground(Color.blue);
		jbtChange.setBackground(Color.blue);
		jbtOut.setBackground(Color.blue);
		
		jbtinput.setForeground(Color.white);
		jbtDelete.setForeground(Color.white);
		jbtChange.setForeground(Color.white);
		jbtOut.setForeground(Color.white);
		
		
		//모델에 값 넣기
		dlm.addElement("1,루피,20,010-1234-5678");
		
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
		jpSouth.add(jbtChange);
		jpSouth.add(jbtOut);
		
		//윈도우 컴퍼넌트에 배치
		add(BorderLayout.CENTER, jpCenter);
		add(BorderLayout.SOUTH, jpSouth);
		
		setSize(800,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}//Exam0903
	@Override//??
	public void valueChanged(ListSelectionEvent e) {
	}
	public static void main(String[] args) {
		Exam0903 ex = new Exam0903();
	}//main

}//class

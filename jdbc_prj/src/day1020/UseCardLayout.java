package day1020;

import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class UseCardLayout extends JFrame implements ActionListener {

	private JButton jbtnA, jbtnB, jbtnC;
	private JPanel jpNorth, jpCenter, jpA, jpB, jpC;
	private CardLayout cl;
	
	
	public UseCardLayout() {
		super("카드레이아웃");
		jbtnA  = new JButton("디자인 A");
		jbtnB  = new JButton("디자인 B");
		jbtnC  = new JButton("디자인 C");
		
		jpNorth = new JPanel();
		jpNorth.add(jbtnA);
		jpNorth.add(jbtnB);
		jpNorth.add(jbtnC);
		
		jpCenter = new JPanel();
		cl = new CardLayout();//카드레이아웃 생성
		jpCenter.setLayout(cl);//패널 등록

		jpA = new JPanel();//패널, 패널을 상속받은 자식 클래스
		jpA.add(new JLabel("패널A"));
		jpA.add(new JLabel("클릭"));
		
		jpB = new JPanel();
		jpB.setLayout(new GridLayout(3,1));
		jpB.add(new JTextField("이름"));
		jpB.add(new JTextField("나이"));
		jpB.add(new JTextField("클릭"));
		
		jpC = new JPanel();
		jpC.add(new JLabel("이름"));
		jpC.add(new JTextField(10));
		jpC.add(new JButton("입력"));
		
		jpA.setBorder(new TitledBorder("입력A"));
		jpB.setBorder(new TitledBorder("입력B"));
		jpC.setBorder(new TitledBorder("입력C"));
		
		//메인 패널에 등록
		jpCenter.add(jpA,"inputA");
		jpCenter.add(jpB,"inputB");
		jpCenter.add(jpC,"inputC");
		
		//처음 보여줄 패널 설정
		cl.show(jpCenter, "inputA");
		
		add("North", jpNorth);
		add("Center", jpCenter);
		
		jbtnA.addActionListener(this);
		jbtnB.addActionListener(this);
		jbtnC.addActionListener(this);
		
		
		setBounds(100, 100, 500, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
	}//UseCardLayout
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == jbtnA) {
			//이벤트가 발생하면 메인패널에 보여질 등록해 놓은 Panel에 아이디를 설정한다. 
			cl.show(jpCenter, "inputA");
		}//end if
		if(ae.getSource() == jbtnB) {
			cl.show(jpCenter, "inputB");
		}//end if
		if(ae.getSource() == jbtnC) {
			cl.show(jpCenter, "inputC");
		}//end if
	}//actionPerformed

	public static void main(String[] args) {
		new UseCardLayout();
	}//main

}//class

package day0903;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

//1.윈도우 컴포넌트 상속
public class UseBorder extends JFrame {
	public UseBorder() {
		super("여러개의 Layout 사용");
		//2.일반컴포넌트를 생성
		//BorderLayout에 North에 들어갈 컴포넌트
		JLabel jlbName = new JLabel("이름");
		JTextField jtfName = new JTextField(20);
		JButton jbtnInput = new JButton("입력");
		//글꼴객체 생성
		Font font = new Font("휴먼편지체", Font.BOLD, 25);
		//컴포넌트에 글꼴 적용
		jlbName.setFont(font);
		jtfName.setFont(font);
		jbtnInput.setFont(font);
		
		//BorderLayout에 Center에 들어갈 컴포넌트
		JTextArea jtaNameView = new JTextArea();
//		TextArea jtaNameView = new TextArea();
		jtaNameView.setFont(new Font("굴림체", Font.ITALIC|Font.BOLD, 30));
		
		//Foreground color - (글자색 변경)
		jtfName.setForeground(Color.blue);
		jlbName.setForeground(new Color(0, 129, 0));
		jbtnInput.setForeground(new Color(0xFF0000));
		jtaNameView.setForeground(new Color(0x326AB5));
		
		
		//Background color-바닥색 변경
		jtfName.setBackground(Color.gray);
		jlbName.setOpaque(true);//아래에서 적용 안되니 불투명도를 활성화해야 바닥색이 설정되어 보여진다.
		jlbName.setBackground(new Color(0xB87D0C));//라벨은 바닥색 적용 안됨 -> 불투명도가 사용된 컴포넌트라서 그럼
		jbtnInput.setBackground(new Color(0xE0E0E0));
		jtaNameView.setBackground(new Color(0xC7B571));
		
		//3.컨테이너 컴포넌트를 생성
		JPanel jpNorth = new JPanel();
		JScrollPane jspJtaNameView = new JScrollPane(jtaNameView);//has a
		
		//JScrollPane에 Border설정
//		jspJtaNameView.setBorder(new TitledBorder("이름 출력"));
		jspJtaNameView.setBorder(new LineBorder(Color.red));
		jpNorth.setBorder(new TitledBorder("이름 입력"));
		
		
		//4.배치관리자를 설정
		setLayout(new BorderLayout()); //Frame의 Layout
		jpNorth.setLayout(new FlowLayout());//Panel의 Layout
		
		//5.컴포넌트를 배치
		//컨테이너 컴포넌트에 일반 컴포넌트 배치
		jpNorth.add(jlbName);
		jpNorth.add(jtfName);
		jpNorth.add(jbtnInput);
		
		//윈도우 컴포넌트에 컴포넌트를 배치
		add(BorderLayout.NORTH, jpNorth);//North에 Panel 배치
//		add(BorderLayout.CENTER, jtaNameView);//Center JtextArea배치
		add(BorderLayout.CENTER, jspJtaNameView);//Center has a관계를 가진 JScrollpane 배치
		//6.윈도우 크기 설정
		setSize(500,500);
		//7.윈도우 가시화
		setVisible(true);
		//8.윈도우 종료 처리
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}//MultipleLayout
	public static void main(String[] args) {
		new UseBorder();
		
	}

}

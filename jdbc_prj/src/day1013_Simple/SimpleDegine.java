package day1013_Simple;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SimpleDegine extends JFrame{
	JLabel jlbNum;
	JLabel jlbName;
	JLabel jlbEmail;
	JLabel jlbPhone;
	JLabel jlbImage;
	JLabel jlbIntro;
	
	JTextField jtfNum;
	JTextField jtfName;
	JTextField jtfEmail;
	JTextField jtfPhone;
	
	JButton jbtSelect;
	JButton jbtInsert;
	JButton jbtSearch;
	JButton jbtExit;
	
	JTextArea jtaIntro;
	
	public SimpleDegine() {
		super("짜투리 시간");
		jlbNum = new JLabel("번호");
		jlbName = new JLabel("이름");
		jlbEmail = new JLabel("이메일");
		jlbPhone = new JLabel("전화번호");
		jlbIntro = new JLabel("소개");
		jlbImage = new JLabel("이미지");
		jtaIntro = new JTextArea(5,20);
		
		jtfNum = new JTextField(20);
		jtfName = new JTextField(20);
		jtfEmail = new JTextField(20);
		jtfPhone = new JTextField(20);
		
		jbtSelect = new JButton("선택");
		jbtInsert = new JButton("추가");
		jbtSearch = new JButton("검색");
		jbtExit = new JButton("종료");
		
		
		JPanel jpCenter = new JPanel();
		JPanel jpSouth = new JPanel();
		
//		jpSouth.setLayout(new FlowLayout(FlowLayout.CENTER));
		jpCenter.setLayout(new GridBagLayout());
		GridBagConstraints gbc=new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		jpCenter.add(jlbNum, gbc);
		gbc.gridx = 1;
		gbc.gridy = 0;
		jpCenter.add(jtfNum, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		jpCenter.add(jlbName, gbc);
		gbc.gridx = 1;
		gbc.gridy = 1;
		jpCenter.add(jtfName, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		jpCenter.add(jlbEmail, gbc);
		gbc.gridx = 1;
		gbc.gridy = 2;
		jpCenter.add(jtfEmail, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		jpCenter.add(jlbPhone, gbc);
		gbc.gridx = 1;
		gbc.gridy = 3;
		jpCenter.add(jtfPhone, gbc);
		
		
		gbc.gridx = 0;
		gbc.gridy = 4;
		jpCenter.add(jlbIntro, gbc);
		gbc.gridx = 1;
		gbc.gridy = 4;
//		gbc.fill = GridBagConstraints.BOTH; 
//		gbc.weighty = 7;
		jpCenter.add(jtaIntro, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.gridheight = 3;
		jpCenter.add(jlbImage, gbc);
		gbc.gridx = 2;
		gbc.gridy = 3;
		gbc.gridheight = 1;
		jpCenter.add(jbtSelect, gbc);
		
		jpSouth.add(jbtInsert);
		jpSouth.add(jbtSearch);
		jpSouth.add(jbtExit);
		
		
		
		add("Center", jpCenter);
		add("South", jpSouth);
		setBounds(100, 100, 500, 300);
		setVisible(true);
	}//simpleDegine
	
}

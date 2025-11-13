package day0905;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class ParentFrame extends JFrame implements ActionListener {
	private JButton jbtnDialogOpen,jbtnDialogOpen2;
	
	
	public ParentFrame() {
		super("부모창");

		jbtnDialogOpen = new JButton("모달");
		jbtnDialogOpen2 = new JButton("비모달");
		
		JPanel jpCenter = new JPanel();
		jpCenter.setBorder(new TitledBorder("다이얼로그"));
		
		jpCenter.add(jbtnDialogOpen);
		jpCenter.add(jbtnDialogOpen2);
		
		add("Center", jpCenter);
		
		jbtnDialogOpen.addActionListener(this);
		jbtnDialogOpen2.addActionListener(this);
		
		setBounds(100, 100, 400, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}// ParentFrame

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == jbtnDialogOpen) {
			useModel();
		}//end if

		if(ae.getSource() == jbtnDialogOpen2) {
			useNonModel();
		}//end if

	}//actionPerformed

	public void useModel() {
		new ChildDialog(this, true);
	}//useModel
	
	public void useNonModel() {
		new ChildDialog(this, false);
	}//useNonModel
	
	
	public static void main(String[] args) {
		new ParentFrame();
	}// main

}// class

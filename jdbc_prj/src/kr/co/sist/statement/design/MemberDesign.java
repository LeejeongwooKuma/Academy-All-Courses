package kr.co.sist.statement.design;

import java.awt.GridLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

import kr.co.sist.statement.dto.MemberDTO;
import kr.co.sist.statement.event.MemberEvent;

public class MemberDesign extends JFrame{

	private MemberLeftPanel mlp;
	private MemberRightPanel mrp;
	private MemberSouthPanle msp;
	
	public MemberDesign() {
		super("회원관리");
		JPanel jpCenter = new JPanel();
		
		mlp = new MemberLeftPanel();
		msp = new MemberSouthPanle();
		mrp = new MemberRightPanel();

		//이벤트 등록
		MemberEvent me = new MemberEvent(this);
		msp.setMemberEvent(me);//South Panel에 이벤트 등록
		mrp.setMemberEvent(me);//Right Panel에 이벤트 등록
		msp.addEvent();
		
		
		jpCenter.setLayout(new GridLayout(1,2));
		
		jpCenter.add(mlp);
		jpCenter.add(mrp);
		
		add("Center", jpCenter);
		add("South", msp);
		
		addWindowListener(me);
		setBounds(100, 100, 600, 300);
		setVisible(true);
	}//MemberDesign

	public MemberLeftPanel getMlp() {
		return mlp;
	}

	public MemberRightPanel getMrp() {
		return mrp;
	}

	public MemberSouthPanle getMsp() {
		return msp;
	}
	
	
	
}//class

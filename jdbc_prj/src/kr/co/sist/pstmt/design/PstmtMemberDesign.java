package kr.co.sist.pstmt.design;

import java.awt.GridLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

import kr.co.sist.pstmt.event.PstmtMemberEvent;
import kr.co.sist.statement.dto.MemberDTO;
import kr.co.sist.statement.event.MemberEvent;

public class PstmtMemberDesign extends JFrame{

	private PstmtMemberLeftPanel mlp;
	private PstmtMemberRightPanel mrp;
	private PstmtMemberSouthPanle msp;
	
	public PstmtMemberDesign() {
		super("대호갱 관리프로그램");
		JPanel jpCenter = new JPanel();
		
		mlp = new PstmtMemberLeftPanel();
		msp = new PstmtMemberSouthPanle();
		mrp = new PstmtMemberRightPanel();

		//이벤트 등록
		PstmtMemberEvent me = new PstmtMemberEvent(this);
		msp.setMemberEvent(me);//South Panel에 이벤트 등록
		mrp.setMemberEvent(me);//Right Panel에 이벤트 등록
		msp.addEvent();
		
		
		jpCenter.setLayout(new GridLayout(1,2));
		
		jpCenter.add(mlp);
		jpCenter.add(mrp);
		
		add("Center", jpCenter);
		add("South", msp);
		
		addWindowListener(me);
		setBounds(100, 100, 1200, 300);
		setVisible(true);
	}//MemberDesign

	public PstmtMemberLeftPanel getMlp() {
		return mlp;
	}

	public PstmtMemberRightPanel getMrp() {
		return mrp;
	}

	public PstmtMemberSouthPanle getMsp() {
		return msp;
	}
	
	
	
}//class

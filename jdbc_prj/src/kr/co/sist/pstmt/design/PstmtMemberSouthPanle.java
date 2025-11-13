package kr.co.sist.pstmt.design;

import javax.swing.JButton;
import javax.swing.JPanel;

import kr.co.sist.pstmt.event.PstmtMemberEvent;
import kr.co.sist.statement.event.MemberEvent;

public class PstmtMemberSouthPanle extends JPanel {

	private JButton jbtnAdd, jbtnModify, jbtnRemove, jbtnClose;
	private PstmtMemberEvent me;

	public PstmtMemberSouthPanle() {
		jbtnAdd = new JButton("추가");
		jbtnModify = new JButton("변경");
		jbtnRemove = new JButton("삭제");
		jbtnClose = new JButton("종료");
		
		add(jbtnAdd);
		add(jbtnModify);
		add(jbtnRemove);
		add(jbtnClose);
		
	}// MemberSouthPanle

	public void setMemberEvent(PstmtMemberEvent me) {
		this.me = me;
	}// setEvent

	/**
	 * 버튼에 이벤트를 등록하는 일. setMemberEvent 이후에 호출되어야 한다.
	 */
	public void addEvent() {
		if(me != null) {
		jbtnAdd.addActionListener(me);
		jbtnModify.addActionListener(me);
		jbtnRemove.addActionListener(me);
		jbtnClose.addActionListener(me);
		}// end if
	}//addEvent

	public JButton getJbtnAdd() {
		return jbtnAdd;
	}

	public JButton getJbtnModify() {
		return jbtnModify;
	}

	public JButton getJbtnRemove() {
		return jbtnRemove;
	}

	public JButton getJbtnClose() {
		return jbtnClose;
	}


}// class

package kr.co.sist.statement.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import kr.co.sist.statement.design.MemberDesign;
import kr.co.sist.statement.design.MemberLeftPanel;
import kr.co.sist.statement.dto.MemberDTO;
import kr.co.sist.statement.service.MemberService;

public class MemberEvent extends WindowAdapter implements ActionListener,MouseListener /*ListSelectionListener*/ {
	
	private MemberDesign md;
	private MemberService ms;
	
	public MemberEvent(MemberDesign md) {
		this.md = md;
		ms = new MemberService();
	}//MemberEvent
	
	@Override
	public void windowClosing(WindowEvent e) {
		md.dispose();
	}//windowClosing

//	private boolean changeFlag;
//	@Override
//	public void valueChanged(ListSelectionEvent lse) {
//		if(changeFlag) {
////			useSplit();//DB를 사용하지 않고 Split 사용한 방법
//			searchOneMember();//DB를 연동해서 출력하는 방법..굳이.. 느낌. 배울려고 해봄.
//			}//end if
//		changeFlag = !changeFlag;
//	}//valueChanged
	
	public void searchOneMember() {
		DefaultListModel<String> dlm =  md.getMrp().getDlmMember();
		JList<String> jl = md.getMrp().getJlMember();
		String selectMember = dlm.elementAt(jl.getSelectedIndex());
		String[] memberArrData = selectMember.split(",");
		
		//선택한 회원의 번호 얻기 
		int memberNum = Integer.parseInt(memberArrData[0]);
		MemberDTO mDTO = ms.searchOneMember(memberNum);//회원번호로 검색한 결과가 DTO에 저장 후 반환
		
		MemberLeftPanel mlp = md.getMlp();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a");
		mlp.getJtfNum().setText(String.valueOf(mDTO.getNum()));
		mlp.getJtfName().setText(mDTO.getName());
		mlp.getJtfAge().setText(String.valueOf(mDTO.getAge()));
		mlp.getJtfGender().setText(String.valueOf(mDTO.getGender()));
		mlp.getJtfTel().setText(String.valueOf(mDTO.getTel()));
		mlp.getJtfInputDate().setText(sdf.format(mDTO.getInput_date()));
		
	}//searchOneMember

	public void useSplit() {
		DefaultListModel<String> dlm =  md.getMrp().getDlmMember();
		JList<String> jl = md.getMrp().getJlMember();
		String selectMember = dlm.elementAt(jl.getSelectedIndex());
//		System.out.println(selectMember);
		String[] memberArrData = selectMember.split(",");
		//배열의 데이터를 JTextField 설정
		MemberLeftPanel mlp = md.getMlp();
		mlp.getJtfNum().setText(memberArrData[0]);
		mlp.getJtfName().setText(memberArrData[1]);
		mlp.getJtfAge().setText(memberArrData[2]);
		mlp.getJtfGender().setText(memberArrData[3]);
		mlp.getJtfTel().setText(memberArrData[4]);
		mlp.getJtfInputDate().setText(memberArrData[5]);
	}// end useSplit
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == md.getMsp().getJbtnAdd()) {//추가
			try {
				addMember();
			}catch(NumberFormatException nfe) {
				JOptionPane.showMessageDialog(md, "나이는 정수로만 입력가능합니다. ");
			}
		}//end if
		
		if(ae.getSource() == md.getMsp().getJbtnModify()) {//변경
			try {
				modifyMember();
			}catch(NumberFormatException nfe) {
				JOptionPane.showMessageDialog(md, "나이는 정수로만 입력가능합니다. ");
			}

		}//end if
		
		if(ae.getSource() == md.getMsp().getJbtnRemove()) {//삭제
			try {
				removeMember();
			}catch(NumberFormatException nfe) {
				JOptionPane.showMessageDialog(md, "나이는 정수로만 입력가능합니다. ");
			}// end catch
			
		}//end if
		
	}//actionPerformed
	
	public void removeMember() throws NumberFormatException{
		MemberLeftPanel mlp = md.getMlp();
							
		if(mlp.getJtfNum().getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(md, "회원을 먼저 선택한 후 정보를 삭제해주세요.");
			return;
		}//end if
		
//		boolean deleteFlag = false;
		switch(JOptionPane.showConfirmDialog(md, mlp.getJtfNum().getText()+"번 회원 정보를 정말 삭제하시겠습니까?")) {
		case JOptionPane.OK_OPTION :
//			deleteFlag = true;
			break;
			
		case JOptionPane.NO_OPTION :
		case JOptionPane.CANCEL_OPTION:
		default:
			return;
		}//end switch
		
//		if(!deleteFlag) { //sowConfirmDialog에서 "아니오", "취소"를 누른 경우,
//			return;
//		}// end if

			//1.사용자가 입력한 값을 얻고
		int selectNum = Integer.parseInt(mlp.getJtfNum().getText().trim());
		
		int flag = ms.removeMember(selectNum);//회원삭제 작업수행
		
		String outputMsg = "문제가 발생했습니다. 잠시 후 다시 시도해주세요.";
		
		switch( flag ) {
		case 0 : outputMsg = selectNum+"번 회원은 존재하지 않습니다."; break;
		case 1 : outputMsg = selectNum+"번 회원정보를 삭제하였습니다."; break;
		}//end switch
		
		JOptionPane.showMessageDialog(md, outputMsg);
		//변경된 데이터를 바로 반영
		searchAllMember();
		resetInputField();
	}//removeMember
	
	public void modifyMember() throws NumberFormatException{
		
		MemberLeftPanel mlp = md.getMlp();

		if(mlp.getJtfNum().getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(md, "회원을 먼저 선택한 후 정보를 변경해주세요.");
			return;
		}//end if

			//1.사용자가 입력한 값을 얻고
		MemberDTO mDTO = new MemberDTO();
		mDTO.setNum(Integer.parseInt(mlp.getJtfNum().getText().trim()));
		mDTO.setAge(Integer.parseInt(mlp.getJtfAge().getText().trim()));
		mDTO.setTel(mlp.getJtfTel().getText().trim());
		
		int flag = ms.modifyMember(mDTO);
		String outputMsg = "문제가 발생했습니다. 잠시 후 다시 시도해주세요.";
		
		switch( flag ) {
		case 0 : outputMsg = mDTO.getNum()+"번 회원은 존재하지 않습니다."; break;
		case 1 : outputMsg = mDTO.getNum()+"번 회원정보를 변경하였습니다."; break;
		}
		
		JOptionPane.showMessageDialog(md, outputMsg);
		//변경된 데이터를 바로 반영
		searchAllMember();
		resetInputField();
	}//modifyMember
	
	public void addMember() throws NumberFormatException {
		
		MemberLeftPanel mlp = md.getMlp();
		//1.사용자가 입력한 값을 얻고
		MemberDTO mDTO = new MemberDTO();
		mDTO.setName(mlp.getJtfName().getText().trim());
		mDTO.setAge(Integer.parseInt(mlp.getJtfAge().getText().trim()));
		mDTO.setGender(mlp.getJtfGender().getText().trim());
		mDTO.setTel(mlp.getJtfTel().getText().trim());
		
		//2.DB에 추가한 후 결과를 보여준다.
		String msg = mDTO.getName()+"회원 정보를 추가할 수 없습니다.";
		if(ms.addMember(mDTO)) {
			msg = mDTO.getName()+"회원 정보가 성공적으로 추가되었습니다.";
			searchAllMember();//리스트를 갱신
		}//end if
		JOptionPane.showMessageDialog(md, msg);
		
		resetInputField();
	}//addMember
	
	private void resetInputField() {
		MemberLeftPanel mlp = md.getMlp();
		//3.입력칸을 초기화
				mlp.getJtfName().setText("");
				mlp.getJtfAge().setText("");
				mlp.getJtfGender().setText("");
				mlp.getJtfTel().setText("");
				mlp.getJtfName().requestFocus();
	}//resetInputField

	/**
	 * 모든 회원을 검색하여 dlm에 설정하는 일
	 */
	public void searchAllMember() {
		List<String> listMemberData = ms.searchAllMember();
		
		DefaultListModel<String> dlm = md.getMrp().getDlmMember();
		dlm.clear();//리스트모델을 초기화. 이게 없으면 2번 추가하면 추가 했던 거 또 추가함.
		
		if(listMemberData.isEmpty()) {//검색된 결과 없음.
			dlm.addElement("집가고 싶다.");//리스트모델에 조회결과를 추가
		}// end if
		
		for ( String recordData : listMemberData ) {
			dlm.addElement(recordData);//리스트모델에 조회결과를 추가
		}//end for
		
	}// searchAllMember

	@Override
	public void mouseClicked(MouseEvent me) {
		switch (me.getButton()) {
		case MouseEvent.BUTTON1 ://왼쪽 버튼 클릭
			try {
			searchOneMember();
			} catch(NumberFormatException nfe) {
				JOptionPane.showMessageDialog(md, "회원 추가 먼저 하세요.");
			}
		}// end switch
	}//end mouseClicked

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}
	
}//class

package day1016;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import day1014.Work1013Design;

public class ZipcodeEvt extends WindowAdapter implements MouseListener, ActionListener{
	private ZipcodeFrm zf;
	private List<ZipcodeDTO> listZip;
	
	public ZipcodeEvt( ZipcodeFrm zf ) {
		this.zf = zf; //has a 관계 만들기

	}//ZipcodeEvt

	public void searchZipcode() {
		String dong = zf.getJtfDong().getText().trim();
		if ( dong.isEmpty() ) {
			JOptionPane.showMessageDialog(zf, "동은 필수 입력입니다.");
			return;
		}//end if
		
		ZipcodeService zs = new ZipcodeService();
		List<ZipcodeDTO> listZip =  zs.searchStmtZipcode(dong);//SQLInjection에 취약
//		List<ZipcodeDTO> listZip =  zs.searchPstmtZipcode(dong);//SQLInjection에 안전
		
		this.listZip = listZip;
		
		DefaultTableModel dtmZipcode = zf.getDtmZipcode();
		
		dtmZipcode.setRowCount(0);
		String[] rowData = null;
		
		StringBuilder tempAddr = new StringBuilder();
		for(ZipcodeDTO zDTO : listZip) {
			tempAddr
			.append(zDTO.getSido()).append(" ")
			.append(zDTO.getGugun()).append(" ")
			.append(zDTO.getDong()).append(" ")
			.append(zDTO.getBunji());

			rowData = new String[2];
			rowData[0] = zDTO.getZipcode();
			rowData[1] = tempAddr.toString();
			
			dtmZipcode.addRow(rowData);
			
			//검색에 사용한 동을 초기화
			tempAddr.delete(0, tempAddr.length());
			
		}//end for
		
		zf.getJtfDong().setText("");
		zf.getJtfDong().requestFocus();
		
	}//searchZipcode
	
	public void sendZipcode() {
		//선택한 행의 zipcode의 값을 부모창으로 보내기
		int selectedRow = zf.getJtaZipcode().getSelectedRow();
		Work1013Design wd = zf.getWd();
		//List에서 선택한 행의 방의 값을 얻고 
		ZipcodeDTO zDTO = listZip.get(selectedRow);
		//부모창에 컴포넌트에 값을 설정하고
		wd.getJtfZipcode().setText(zDTO.getZipcode());
		wd.getJtfAddr().setText(zDTO.getSido() + " " + zDTO.getGugun() + " " + 
		zDTO.getDong());
		
		//자식창을 닫는다.
		zf.dispose();
		
	}//sendZipcode
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		searchZipcode();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		sendZipcode();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		super.windowClosed(e);
	}
	
}//class

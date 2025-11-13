package kr.co.sist.pstmt.service;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import day1021.CstmtMemberDAO;
import kr.co.sist.pstmt.dao.PstmtMemberDAO;
import kr.co.sist.statement.dto.MemberDTO;

public class PstmtMemberService {
	
	public PstmtMemberService() {
	}
	
	public boolean addMember( MemberDTO mDTO) {
		boolean flag = false;//기본은 실패 상태
			
//			PstmtMemberDAO pmDao=PstmtMemberDAO.getInstance();
			CstmtMemberDAO pmDao=CstmtMemberDAO.getInstance();
			
			
			try {
				flag = pmDao.insertMember(mDTO) == 1;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}////DB에 추가 작업이 문제가 없다면
		
		return flag;
	}// addMember
	
	/**
	 * 모든 회원 검색, DTO에 저장된 데이터를 문자열로 반환
	 * @return
	 */
	public List<MemberDTO> searchAllMember() {
		List<MemberDTO> list = null;
		
		try {
//			PstmtMemberDAO pmDao=PstmtMemberDAO.getInstance();
			CstmtMemberDAO pmDao =CstmtMemberDAO.getInstance();
			list = pmDao.selctAllMember();
		} catch (SQLException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}//end catch
		return list;
	}//searchAllMember
	
	public MemberDTO searchOneMember(int num) {
		MemberDTO mDTO = null;
		try {
//			PstmtMemberDAO pmDao=PstmtMemberDAO.getInstance();
			CstmtMemberDAO pmDao =CstmtMemberDAO.getInstance();
			mDTO = pmDao.selectOneMember(num);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}//end catch
		
		return mDTO;
	}// searchOneMember
	
	/**
	 * 회원정보를 변경 - 0 : 회원번호 없음, n - 회원번호 n개 있음, 2- DB의 문제 
	 * @param mDTO
	 * @return
	 */
	public int modifyMember(MemberDTO mDTO) {
		int flag = 0;
		try {
//			PstmtMemberDAO pmDao=PstmtMemberDAO.getInstance();
			CstmtMemberDAO pmDao=CstmtMemberDAO.getInstance();
			flag = pmDao.updateMember(mDTO);
			//DB테이블에 회원번호가 PK가 아니라면 flag가 n개가 반활될 수 있고, 그 경우에는 1로 재설정한다.
		} catch(IOException ie) {
			ie.printStackTrace();
		}
		catch (SQLException e) {
			flag = 2;
			e.printStackTrace();
		}// end catch
		
		return flag;
	}//modifyMember
	
	/**
	 * 회원번호를 입력받아서 해당 회원을 삭제하는 일
	 * @param memberNum
	 * @return
	 */
	public int removeMember(int memberNum) {
		int flag = 0;
		try {
//			PstmtMemberDAO pmDao=PstmtMemberDAO.getInstance();
			CstmtMemberDAO pmDao=CstmtMemberDAO.getInstance();
			flag = pmDao.deleteMember(memberNum);
			//DB테이블에 회원번호가 PK가 아니라면 flag가 n개가 반활될 수 있고, 그 경우에는 1로 재설정한다.
		}catch (IOException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			flag = 2;
			e.printStackTrace();
		}// end catch
		
		return flag;
	}//removeMember
	
	
}//class

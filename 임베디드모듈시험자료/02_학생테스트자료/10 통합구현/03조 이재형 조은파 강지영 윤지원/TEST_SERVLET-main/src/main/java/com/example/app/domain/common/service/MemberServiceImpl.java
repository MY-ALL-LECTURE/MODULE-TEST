package com.example.app.domain.common.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.example.app.domain.common.dao.MemberDao;
import com.example.app.domain.common.dao.MemberDaoImpl;
import com.example.app.domain.common.dao.SessionDao;
import com.example.app.domain.common.dao.SessionDaoImpl;
import com.example.app.domain.common.dao.common.ConnectionPool;
import com.example.app.domain.common.dto.MemberDto;
import com.example.app.domain.common.dto.SessionDto;

public class MemberServiceImpl implements MemberService {

	private MemberDao memberDao;
	private SessionDao sessionDao;
	private ConnectionPool connectionPool;

	private static MemberService instance;

	public static MemberService getInstance() throws Exception {
		if (instance == null)
			instance = new MemberServiceImpl();
		return instance;
	}

	private MemberServiceImpl() throws Exception {

		memberDao = MemberDaoImpl.getInstance();
		sessionDao = SessionDaoImpl.getInstance();
		this.connectionPool = ConnectionPool.getInstance();
	}

	@Override
	public boolean deleteMember(int id) throws Exception {
		connectionPool.txStart();
		memberDao.delete(id);
		connectionPool.txCommit();
		return true;
	}

	@Override
	public boolean register(MemberDto memberDto) throws Exception {
		connectionPool.txStart();
		boolean isSuccess = memberDao.insert(memberDto);
		connectionPool.txCommit();
		return isSuccess;

	}

	@Override
	public boolean login(String username, String password, HttpSession session) throws Exception {

		connectionPool.txStart();
		// member table에 해당 member가 존재하는가?
		// 해당 member의 password는 일치한가?
		MemberDto memberDto = memberDao.select(username, password);
		System.out.println(memberDto);
		if (memberDto == null)
			return false;
		// session에 해당 member가 존재하는가?
		boolean isExists = sessionDao.exists(memberDto);
		if (isExists) {
			return false;
		}
		// session에 member 저장!!
		boolean isSuccess = sessionDao.insert(memberDto);
		// sessionDto 가져오기
		SessionDto sessionDto = sessionDao.select(memberDto);
		// client session에 sessionId 저장!!
		session.setAttribute("session_id", sessionDto.getId());

		connectionPool.txCommit();
		return isSuccess;
	}

	@Override
	public boolean logout(int sessionId) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<MemberDto> selectAll() throws Exception {
		connectionPool.txStart();
		List<MemberDto> list = memberDao.selectAll();
		connectionPool.txCommit();
		return list;
	}

	@Override
	public MemberDto selectMember(String username) throws Exception {
		connectionPool.txStart();
		MemberDto dto = memberDao.selectMember(username);
		connectionPool.txCommit();
		return dto;
	}

	@Override
	public boolean update(String username, String password, String email, String phone) throws Exception {
		connectionPool.txStart();
		memberDao.update(username, password, email, phone);

		connectionPool.txCommit();
		return true;
	}
}

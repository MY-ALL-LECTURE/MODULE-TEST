package com.example.app.domain.common.dao;

import com.example.app.domain.common.dao.common.CommonDao;
import com.example.app.domain.common.dto.MemberDto;
import com.example.app.domain.common.dto.SessionDto;

public class SessionDaoImpl extends CommonDao implements SessionDao {

	private static SessionDao instance;

	public static SessionDao getInstance() throws Exception {
		if (instance == null)
			instance = new SessionDaoImpl();
		return instance;
	}

	private SessionDaoImpl() throws Exception {
		System.out.println("[DAO] SessionDaoImpl's INIT " + conn);

	}

	@Override
	public boolean exists(MemberDto dto) throws Exception {
		boolean exists = false;
		try {
			pstmt = conn.prepareStatement("select exists (select * from session where member_id=?)");
			int memberId = dto.getId();
			pstmt.setInt(1, memberId);
			rs = pstmt.executeQuery();

			if (rs != null && rs.next())
				exists = rs.getInt(1) > 0;
		} finally {
			freeConnection(pstmt, rs);
		}

		return exists;
	}

	@Override
	public boolean insert(MemberDto memberDto) throws Exception {
		pstmt = conn.prepareStatement("insert into session values(null, ?)");
		int memberId = memberDto.getId();
		pstmt.setInt(1, memberId);
		int result = pstmt.executeUpdate();

		freeConnection(pstmt);
		return result > 0;
	}

	@Override
	public SessionDto select(MemberDto memberDto) throws Exception {
		pstmt = conn.prepareStatement("select * from session where member_id=?");
		int memberId = memberDto.getId();
		pstmt.setInt(1, memberId);
		rs = pstmt.executeQuery();
		SessionDto sessionDto = null;
		if (rs != null && rs.next()) {
			sessionDto = new SessionDto();
			sessionDto.setId(rs.getInt("id"));
			sessionDto.setMember_id(rs.getInt("member_id"));
		}
		return sessionDto;
	}

}

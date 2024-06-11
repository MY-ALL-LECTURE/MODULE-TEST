package com.example.app.domain.common.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.app.domain.common.dao.common.CommonDao;
import com.example.app.domain.common.dto.MemberDto;

public class MemberDaoImpl extends CommonDao implements MemberDao {

	private static MemberDao instance;

	public static MemberDao getInstance() throws Exception {
		if (instance == null)
			instance = new MemberDaoImpl();
		return instance;
	}

	private MemberDaoImpl() throws Exception {
		System.out.println("[DAO] MemberDaoImpl's INIT " + conn);

	}

	@Override
	public boolean insert(MemberDto dto) throws Exception {
		pstmt = conn.prepareStatement("insert into member values(0,?,?,?,?,?,?,?)");
		pstmt.setString(1, dto.getRealname());
		pstmt.setString(2, dto.getBirth());
		pstmt.setBoolean(3, dto.isGender());
		pstmt.setString(4, dto.getPhone());
		pstmt.setString(5, dto.getEmail());
		pstmt.setString(6, dto.getUsername());
		pstmt.setString(7, dto.getPassword());
		int result = pstmt.executeUpdate();
		freeConnection(pstmt);
		return result > 0;
	}

	@Override
	public List<MemberDto> selectAll() throws SQLException {
		pstmt = conn.prepareStatement("select * from member");
		rs = pstmt.executeQuery();
		// MemberDto dto = null;
		// null이 아닌 ArrayList의 인스턴스로 초기화 -> NullPointerException 방지
		List<MemberDto> list = new ArrayList<>(); // List 초기화
		if (rs != null) {
			while (rs.next()) {
				MemberDto dto = new MemberDto(); // 객체를 반복적으로 생성
				dto.setUsername(rs.getString("username"));
				dto.setRealname(rs.getString("realname"));
				dto.setEmail(rs.getString("email"));
				dto.setPhone(rs.getString("phone"));
				list.add(dto); // 리스트에 회원정보 추가
			}
		}
		freeConnection(pstmt, rs);
		System.out.println(list);
		return list;
	}

	@Override
	public MemberDto select(String username, String password) throws Exception {
		pstmt = conn.prepareStatement("select * from member where username=? and password=?");
		pstmt.setString(1, username);
		pstmt.setString(2, password);
		rs = pstmt.executeQuery();
		MemberDto dto = null;

		if (rs != null) {
			if (rs.next()) {
				dto = new MemberDto();
				dto.setId(rs.getInt("id"));
			}
		}
		freeConnection(pstmt, rs);
		return dto;
	}

	@Override
	public boolean update(String username, String password, String email, String phone) throws Exception {
		pstmt = conn.prepareStatement("update member set password=?, email=?, phone=? where username=?");
		pstmt.setString(1, password);
		pstmt.setString(2, email);
		pstmt.setString(3, phone);
		pstmt.setString(4, username);
		int result = pstmt.executeUpdate();
		freeConnection(pstmt);
		return result > 0;
	}

	@Override
	public boolean delete(int id) throws Exception {
		pstmt = conn.prepareStatement("delete from member where id=?");
		pstmt.setInt(1, id);
		int result = pstmt.executeUpdate();
		freeConnection(pstmt);
		return result > 0;
	}

	@Override
	public MemberDto selectMember(String username) throws Exception {
		pstmt = conn.prepareStatement("select * from member where username=?");
		pstmt.setString(1, username);
		rs = pstmt.executeQuery();
		MemberDto dto = null;

		if (rs != null) {
			if (rs.next()) {
				dto = new MemberDto();
				dto.setUsername(rs.getString("username"));
				dto.setPassword(rs.getString("password"));
				dto.setEmail(rs.getString("email"));
				dto.setPhone(rs.getString("phone"));
			}
		}
		freeConnection(pstmt, rs);
		return dto;
	}
}

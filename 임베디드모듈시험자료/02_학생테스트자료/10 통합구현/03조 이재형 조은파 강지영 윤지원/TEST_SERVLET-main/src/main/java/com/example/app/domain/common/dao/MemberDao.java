package com.example.app.domain.common.dao;

import java.sql.SQLException;
import java.util.List;

import com.example.app.domain.common.dto.MemberDto;

public interface MemberDao {

	boolean insert(MemberDto dto) throws Exception;

	MemberDto select(String username, String password) throws Exception;

	boolean update(String username, String password, String email, String phone) throws Exception;

	boolean delete(int id) throws Exception;

	List<MemberDto> selectAll() throws SQLException;

	MemberDto selectMember(String username) throws Exception;

}
package com.example.app.domain.common.dao;

import com.example.app.domain.common.dto.MemberDto;
import com.example.app.domain.common.dto.SessionDto;

public interface SessionDao {
	boolean exists(MemberDto dto) throws Exception;

	boolean insert(MemberDto memberDto) throws Exception;

	SessionDto select(MemberDto memberDto) throws Exception;
}

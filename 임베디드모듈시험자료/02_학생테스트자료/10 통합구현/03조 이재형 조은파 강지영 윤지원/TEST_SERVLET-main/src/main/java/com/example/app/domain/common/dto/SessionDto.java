package com.example.app.domain.common.dto;

public class SessionDto {
	private int id;
	private int member_id;

	public SessionDto() {
		super();
	}

	public SessionDto(int id, int member_id) {
		super();
		this.id = id;
		this.member_id = member_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMember_id() {
		return member_id;
	}

	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}

	@Override
	public String toString() {
		return "SessionDto [id=" + id + ", member_id=" + member_id + "]";
	}

}

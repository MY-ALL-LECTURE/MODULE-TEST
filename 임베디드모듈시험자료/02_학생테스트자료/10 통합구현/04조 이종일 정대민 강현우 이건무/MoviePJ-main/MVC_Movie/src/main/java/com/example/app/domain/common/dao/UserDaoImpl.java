package com.example.app.domain.common.dao;

import com.example.app.domain.common.dao.common.CommonDao;
import com.example.app.domain.common.dao.common.ConnectionPool;

public class UserDaoImpl extends CommonDao implements DaoFunctionHeaderNaming{

	private static UserDaoImpl instance ;
	public static UserDaoImpl getInstance() throws Exception {
		if(instance==null)
			instance=new UserDaoImpl();
		return instance;
	}
	private UserDaoImpl() throws Exception{
		System.out.println("UserDaoImpl's constructor invoke .." + conn);
	}
	
	
	@Override
	public boolean select(Object object) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean selectAll() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean insert(Object object) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean update(Object object) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean delete(Object object) {
		// TODO Auto-generated method stub
		return false;
	}
	
		

	
}

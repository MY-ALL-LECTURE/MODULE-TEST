package Domain.User.Dao;

import Domain.DB.Crud;
import Domain.User.Dto.BussinessMan;

public interface BussinessManDao extends Crud<BussinessMan, String>{
	BussinessMan select2(String bussinessManId) throws Exception;
}
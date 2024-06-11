package Domain.User.Dao;

import Domain.DB.Crud;
import Domain.User.Dto.Session;

public interface SessionDao extends Crud<Session, Integer> {
	Session select(String userId) throws Exception;
}

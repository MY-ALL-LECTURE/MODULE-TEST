package Domain.Item.Dao;

import java.util.List;

import Domain.DB.Crud;
import Domain.Item.Dto.Item;

public interface ItemDao extends Crud<Item, Integer>{
	List<Item> select1(String keyword, int offset, int limit) throws Exception;
	List<Item> select2(String bussinessManId, int offset, int limit) throws Exception;
	boolean delete2(Integer id, String bussinessManId) throws Exception;
	boolean update2(Integer id, String bussinessManId, Item item) throws Exception;
}

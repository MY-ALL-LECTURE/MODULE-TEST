package Domain.Item.Service;

import java.util.Map;

import Domain.Item.Dto.Item;

public interface ItemService {
	Map<String, Object> BussinessManItemShow(String userId, int offset, int limit) throws Exception;
	Map<String, Object> KeywordItemShow(String keyword, int offset, int limit) throws Exception;
	Map<String, Object> ItemInsert(Item item, String userId) throws Exception;
	Map<String, Object> ItemUpdate(int itemId, String userId, Item updateItem) throws Exception;
	Map<String, Object> ItemDelete(int itemId, String userId) throws Exception;
}

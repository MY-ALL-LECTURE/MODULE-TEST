package Controller.Sub;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Domain.Item.Dto.Item;
import Domain.Item.Service.ItemService;
import Domain.Item.Service.ItemServiceImpl;

public class ItemController implements SubController {

	private ItemService service;
	
	public ItemController() throws Exception {
		service = ItemServiceImpl.getInstance();
	}
	
	// 1 등록상품조회, 2 상품키워드검색, 3 상품등록, 4 상품수정, 5 상품삭제
	@Override
	public Map<String, Object> execute(int serviceNo, Map<String, Object> params) {
		Map<String, Object> response = new HashMap<String, Object>();
		Item item;
		List<Item> list;
		String bussinessManId, userId;
		int itemId, offset, limit;
		
		switch(serviceNo) {
		case 1:
			// 등록상품조회
			userId = (String) params.get("userId");
			offset = (int) params.get("offset");
			limit = (int) params.get("limit");
			
			try {
				response = service.BussinessManItemShow(userId, offset, limit);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case 2:
			// 상품키워드검색
			String keyword = (String) params.get("keyword");
			offset = (int) params.get("offset");
			limit = (int) params.get("limit");
			
			try {
				response = service.KeywordItemShow(keyword, offset, limit);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case 3:
			// 상품등록
			userId = (String) params.get("userId");
			item = (Item) params.get("item"); 
			
			try {
				response = service.ItemInsert(item, userId);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case 4:
			// 상품수정
			itemId = (int) params.get("itemId");
			userId = (String) params.get("userId");
			item = (Item) params.get("item");
			
			try {
				response = service.ItemUpdate(itemId, userId, item);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case 5:
			// 상품삭제
			itemId = (int) params.get("itemId");
			userId = (String) params.get("userId");
			
			try {
				response = service.ItemDelete(itemId, userId);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		}
		
		return response;
	}
	
}

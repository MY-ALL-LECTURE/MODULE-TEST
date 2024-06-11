package Controller;

import java.util.HashMap;
import java.util.Map;

import Controller.Sub.ItemController;
import Controller.Sub.SubController;
import Controller.Sub.UserController;

public class FrontController {
	private Map<String, SubController> map = new HashMap<String, SubController>();
	
	public FrontController() {
		try {
			init();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void init() throws Exception {
		map.put("/user", new UserController());
		map.put("/item", new ItemController());
	}
	
	public Map<String, Object> execute(String uri, int serviceNo, Map<String, Object> params) {
		SubController controller = map.get(uri);
		return controller.execute(serviceNo, params);
	}
}

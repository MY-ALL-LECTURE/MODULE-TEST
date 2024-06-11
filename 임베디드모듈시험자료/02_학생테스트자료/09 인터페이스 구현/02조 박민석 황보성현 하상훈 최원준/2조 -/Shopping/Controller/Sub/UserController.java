package Controller.Sub;

import java.util.HashMap;
import java.util.Map;

import Domain.User.Dto.User;
import Domain.User.Service.UserService;
import Domain.User.Service.UserServiceImpl;

public class UserController implements SubController {
	private UserService service;

	public UserController() throws Exception {
		service = UserServiceImpl.getInstance();
	}
	
	// 1 로그인, 2 유저 회원가입, 3 사업자 회원가입, 4 회원조회, 5 로그아웃, 6 회원탈퇴, 7 회원수정
	@Override
	public Map<String, Object> execute(int serviceNo, Map<String, Object> params) {
		Map<String, Object> response = new HashMap<String, Object>();
		User user;
		int sessionId;
		String id, pw, bussinessManId;
		
		
		switch(serviceNo) {
		case 1:
			// 로그인
			id = (String) params.get("id");
			pw = (String) params.get("pw");
			
			try {
				response = service.login(id, pw);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 2:
			// 유저 회원가입
			user = (User) params.get("user");
			
			try {
				response = service.signUp(user);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			break;
		case 3:
			// 사업자 회원가입
			user = (User)params.get("user");
			bussinessManId = (String)params.get("bussinessManId");
			
			try {
				response = service.signUpBussinessMan(user, bussinessManId);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 4:
			// 회원정보 조회
			sessionId = (int)params.get("sessionId");
			pw = (String) params.get("pw");
			
			try {
				id = service.getSession(sessionId).getUserId();
				user = service.getUser(id);
				if (user.getRole().equals("BussinessMan")) {
					response = service.bussniessManSelect(id, pw);
				} else {
					response = service.userSelect(id, pw);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 5:
			// 로그아웃
			sessionId = (int)params.get("sessionId");
			try {
				response = service.logout(sessionId);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case 6:
			// 회원탈퇴
			sessionId = (int)params.get("sessionId");
			pw = (String)params.get("pw");
			
			try {
				id = service.getSession(sessionId).getUserId();
				user = service.getUser(id);
				response = service.deleteUser(id, pw);
			} catch(Exception e) {
				e.printStackTrace();
			}
			break;
		case 7:
			// 회원수정
			user = (User)params.get("user");
			pw = (String)params.get("pw");
			sessionId = (int)params.get("sessionId");
			try {
				id = service.getSession(sessionId).getUserId();
				response = service.updateUser(id, pw, user);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		}
		return response;
	}
	
}

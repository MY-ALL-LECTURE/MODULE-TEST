package View.TUI;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import Controller.FrontController;
import Domain.Item.Dto.Item;
import Domain.User.Dto.BussinessMan;
import Domain.User.Dto.Session;
import Domain.User.Dto.User;

public class TUI {
	private FrontController controller;
	private Map<String, Object> request;
	private Map<String, Object> response;
	private Scanner sc;
	private User user;
	private BussinessMan bussinessMan;
	private Session session;
	private int sessionNum;
	
	
	public TUI() {
		controller = new FrontController();
		request = new HashMap<String, Object>();
		response = new HashMap<String, Object>();
		sc = new Scanner(System.in);
		sessionNum = -1;
	}
	
	public void MainMenu() {
		int selectNum = 0;
		
		while(true) {
			try {
				selectNum = 0;
				System.out.println("=================================");
				System.out.println("1: 로그인");
				System.out.println("2: 일반 회원가입");
				System.out.println("3: 사업자 회원가입");
				System.out.println("4: 종료");			
				System.out.println("=================================");
				System.out.print("번호: ");
				String input = sc.next();
				selectNum = Integer.parseInt(input);
			} catch (Exception e) {
				
			}
				
			switch(selectNum) {
			case 1:
				// 로그인
				loginMenu();
				break;
			case 2:
				// 유저 회원가입
				normalRegisterMenu();
				break;
			case 3:
				bussinessManRegisterMenu();
				break;
			case 4:
				System.out.println("프로그램을 종료합니다.");
				System.exit(-1);
				break;
			default:
				System.out.println("메뉴에 있는 번호만 선택해주세요.");
			}
			
			while (sessionNum != -1) {
				try {
					if (session.getRole().equals("User")) {
						subMenu();
					} else if (session.getRole().equals("BussinessMan")) {
						subMenu2();
					}
				} catch (Exception e) {
					System.out.println("형식에 맞게 입력해주세요.");
				}
			}
		}
	}
	
	private void subMenu() {
		int selectNum = 0;
		try {
			selectNum = 0;
			System.out.println("=================================");
			System.out.println("1: 회원조회");
			System.out.println("2: 회원수정");
			System.out.println("3: 회원탈퇴");
			System.out.println("4: 상품검색");
			System.out.println("5: 로그아웃");
			System.out.println("=================================");
			System.out.print("번호: ");
			String input = sc.next();
			selectNum = Integer.parseInt(input);
		} catch (Exception e) {
			
		}
		switch(selectNum) {
		case 1:
			userView();
			break;
		case 2:
			userUpdateMenu();
			break;
		case 3:
			deleteUser();
			break;
		case 4:
			searchItem();
			break;
		case 5:
			logoutMenu();
			break;
		default:
			System.out.println("메뉴에 있는 번호만 선택해주세요.");
		}
	}
	
	private void subMenu2() {
		int selectNum = 0;
		try {
			selectNum = 0;
			System.out.println("=================================");
			System.out.println("1: 회원조회");
			System.out.println("2: 회원수정");
			System.out.println("3: 회원탈퇴");
			System.out.println("4: 등록상품조회");
			System.out.println("5: 상품등록");
			System.out.println("6: 상품수정");
			System.out.println("7: 상품삭제");
			System.out.println("8: 로그아웃");
			System.out.println("=================================");
			System.out.print("번호: ");
			String input = sc.next();
			selectNum = Integer.parseInt(input);
		} catch (Exception e) {
			
		}
		switch(selectNum) {
		case 1:
			userView();
			break;
		case 2:
			userUpdateMenu();
			break;
		case 3:
			deleteUser();
			break;
		case 4:
			// 등록상품조회
			searchItem2();
			break;
		case 5:
			// 상품등록
			insertItemMenu();
			break;
		case 6:
			// 상품수정
			updateItemMenu();
			break;
		case 7:
			// 상품삭제
			deleteItemMenu();
			break;
		case 8:
			logoutMenu();
			break;
		default:
			System.out.println("메뉴에 있는 번호만 선택해주세요.");
		}
	}
	
	private void searchItem() {
		String keyword, msg;
		int offset = 0;
		int limit = 10;
		List<Item> list;
		
		System.out.print("검색 키워드: ");
		keyword = sc.next();
		
		while(true) {
			request.put("keyword", keyword);
			request.put("offset", offset);
			request.put("limit", limit);
			
			response = controller.execute("/item", 2, request);
			msg = (String)response.get("msg");
			
			System.out.println(msg);
			if ((boolean)response.get("response")) {
				list = (List<Item>)response.get("itemList");
				for (Item item : list) {
					System.out.println("-------------------------------");
					System.out.println("상품코드: " + item.getItemId());
					System.out.println("이름: " + item.getItemName());
					System.out.println("분류: " + item.getItemType());
					System.out.println("가격: " + item.getItemPrice());
					System.out.println("수량: " + item.getItemCount());
					System.out.println("제조일자: " + item.getItemManufacturingDate());
					System.out.println("-------------------------------");
				}
			} else {
				break;
			}
			
			String next;
			
			System.out.print("(계속 검색: 아무키 입력, 종료: E): ");
			next = sc.next();
			
			if (next.equals("E")) {
				break;
			}
			
			offset += 10;
		}
	}
	
	private void searchItem2() {
		String msg, userId = (String)session.getUserId();
		int offset = 0;
		int limit = 10;
		List<Item> list;
		
		System.out.print("검색 키워드: ");

		while(true) {
			request.put("userId", userId);
			request.put("offset", offset);
			request.put("limit", limit);
			
			response = controller.execute("/item", 1, request);
			msg = (String)response.get("msg");
			
			System.out.println(msg);
			if ((boolean)response.get("response")) {
				list = (ArrayList<Item>)response.get("itemList");

				for (Item item : list) {
					System.out.println("-------------------------------");
					System.out.println("상품코드: " + item.getItemId());
					System.out.println("이름: " + item.getItemName());
					System.out.println("분류: " + item.getItemType());
					System.out.println("가격: " + item.getItemPrice());
					System.out.println("수량: " + item.getItemCount());
					System.out.println("제조일자: " + item.getItemManufacturingDate());
					System.out.println("-------------------------------");
				}
			} else {
				break;
			}
			
			String next;
			
			System.out.print("(계속 검색: 아무키 입력, 종료: E): ");
			next = sc.next();
			
			if (next.equals("E")) {
				break;
			}
			
			offset += 10;
		}
	}
	
	private void insertItemMenu() {
		String userId, itemName, itemType, msg;
		int itemPrice, itemCount;
		
		userId = (String)session.getUserId();
		
		System.out.print("상품 이름: ");
        itemName = sc.next();
        
        System.out.print("상품 타입: ");
        itemType = sc.next();
        
        System.out.print("상품 가격: ");
        itemPrice = Integer.parseInt(sc.next());
        
        System.out.print("상품 개수: ");
        itemCount = Integer.parseInt(sc.next());
        
        System.out.print("제조일자 (yyyy-MM-dd):");
        Date itemManufacturingDate = null;
        try {
            itemManufacturingDate = new SimpleDateFormat("yyyy-MM-dd").parse(sc.next());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        Item item = new Item(itemName, itemType, itemPrice, itemCount, itemManufacturingDate);
        
        request.put("item", item);
        request.put("userId", userId);
        
        response = controller.execute("/item", 3, request);
        msg = (String)response.get("msg");
        
        System.out.println(msg);
	}
	
	private void updateItemMenu() {
		String userId, itemName, itemType, msg;
		int itemPrice, itemCount, itemId;
		
		userId = (String)session.getUserId();
		
		System.out.print("수정할 상품코드 입력: ");
		itemId = Integer.parseInt(sc.next());		
		
		System.out.print("상품 이름: ");
        itemName = sc.next();
        
        System.out.print("상품 타입: ");
        itemType = sc.next();
        
        System.out.print("상품 가격: ");
        itemPrice = Integer.parseInt(sc.next());
        
        System.out.print("상품 개수: ");
        itemCount = Integer.parseInt(sc.next());
        
        System.out.print("제조일자 (yyyy-MM-dd):");
        Date itemManufacturingDate = null;
        try {
            itemManufacturingDate = new SimpleDateFormat("yyyy-MM-dd").parse(sc.next());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        Item item = new Item(itemName, itemType, itemPrice, itemCount, itemManufacturingDate);
        
        request.put("item", item);
        request.put("userId", userId);
        request.put("itemId", itemId);
        
        response = controller.execute("/item", 4, request);
        msg = (String)response.get("msg");
        
        System.out.println(msg);
	}
	
	private void deleteItemMenu() {
		String userId, msg;
		int itemId;
		
		userId = (String)session.getUserId();
		
		System.out.print("삭제할 상품코드 입력: ");
		itemId = Integer.parseInt(sc.next());		
		
        request.put("userId", userId);
        request.put("itemId", itemId);
        
        response = controller.execute("/item", 5, request);
        msg = (String)response.get("msg");
        
        System.out.println(msg);
	}
	
	private void loginMenu() {
		String id, pw, msg;
		
		System.out.print("ID: ");
		id = sc.next();
		System.out.print("PW: ");
		pw = sc.next();
		
		request.put("id", id);
		request.put("pw", pw);
		
		response = controller.execute("/user", 1, request);
		
		if ((boolean)response.get("response")) {
			sessionNum = (int)response.get("sessionId");
			session = (Session)response.get("session");
		}
		
		if (response.get("msg") != null) {
			msg = (String)response.get("msg");
			System.out.println(msg);
		}
		
		request.clear();
		response.clear();
	}
	
	private void normalRegisterMenu() {
		String id, pw, name, phoneNumber, email, role, msg;
		
		System.out.print("ID ( 4~20자리 ): ");
		id = sc.next();
		while (!idValidate(id)) {
			System.out.println("유효하지 않은 아이디입니다.");
			System.out.print("ID ( 4~20자리 ): ");
			id = sc.next();
		}
		
		System.out.print("PW ( 8~16자리 영문 대소문자, 숫자, 특문 포함) : ");
		pw = sc.next();
		while (!pwValidate(pw)) {
			System.out.println("유효하지 않은 비밀번호입니다.");
			System.out.print("PW ( 8~16자리 영문 대소문자, 숫자, 특문 포함) : ");
			pw = sc.next();
		}
		
		System.out.print("Name: ");
		name = sc.next();
		
		System.out.print("PhoneNumber: ");
		phoneNumber = sc.next();
		
		System.out.print("Email: ");
		email = sc.next();
		role = "User";
		
		user = new User(id, pw, name, phoneNumber, email, role);
		request.put("user", user);
		
		response = controller.execute("/user", 2, request);
		
		msg = (String)response.get("msg");
		System.out.println(msg);
		
		user = null;
		request.clear();
		response.clear();	
	}
	
	private void bussinessManRegisterMenu() {
		String id, pw, name, phoneNumber, email, role, msg, bussinessId;
		
		System.out.print("ID ( 4~20자리 ): ");
		id = sc.next();
		
		while (!idValidate(id)) {
			System.out.println("유효하지 않은 아이디입니다.");
			System.out.print("ID ( 4~20자리 ): ");
			id = sc.next();
		}
		
		System.out.print("PW ( 8~16자리 영문 대소문자, 숫자, 특문 포함) : ");
		pw = sc.next();
		while (!pwValidate(pw)) {
			System.out.println("유효하지 않은 비밀번호입니다.");
			System.out.print("PW ( 8~16자리 영문 대소문자, 숫자, 특문 포함) : ");
			pw = sc.next();
		}
		
		System.out.print("Name: ");
		name = sc.next();
		
		System.out.print("PhoneNumber: ");
		phoneNumber = sc.next();
		
		System.out.print("Email: ");
		email = sc.next();
		
		System.out.print("BussinessId (숫자 10자리): ");
		bussinessId = sc.next();
		while(!bussinessIdValidate(bussinessId)) {
			System.out.println("유효하지 않은 사업자 번호입니다.");
			System.out.print("BussinessId (숫자 10자리): ");
			bussinessId = sc.next();
		}
		
		role = "BussinessMan";
		
		user = new User(id, pw, name, phoneNumber, email, role);
		request.put("user", user);
		request.put("bussinessManId", bussinessId);
		
		response = controller.execute("/user", 3, request);

		msg = (String) response.get("msg");
		System.out.println(msg);
		
		user = null;
		request.clear();
		response.clear();
	}
	
	private void userView() {
		String pw, msg;
		
		System.out.println("본인 확인을 위해 PW를 입력해주세요.");
		System.out.print("pw: ");
		pw = sc.next();
		request.put("sessionId", sessionNum);
		request.put("pw", pw);
		
		response = controller.execute("/user", 4, request);
		
		msg = (String)response.get("msg");
		System.out.println(msg);
		
		if((boolean)response.get("response")) {
			user = (User)response.get("user");
			if(user.getRole().equals("BussinessMan")) {
				bussinessMan = (BussinessMan) response.get("bussinessMan");
			}
			detailUserView(user, bussinessMan);
		}
		
		user = null;
		bussinessMan = null;
		request.clear();
		response.clear();
	}
	
	private void userUpdateMenu() {
		String pw, name, phoneNumber, email, msg;
		
		System.out.println("--------------- 회원 수정 ------------------");

		System.out.print("PW ( 8~16자리 영문 대소문자, 숫자, 특문 포함) : ");
		pw = sc.next();
		while (!pwValidate(pw)) {
			System.out.println("유효하지 않은 비밀번호입니다.");
			System.out.print("PW ( 8~16자리 영문 대소문자, 숫자, 특문 포함) : ");
			pw = sc.next();
		}
		
		System.out.print("Name: ");
		name = sc.next();
		
		System.out.print("PhoneNumber: ");
		phoneNumber = sc.next();
		
		System.out.print("Email: ");
		email = sc.next();
		
		user = new User(session.getUserId(), pw, name, phoneNumber, email, session.getRole());
		request.put("user", user);
		
		System.out.println("본인 확인을 위해 현재 PW를 입력해주세요.");
		System.out.print("pw: ");
		pw = sc.next();
		request.put("sessionId", sessionNum);
		request.put("pw", pw);
		
		response = controller.execute("/user", 7, request);
		
		msg = (String)response.get("msg");
		System.out.println(msg);
		
		user = null;
		request.clear();
		response.clear();	
	}
	
	private void logoutMenu() {
		String msg;
		
		request.put("sessionId", sessionNum);
		response = controller.execute("/user", 5, request);
		
		if ((boolean)response.get("response")) {
			sessionNum = -1;
		}
		msg = (String)response.get("msg");
		System.out.println(msg);
		
		request.clear();
		response.clear();
	}
	
	private void deleteUser() {
		String pw, msg;
		
		System.out.println("본인 확인을 위해 PW를 입력해주세요.");
		System.out.print("pw: ");
		pw = sc.next();
		request.put("sessionId", sessionNum);
		request.put("pw", pw);
		response = controller.execute("/user", 6, request);
		if ((boolean)response.get("response")) {
			sessionNum = -1;
		}
		msg = (String)response.get("msg");
		System.out.println(msg);
		
		request.clear();
		response.clear();
	}
	
	private boolean idValidate(String id) {
		int length = id.length();
		return length >= 4 && length <=20;
	}
	
	private boolean pwValidate(String pw) {
		if (pw.length() < 8 && pw.length() > 16) {
			return false;
		}
		
		boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;
		
		for (char ch : pw.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(ch)) {
                hasLowerCase = true;
            } else if (Character.isDigit(ch)) {
                hasDigit = true;
            } else {
                // 특수문자인지 확인
                hasSpecialChar = true;
            }
        }
        
        return hasUpperCase && hasLowerCase && hasDigit && hasSpecialChar;
	}
	
	public boolean bussinessIdValidate(String bussinessId) {
		return bussinessId.length() == 10;
	}
	
	public void detailUserView(User user, BussinessMan bussinessMan) {
		System.out.println("유저 정보 조회 -----------------");
		System.out.println("유저 Id: " + user.getUserId());
		System.out.println("유저 이름: " + user.getName());
		System.out.println("유저 이메일: " + user.getEmail());
		System.out.println("유저 전화번호: " + user.getPhoneNumber());
		System.out.println("타입: " + user.getRole());
		if (user.getRole().equals("BussinessMan")) {
			System.out.println("사업자 번호: " + bussinessMan.getBussinessManId());
		}
	}
}

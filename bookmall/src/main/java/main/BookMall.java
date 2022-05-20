package main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import dao.BookDao;
import dao.CartDao;
import dao.CategoryDao;
import dao.MemberDao;
import dao.OrderDao;
import vo.BookVo;
import vo.CartVo;
import vo.CategoryVo;
import vo.MemberVo;
import vo.OrderVo;

public class BookMall {

	public static void main(String[] args) {
		insertAll();
		findAll();
		

	}

	private static void insertAll() {
		insertMember();
		insertCategory();
		insertBook();
		insertCart();
		insertOrder();
	}





	

	private static void findAll() {
		findByMember();
		findByCategory();
		findByBook();
		findByCart();
		findByOrder();
	}



	private static void findByMember() {
		System.out.println("─ 멤버 목록 ────────────────────────────────────");

		List<MemberVo> list = new MemberDao().findAll();
		for (MemberVo vo : list) {
			System.out.println(vo);
		}
		System.out.println();
	}

	private static void findByCategory() {

		System.out.println("─ 카테고리 목록 ─────────────────────────────────");

		List<CategoryVo> list = new CategoryDao().findAll();
		for (CategoryVo vo : list) {
			System.out.println(vo);
		}
		System.out.println();
	}

	private static void findByBook() {
		System.out.println("─ 책 목록 ─────────────────────────────────────");

		List<BookVo> list = new BookDao().findAll();
		for (BookVo vo : list) {
			System.out.println(vo);
		}
		System.out.println();
	}

	private static void findByCart() {
		System.out.println("─ 카트 목록 ────────────────────────────────────");

		List<CartVo> list = new CartDao().findAll();
		for (CartVo vo : list) {
			System.out.println(vo);
		}
		System.out.println();
	}
	
	private static void findByOrder() {
		
		System.out.println("─ 주문서 목록 ────────────────────────────────────");
		List<OrderVo> list2 = new OrderDao().orderFindAll();
		for (OrderVo vo : list2) {
			System.out.println(vo.getOrders_no() +"\n"+ vo.getName() +"(" +vo.getMail() +")"+"\n"+vo.getPrice() +"\n" +vo.getAddress());
		}
		System.out.println();
		
		System.out.println("─ 주문 목록 ────────────────────────────────────");
		List<OrderVo> list = new OrderDao().findAll();
		for (OrderVo vo : list) {
			System.out.println(vo);
		}
		System.out.println();
		
	}
	
	private static void insertMember() {
		MemberDao dao = new MemberDao();
		MemberVo vo = null;
		
		vo = new MemberVo();
		vo.setName("호랑이");
		vo.setCall("010-1111-4444");
		vo.setMail("horang2@gmail.com");	
		vo.setPassword("1234");
		dao.insert(vo);
		
		vo = new MemberVo();
		vo.setName("거북이");
		vo.setCall("010-2222-3333");
		vo.setMail("slow@gmail.com");	
		vo.setPassword("4567");
		dao.insert(vo);
	}
	

	private static void insertCategory() {
		CategoryVo vo = null;
		CategoryDao dao = new CategoryDao();

		vo = new CategoryVo();
		vo.setTitle("컴퓨터/IT");
		dao.insert(vo);

		vo = new CategoryVo();
		vo.setTitle("에쎄이");
		dao.insert(vo);

		vo = new CategoryVo();
		vo.setTitle("소설");
		dao.insert(vo);
	}
	

	private static void insertBook() {
		BookDao dao = new BookDao();
		BookVo vo = null;
		
		vo = new BookVo();
		vo.setCategory_no(1);
		vo.setTitle("이것이자바다");
		vo.setPrice("10000");
		dao.insert(vo);

		vo = new BookVo();
		vo.setCategory_no(2);
		vo.setTitle("퇴사합니다 독립하려고요");
		vo.setPrice("13950");
		dao.insert(vo);
		
		vo = new BookVo();
		vo.setCategory_no(3);
		vo.setTitle("여름의문");
		vo.setPrice("15210");
		dao.insert(vo);
	}
	

	private static void insertCart() {
		CartDao dao = new CartDao();
		CartVo vo = null;

		vo = new CartVo();
		vo.setMember_no(1);
		vo.setBook_no(2);
		vo.setAmount("1");
		dao.insert(vo);

		vo = new CartVo();
		vo.setMember_no(1);
		vo.setBook_no(1);
		vo.setAmount("2");
		dao.insert(vo);
	}
	
	private static void insertOrder() {

		OrderVo vo = new OrderVo();
		vo.setNo("2022001");
		vo.setPrice("33950");
		vo.setAddress("개금");
		vo.setMember_no(1);
		OrderDao.insert(vo);
		
		
		OrderVo Ovo = new OrderVo();
		Ovo.setBook_no(2);
		Ovo.setNo("2022001");
		Ovo.setAmount("1");
		OrderDao.insertOrderBook(Ovo);
	}
	

	
}

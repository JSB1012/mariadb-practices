package dao.test;

import java.util.List;

import dao.BookDao;
import vo.BookVo;
import vo.CategoryVo;

public class BookDaoTest {

	public static void main(String[] args) {
		testInsert();
		 //testFindAll();
		// testUpdate();
	}

	private static void testFindAll() {
		List<BookVo> list = new BookDao().findAll();
		for (BookVo vo : list) {
			System.out.println(vo);
		}
	}

	public static void testInsert() {
		BookDao dao = new BookDao();
		BookVo vo = null;
		
		vo = new BookVo();
		vo.setCategory_no(1);
		vo.setTitle("이것이자바다");
		vo.setPrice("10000");
		dao.insert(vo);

		vo = new BookVo();
		vo.setCategory_no(2);
		vo.setTitle("난중일기");
		vo.setPrice("20000");
		dao.insert(vo);
		
		vo = new BookVo();
		vo.setCategory_no(3);
		vo.setTitle("개미");
		vo.setPrice("30000");
		dao.insert(vo);
	}
}

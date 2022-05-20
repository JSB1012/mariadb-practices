package dao.test;

import java.util.List;

import dao.CartDao;
import vo.BookVo;
import vo.CartVo;

public class CartDaoTest {

	public static void main(String[] args) {
		//testInsert();
		 testFindAll();
		// testUpdate();
	}

	public static void testInsert() {
		CartDao dao = new CartDao();
		CartVo vo = null;

		vo = new CartVo();
		vo.setMember_no(1);
		vo.setBook_no(2);
		vo.setAmount("3");
		dao.insert(vo);

		vo = new CartVo();
		vo.setMember_no(2);
		vo.setBook_no(3);
		vo.setAmount("1");
		dao.insert(vo);

	}

	private static void testFindAll() {
		List<CartVo> list = new CartDao().findAll();
		for (CartVo vo : list) {
			System.out.println(vo);
		}
	}
}

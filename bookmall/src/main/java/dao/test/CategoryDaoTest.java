package dao.test;

import java.util.List;

import dao.CategoryDao;
import vo.CategoryVo;

public class CategoryDaoTest {

	public static void main(String[] args) {
		 testInsert();
		//testFindAll();
		// testUpdate();
	}

	private static void testFindAll() {
		List<CategoryVo> list = new CategoryDao().findAll();
		for (CategoryVo vo : list) {
			System.out.println(vo);
		}
	}

	public static void testInsert() {
		CategoryVo vo = null;
		CategoryDao dao = new CategoryDao();

		vo = new CategoryVo();
		vo.setTitle("IT");
		dao.insert(vo);

		vo = new CategoryVo();
		vo.setTitle("역사");
		dao.insert(vo);

		vo = new CategoryVo();
		vo.setTitle("소설");
		dao.insert(vo);

	}

}

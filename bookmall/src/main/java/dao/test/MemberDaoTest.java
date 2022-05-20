package dao.test;

import java.util.List;

import dao.BookDao;
import dao.MemberDao;
import vo.BookVo;
import vo.MemberVo;

public class MemberDaoTest {
	
	public static void main(String[] args) {
		 testInsert();
		//testFindAll();
	//	 testUpdate();
	}
	
	public static void testInsert() {
		MemberDao dao = new MemberDao();
		MemberVo vo = null;
		
		vo = new MemberVo();
		vo.setName("둘리");
		vo.setCall("010-1111-4444");
		vo.setMail("dooly@gmail.com");	
		vo.setPassword("hoit");
		dao.insert(vo);
		
		vo = new MemberVo();
		vo.setName("마이콜");
		vo.setCall("010-2222-3333");
		vo.setMail("micol@gmail.com");	
		vo.setPassword("col");
		dao.insert(vo);
		
		

	}
	
	private static void testFindAll() {
		List<MemberVo> list = new MemberDao().findAll();
		for (MemberVo vo : list) {
			System.out.println(vo);
		}
	}

}

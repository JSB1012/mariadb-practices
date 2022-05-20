package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.OrderVo;

public class OrderDao {

	public List<OrderVo> findAll() {
		List<OrderVo> result = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			connection = getConnection();

			String sql =     
					"select a.title, b.amount, (a.price * b.amount) as price "+
				     " from book a, cart b" +
				     " where a.no = b.book_no";
					
			pstmt = connection.prepareStatement(sql);
	
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				OrderVo vo = new OrderVo();
				vo.setBook_title(rs.getString(1));
				vo.setAmount(rs.getString(2));
				vo.setPrice(rs.getString(3));
				
				result.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;	
	}
	
	public List<OrderVo> orderFindAll() {
		List<OrderVo> result = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			connection = getConnection();

			String sql =
					"select c.orders_no, b.name, b.mail, a.price, a.address" +
					" from orders a, member b, orders_book c" +
					" where a.member_no = b.no" +
					" and a.no = c.orders_no";
			pstmt = connection.prepareStatement(sql);
	
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				OrderVo vo = new OrderVo();
				vo.setOrders_no(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setMail(rs.getString(3));
				vo.setPrice(rs.getString(4));
				vo.setAddress(rs.getString(5));
				
				result.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;	
	}


	public static boolean insert(OrderVo vo) {
		boolean result = false;
		Connection connection = null;
		PreparedStatement pstmt = null;
				
		try {
			connection = getConnection();
				
			String sql = " Insert into orders values (?,?,?,?) ";
			pstmt = connection.prepareStatement(sql);	
			pstmt.setString(1, vo.getNo());
			pstmt.setLong(2,vo.getMember_no());
			pstmt.setString(3,vo.getAddress());
			pstmt.setString(4,vo.getPrice());		
					
			int count = pstmt.executeUpdate();
			result = count == 1;
		} catch (SQLException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public static void insertOrderBook(OrderVo vo) {
		Connection connection = null;
		PreparedStatement pstmt = null;
				
		try {
			connection = getConnection();
				
			String sql = "Insert into orders_book values (?,?,?) ";
			pstmt = connection.prepareStatement(sql);			
			pstmt.setString(1,vo.getNo());
			pstmt.setLong(2,vo.getBook_no());
			pstmt.setString(3,vo.getAmount());			
						
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static Connection getConnection() throws SQLException{
		Connection connection = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			
			String url = "jdbc:mysql://192.168.10.43:3306/bookmall?charset=utf8";
			connection = DriverManager.getConnection(url, "bookmall", "bookmall");
			
		} catch (ClassNotFoundException e) {
			System.out.println("ERROR: " + e);
		}
		return connection;		
	}

	


	
}
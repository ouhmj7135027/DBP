package controller.member;

import java.beans.Statement;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.corba.se.pept.transport.Connection;

import controller.Controller;
import service.dto.cartDTO;
import service.dto.cartListDTO;

public class CartListController implements Controller{
	
	private static final long serialVersionUID = 1L;
	
	public CartListController() {
		// TODO Auto-generated constructor stub
	}

	public void onlyGet (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		HttpSession session = request.getSession();
		cartDTO cart = (cartDTO) session.getAttribute("CART");
		
		if (cart != null) {
			cartListDTO cartList = readDB(cart);
			request.setAttribute("CART_LIST",  cartList);
		}
		else {
			request.setAttribute("CART_LIST",  null);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("produclist.jsp?BODY_PATH=Cart.jsp");
		dispatcher.forward(request,  response);
	
	}
	
	//product에서 받아와야 하나..?
	private cartListDTO readDB(cartDTO cart) throws ServletException {
		cartListDTO cartList = new cartListDTO();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe", user = "dbp0103", passwd = "20160149";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDirver");
		}catch (ClassNotFoundException e) { e.printStackTrace(); }
		
		try {
			conn = (Connection) DriverManager.getConnection(url, user, passwd);
			if (conn == null)
				throw new Exception("데이터베이스에 연결할 수 없습니다.");
			stmt = (Statement) ((java.sql.Connection) conn).createStatement(); //???
			
			int productNum = cart.getSize();
			for (int cnt = 0; cnt < productNum; cnt++) {
				String id = cart.getCode(cnt);
				int num = cart.getNumber(cnt);
		
				rs = ((java.sql.Statement) stmt).executeQuery("select p_name, p_price from product "
						+ "where product_id = '" + id + "';");
				
				if (!rs.next())
					throw new Exception("해당 상품이 없습니다.[상품id:" + id + "]");
				
				String name = rs.getString("p_name");
				int price = rs.getInt("p_price");
				cartList.setCode(cnt, id);
				cartList.setTitle(cnt, name);
				cartList.setPrice(cnt, price);
				cartList.setNumber(cnt, num);
			}
		} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (rs != null) {
					try {
						rs.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				if (stmt != null) {
					try {
						((ResultSet) stmt).close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				if (conn != null) {
					try {
						conn.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		return cartList;
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}

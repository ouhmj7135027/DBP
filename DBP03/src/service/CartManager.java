package service;

import java.sql.SQLException;
import java.util.List;

import persistence.DAOFactory;
import persistence.dao.MemberDAO;
import persistence.dao.cartDAO;
import persistence.dao.impl.cartDAOImpl;
import service.dto.MemberDTO;
import service.dto.cartDTO;

public class CartManager {
	private static CartManager cartMan = new CartManager();
	private cartDAOImpl cartDAO = null;

	private CartManager() {
		try {
			DAOFactory factory = new DAOFactory();
			cartDAO = factory.getCartDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	
	public static CartManager getInstance() {
		return cartMan;
	}
	
	public int insert(cartDTO cart) throws SQLException {
		return cartDAO.insertInCart(cart);
	}

	public int update(cartDTO cart) throws SQLException {
		return cartDAO.updateInCart(cart);
	}	

	public int delete(int c_id) throws SQLException {
		return cartDAO.deleteInCart(c_id);
	}

	public List<cartDTO> findCartList(MemberDTO mem) throws SQLException {
		return cartDAO.getCartById(mem.getM_id());
	}

	public cartDAO getCartDAO() {
		return this.cartDAO;
	}

}

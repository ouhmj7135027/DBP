package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import persistence.DAOFactory;
import persistence.dao.productDAO;
import service.dto.productDTO;

/**
 * 상품 관리 API을 사용하는 개발자들이 직접 접근하게 되는 클래스.
 * ProductDAO를 이용하여 데이터베이스에 데이터 조작 작업이 가능하도록 함
 */
public class ProductManager {
	private static ProductManager productMan = new ProductManager();
	private productDAO proDAO;
	
	public ProductManager() {
		try {
			DAOFactory factory = new DAOFactory();
			proDAO = factory.getProdutDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	public static ProductManager getInstance() {
		return productMan;
	}
	

	
	//전체 상품 목록(=상품 정보) 불러오기
	public List<productDTO> ListingProductsInfo() throws SQLException {
		return proDAO.getProductList();
	}
	
	//전체 상품 목록만 불러오기
	public List<productDTO> ListingProducts() throws SQLException {
		return proDAO.getOnlyProductList();
	}
	
	//상품 이름 검색해서 불러오기
	public List<productDTO> getProductByCategory(int cnum1, int cnum2) {
		return proDAO.getProductByCategory(cnum1, cnum2);
	}
	
	
	public productDTO getProductById(int id) {
		
		return proDAO.getProductById(id);
	} 
	public productDTO getProductByName(String name) {
		return proDAO.getProductByName(name);
	}
	//name에 해당하는 상품정보를 반환하는 메소드
	public int insert(productDTO pro) {
	
		return proDAO.insertProduct(pro);
	}
	public int update(productDTO pro) {
		return proDAO.updateProduct(pro);
		
		
	}
	public int delete(int deleteId) {
		return proDAO.deleteProduct(deleteId);
	}
	public productDTO getProductBySurvey(int survey, int category) {
		
		return proDAO.survey(survey, category);
	}
	public List<productDTO> getProductByp_Id(int id) {
		return proDAO.getProductByp_id(id);
	}
		
	
}

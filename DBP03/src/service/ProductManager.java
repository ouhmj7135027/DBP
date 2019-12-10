package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import persistence.DAOFactory;
import persistence.dao.productDAO;
import service.dto.productDTO;

/**
 * ��ǰ ���� API�� ����ϴ� �����ڵ��� ���� �����ϰ� �Ǵ� Ŭ����.
 * ProductDAO�� �̿��Ͽ� �����ͺ��̽��� ������ ���� �۾��� �����ϵ��� ��
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
	

	
	//��ü ��ǰ ���(=��ǰ ����) �ҷ�����
	public List<productDTO> ListingProductsInfo() throws SQLException {
		return proDAO.getProductList();
	}
	
	//��ü ��ǰ ��ϸ� �ҷ�����
	public List<productDTO> ListingProducts() throws SQLException {
		return proDAO.getOnlyProductList();
	}
	
	//��ǰ �̸� �˻��ؼ� �ҷ�����
	public List<productDTO> getProductByCategory(int cnum1, int cnum2) {
		return proDAO.getProductByCategory(cnum1, cnum2);
	}
	
	
	public productDTO getProductById(int id) {
		
		return proDAO.getProductById(id);
	} 
	public productDTO getProductByName(String name) {
		return proDAO.getProductByName(name);
	}
	//name�� �ش��ϴ� ��ǰ������ ��ȯ�ϴ� �޼ҵ�
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

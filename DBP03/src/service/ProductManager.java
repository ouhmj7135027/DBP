package service;

import java.sql.SQLException;
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
	
	private ProductManager() {
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
	public productDTO getProduct(String name) {
		return proDAO.getProductByName(name);
	}
	
	
	public productDTO getProductByNames(String name) {
		
		return proDAO.getProductByName(name);
	} 
	//name�� �ش��ϴ� ��ǰ������ ��ȯ�ϴ� �޼ҵ�
	public int insert(productDTO pro) {
	
		return proDAO.insertProduct(pro);
	}
	public int update(productDTO pro) {
		return proDAO.updateProduct(pro);
		
		
	}
	public int delete(String product_id) {
		return proDAO.deleteProduct(product_id);
	}
	public int getProductBySurvey() {}
	
	
}
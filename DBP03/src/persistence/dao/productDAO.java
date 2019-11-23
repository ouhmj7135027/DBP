package persistence.dao;

import java.sql.ResultSet;
import java.util.List;

import service.dto.productDTO;

public interface productDAO {
	//��ü ��ǰ ������ ProductDTO�� List�� ��ȯ�ϴ� �޼ҵ�
	public List<productDTO> getProductList();
	
	//��ü ��ǰ ��ϸ��� ProductDTO�� List�� ��ȯ�ϴ� �޼ҵ�
	public List<productDTO> getOnlyProductList();
	
	//name�� �ش��ϴ� ��ǰ������ ��ȯ�ϴ� �޼ҵ�
	public productDTO getProductByName(String name);
	
	public List<productDTO> getProductByCategory(int cnum1, int cnum2);
	
	public int insertProduct(productDTO pro);
	public int updateProduct(productDTO pro);
	public int deleteProduct(String product_id);
	public productDTO survey (int survey, int category) ;

}

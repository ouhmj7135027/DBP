package persistence.dao;

import service.dto.productDTO;

public interface productDAO {
	public productDTO getProductByName(String name);
	public int insertProduct(productDTO pro);
	public int updateProduct(productDTO pro);
	public int deleteProduct(String product_id);


}

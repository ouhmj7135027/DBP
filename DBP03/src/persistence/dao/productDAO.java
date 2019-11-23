package persistence.dao;

import java.sql.ResultSet;
import java.util.List;

import service.dto.productDTO;

public interface productDAO {
	//전체 상품 정보를 ProductDTO의 List로 반환하는 메소드
	public List<productDTO> getProductList();
	
	//전체 상품 목록만을 ProductDTO의 List로 반환하는 메소드
	public List<productDTO> getOnlyProductList();
	
	//name에 해당하는 상품정보를 반환하는 메소드
	public productDTO getProductByName(String name);
	
	public List<productDTO> getProductByCategory(int cnum1, int cnum2);
	
	public int insertProduct(productDTO pro);
	public int updateProduct(productDTO pro);
	public int deleteProduct(String product_id);
	public productDTO survey (int survey, int category) ;

}

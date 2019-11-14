package service;

import java.util.List;

import persistence.DAOFactory;
import persistence.dao.ExchangeDAO;
import service.dto.ExchangeDTO;

public class ExchangeServiceImpl implements ExchangeService {

	private ExchangeDAO dao = null; 
	
	public ExchangeServiceImpl() {
		DAOFactory factory = new DAOFactory();
		dao = factory.getExchangeDAO();
	}
	@Override
	public List<ExchangeDTO> ListingExchanges() {
		// TODO Auto-generated method stub
		return dao.getExchangeList();
	}

	@Override
	public ExchangeDTO getExchange(String exchange_id) {
		// TODO Auto-generated method stub
		return dao.getExchangeById(exchange_id);
	}

	@Override
	public int insertExchange(ExchangeDTO exchange) {
		// TODO Auto-generated method stub
		return dao.insertExchange(exchange);
	}

	@Override
	public int deleteExchange(int exchange_id) {
		// TODO Auto-generated method stub
		return dao.deleteExchange(exchange_id);
	}

}

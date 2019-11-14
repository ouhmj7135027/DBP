package persistence.dao;

import java.util.List;

import service.dto.ExchangeDTO;

public interface ExchangeDAO {
	public List<ExchangeDTO> getExchangeList();
	public ExchangeDTO getExchangeById(String exchange_id);
	public int insertExchange(ExchangeDTO exchange);
	public int deleteExchange(int exchange_id);
}

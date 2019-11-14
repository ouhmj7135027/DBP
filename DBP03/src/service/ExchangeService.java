package service;

import java.util.List;
import service.dto.ExchangeDTO;

public interface ExchangeService {
	public List<ExchangeDTO> ListingExchanges();
	public ExchangeDTO getExchange(String exchange_id);
	public int insertExchange(ExchangeDTO exchange);
	public int deleteExchange(int exchange_id);
}

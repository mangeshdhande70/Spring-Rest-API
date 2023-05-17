package in.ineuron.service;

import java.util.List;

import in.ineuron.model.Tourist;

public interface ITouristService {
	
	public String register(Tourist tourist);
	
	public List<Tourist> fetchAll();
	
	public Tourist fetchTouristById(Integer id);
	
	public String updateTouristDetails(Tourist tourist);
	
	public String updateBudgetById(Integer id , Float hikePercentage);

}

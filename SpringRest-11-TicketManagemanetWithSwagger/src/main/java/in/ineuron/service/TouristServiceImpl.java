package in.ineuron.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.dao.ITouristDao;
import in.ineuron.exception.TouristNotFoundException;
import in.ineuron.model.Tourist;

@Service
public class TouristServiceImpl implements ITouristService {

	@Autowired
	private ITouristDao repo;
	
	@Override
	public String register(Tourist tourist) {
		Integer tid = repo.save(tourist).getTid();
		return "Tourist Registration successfully with ticket Id :: "+tid;
	}

	@Override
	public List<Tourist> fetchAll() {
		
		return repo.findAll();
	}

	@Override
	public Tourist fetchTouristById(Integer id) {
		
//		Optional<Tourist> optional = repo.findById(id);
//		if (optional.isPresent()) {
//			return optional.get();
//		}else {
//			 throw new TouristNotFoundException("Tourist not found for given id :: "+id); 
//		}
		
		
		return repo.findById(id).orElseThrow(()->new TouristNotFoundException("Tourist not found for given id :: "+id));
	}

	@Override
	public String updateTouristDetails(Tourist tourist) {
		
		Optional<Tourist> optional = repo.findById(tourist.getTid());
		if(optional.isPresent()) {
			repo.save(tourist);
			return "tourist details is updated for given id ::"+tourist.getTid();
		}else {
			throw new TouristNotFoundException("Tourist Not Found with id :: "+tourist.getTid());
		}
			
	}
	

	@Override
	public String updateBudgetById(Integer id, Float hikePercentage) {
		Optional<Tourist> optional = repo.findById(id);
		
		if (optional.isPresent()) {
			Tourist tourist = optional.get();
			tourist.setBudget(tourist.getBudget()+(tourist.getBudget()*(hikePercentage/100)));
			repo.save(tourist);
			return "Tourist Details Updated Successfully with id :: "+id;
		}else {
			throw new TouristNotFoundException("Tourist Not Found for given Id :: "+id);
		}
		
		
	}

}

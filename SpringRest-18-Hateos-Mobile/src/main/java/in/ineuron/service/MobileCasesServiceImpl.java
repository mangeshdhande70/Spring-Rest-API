package in.ineuron.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.dao.IMobileCaseDao;
import in.ineuron.model.MobileCases;

@Service
public class MobileCasesServiceImpl implements IMobileCaseService{

	@Autowired
	private IMobileCaseDao repo;
	
	@Override
	public String addMobileCases(MobileCases mobileCases) {
	
		MobileCases mobileCases2 = repo.save(mobileCases);
		
		return mobileCases2!=null?"cases addes successfully":"Faild to add cases";
	}

	@Override
	public List<MobileCases> getByModel(String model) {
		List<MobileCases> list = repo.findByModel(model);
		return list;
	}

}

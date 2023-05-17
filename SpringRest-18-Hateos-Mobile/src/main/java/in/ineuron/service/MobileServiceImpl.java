package in.ineuron.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.dao.IMobileDao;
import in.ineuron.model.Mobile;
import in.ineuron.model.MobileCompany;

@Service
public class MobileServiceImpl implements IMobileService {
	
	@Autowired
	private IMobileDao repo;

	@Override
	public String addMobile(Mobile mobile) {
		
		Mobile mobile2 = repo.save(mobile);
		return mobile2!=null?"Mobile added Successfully":"mobile not added";
	}

	@Override
	public List<Mobile> getMobileByCompanyAndModel(MobileCompany mobileCompany, String model) {
		List<Mobile> list = repo.findByCompanyAndModel(mobileCompany, model);
		return list;
	}

}

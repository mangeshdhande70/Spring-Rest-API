package in.ineuron.service;

import java.util.List;

import in.ineuron.model.Mobile;
import in.ineuron.model.MobileCompany;

public interface IMobileService {
	
	public String addMobile(Mobile mobile);
	
	public List<Mobile> getMobileByCompanyAndModel(MobileCompany mobileCompany , String model);

}

package in.ineuron.service;

import java.util.List;

import in.ineuron.model.MobileCases;

public interface IMobileCaseService {
	
	public String addMobileCases(MobileCases mobileCases);
	
	public List<MobileCases> getByModel(String model);

}

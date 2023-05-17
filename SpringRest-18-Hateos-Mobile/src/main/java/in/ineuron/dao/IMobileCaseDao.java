package in.ineuron.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ineuron.model.MobileCases;

public interface IMobileCaseDao extends JpaRepository<MobileCases, Long>{
	
	public List<MobileCases> findByModel(String model);

}

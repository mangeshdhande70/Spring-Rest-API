package in.ineuron.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ineuron.model.Mobile;
import in.ineuron.model.MobileCompany;

public interface IMobileDao extends JpaRepository<Mobile, Long> {
	
public List<Mobile> findByCompanyAndModel(MobileCompany company , String model);

}

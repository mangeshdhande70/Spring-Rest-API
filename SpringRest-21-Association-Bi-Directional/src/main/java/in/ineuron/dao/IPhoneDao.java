package in.ineuron.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ineuron.model.PhoneNumber;

public interface IPhoneDao extends JpaRepository<PhoneNumber, Integer> {

}

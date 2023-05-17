package in.ineuron.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ineuron.model.Person;

public interface IPersonDao extends JpaRepository<Person, Integer>{

}

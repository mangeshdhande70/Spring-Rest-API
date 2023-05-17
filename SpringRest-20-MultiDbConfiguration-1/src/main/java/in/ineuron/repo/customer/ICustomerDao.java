package in.ineuron.repo.customer;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ineuron.model.customer.Customer;



public interface ICustomerDao extends JpaRepository<Customer, Long> {

}

package osu.opr.erp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import osu.opr.erp.entity.Customer;

@Repository
public interface CustomerRepository  extends JpaRepository<Customer,Long> {
}

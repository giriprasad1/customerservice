package com.aws.customer.repoitory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aws.customer.domain.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long>{

}

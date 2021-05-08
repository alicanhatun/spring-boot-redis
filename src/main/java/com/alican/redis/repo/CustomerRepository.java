package com.alican.redis.repo;

import com.alican.redis.entity.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    Customer findByExternalId(String externalId);

    List<Customer> findByDeliveriesId(Long id);
}

package com.alican.redis;

import com.alican.redis.entity.Customer;
import com.alican.redis.entity.Delivery;
import com.alican.redis.repo.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.redis.DataRedisTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataRedisTest
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void addFirstCustomer() {
        Customer customer = generateFirstCustomer();
        customer = customerRepository.save(customer);
        assertNotNull(customer);

        Optional<Customer> byId = customerRepository.findById(1L);
        if (byId.isPresent()) {
            customer = byId.get();
            assertTrue(customer.getDeliveries().size() == 3);
        }
    }

    @Test
    public void addSecondCustomer() {
        Customer customer = generateSecondCustomer();
        customer = customerRepository.save(customer);
        assertNotNull(customer);

        Optional<Customer> byId = customerRepository.findById(1L);
        if (byId.isPresent()) {
            customer = byId.get();
            assertTrue(customer.getDeliveries().size() == 3);
        }
    }

    @Test
    public void testFindByAccounts() {
        List<Customer> deliveries = customerRepository.findByDeliveriesId(3L);
        assertEquals(1, deliveries.size());
        Customer customer = deliveries.get(0);
        assertNotNull(customer);
        assertEquals(1, customer.getId().longValue());
    }

    @Test
    public void testFindByExternal() {
        Customer customer = customerRepository.findByExternalId("1000");
        assertNotNull(customer);
        assertEquals(1, customer.getId().longValue());
    }

    private Customer generateFirstCustomer() {
        Customer customer = new Customer(1L, "John Smith");
        customer.addAccount(new Delivery(1L, "Address-1"));
        customer.addAccount(new Delivery(2L, "Address-2"));
        customer.addAccount(new Delivery(2L, "Address-3"));
        customer.addAccount(new Delivery(3L, "Address-3"));
        return customer;
    }

    private Customer generateSecondCustomer() {
        Customer customer = new Customer(100L, "John Smith");
        customer.addAccount(new Delivery(100L, "Address-100"));
        customer.addAccount(new Delivery(200L, "Address-200"));
        customer.addAccount(new Delivery(300L, "Address-300"));
        return customer;
    }
}

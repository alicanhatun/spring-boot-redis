package com.alican.redis.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@RedisHash("CUSTOMER")
public class Customer implements Serializable {

    @Id
    private Long id;

    private String name;

    private Set<Delivery> deliveries = new HashSet<>();

    public Customer(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Delivery> getDeliveries() {
        return deliveries;
    }

    public void setDelivery(Set<Delivery> deliveries) {
        this.deliveries = deliveries;
    }

    public void addAccount(Delivery delivery) {
        this.deliveries.add(delivery);
    }


}

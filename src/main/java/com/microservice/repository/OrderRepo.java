package com.microservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.microservice.entity.Order;

@Repository
public interface OrderRepo extends MongoRepository<Order, Integer>{

}

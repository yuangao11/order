package com.susangao.order.dao;

import com.susangao.order.model.Order;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface OrderDao extends ReactiveMongoRepository<Order, String> {
    @Override
    Mono<Order> findById(String s);
    @Override
    Flux<Order> findAll(Sort sort);
    @Query(value = "{ 'orderNo' : ?0}")
    Flux<Order> findByOrderNo(String orderNo);
    
}

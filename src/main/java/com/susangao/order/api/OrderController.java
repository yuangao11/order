package com.susangao.order.api;


import com.susangao.order.dao.OrderDao;
import com.susangao.order.exception.OrderServiceException;
import com.susangao.order.model.Order;
import com.susangao.order.request.MultiOrderRequest;
import com.susangao.order.service.OrderService;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping(path = "/api/v1/", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController

public class OrderController {
    
	Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private OrderDao orderDao;

    @GetMapping(path="/{id}")
    public Mono<Order> getOrderbyId(@PathVariable("id") String id){
        return orderDao.findById(id);
    }

    @GetMapping(path="/order/{orderNo}")
    public  Flux<Order> findByOrderNo(@PathVariable("orderNo") String orderNo){
        return orderDao.findByOrderNo(orderNo);
    }
    
    @GetMapping(path="/orders")
    public  Flux<Order> findAll(){
        return orderDao.findAll();
    }
    
    @PostMapping(path="/createNewOrder")
    public  Mono<Order> insertNewOrder(@RequestBody Order order){
    	return orderDao.findByOrderNo(order.getOrderNo()).collectList().flatMap(orderList -> {
    		logger.info(" orders sixe : {}" , orderList.size());
    		if (orderList.size() == 0) {
    			return orderDao.save(order);
    		} else {
    			throw new OrderServiceException("Order alreay exist");
    		}
    		
    	});
       
    }
    
    @PostMapping(path="/createOrders")
    public  Mono<String> createOrders(@RequestBody MultiOrderRequest orders){
    	Mono<String> orderString = null;
    	List<Order> ordList = orders.getOrders();
    	for (Order order: ordList) {
    		   orderDao.save(order);
    	}    	
    	return orderString;
    }
}

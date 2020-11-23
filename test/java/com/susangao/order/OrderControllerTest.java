package com.susangao.order;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.susangao.order.api.OrderController;
import com.susangao.order.dao.OrderDao;
import com.susangao.order.model.Order;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@ExtendWith(SpringExtension.class)
public class OrderControllerTest {
	@InjectMocks
	private OrderController orderController;
	
	@Mock
	private OrderDao orderDao;
	@Mock
    private ReactiveMongoTemplate reactiveMongoTemplate;
	
	
	@Test
    void testFindByOrderNo() {
        String orderNo = "2951781080173";
        when(reactiveMongoTemplate.findById(orderNo, OrderDao.class))
        .thenReturn(Mono.just(orderDao));
        
        Flux<Order> orderDoFlux = orderController.findByOrderNo(orderNo);
        		
        StepVerifier.create(orderDoFlux).expectNextCount(1).verifyComplete();
    }

}

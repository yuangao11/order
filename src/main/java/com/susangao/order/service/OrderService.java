package com.susangao.order.service;

import com.susangao.order.dao.OrderDao;
import com.susangao.order.model.Order;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderService {
    private final OrderDao orderDao;

    @Autowired
    public OrderService(OrderDao orderDao) {
        this.orderDao = orderDao;
    }
}

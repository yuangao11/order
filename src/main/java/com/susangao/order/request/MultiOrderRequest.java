package com.susangao.order.request;

import java.util.List;

import com.susangao.order.model.Order;
import com.susangao.order.model.OrderLine;

import lombok.Data;

@Data
public class MultiOrderRequest {
	 private List<Order> orders;

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

}

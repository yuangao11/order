package com.susangao.order.model;

import lombok.Data;
import lombok.NonNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("Orders")
public class Order {
	@NonNull
    private String customerAccountId;
	@NonNull
    private String orderNo;	
	@NonNull
    private String orderDate;
    
	@NotNull
    private BigDecimal orderTotal;
    @NotNull
    private Integer numOfLines;
    private List<OrderLine> orderlines;
	public String getCustomerAccountId() {
		return customerAccountId;
	}
	public void setCustomerAccountId(String customerAccountId) {
		this.customerAccountId = customerAccountId;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public BigDecimal getOrderTotal() {
		return orderTotal;
	}
	public void setOrderTotal(BigDecimal orderTotal) {
		this.orderTotal = orderTotal;
	}
	public Integer getNumOfLines() {
		return numOfLines;
	}
	public void setNumOfLines(Integer numOfLines) {
		this.numOfLines = numOfLines;
	}
	public List<OrderLine> getOrderlines() {
		return orderlines;
	}
	public void setOrderlines(List<OrderLine> orderlines) {
		this.orderlines = orderlines;
	}	
	//private long ttl;
    //private Date createdDtm;
	
	//public Date getCreatedDtm() {
	//	return createdDtm;
	//}
	//public void setCreatedDtm(Date createdDtm) {
	//	this.createdDtm = createdDtm;
	//}
	/*public long getTtl() {
		return ttl;
	}
	public void setTtl(Integer ttl) {
		 LocalDate dt1 = LocalDate.parse("2021-10-01");
		 LocalDate dt2= LocalDate.parse("2020-10-01");
		 long diffDays = ChronoUnit.DAYS.between(dt1, dt2);
		 this.ttl = diffDays;
	}*/
       
}

package com.susangao.order.model;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

public class OrderLine {
	@NotNull
	private Integer lineNo;
	@NotNull
	private String upc;
	@NotNull
	private String productName;
    @NotNull
    private BigDecimal unitPrice;
    @NotNull
    private Integer quantity;
    @NotNull
    private BigDecimal totalItemPrice;
    @NotNull
    private String shippingMethod;
    @NotNull
    private String shippingTier;
    
	public Integer getLineNo() {
		return lineNo;
	}
	public void setLineNo(Integer lineNo) {
		this.lineNo = lineNo;
	}
	public String getUpc() {
		return upc;
	}
	public void setUpc(String upc) {
		this.upc = upc;
	}
    public ShipToAddress getShipToAddress() {
		return shipToAddress;
	}
	public void setShipToAddress(ShipToAddress shipToAddress) {
		this.shipToAddress = shipToAddress;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getTotalPrice() {
		return totalItemPrice;
	}
	public void setTotalPrice(BigDecimal totalItemPrice) {
		this.totalItemPrice = totalItemPrice;
	}
	public String getShippingMethod() {
		return shippingMethod;
	}
	public void setShippingMethod(String shippingMethod) {
		this.shippingMethod = shippingMethod;
	}
	public String getShippingTier() {
		return shippingTier;
	}
	public void setShippingTier(String shippingTier) {
		this.shippingTier = shippingTier;
	}
	private ShipToAddress shipToAddress;

}

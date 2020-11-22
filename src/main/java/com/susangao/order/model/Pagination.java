package com.susangao.order.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Pagination {
    int page;
    int pageSize;
    long productsCount;
    
    public Pagination(int page, int pageSize, long productsCount) {
        this.page = page;
        this.pageSize = pageSize;
        this.productsCount = productsCount;
    }
}
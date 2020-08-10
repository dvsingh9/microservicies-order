package com.ecommerce.orderservice.feign;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemDTO implements Serializable {

    private UUID id;

    private String productName;

    private String productCode;

    private Integer salePrice;

    private Integer quantity;

}

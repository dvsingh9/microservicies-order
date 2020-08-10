package com.ecommerce.orderitemservice.web.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemRequest implements Serializable {

    @NotNull @NotBlank
    private String productName;

    @NotNull @NotBlank
    private String productCode;

    @NotNull
    private Integer salePrice;

    @NotNull
    private Integer quantity;

}

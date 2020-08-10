package com.ecommerce.orderservice.web.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest implements Serializable {

    @NotBlank @NotNull
    private String customerName;

    @NotBlank @NotNull
    private String  shippingAddress;

    @Size(min = 1)
    private Set<UUID> orderItemIds;
}

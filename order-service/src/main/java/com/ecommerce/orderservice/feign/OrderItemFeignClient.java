package com.ecommerce.orderservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(value = "orderItemFeignClient", url = "${services.orderitem.url}")
public interface OrderItemFeignClient {

    @GetMapping(value = "/orderitem/{id}")
    OrderItemDTO getOrderItems(@PathVariable UUID id);

}

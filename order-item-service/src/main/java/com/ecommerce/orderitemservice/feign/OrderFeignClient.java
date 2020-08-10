package com.ecommerce.orderitemservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(value = "orderFeignClient", url = "${services.order.url}")
public interface OrderFeignClient {

    @GetMapping(value = "/orderitems/{id}")
    OrderDTO getOrderItems(@PathVariable UUID id);

}

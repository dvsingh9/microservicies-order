package com.ecommerce.orderservice.web;

import com.ecommerce.orderservice.business.OrderService;
import com.ecommerce.orderservice.errors.RequestValidationException;
import com.ecommerce.orderservice.repository.entity.Order;
import com.ecommerce.orderservice.web.request.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public Order create(@RequestBody @Valid final OrderRequest request, BindingResult result) {
        if (result.hasErrors())
            throw new RequestValidationException("Validations failed for create order ", result.getFieldErrors());
       return orderService.create(request);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Order> getAll() {
       return orderService.getAll();
    }
}

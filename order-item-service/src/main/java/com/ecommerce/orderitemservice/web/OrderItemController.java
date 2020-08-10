package com.ecommerce.orderitemservice.web;

import com.ecommerce.orderitemservice.business.OrderItemService;
import com.ecommerce.orderitemservice.errors.RequestValidationException;
import com.ecommerce.orderitemservice.repository.entity.OrderItem;
import com.ecommerce.orderitemservice.web.request.OrderItemRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/orderitem")
public class OrderItemController {

    private final OrderItemService orderItemService;

    @Autowired
    public OrderItemController(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    @PostMapping
    public OrderItem create(@RequestBody @Valid final OrderItemRequest request, BindingResult result) {
        if (result.hasErrors())
            throw new RequestValidationException("Validations failed for order item creation", result.getFieldErrors());
       return orderItemService.create(request);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<OrderItem> getAll() {
       return orderItemService.getAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public OrderItem getById(@PathVariable final UUID id) {
        return orderItemService.getById(id);
    }


}

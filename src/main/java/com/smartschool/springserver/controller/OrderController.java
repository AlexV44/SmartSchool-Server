package com.smartschool.springserver.controller;

import com.smartschool.springserver.dto.OrderDTO;
import com.smartschool.springserver.dto.OrderRequestDTO;
import com.smartschool.springserver.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping(value = "/takeorder", consumes = {"*/*"})
    public OrderDTO takeOrder(@RequestBody OrderRequestDTO order) {
        return orderService.takeOrder(order);
    }

    //@GetMapping(value = { "", "/{id}" })
    public OrderDTO getOrder(@PathVariable("id") int id) {
        return orderService.getOrder(id);
    }

    @GetMapping("/api/orders")
    public List<OrderDTO> getOrdersBySchoolId(@PathVariable int id) {
        return orderService.getOrdersBySchoolId(id);
    }
}

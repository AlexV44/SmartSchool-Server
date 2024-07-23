package com.smartschool.springserver.mapper;

import com.smartschool.springserver.dto.OrderDTO;
import com.smartschool.springserver.dto.OrderProductDTO;
import com.smartschool.springserver.model.Order;
import com.smartschool.springserver.model.OrderProduct;

public class OrderMapper {
    private OrderMapper() {}

    public static OrderProductDTO mapOrderProduct(OrderProduct product) {
        OrderProductDTO productDto = new OrderProductDTO();
        productDto.setId(product.getPk().getProduct().getId());
        productDto.setTitle(product.getPk().getProduct().getTitle());
        productDto.setDescription(product.getPk().getProduct().getDescription());
        productDto.setPic(product.getPk().getProduct().getPic());
        productDto.setPrice(product.getPk().getProduct().getPrice());
        productDto.setQuantity(product.getQuantity());
        return productDto;
    }

    public static OrderDTO mapOrder(Order order) {
        OrderDTO orderDto = new OrderDTO();
        orderDto.setId(order.getId());
        orderDto.setMemberId(order.getSmember().getId());
        orderDto.setTime(order.getTime());
        orderDto.setSchoolId(order.getSchool().getId());
        orderDto.setProducts(order.getOrderProducts().stream().map(OrderMapper::mapOrderProduct).toList());
        return orderDto;
    }
}

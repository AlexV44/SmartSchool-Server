package com.smartschool.springserver.service;

import com.smartschool.springserver.dto.OrderDTO;
import com.smartschool.springserver.dto.OrderRequestDTO;
import com.smartschool.springserver.mapper.OrderMapper;
import com.smartschool.springserver.mapper.ProductMapper;
import com.smartschool.springserver.model.Order;
import com.smartschool.springserver.model.OrderProduct;
import com.smartschool.springserver.model.School;
import com.smartschool.springserver.model.Smember;
import com.smartschool.springserver.repository.OrderProductsRepository;
import com.smartschool.springserver.repository.OrderRepository;
import com.smartschool.springserver.repository.SchoolRepository;
import com.smartschool.springserver.repository.SmemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private SchoolRepository schoolRepository;
    @Autowired
    private SmemberRepository smemberRepository;
    @Autowired
    private OrderProductsRepository orderProductsRepository;

    public OrderDTO takeOrder(OrderRequestDTO request) {
        Order order = new Order();
        School school = schoolRepository.findById(request.getSchoolId()).get();
        Smember smember = smemberRepository.findById(request.getMemberId()).get();
        order.setSchool(school);
        order.setSmember(smember);
        order.setTime(request.getTime());
        order = orderRepository.save(order);
        Order order1 = order;
        List<OrderProduct> products = request.getProducts().stream().map(product -> new OrderProduct(order1,
                ProductMapper.mapProduct(product), product.getQuantity())).toList();
        products = Streamable.of(orderProductsRepository.saveAll(products)).toList();
        order.setOrderProducts(products);
        return OrderMapper.mapOrder(order);
    }

    public List<Order> getAllOrders() {
        List<Order> orders = new ArrayList<>();
        Streamable.of(orderRepository.findAll()).forEach(orders::add);
        return orders;
    }

    public OrderDTO getOrder(int id) {
        Optional<Order> order = orderRepository.findById(id);
        return order.map(OrderMapper::mapOrder).orElse(null);
    }

    public List<OrderDTO> getOrdersBySchoolId(int id) {
        List<Order> orders = orderRepository.findOrdersBySchoolId(id);
        return orders.stream().map(OrderMapper::mapOrder).toList();
    }
}

package com.devsuperior.dscommerce.services;

import com.devsuperior.dscommerce.dto.OrderDTO;
import com.devsuperior.dscommerce.dto.OrderItemDTO;
import com.devsuperior.dscommerce.dto.ProductDTO;
import com.devsuperior.dscommerce.entities.*;
import com.devsuperior.dscommerce.repositories.OrderItemRepository;
import com.devsuperior.dscommerce.repositories.OrderRepository;
import com.devsuperior.dscommerce.repositories.ProductRepository;
import com.devsuperior.dscommerce.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;
    @Autowired
    private UserService userService;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;
    @Transactional(readOnly = true)
    public OrderDTO findById(Long id){
        Optional<Order> result = repository.findById(id);
        Order order = result.orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
        OrderDTO dto = new OrderDTO(order);
        return dto;
    }

    @Transactional
    public OrderDTO insert(OrderDTO dto){
        Order order = new Order();

        order.setMoment(dto.getMoment());
        order.setStatus(OrderStatus.WAITING_PAYMENT);
        User user = userService.authenticated();
        order.setClient(user);

        for (OrderItemDTO x : dto.getItems()){
            Product product = productRepository.getReferenceById(x.getProductId());
            OrderItem item = new OrderItem(order,product,x.getQuantity(), product.getPrice());
            order.getItems().add(item);
        }



        order = repository.save(order);
        orderItemRepository.saveAll(order.getItems());

        return new OrderDTO(order);
    }



}

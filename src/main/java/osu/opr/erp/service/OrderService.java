package osu.opr.erp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import osu.opr.erp.entity.Order;
import osu.opr.erp.repository.OrderRepository;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Order saveOrder(Order order){
        return orderRepository.save(order);
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order findOrderById(Long id) {
        return orderRepository.findOrderById(id);
    }

    public void deleteOrderById(Long id) {
        orderRepository.deleteById(id);
    }
}

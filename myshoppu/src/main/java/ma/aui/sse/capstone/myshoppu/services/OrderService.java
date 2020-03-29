package ma.aui.sse.capstone.myshoppu.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.aui.sse.capstone.myshoppu.data.dtos.ShoppingCart;
import ma.aui.sse.capstone.myshoppu.data.entities.Order;
import ma.aui.sse.capstone.myshoppu.data.entities.OrderStatus;
import ma.aui.sse.capstone.myshoppu.data.entities.User;
import ma.aui.sse.capstone.myshoppu.data.repositeries.OrderRepository;
import ma.aui.sse.capstone.myshoppu.data.repositeries.UserRepository;

/**
 *
 * @author Youness AYYADA
 */
@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ShoppingCartService shoppingCartService;

    public List<Order> getOrdersByCustomer(long customerId) {
        return orderRepository.findByCustomer(customerId);
    }

    public void checkout(long userId) {
        User user = userRepository.findById(userId).get();
        ShoppingCart shoppingCart = shoppingCartService.getShoppingCart(userId);
        if(shoppingCart == null || shoppingCart.getProductsTotalPrice() == 0)
            return;

        Order order = new Order(shoppingCart, user);
        orderRepository.save(order);
        shoppingCartService.empty(shoppingCart, user.getId());
    }

    public void updateOrderStatus(long orderId, OrderStatus newStatus){
        Order order = orderRepository.findById(orderId).get();
        order.updateStatus(newStatus);
        orderRepository.save(order);
    }
}
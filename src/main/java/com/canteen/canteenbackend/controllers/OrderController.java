package com.canteen.canteenbackend.controllers;

import com.canteen.canteenbackend.models.dbmodels.Order;
import com.canteen.canteenbackend.models.pojos.ApiResponse;
import com.canteen.canteenbackend.repositories.OrderRepository;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    OrderRepository orderRepository;

    @GetMapping("/orders")
    public List<Order> getOrders(@RequestParam String email) {

        return orderRepository.findAllByEmail(email);
    }

    @PostMapping("/orders/create")
    public ApiResponse placeOrder(@RequestParam String orderId) throws RazorpayException {
        RazorpayClient razorpayClient = new RazorpayClient("[YOUR_KEY_ID]", "[YOUR_KEY_SECRET]");
        com.razorpay.Order razorpayOrder = razorpayClient.orders.fetch(orderId);
        if(razorpayOrder.get("status").equals("created")) {
            Order order = new Order();
            order.setId(razorpayOrder.get("id"));
            order.setOrderTime(razorpayOrder.get("created_at"));
            orderRepository.save(order);
            return new ApiResponse("Order created successfully!", true, order);
        }
        return new ApiResponse("Order Not Created!", false, null);
    }

    @PutMapping("/orders/{id}")
    public ApiResponse updateOrderStatus(@PathVariable String id, @RequestParam String status) {
        if(!orderRepository.existsById(id)) {
            return new ApiResponse("Order does not exist!", false, null);
        }
        Order order = orderRepository.findById(id).get();
        order.setOrderStatus(status);
        orderRepository.save(order);
        return new ApiResponse("Order status updated successfully!", true, order);
    }
}

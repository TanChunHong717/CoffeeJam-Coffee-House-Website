package org.example.restaurantwebsite.service;

import com.github.pagehelper.PageInfo;
import org.example.restaurantwebsite.pojo.Order;

import java.util.List;

public interface OrderService {
    PageInfo<Order> getOrderPage(Integer pageNum);
    PageInfo<Order> getUserOrderPage(Integer pageNum, Integer userId);
    Order getOrder(Integer orderId);
    void makeOrder(Order order, List<Integer> menuIds);
}

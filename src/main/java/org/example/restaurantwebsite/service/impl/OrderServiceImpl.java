package org.example.restaurantwebsite.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.example.restaurantwebsite.mapper.OrderMapper;
import org.example.restaurantwebsite.pojo.Order;
import org.example.restaurantwebsite.pojo.PageSize;
import org.example.restaurantwebsite.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    private OrderMapper orderMapper;

    @Autowired
    public OrderServiceImpl(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    @Override
    public PageInfo<Order> getOrderPage(Integer pageNum) {
        PageHelper.startPage(pageNum, PageSize.PAGE_NUMBER);
        List<Order> orderList = orderMapper.getAllOrder();
        return new PageInfo<>(orderList, PageSize.NAVIGATES_PAGE_NUMBER);
    }

    @Override
    public PageInfo<Order> getUserOrderPage(Integer pageNum, Integer userId) {
        PageHelper.startPage(pageNum, PageSize.PAGE_NUMBER);
        List<Order> orderList = orderMapper.getOrderByUser(userId);
        return new PageInfo<>(orderList, PageSize.NAVIGATES_PAGE_NUMBER);
    }

    @Override
    public Order getOrder(Integer orderId) {
        return orderMapper.getOrder(orderId);
    }

    @Override
    public void makeOrder(Order order, List<Integer> menuIds) {
        orderMapper.insertOrder(order);
        orderMapper.insertOrderMenu(order.getOrderId(), menuIds);
    }
}

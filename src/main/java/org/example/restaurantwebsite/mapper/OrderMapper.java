package org.example.restaurantwebsite.mapper;

import org.apache.ibatis.annotations.Param;
import org.aspectj.weaver.ast.Or;
import org.example.restaurantwebsite.pojo.Menu;
import org.example.restaurantwebsite.pojo.Order;

import java.util.List;

public interface OrderMapper {
    List<Order> getAllOrder();
    List<Order> getOrderByUser(Integer userId);
    Order getOrder(Integer orderId);
    void insertOrder(Order order);
    void insertOrderMenu(@Param("orderId") Integer orderId, @Param("menuIds") List<Integer> menuIds);
}

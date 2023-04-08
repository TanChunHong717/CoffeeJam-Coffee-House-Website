package org.example.restaurantwebsite.pojo;

import java.sql.Timestamp;
import java.util.List;

public class OrderMenus {
    private Integer orderId;
    private Integer orderUserId;
    private Integer orderTableId;
    private List<Integer> menuIds;

    public OrderMenus() {
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getOrderUserId() {
        return orderUserId;
    }

    public void setOrderUserId(Integer orderUserId) {
        this.orderUserId = orderUserId;
    }

    public Integer getOrderTableId() {
        return orderTableId;
    }

    public void setOrderTableId(Integer orderTableId) {
        this.orderTableId = orderTableId;
    }

    public List<Integer> getMenuIds() {
        return menuIds;
    }

    public void setMenuIds(List<Integer> menuIds) {
        this.menuIds = menuIds;
    }

    public Order toOrder() {
        return new Order(orderId, new User(orderUserId), new Table(orderTableId));
    }
}

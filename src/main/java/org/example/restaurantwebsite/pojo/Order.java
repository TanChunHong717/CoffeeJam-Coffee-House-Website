package org.example.restaurantwebsite.pojo;

import java.sql.Timestamp;
import java.util.List;

public class Order {
    private Integer orderId;
    private User orderUser;
    private Table orderTable;

    private List<Menu> menuList;

    public Order() {
    }

    public Order(Integer orderId, User orderUser, Table orderTable) {
        this.orderId = orderId;
        this.orderUser = orderUser;
        this.orderTable = orderTable;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public User getOrderUser() {
        return orderUser;
    }

    public void setOrderUser(User orderUser) {
        this.orderUser = orderUser;
    }

    public Table getOrderTable() {
        return orderTable;
    }

    public void setOrderTable(Table orderTable) {
        this.orderTable = orderTable;
    }

    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderUser=" + orderUser +
                ", orderTable=" + orderTable +
                ", menuList=" + menuList +
                '}';
    }
}

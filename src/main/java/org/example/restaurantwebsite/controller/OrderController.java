package org.example.restaurantwebsite.controller;

import com.github.pagehelper.PageInfo;
import org.example.restaurantwebsite.pojo.*;
import org.example.restaurantwebsite.service.MenuService;
import org.example.restaurantwebsite.service.OrderService;
import org.example.restaurantwebsite.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;


@Controller
public class OrderController {
    private TableService tableService;
    private MenuService menuService;
    private OrderService orderService;

    @Autowired
    public void setTableService(TableService tableService) {
        this.tableService = tableService;
    }

    @Autowired
    public void setMenuService(MenuService menuService) {
        this.menuService = menuService;
    }

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping("/")
    public String getIndex(Model model) {
        PageInfo<Menu> page = menuService.getMenuPage(1);
        model.addAttribute("page", page);
        return "index";
    }

    @RequestMapping("/admin")
    public String getAdminIndex(Model model) {
        PageInfo<Order> page = orderService.getOrderPage(1);
        model.addAttribute("page", page);
        return "admin_index";
    }

    @RequestMapping("/admin/order/page/{pageNum}")
    public String getOrderPage(@PathVariable("pageNum") Integer pageNum, Model model) {
        PageInfo<Order> page = orderService.getOrderPage(pageNum);
        model.addAttribute("page", page);
        return "admin_index";
    }

    @RequestMapping("/admin/order/{orderId}")
    public String getAdminIndex(@PathVariable("orderId") Integer orderId, Model model) {
        Order order = orderService.getOrder(orderId);
        model.addAttribute("order", order);
        return "order_details";
    }

    @RequestMapping("/order/page/{pageNum}")
    public String getUserOrder(HttpSession session, @PathVariable("pageNum") Integer pageNum, Model model) {
        PageInfo<Order> page = orderService.getUserOrderPage(pageNum, ((User)session.getAttribute("user")).getUserId());
        model.addAttribute("page", page);
        return "admin_index";
    }

    @RequestMapping("/make/order")
    public String toMakeOrder(Model model) {
        model.addAttribute("tableList", tableService.getAllTable());
        model.addAttribute("menuList", menuService.getAllMenu());
        return "make_order";
    }

    @PostMapping("/order")
    public String makeOrder(OrderMenus orderMenus) {
        orderService.makeOrder(orderMenus.toOrder(), orderMenus.getMenuIds());
        return "success";
    }
}

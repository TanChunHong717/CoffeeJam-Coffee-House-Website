package org.example.restaurantwebsite.service;

import com.github.pagehelper.PageInfo;
import org.example.restaurantwebsite.pojo.Menu;

import java.util.List;

public interface MenuService {
    PageInfo<Menu> getMenuPage(Integer pageNum);
    List<Menu> getMenuBeOrder(Integer orderId);
    Menu getMenu(Integer menuId);
    void insertMenu(Menu menu);
    void deleteMenu(Integer menuId);
    void updateMenu(Menu menu);

    Object getAllMenu();
}

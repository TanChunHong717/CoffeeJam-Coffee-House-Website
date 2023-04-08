package org.example.restaurantwebsite.mapper;

import org.apache.ibatis.annotations.Param;
import org.example.restaurantwebsite.pojo.Menu;

import java.util.List;

public interface MenuMapper {
    List<Menu> getAllMenu();
    Menu getMenu(@Param("menuId") Integer menuId);
    void insertMenu(Menu menu);
    void deleteMenu(@Param("menuId") Integer menuId);
    void updateMenu(Menu menu);
    List<Menu> getMenuBeOrder(Integer orderId);
}

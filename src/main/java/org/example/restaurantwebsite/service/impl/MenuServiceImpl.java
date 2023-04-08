package org.example.restaurantwebsite.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.example.restaurantwebsite.mapper.MenuMapper;
import org.example.restaurantwebsite.pojo.Menu;
import org.example.restaurantwebsite.pojo.PageSize;
import org.example.restaurantwebsite.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MenuServiceImpl implements MenuService {
    private MenuMapper menuMapper;

    @Autowired
    public MenuServiceImpl(MenuMapper menuMapper) {
        this.menuMapper = menuMapper;
    }

    public PageInfo<Menu> getMenuPage(Integer pageNum) {
        PageHelper.startPage(pageNum, PageSize.PAGE_NUMBER);
        List<Menu> menuList = menuMapper.getAllMenu();
        return new PageInfo<Menu>(menuList, PageSize.NAVIGATES_PAGE_NUMBER);
    }

    @Override
    public List<Menu> getMenuBeOrder(Integer orderId) {
        return menuMapper.getMenuBeOrder(orderId);
    }

    @Override
    public Menu getMenu(Integer menuId) {
        return menuMapper.getMenu(menuId);
    }

    public void insertMenu(Menu menu) {
        menuMapper.insertMenu(menu);
    }

    public void deleteMenu(Integer menuId) {
        menuMapper.deleteMenu(menuId);
    }

    public void updateMenu(Menu menu) {
        menuMapper.updateMenu(menu);
    }

    @Override
    public Object getAllMenu() {
        return menuMapper.getAllMenu();
    }
}

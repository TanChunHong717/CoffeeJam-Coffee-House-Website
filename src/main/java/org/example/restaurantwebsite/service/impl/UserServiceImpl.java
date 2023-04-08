package org.example.restaurantwebsite.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.example.restaurantwebsite.mapper.MenuMapper;
import org.example.restaurantwebsite.mapper.UserMapper;
import org.example.restaurantwebsite.pojo.Menu;
import org.example.restaurantwebsite.pojo.PageSize;
import org.example.restaurantwebsite.pojo.User;
import org.example.restaurantwebsite.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public PageInfo<User> getUserPage(Integer pageNum) {
        PageHelper.startPage(pageNum, PageSize.PAGE_NUMBER);
        List<User> userList = userMapper.getAllUser();
        return new PageInfo<User>(userList, PageSize.NAVIGATES_PAGE_NUMBER);
    }

    @Override
    public User getUser(Integer userId) {
        return userMapper.getUserById(userId);
    }

    @Override
    public User getUser(String username) {
        return userMapper.getUserByName(username);
    }

    @Override
    public void registerUser(User user) {
        userMapper.registerUser(user);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public boolean login(String username, String password) {
        User user = getUser(username);
        if(user.getPassword().equals(password))
            return true;
        else
            return false;
    }
}

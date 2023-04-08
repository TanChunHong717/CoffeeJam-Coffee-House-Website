package org.example.restaurantwebsite.service;

import com.github.pagehelper.PageInfo;
import org.example.restaurantwebsite.pojo.User;

public interface UserService {
    PageInfo<User> getUserPage(Integer pageNum);
    User getUser(Integer userId);
    User getUser(String username);
    void registerUser(User user);
    void updateUser(User user);
    boolean login(String username, String password);
}

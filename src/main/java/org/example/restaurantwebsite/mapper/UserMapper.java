package org.example.restaurantwebsite.mapper;

import org.apache.ibatis.annotations.Param;
import org.example.restaurantwebsite.pojo.User;

import java.util.List;

public interface UserMapper {
    List<User> getAllUser();
    User getUserById(@Param("userId") Integer userId);
    User getUserByName(@Param("username") String username);
    void registerUser(User user);
    void updateUser(User user);
}

package com.bjpowernode.finance.service;

import com.bjpowernode.finance.entity.Proportion;
import com.bjpowernode.finance.entity.OutAndIn;
import com.bjpowernode.finance.entity.User;

import java.util.List;

public interface UserService {

    User selectUserByTerms(String username, String password);

    List<User> selectUserByStatusDesc();

    List<User> selectAllUser();

    Integer updateUser(User user);

    Integer insertUser(User user);

    User selectUserById(Integer id);

    Integer deleteUserById(Integer id);

    /**
     * 收支情况
     * @param userId
     * @return
     */
    OutAndIn selectByUser(Integer userId);

    /**
     * 收藏数量.
     * @param userId
     * @return
     */
    Proportion selectCollection(Integer userId);
}

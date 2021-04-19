package com.bjpowernode.finance.service;

import com.bjpowernode.finance.common.Msg;
import com.bjpowernode.finance.entity.Admin;
import com.bjpowernode.finance.entity.Exam;
import com.bjpowernode.finance.entity.Proportion;
import com.bjpowernode.finance.entity.OutAndIn;
import com.bjpowernode.finance.entity.User;

import java.util.Date;
import java.util.List;

public interface UserService {

    User selectUserByTerms(String username, String password);

    List<User> selectAllUser(Admin admin);

    Integer updateUser(User user);

    Integer insertUser(User user);

    User selectUserById(Integer id);

    Integer deleteUserById(Integer id);

    /**
     * 收支情况
     * @param userId
     * @param flag
     * @return
     */
    OutAndIn selectByUser(Integer userId, Integer flag);

    /**
     * 收藏数量.
     * @param userId
     * @return
     */
    Proportion selectCollection(Integer userId);

    /**
     * 增加风险级别.
     * @param user
     * @param exam
     */
    String addRisk(User user, Exam exam);

    /**
     * 新增用户.
     * @param adminId
     * @param user
     */
    Msg insertAdminUser(Integer adminId, User user);

    List<Admin> selectAllAdmin();

    List<User> selectUser();

    Msg updateAdminUser(User user);
}

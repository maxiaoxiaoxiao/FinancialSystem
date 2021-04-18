package com.bjpowernode.finance.mapper;

import com.bjpowernode.finance.entity.AdminUserRela;
import com.bjpowernode.finance.entity.OutAndIn;
import com.bjpowernode.finance.entity.User;
import com.bjpowernode.finance.entity.UserExample;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    Integer insertUser(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKey(User record);

    /**
     * 查询支出和收入.
     * @param userId
     * @param flag
     * @return
     */
    OutAndIn selectByUser(@Param("userId") Integer userId, @Param("flag") Integer flag);

    Integer selectChangeMoney(@Param("userId") Integer userId);

    Integer selectFundProduct(@Param("userId") Integer userId);

    Integer selectPayMoney(@Param("userId") Integer userId);

    Integer selectTermFinancial(@Param("userId") Integer userId);

    Integer updateUser(@Param("user") User user);

    List<User> selectAllUser(@Param("adminId") Integer adminId);

    User selectByName(@Param("username") String username);

    void insertAdminUser(@Param("adminId") Integer adminId, @Param("userId") Integer userId);

    AdminUserRela selectAdminUser(@Param("adminId") Integer adminId, @Param("userId") Integer userId);

    void deleteAdminser(@Param("id") Integer id);
}

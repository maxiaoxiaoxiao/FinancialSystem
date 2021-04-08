package com.bjpowernode.finance.mapper;

import com.bjpowernode.finance.entity.OutAndIn;
import com.bjpowernode.finance.entity.User;
import com.bjpowernode.finance.entity.UserExample;

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

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 查询支出和收入.
     * @param userId
     * @return
     */
    OutAndIn selectByUser(@Param("userId") Integer userId);

    Integer selectChangeMoney(@Param("userId") Integer userId);

    Integer selectFundProduct(@Param("userId") Integer userId);

    Integer selectPayMoney(@Param("userId") Integer userId);

    Integer selectTermFinancial(@Param("userId") Integer userId);
}

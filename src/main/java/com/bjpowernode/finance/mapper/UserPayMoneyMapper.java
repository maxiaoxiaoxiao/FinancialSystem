package com.bjpowernode.finance.mapper;

import com.bjpowernode.finance.entity.PayMoney;
import com.bjpowernode.finance.entity.UserPayMoney;
import com.bjpowernode.finance.entity.UserPayMoneyExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserPayMoneyMapper {
    long countByExample(UserPayMoneyExample example);

    int deleteByExample(UserPayMoneyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserPayMoney record);

    int insertSelective(UserPayMoney record);

    List<UserPayMoney> selectByExample(UserPayMoneyExample example);

    UserPayMoney selectByPrimaryKey(Integer id);


    UserPayMoney selectByPrimaryKeyWithUserAndPayMoney(Integer id);

    int updateByExampleSelective(@Param("record") UserPayMoney record, @Param("example") UserPayMoneyExample example);

    int updateByExample(@Param("record") UserPayMoney record, @Param("example") UserPayMoneyExample example);

    int updateByPrimaryKeySelective(UserPayMoney record);

    int updateByPrimaryKey(UserPayMoney record);

    /**
     * 推荐的工资理财.
     * @param userId
     * @return
     */
  List<UserPayMoney> selectUserPayMoneyByUser(@Param("userId") Integer userId);

    /**
     * 查询是否已经收藏过
     * @param userId
     * @param payMoneyId
     * @return
     */
  Integer selectByUserIdAndPayId(@Param("userId") Integer userId, @Param("payMoneyId") Integer payMoneyId);

    List<PayMoney> selectUserPayMoneyByUserId(@Param("userId") Integer userId);
}

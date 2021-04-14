package com.bjpowernode.finance.mapper;

import com.bjpowernode.finance.entity.ChangeMoney;
import com.bjpowernode.finance.entity.UserChangeMoney;
import com.bjpowernode.finance.entity.UserChangeMoneyExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserChangeMoneyMapper {

    long countByExample(UserChangeMoneyExample example);

    int deleteByExample(UserChangeMoneyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserChangeMoney record);

    int insertSelective(UserChangeMoney record);

    List<UserChangeMoney> selectByExample(UserChangeMoneyExample example);

    UserChangeMoney selectByPrimaryKey(Integer id);

    UserChangeMoney selectByPrimaryKeyWithUserAndChangeMoney(@Param("id") Integer id, @Param("userId") Integer userId);

    int updateByExampleSelective(@Param("record") UserChangeMoney record, @Param("example") UserChangeMoneyExample example);

    int updateByExample(@Param("record") UserChangeMoney record, @Param("example") UserChangeMoneyExample example);

    int updateByPrimaryKeySelective(UserChangeMoney record);

    int updateByPrimaryKey(UserChangeMoney record);

    /**
     *查询推荐的股票类基金
     * @param userId
     * @return
     */
  List<ChangeMoney> selectUserChangeMoneyByUser(@Param("userId") Integer userId);

    /**
     * 查询是否存在.
     * @param userId
     * @param changeMoneyId
     * @return
     */
  Integer selectByUserIdAndChangeMoneyId(
      @Param("userId") Integer userId, @Param("changeMoneyId") Integer changeMoneyId);

    /**
     *
     * @param userId
     * @return
     */
    List<ChangeMoney> selectUserChangeMoneyByUserId(@Param("userId") Integer userId);
}

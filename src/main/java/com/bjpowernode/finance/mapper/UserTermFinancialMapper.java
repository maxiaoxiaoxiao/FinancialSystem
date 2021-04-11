package com.bjpowernode.finance.mapper;

import com.bjpowernode.finance.entity.TermFinancial;
import com.bjpowernode.finance.entity.UserTermFinancial;
import com.bjpowernode.finance.entity.UserTermFinancialExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserTermFinancialMapper {
    long countByExample(UserTermFinancialExample example);

    int deleteByExample(UserTermFinancialExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserTermFinancial record);

    int insertSelective(UserTermFinancial record);

    List<UserTermFinancial> selectByExample(UserTermFinancialExample example);

    UserTermFinancial selectByPrimaryKey(Integer id);


    UserTermFinancial selectByPrimaryKeyWithUserAndTermFinancial(Integer id);

    int updateByExampleSelective(@Param("record") UserTermFinancial record, @Param("example") UserTermFinancialExample example);

    int updateByExample(@Param("record") UserTermFinancial record, @Param("example") UserTermFinancialExample example);

    int updateByPrimaryKeySelective(UserTermFinancial record);

    int updateByPrimaryKey(UserTermFinancial record);

    /**
     * 推荐的期限理财.
     *
     * @param userId
     * @return
     */
  List<TermFinancial> selectUserTermFinancialByUser(@Param("userId") Integer userId);

    /**
     *
     * @param userId
     * @param termFinancialId
     * @return
     */
  Integer selectByUserIdAndtermId(@Param("userId") Integer userId, @Param("termFinancialId") Integer termFinancialId);

    List<TermFinancial> selectUserTermFinancialByUserId(@Param("userId") Integer userId);
}

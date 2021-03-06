package com.bjpowernode.finance.mapper;

import com.bjpowernode.finance.entity.FundProduct;
import com.bjpowernode.finance.entity.UserFundProduct;
import com.bjpowernode.finance.entity.UserFundProductExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserFundProductMapper {
    long countByExample(UserFundProductExample example);

    int deleteByExample(UserFundProductExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserFundProduct record);

    int insertSelective(UserFundProduct record);

    List<UserFundProduct> selectByExample(UserFundProductExample example);

    UserFundProduct selectByPrimaryKey(Integer id);

    UserFundProduct selectByPrimaryKeyWithUserAndFundProduct(@Param("id") Integer id, @Param("userId") Integer userId);

    int updateByExampleSelective(@Param("record") UserFundProduct record, @Param("example") UserFundProductExample example);

    int updateByExample(@Param("record") UserFundProduct record, @Param("example") UserFundProductExample example);

    int updateByPrimaryKeySelective(UserFundProduct record);

    int updateByPrimaryKey(UserFundProduct record);

    /**
     * 推荐的混合类基金.
     *
     * @param userId
     * @return
     */
  List<FundProduct> selectUserFundProductByUser(@Param("userId") Integer userId);

    Integer selectByUserIdAndFundId(@Param("userId") Integer userId, @Param("fundProductId") Integer fundProductId);

    List<FundProduct> selectUserFundProductByUserId(@Param("userId") Integer userId);
}

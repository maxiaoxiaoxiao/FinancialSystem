package com.bjpowernode.finance.mapper;

import com.bjpowernode.finance.entity.PayMoney;
import com.bjpowernode.finance.entity.PayMoneyExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PayMoneyMapper {
    long countByExample(PayMoneyExample example);

    int deleteByExample(PayMoneyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PayMoney record);

    int insertSelective(PayMoney record);


    PayMoney selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PayMoney record, @Param("example") PayMoneyExample example);

    int updateByExample(@Param("record") PayMoney record, @Param("example") PayMoneyExample example);

    int updateByPrimaryKeySelective(PayMoney record);

    int updateByPrimaryKey(PayMoney record);

  /**
   * 查询你所有的工资理财.
   *
   * @return
   * @param code
   * @param name
   * @param company
   * @param people
   */
  List<PayMoney> selectAllPayMoney(
      @Param("code") String code,
      @Param("name") String name,
      @Param("company") String company,
      @Param("people") String people);
}

package com.bjpowernode.finance.mapper;

import com.bjpowernode.finance.entity.ChangeMoney;
import com.bjpowernode.finance.entity.ChangeMoneyExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ChangeMoneyMapper {
    long countByExample(ChangeMoneyExample example);

    int deleteByExample(ChangeMoneyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ChangeMoney record);

    int insertSelective(ChangeMoney record);


    ChangeMoney selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ChangeMoney record, @Param("example") ChangeMoneyExample example);

    int updateByExample(@Param("record") ChangeMoney record, @Param("example") ChangeMoneyExample example);

    int updateByPrimaryKeySelective(ChangeMoney record);

    int updateByPrimaryKey(ChangeMoney record);

  /**
   * 查询所有的零钱理财.
   *
   * @return
   * @param id
   * @param name
   * @param company
   * @param people
   */
  List<ChangeMoney> selectAllChangeMoney(
      @Param("id") Integer id,
      @Param("name") String name,
      @Param("company") String company,
      @Param("people") String people);
}

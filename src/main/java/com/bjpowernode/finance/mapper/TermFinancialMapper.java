package com.bjpowernode.finance.mapper;

import com.bjpowernode.finance.entity.TermFinancial;
import com.bjpowernode.finance.entity.TermFinancialExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TermFinancialMapper {
    long countByExample(TermFinancialExample example);

    int deleteByExample(TermFinancialExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TermFinancial record);

    int insertSelective(TermFinancial record);


    TermFinancial selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TermFinancial record, @Param("example") TermFinancialExample example);

    int updateByExample(@Param("record") TermFinancial record, @Param("example") TermFinancialExample example);

    int updateByPrimaryKeySelective(TermFinancial record);

    int updateByPrimaryKey(TermFinancial record);

  /**
   * 查询货币基金.
   *
   * @return
   * @param code
   * @param name
   * @param company
   * @param people
   */
  List<TermFinancial> selectAllTermFinancial(
      @Param("code") String code,
      @Param("name") String name,
      @Param("company") String company,
      @Param("people") String people);
}

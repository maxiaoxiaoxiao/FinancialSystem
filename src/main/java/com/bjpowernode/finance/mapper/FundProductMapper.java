package com.bjpowernode.finance.mapper;

import com.bjpowernode.finance.entity.FundProduct;
import com.bjpowernode.finance.entity.FundProductExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FundProductMapper {
    long countByExample(FundProductExample example);

    int deleteByExample(FundProductExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FundProduct record);

    int insertSelective(FundProduct record);


    FundProduct selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FundProduct record, @Param("example") FundProductExample example);

    int updateByExample(@Param("record") FundProduct record, @Param("example") FundProductExample example);

    int updateByPrimaryKeySelective(FundProduct record);

    int updateByPrimaryKey(FundProduct record);

  /**
   * 查询基金理财.
   *
   * @return
   * @param code
   * @param name
   * @param company
   * @param people
   */
  List<FundProduct> selectAllFundProduct(
      @Param("code") String code,
      @Param("name") String name,
      @Param("company") String company,
      @Param("people") String people);
}

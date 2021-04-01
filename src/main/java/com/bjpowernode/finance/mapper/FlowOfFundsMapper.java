package com.bjpowernode.finance.mapper;

import com.bjpowernode.finance.entity.FlowOfFunds;
import com.bjpowernode.finance.entity.FlowOfFundsExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FlowOfFundsMapper {
    long countByExample(FlowOfFundsExample example);

    int deleteByExample(FlowOfFundsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FlowOfFunds record);

    int insertSelective(FlowOfFunds record);


    FlowOfFunds selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FlowOfFunds record, @Param("example") FlowOfFundsExample example);

    int updateByExample(@Param("record") FlowOfFunds record, @Param("example") FlowOfFundsExample example);

    int updateByPrimaryKeySelective(FlowOfFunds record);

    int updateByPrimaryKey(FlowOfFunds record);

    /**
     * 新增或者是编辑收支记录.
     * @param flowOfFunds
     */
    void addRecord(@Param("flowOfFunds") FlowOfFunds flowOfFunds);

    /**
     * 更新收支记录
     * @param flowOfFunds
     */
    void updateRecord(@Param("flowOfFunds") FlowOfFunds flowOfFunds);

    /**
     * 查询收支记录.
     * @param userId
     * @param type
     * @return
     */
    List<FlowOfFunds> selectFlowOfFunds(@Param("userId") Integer userId, @Param("type") Integer type);
}

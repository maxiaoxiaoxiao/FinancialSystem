package com.bjpowernode.finance.service;

import com.bjpowernode.finance.common.Msg;
import com.bjpowernode.finance.entity.FlowOfFunds;

import java.util.List;

public interface FlowOfFundsService {


    List<FlowOfFunds> selectFlowOfFundsByUserId(Integer userId,Integer type);

    /**
     * 新增或者是编辑收支记录.
     *
     * @param flowOfFunds
     * @return
     */
    Msg addRecord(FlowOfFunds flowOfFunds);

    /**
     * 删除收支记录.
     *
     * @param id
     * @return
     */
    Msg deleteRecord(Integer id);
}

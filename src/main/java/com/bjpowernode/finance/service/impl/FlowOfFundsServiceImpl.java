package com.bjpowernode.finance.service.impl;

import com.bjpowernode.finance.common.Msg;
import com.bjpowernode.finance.entity.FlowOfFunds;
import com.bjpowernode.finance.mapper.FlowOfFundsMapper;
import com.bjpowernode.finance.service.FlowOfFundsService;
import com.bjpowernode.finance.utils.CheckEmptyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class FlowOfFundsServiceImpl implements FlowOfFundsService {

    @Autowired
    FlowOfFundsMapper flowOfFundsMapper;

    @Override
    public List<FlowOfFunds> selectFlowOfFundsByUserId(Integer userId,Integer type) {

        return flowOfFundsMapper.selectFlowOfFunds(userId,type);
    }

    @Override
    public Msg addRecord(FlowOfFunds flowOfFunds) {
        if (CheckEmptyUtil.isEmpty(flowOfFunds.getId())) {
            flowOfFundsMapper.addRecord(flowOfFunds);
        } else {
            flowOfFundsMapper.updateRecord(flowOfFunds);
        }
        return Msg.success();
    }

    @Override
    public Msg deleteRecord(Integer id) {
        flowOfFundsMapper.deleteByPrimaryKey(id);
        return Msg.success();
    }
}

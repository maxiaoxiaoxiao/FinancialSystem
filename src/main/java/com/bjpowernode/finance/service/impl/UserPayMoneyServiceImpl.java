package com.bjpowernode.finance.service.impl;

import com.bjpowernode.finance.common.Msg;
import com.bjpowernode.finance.entity.PayMoney;
import com.bjpowernode.finance.entity.UserPayMoney;
import com.bjpowernode.finance.entity.UserPayMoneyExample;
import com.bjpowernode.finance.mapper.PayMoneyMapper;
import com.bjpowernode.finance.mapper.UserPayMoneyMapper;
import com.bjpowernode.finance.service.UserPayMoneyService;
import java.math.BigDecimal;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserPayMoneyServiceImpl implements UserPayMoneyService {

    @Autowired
    UserPayMoneyMapper userPayMoneyMapper;
    @Autowired
    PayMoneyMapper payMoneyMapper;

    @Override
    @Transactional
    public Msg insertUserPayMoney(Integer payMoneyId, Integer userId) {
        Integer userPayMoney = userPayMoneyMapper.selectByUserIdAndPayId(userId,payMoneyId);
        Msg msg = new Msg();
        msg.setCode(100);
        if (userPayMoney ==1) {
            msg.setMsg("已经收藏过该理财产品");
            return msg;
        }
        PayMoney pm = payMoneyMapper.selectByPrimaryKey(payMoneyId);
        UserPayMoney upm = new UserPayMoney();
        upm.setUserid(userId);
        upm.setPayid(payMoneyId);
        upm.setStarttime(new Date());
        upm.setAveryield(new BigDecimal("0.03123"));
        upm.setProfit(new BigDecimal("0.03123").multiply(pm.getMonthmoney()));
        upm.setStatus(1);
        userPayMoneyMapper.insertSelective(upm);
        msg.setMsg("收藏成功");
        return msg;
    }

    @Override
    public List<PayMoney> selectUserPayMoneyByUserId(Integer userId) {

        return userPayMoneyMapper.selectUserPayMoneyByUserId(userId);
    }

    @Override
    @Transactional
    public Integer updateUserPayMoney(UserPayMoney userPayMoney) {
        return userPayMoneyMapper.updateByPrimaryKeySelective(userPayMoney);
    }

    @Override
    public UserPayMoney selectUserPayMoneyById(Integer id) {
        return userPayMoneyMapper.selectByPrimaryKeyWithUserAndPayMoney(id);
    }

  @Override
  public List<PayMoney> selectUserPayMoneyByUser(Integer userId) {

        return userPayMoneyMapper.selectUserPayMoneyByUser(userId);
  }
}

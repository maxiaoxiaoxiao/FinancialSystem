package com.bjpowernode.finance.service.impl;

import com.bjpowernode.finance.common.Msg;
import com.bjpowernode.finance.entity.News;
import com.bjpowernode.finance.entity.PayMoney;
import com.bjpowernode.finance.entity.UserPayMoney;
import com.bjpowernode.finance.mapper.PayMoneyMapper;
import com.bjpowernode.finance.mapper.UserPayMoneyMapper;
import com.bjpowernode.finance.mapper.UserTermFinancialMapper;
import com.bjpowernode.finance.service.UserPayMoneyService;
import java.math.BigDecimal;
import java.util.ArrayList;
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
    @Autowired
    UserTermFinancialMapper userTermFinancialMapper;

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
    public UserPayMoney selectUserPayMoneyById(Integer id,Integer userId) {
        return userPayMoneyMapper.selectByPrimaryKeyWithUserAndPayMoney(id,userId);
    }

  @Override
  public List<PayMoney> selectUserPayMoneyByUser(Integer userId) {

        return userPayMoneyMapper.selectUserPayMoneyByUser(userId);
  }

    @Override
    public void deleteUserPayMoney(UserPayMoney upm) {
        userPayMoneyMapper.deleteByPrimaryKey(upm.getId());
    }

  @Override
  public void insertUserPayMoneyList(
      Integer payMoneyId, List<Integer> userIdList, Integer adminId, String content) {
      List<News> news = new ArrayList<>();
      Date date = new Date();
    PayMoney payMoney = payMoneyMapper.selectByPrimaryKey(payMoneyId);
    userIdList.stream()
        .forEach(
            id -> {
              Integer integer =
                  userPayMoneyMapper.selectByUserIdAndPayId(id, payMoneyId);
              if (integer == 0) {
                UserPayMoney userPayMoney = new UserPayMoney();
                userPayMoney.setPayid(payMoneyId);
                userPayMoney.setUserid(id);
                userPayMoneyMapper.insertSelective(userPayMoney);
              }
              News n = new News();
              n.setCreateTime(date);
              n.setAdminId(adminId);
              n.setName(payMoney.getName());
              n.setStatus(0);
              n.setUserId(id);
              n.setContent(content);
              news.add(n);
            });

    userTermFinancialMapper.insertNews(news);
  }
}

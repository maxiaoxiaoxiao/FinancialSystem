package com.bjpowernode.finance.service.impl;

import com.bjpowernode.finance.common.Msg;
import com.bjpowernode.finance.entity.TermFinancial;
import com.bjpowernode.finance.entity.UserTermFinancial;
import com.bjpowernode.finance.mapper.TermFinancialMapper;
import com.bjpowernode.finance.mapper.UserTermFinancialMapper;
import com.bjpowernode.finance.service.UserTermFinancialService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserTermFinancialServiceImpl implements UserTermFinancialService {
    @Autowired
    UserTermFinancialMapper userTermFinancialMapper;
    @Autowired
    TermFinancialMapper termFinancialMapper;
    @Override
    @Transactional
    public Msg insertUserTermFinancial(Integer termFinancialId, Integer userId) {
        Integer userTermFinancial =
            userTermFinancialMapper.selectByUserIdAndtermId(userId,termFinancialId);
        Msg msg = new Msg();
        msg.setCode(100);
        if (userTermFinancial ==1) {
            msg.setMsg("已经收藏过该理财产品");
            return msg;
        }else {
            UserTermFinancial utf = new UserTermFinancial();
            utf.setUserid(userId);
            utf.setTermid(termFinancialId);
            utf.setStarttime(new Date());
            TermFinancial tf = termFinancialMapper.selectByPrimaryKey(termFinancialId);
            utf.setAveryield(tf.getAnnualincome());
            utf.setProfit(tf.getAnnualincome().multiply(tf.getLeastmoney()));
            utf.setStatus(1);
            userTermFinancialMapper.insertSelective(utf);
            msg.setMsg("收藏成功");
            return  msg;
        }
    }

    @Override
    public List<TermFinancial> selectUserTermFinancialByUserId(Integer userId) {
        return userTermFinancialMapper.selectUserTermFinancialByUserId(userId);
    }

    @Override
    @Transactional
    public Integer updateUserTermFinancial(UserTermFinancial userTermFinancial) {
        return userTermFinancialMapper.updateByPrimaryKeySelective(userTermFinancial);
    }

    @Override
    public UserTermFinancial selectUserTermFinancialById(Integer id) {
        return userTermFinancialMapper.selectByPrimaryKeyWithUserAndTermFinancial(id);
    }

  @Override
  public List<TermFinancial> selectUserTermFinancialByUser(Integer userId) {

        return userTermFinancialMapper.selectUserTermFinancialByUser(userId);
  }
}

package com.bjpowernode.finance.service.impl;

import com.bjpowernode.finance.common.Msg;
import com.bjpowernode.finance.entity.ChangeMoney;
import com.bjpowernode.finance.entity.News;
import com.bjpowernode.finance.entity.UserChangeMoney;
import com.bjpowernode.finance.mapper.ChangeMoneyMapper;
import com.bjpowernode.finance.mapper.UserChangeMoneyMapper;
import com.bjpowernode.finance.mapper.UserTermFinancialMapper;
import com.bjpowernode.finance.service.UserChangeMoneyService;
import java.util.ArrayList;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserChangeMoneyServiceImpl implements UserChangeMoneyService {
  @Autowired UserChangeMoneyMapper userChangeMoneyMapper;
  @Autowired ChangeMoneyMapper changeMoneyMapper;
  @Autowired
  UserTermFinancialMapper userTermFinancialMapper;

  @Override
  @Transactional
  public Msg insertUserChangeMoney(Integer changeMoneyId, Integer userId) {
    Integer userChangeMoney =
        userChangeMoneyMapper.selectByUserIdAndChangeMoneyId(userId, changeMoneyId);
    Msg msg = new Msg();
    msg.setCode(100);
    if (userChangeMoney == 1) {
      msg.setMsg("已经收藏过该理财产品");
      return msg;
    } else {

      ChangeMoney cm = changeMoneyMapper.selectByPrimaryKey(changeMoneyId);
      UserChangeMoney ucm = new UserChangeMoney();
      ucm.setUserid(userId);
      ucm.setChangeid(changeMoneyId);
      ucm.setStarttime(new Date());
      ucm.setAveryield(cm.getAnnualincome());
      ucm.setProfit(cm.getAnnualincome().multiply(cm.getInvesmoney()));
      ucm.setStatus(1);
      userChangeMoneyMapper.insertSelective(ucm);
      msg.setMsg("收藏成功");
      return msg;
    }
  }

  @Override
  public List<ChangeMoney> selectUserChangeMoneyByUserId(Integer userId) {
    return userChangeMoneyMapper.selectUserChangeMoneyByUserId(userId);
  }

  @Override
  @Transactional
  public Integer updateUserChangeMoney(UserChangeMoney userChangeMoney) {
    return userChangeMoneyMapper.updateByPrimaryKeySelective(userChangeMoney);
  }

  @Override
  public UserChangeMoney selectUserChangeMoneyById(Integer id, Integer userId) {
    return userChangeMoneyMapper.selectByPrimaryKeyWithUserAndChangeMoney(id, userId);
  }

  @Override
  public List<ChangeMoney> selectUserChangeMoneyByUser(Integer userId) {

    return userChangeMoneyMapper.selectUserChangeMoneyByUser(userId);
  }

  @Override
  public void deletUserChangeMoney(UserChangeMoney ucm) {
    userChangeMoneyMapper.deleteByPrimaryKey(ucm.getId());
  }

  @Override
  public void insertUserListChangeMoney(
      Integer changeMoneyId, List<Integer> userIdList, Integer adminId, String content) {
    List<News> news = new ArrayList<>();
    Date date = new Date();
    ChangeMoney changeMoney = changeMoneyMapper.selectByPrimaryKey(changeMoneyId);
    userIdList.stream()
        .forEach(
            id -> {
                Integer integer =
                    userChangeMoneyMapper.selectByUserIdAndChangeMoneyId(id, changeMoneyId);
                if (integer == 0) {
                    UserChangeMoney userChangeMoney = new UserChangeMoney();
                    userChangeMoney.setChangeid(changeMoneyId);
                    userChangeMoney.setUserid(id);
                    userChangeMoneyMapper.insertSelective(userChangeMoney);
                }
              News n = new News();
              n.setCreateTime(date);
              n.setAdminId(adminId);
              n.setName(changeMoney.getName());
              n.setStatus(0);
              n.setUserId(id);
              n.setContent(content);
              news.add(n);
            });

    userTermFinancialMapper.insertNews(news);
  }
}

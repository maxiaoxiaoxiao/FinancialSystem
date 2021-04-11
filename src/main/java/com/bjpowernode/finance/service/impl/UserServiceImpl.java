package com.bjpowernode.finance.service.impl;

import com.bjpowernode.finance.entity.AgeEnums;
import com.bjpowernode.finance.entity.CheckAbEnums;
import com.bjpowernode.finance.entity.Exam;
import com.bjpowernode.finance.entity.ExperienceEnums;
import com.bjpowernode.finance.entity.MoneyEnums;
import com.bjpowernode.finance.entity.PeriodEnums;
import com.bjpowernode.finance.entity.Proportion;
import com.bjpowernode.finance.entity.OutAndIn;
import com.bjpowernode.finance.entity.RiskEnums;
import com.bjpowernode.finance.entity.User;
import com.bjpowernode.finance.entity.UserExample;
import com.bjpowernode.finance.mapper.UserMapper;
import com.bjpowernode.finance.service.UserService;
import com.bjpowernode.finance.utils.CheckEmptyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired(required = false)
    UserMapper userMapper;

    @Override
    public User selectUserByTerms(String username, String password) {
        UserExample userExample =new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        if (username!=null){
            criteria.andUsernameEqualTo(username);
        }
        if (password!=null){
            criteria.andPasswordEqualTo(password);
        }
        List<User> list = userMapper.selectByExample(userExample);
        if ("[]".equals(list.toString())){
            return null;
        }else {
            return list.get(0);
        }
    }

    @Override
    public List<User> selectUserByStatusDesc() {
        UserExample userExample = new UserExample();
        userExample.setOrderByClause("status desc");
        return userMapper.selectByExample(userExample);
    }

    @Override
    public List<User> selectAllUser() {
        return userMapper.selectByExample(null);
    }

    @Override
    @Transactional
    public Integer updateUser(User user) {
        int result = userMapper.updateUser(user);
        return result;
    }

    @Override
    @Transactional
    public Integer insertUser(User user) {
        int result = userMapper.insertSelective(user);
        return result;
    }

    @Override
    public User selectUserById(Integer id) {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }

    @Override
    @Transactional
    public Integer deleteUserById(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }

  @Override
  public OutAndIn selectByUser(Integer userId) {
    return userMapper.selectByUser(userId);
  }

    @Override
    public Proportion selectCollection(Integer userId) {
        Integer changeMoney =  userMapper.selectChangeMoney(userId);
        Integer fundProduct = userMapper.selectFundProduct(userId);
        Integer payMoney = userMapper.selectPayMoney(userId);
        Integer termFinancial = userMapper.selectTermFinancial(userId);
        Proportion proportion = new Proportion();
        proportion.setChangeMoney(changeMoney);
        proportion.setFundProduct(fundProduct);
        proportion.setPayMoney(payMoney);
        proportion.setTermFinancial(termFinancial);
        return proportion;
    }

    @Override
    public String addRisk(User user, Exam exam) {
        //计算分数
        Integer score = 6;
        score =
            score + AgeEnums.getScoreByS(exam.getAge()) + RiskEnums.getScoreByS(exam.getRisLevel())
                + PeriodEnums.getScoreByS(exam.getPeriod()) + ExperienceEnums
                .getScoreByS(exam.getExperience()) + MoneyEnums.getScoreByS(exam.getMoney())
                + CheckAbEnums.getScoreByS(exam.getCheckAB());
        if (CheckEmptyUtil.isEmpty(exam.getHealth())) {
            score = score + 10;
        }
        //高中低 1 2 3
        String risk = "3";
        if (score < 30) {
            risk = "3";
        } else if (score >= 30 && score < 60) {
            risk = "2";
        } else {
            risk = "1";
        }
        user.setRisLevel(risk);
        userMapper.updateUser(user);
        return "1".equalsIgnoreCase(risk)? "高":("2".equalsIgnoreCase(risk)?"中":"低");
    }
}

package com.bjpowernode.finance.service.impl;

import com.bjpowernode.finance.common.Msg;
import com.bjpowernode.finance.entity.Admin;
import com.bjpowernode.finance.entity.AdminUserRela;
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
import com.bjpowernode.finance.mapper.AdminMapper;
import com.bjpowernode.finance.mapper.UserMapper;
import com.bjpowernode.finance.service.UserService;
import com.bjpowernode.finance.utils.CheckEmptyUtil;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

  @Autowired(required = false)
  UserMapper userMapper;

  @Autowired AdminMapper adminMapper;

  @Override
  public User selectUserByTerms(String username, String password) {
    UserExample userExample = new UserExample();
    UserExample.Criteria criteria = userExample.createCriteria();
    if (username != null) {
      criteria.andUsernameEqualTo(username);
    }
    if (password != null) {
      criteria.andPasswordEqualTo(password);
    }
    List<User> list = userMapper.selectByExample(userExample);
    if ("[]".equals(list.toString())) {
      return null;
    } else {
      return list.get(0);
    }
  }

  @Override
  public List<User> selectAllUser(Admin admin) {
    if (admin.getType().equals(1)) {
      return userMapper.selectAllUser(admin.getId());
    } else {
      return userMapper.selectByExample(null);
    }
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
    userMapper.deleteByPrimaryKey(id);
    userMapper.deleteAdminser(id);
    return 1;
  }

  @Override
  public OutAndIn selectByUser(Integer userId, Integer flag) {
    return userMapper.selectByUser(userId, flag);
  }

  @Override
  public Proportion selectCollection(Integer userId) {
    Integer changeMoney = userMapper.selectChangeMoney(userId);
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
    // ????????????
    Integer score = 6;
    score =
        score
            + AgeEnums.getScoreByS(exam.getAge())
            + RiskEnums.getScoreByS(exam.getRisLevel())
            + PeriodEnums.getScoreByS(exam.getPeriod())
            + ExperienceEnums.getScoreByS(exam.getExperience())
            + MoneyEnums.getScoreByS(exam.getMoney())
            + CheckAbEnums.getScoreByS(exam.getCheckAB());
    if (CheckEmptyUtil.isEmpty(exam.getHealth())) {
      score = score + 10;
    }
    // ????????? 1 2 3
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
    return "1".equalsIgnoreCase(risk) ? "???" : ("2".equalsIgnoreCase(risk) ? "???" : "???");
  }

  @Override
  public Msg insertAdminUser(Integer adminId, User user) {
    // ?????????????????????
    Msg msg = new Msg();
    Admin admin = adminMapper.selectById(adminId);
    if (admin.getType().equals(0)) {
      msg.setCode(200);
      msg.setMsg("???????????????????????????????????????");
      return msg;
    }
    // ????????????????????????
    User user1 = userMapper.selectByName(user.getUsername());
    if (CheckEmptyUtil.isNotEmpty(user1)) {
      msg.setCode(200);
      msg.setMsg("????????????????????????");
      return msg;
    }
    AdminUserRela adminUserRela = userMapper.selectAdminUser(adminId, user.getId());
    if (CheckEmptyUtil.isNotEmpty(adminUserRela)) {
      msg.setCode(200);
      msg.setMsg("???????????????????????????" + adminUserRela.getUsername() + "??????????????????");
      return msg;
    }
    userMapper.insertUser(user);
    userMapper.insertAdminUser(adminId, user.getId());
    msg.setCode(100);
    msg.setMsg("?????????????????????");
    return msg;
  }

  @Override
  public List<Admin> selectAllAdmin() {
    return adminMapper.selectAdmin();
  }

  @Override
  public List<User> selectUser() {
    return userMapper.selectByExample(null);
  }

  @Override
  public Msg updateAdminUser(User user) {
    AdminUserRela rela = userMapper.selectAdminUserById(user.getId());
    if (CheckEmptyUtil.isEmpty(rela)) {
      userMapper.insertAdminUser(user.getAdminId(),user.getId());
    } else {
      userMapper.updateAdminUser(user);
    }

    return Msg.success();
  }
}

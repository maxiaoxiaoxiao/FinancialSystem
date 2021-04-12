package com.bjpowernode.finance.service;


import com.bjpowernode.finance.common.Msg;
import com.bjpowernode.finance.entity.PayMoney;
import com.bjpowernode.finance.entity.UserPayMoney;

import java.util.List;

public interface UserPayMoneyService {

    Msg insertUserPayMoney(Integer payMoneyId, Integer userId);

    List<PayMoney> selectUserPayMoneyByUserId(Integer userId);

    Integer updateUserPayMoney(UserPayMoney userPayMoney);

    UserPayMoney selectUserPayMoneyById(Integer id,Integer userId);

  /**
   * 推荐的工资理财.
   * @param userId
   * @return
   */
  List<PayMoney> selectUserPayMoneyByUser(Integer userId);

    void deleteUserPayMoney(UserPayMoney upm);

  void insertUserPayMoneyList(
      Integer payMoneyId, List<Integer> userIdList, Integer adminId);
}

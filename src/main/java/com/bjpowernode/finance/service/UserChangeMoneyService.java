package com.bjpowernode.finance.service;

import com.bjpowernode.finance.common.Msg;
import com.bjpowernode.finance.entity.ChangeMoney;
import com.bjpowernode.finance.entity.UserChangeMoney;

import java.util.List;

public interface UserChangeMoneyService {

    Msg insertUserChangeMoney(Integer changeMoneyId, Integer userId);

    List<ChangeMoney> selectUserChangeMoneyByUserId(Integer userId);

    Integer updateUserChangeMoney(UserChangeMoney userChangeMoney);

    UserChangeMoney selectUserChangeMoneyById(Integer id, Integer userId);

  /**
   * 查询推荐的零钱理财.
   *
   * @param userId
   * @return
   */
  List<ChangeMoney> selectUserChangeMoneyByUser(Integer userId);

    void deletUserChangeMoney(UserChangeMoney ucm);

  /**
   * 推荐理财.
   * @param changeMoneyId
   * @param userIdList
   * @param adminId
   * @param content
   * @return
   */
  void insertUserListChangeMoney(
      Integer changeMoneyId, List<Integer> userIdList, Integer adminId, String content);
}

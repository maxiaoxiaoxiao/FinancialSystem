package com.bjpowernode.finance.service;

import com.bjpowernode.finance.common.Msg;
import com.bjpowernode.finance.entity.ChangeMoney;
import com.bjpowernode.finance.entity.UserChangeMoney;

import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;

public interface UserChangeMoneyService {

    Msg insertUserChangeMoney(Integer changeMoneyId, Integer userId);

    List<ChangeMoney> selectUserChangeMoneyByUserId(Integer userId);

    Integer updateUserChangeMoney(UserChangeMoney userChangeMoney);

    UserChangeMoney selectUserChangeMoneyById(Integer id);

  /**
   * 查询推荐的零钱理财.
   *
   * @param userId
   * @return
   */
  List<ChangeMoney> selectUserChangeMoneyByUser(Integer userId);
}

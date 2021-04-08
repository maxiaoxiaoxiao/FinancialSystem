package com.bjpowernode.finance.service;

import com.bjpowernode.finance.common.Msg;
import com.bjpowernode.finance.entity.FundProduct;
import com.bjpowernode.finance.entity.UserFundProduct;

import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;

public interface UserFundProductService {

    Msg insertUserFundProduct(Integer fundProductId, Integer userId);

    List<FundProduct> selectUserFundProductByUserId(Integer userId);

    Integer updateUserFundProduct(UserFundProduct userFundProduct);

    UserFundProduct selectUserFundProductById(Integer id);

  /**
   * 推荐的基金理财.
   * @param userId
   * @return
   */
  List<UserFundProduct> selectUserFundProductByUser(Integer userId);
}

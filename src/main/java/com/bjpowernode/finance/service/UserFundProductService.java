package com.bjpowernode.finance.service;

import com.bjpowernode.finance.entity.UserFundProduct;

import java.util.List;

public interface UserFundProductService {

    Integer insertUserFundProduct(UserFundProduct userFundProduct);

    List<UserFundProduct> selectUserFundProductByUserId(Integer userId);

    Integer updateUserFundProduct(UserFundProduct userFundProduct);

    UserFundProduct selectUserFundProductById(Integer id);

  /**
   * 推荐的基金理财.
   * @param userId
   * @return
   */
  List<UserFundProduct> selectUserFundProductByUser(Integer userId);
}

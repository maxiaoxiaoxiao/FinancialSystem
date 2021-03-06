package com.bjpowernode.finance.service;

import com.bjpowernode.finance.common.Msg;
import com.bjpowernode.finance.entity.FundProduct;
import com.bjpowernode.finance.entity.UserFundProduct;

import java.util.List;

public interface UserFundProductService {

    Msg insertUserFundProduct(Integer fundProductId, Integer userId);

    List<FundProduct> selectUserFundProductByUserId(Integer userId);

    Integer updateUserFundProduct(UserFundProduct userFundProduct);

    UserFundProduct selectUserFundProductById(Integer id, Integer userId);

  /**
   * 推荐的混合类基金.
   * @param userId
   * @return
   */
  List<FundProduct> selectUserFundProductByUser(Integer userId);

    void deleteUserFundProduct(UserFundProduct ufp);

  void insertUserFundProductList(
      Integer fundProductId, List<Integer> userIdList, Integer adminId, String content);
}

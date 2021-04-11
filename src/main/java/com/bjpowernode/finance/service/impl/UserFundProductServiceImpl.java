package com.bjpowernode.finance.service.impl;

import com.bjpowernode.finance.common.Msg;
import com.bjpowernode.finance.entity.FundProduct;
import com.bjpowernode.finance.entity.UserFundProduct;
import com.bjpowernode.finance.mapper.FundProductMapper;
import com.bjpowernode.finance.mapper.UserFundProductMapper;
import com.bjpowernode.finance.service.UserFundProductService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserFundProductServiceImpl implements UserFundProductService {
    @Autowired
    UserFundProductMapper userFundProductMapper;
    @Autowired
    FundProductMapper fundProductMapper;

    @Override
    @Transactional
    public Msg insertUserFundProduct(Integer fundProductId, Integer userId) {
        Integer userFundProduct = userFundProductMapper.selectByUserIdAndFundId(userId,fundProductId);
        Msg msg = new Msg();
        msg.setCode(100);
        if (userFundProduct ==1) {
            msg.setMsg("已经收藏过该理财产品");
            return msg;
        } else {
            UserFundProduct ufp = new UserFundProduct();
            ufp.setUserid(userId);
            ufp.setFundid(fundProductId);
            ufp.setStarttime(new Date());
            FundProduct fp = fundProductMapper.selectByPrimaryKey(fundProductId);
            ufp.setAveryield(fp.getMonthlygrowth());
            ufp.setProfit(fp.getLeastmoney().multiply(fp.getMonthlygrowth()));
            ufp.setStatus(1);
            userFundProductMapper.insertSelective(ufp);
            msg.setMsg("收藏成功");
            return msg;
        }

    }

    @Override
    public List<FundProduct> selectUserFundProductByUserId(Integer userId) {
        return userFundProductMapper.selectUserFundProductByUserId(userId);
    }

    @Override
    @Transactional
    public Integer updateUserFundProduct(UserFundProduct userFundProduct) {
        return userFundProductMapper.updateByPrimaryKeySelective(userFundProduct);
    }

    @Override
    public UserFundProduct selectUserFundProductById(Integer id, Integer userId) {
        return userFundProductMapper.selectByPrimaryKeyWithUserAndFundProduct(id,userId);
    }

  @Override
  public List<FundProduct> selectUserFundProductByUser(Integer userId) {

        return userFundProductMapper.selectUserFundProductByUser(userId);
  }

    @Override
    public void deleteUserFundProduct(UserFundProduct ufp) {
        userFundProductMapper.deleteByPrimaryKey(ufp.getId());
    }
}

package com.bjpowernode.finance.service;

import com.bjpowernode.finance.entity.FundProduct;

import java.util.List;

public interface FundProductService {

    List<FundProduct> selectAllFundProduct(
        String code, String name, String company, String people);

    FundProduct selectFundProductById(Integer id);

    Integer insertFundProduct(FundProduct fundProduct);

    Integer updateFundProduct(FundProduct fundProduct);

    Integer deleteFundProductById(Integer id);
}

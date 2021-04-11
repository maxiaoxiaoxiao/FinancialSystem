package com.bjpowernode.finance.service;

import com.bjpowernode.finance.common.Msg;
import com.bjpowernode.finance.entity.TermFinancial;
import com.bjpowernode.finance.entity.UserTermFinancial;

import java.util.List;

public interface UserTermFinancialService {

    Msg insertUserTermFinancial(Integer termFinancialId, Integer userId);

    List<TermFinancial> selectUserTermFinancialByUserId(Integer userId);

    Integer updateUserTermFinancial(UserTermFinancial userTermFinancial);

    UserTermFinancial selectUserTermFinancialById(Integer id, Integer userId);

    /**
     * 推荐的期限理财.
     * @param userId
     * @return
     */
    List<TermFinancial> selectUserTermFinancialByUser(Integer userId);

    void deleteUserTermFinancial(UserTermFinancial utf);
}

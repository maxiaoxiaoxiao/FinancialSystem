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
     * 推荐的货币基金.
     * @param userId
     * @return
     */
    List<TermFinancial> selectUserTermFinancialByUser(Integer userId);

    void deleteUserTermFinancial(UserTermFinancial utf);

    void buyTermFinancialList(
        Integer termFinancialId, List<Integer> userIdList, Integer adminId,
        String content);
}

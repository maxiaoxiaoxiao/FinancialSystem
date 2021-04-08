package com.bjpowernode.finance.service;

import com.bjpowernode.finance.common.Msg;
import com.bjpowernode.finance.entity.TermFinancial;
import com.bjpowernode.finance.entity.UserTermFinancial;

import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;

public interface UserTermFinancialService {

    Msg insertUserTermFinancial(Integer termFinancialId, Integer userId);

    List<TermFinancial> selectUserTermFinancialByUserId(Integer userId);

    Integer updateUserTermFinancial(UserTermFinancial userTermFinancial);

    UserTermFinancial selectUserTermFinancialById(Integer id);

    /**
     * 推荐的期限理财.
     * @param userId
     * @return
     */
    List<UserTermFinancial> selectUserTermFinancialByUser(Integer userId);
}

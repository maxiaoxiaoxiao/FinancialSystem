package com.bjpowernode.finance.service;

import com.bjpowernode.finance.entity.TermFinancial;

import java.util.List;

public interface TermFinancialService {

    List<TermFinancial> selectAllTermFinancial(
        String code, String name, String company, String people);

    TermFinancial selectTermFinancialById(Integer id);

    Integer insertTermFinancial(TermFinancial termFinancial);

    Integer updateTermFinancial(TermFinancial termFinancial);

    Integer deleteTermFinancialById(Integer id);
}

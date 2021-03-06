package com.bjpowernode.finance.service.impl;

import com.bjpowernode.finance.entity.TermFinancial;
import com.bjpowernode.finance.mapper.TermFinancialMapper;
import com.bjpowernode.finance.service.TermFinancialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class TermFinancialServiceImpl implements TermFinancialService {
    @Autowired
    TermFinancialMapper termFinancialMapper;

    @Override
    public List<TermFinancial> selectAllTermFinancial(
        String code, String name, String company, String people) {
        return termFinancialMapper.selectAllTermFinancial(code,name,company,people);
    }

    @Override
    public TermFinancial selectTermFinancialById(Integer id) {
        return termFinancialMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional
    public Integer insertTermFinancial(TermFinancial termFinancial) {
        return termFinancialMapper.insertSelective(termFinancial);
    }

    @Override
    @Transactional
    public Integer updateTermFinancial(TermFinancial termFinancial) {
        return termFinancialMapper.updateByPrimaryKeySelective(termFinancial);
    }

    @Override
    @Transactional
    public Integer deleteTermFinancialById(Integer id) {
        return termFinancialMapper.deleteByPrimaryKey(id);
    }
}

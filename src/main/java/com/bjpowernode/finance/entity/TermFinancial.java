package com.bjpowernode.finance.entity;

import java.math.BigDecimal;

public class TermFinancial {
    private Integer id;

    private String name;

    private String investerm;

    private BigDecimal leastmoney;

    private Integer profit;

    private BigDecimal annualincome;

    private Integer risLevel;

    private String company;

    private String people;

    private String instruction;

    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public Integer getRisLevel() {
        return risLevel;
    }

    public void setRisLevel(Integer risLevel) {
        this.risLevel = risLevel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getInvesterm() {
        return investerm;
    }

    public void setInvesterm(String investerm) {
        this.investerm = investerm == null ? null : investerm.trim();
    }

    public BigDecimal getLeastmoney() {
        return leastmoney;
    }

    public void setLeastmoney(BigDecimal leastmoney) {
        this.leastmoney = leastmoney;
    }

    public Integer getProfit() {
        return profit;
    }

    public void setProfit(Integer profit) {
        this.profit = profit;
    }

    public BigDecimal getAnnualincome() {
        return annualincome;
    }

    public void setAnnualincome(BigDecimal annualincome) {
        this.annualincome = annualincome;
    }
}


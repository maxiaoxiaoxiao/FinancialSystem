package com.bjpowernode.finance.entity;

import java.math.BigDecimal;

public class PayMoney {
    private Integer id;

    private BigDecimal monthmoney;

    private Integer autointo;

    private Integer type;

    private String investerm;

    private String risLevel;

    private String company;

    private String people;

    private String instruction;

    private String name;
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


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getMonthmoney() {
        return monthmoney;
    }

    public void setMonthmoney(BigDecimal monthmoney) {
        this.monthmoney = monthmoney;
    }

    public Integer getAutointo() {
        return autointo;
    }

    public void setAutointo(Integer autointo) {
        this.autointo = autointo;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getInvesterm() {
        return investerm;
    }

    public String getRisLevel() {
        return risLevel;
    }

    public void setRisLevel(String risLevel) {
        this.risLevel = risLevel;
    }

    public void setInvesterm(String investerm) {
        this.investerm = investerm == null ? null : investerm.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


package com.bjpowernode.finance.entity;

import java.math.BigDecimal;
import javax.annotation.sql.DataSourceDefinition;

public class ChangeMoney {
    private Integer id;

    private String name;

    private BigDecimal annualincome;

    private BigDecimal peiincome;

    private String investerm;

    private BigDecimal invesmoney;

    private Integer risLevel;

    private String company;

    private String people;

    private String instruction;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public BigDecimal getAnnualincome() {
        return annualincome;
    }

    public void setAnnualincome(BigDecimal annualincome) {
        this.annualincome = annualincome;
    }

    public BigDecimal getPeiincome() {
        return peiincome;
    }

    public void setPeiincome(BigDecimal peiincome) {
        this.peiincome = peiincome;
    }

    public String getInvesterm() {
        return investerm;
    }

    public void setInvesterm(String investerm) {
        this.investerm = investerm == null ? null : investerm.trim();
    }

    public BigDecimal getInvesmoney() {
        return invesmoney;
    }

    public void setInvesmoney(BigDecimal invesmoney) {
        this.invesmoney = invesmoney;
    }

    public Integer getRisLevel() {
        return risLevel;
    }

    public void setRisLevel(Integer risLevel) {
        this.risLevel = risLevel;
    }
}

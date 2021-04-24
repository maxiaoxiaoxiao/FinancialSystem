package com.bjpowernode.finance.entity;

/**
 * @author 秦润东
 * @since 2021/4/24 21:16
 */
public class BugTermFinancial {
    private Integer termFinancialId;
    private String conctent;
    private String userIdList;

    public Integer getTermFinancialId() {
        return termFinancialId;
    }

    public void setTermFinancialId(Integer termFinancialId) {
        this.termFinancialId = termFinancialId;
    }

    public String getConctent() {
        return conctent;
    }

    public void setConctent(String conctent) {
        this.conctent = conctent;
    }

    public String getUserIdList() {
        return userIdList;
    }

    public void setUserIdList(String userIdList) {
        this.userIdList = userIdList;
    }
}

package com.bjpowernode.finance.entity;

/**
 * @author 秦润东
 * @since 2021/4/12 23:43
 */
public class BuyChangeMoney {
    private Integer changeMoneyId;
    private String conctent;
    private String userIdList;

    public Integer getChangeMoneyId() {
        return changeMoneyId;
    }

    public void setChangeMoneyId(Integer changeMoneyId) {
        this.changeMoneyId = changeMoneyId;
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

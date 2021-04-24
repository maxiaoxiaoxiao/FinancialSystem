package com.bjpowernode.finance.entity;

/**
 * @author 秦润东
 * @since 2021/4/24 21:12
 */
public class BugFundProduct {
    private Integer fundProductId;
    private String conctent;
    private String userIdList;

    public Integer getFundProductId() {
        return fundProductId;
    }

    public void setFundProductId(Integer fundProductId) {
        this.fundProductId = fundProductId;
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

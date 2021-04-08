package com.bjpowernode.finance.entity;

/**
 * @since 2021/4/8 20:58
 */
public class Proportion {

  private Integer changeMoney;
  private Integer fundProduct;

  private Integer payMoney;

  private Integer termFinancial;

  public Integer getChangeMoney() {
    return changeMoney;
  }

  public void setChangeMoney(Integer changeMoney) {
    this.changeMoney = changeMoney;
  }

  public Integer getFundProduct() {
    return fundProduct;
  }

  public void setFundProduct(Integer fundProduct) {
    this.fundProduct = fundProduct;
  }

  public Integer getPayMoney() {
    return payMoney;
  }

  public void setPayMoney(Integer payMoney) {
    this.payMoney = payMoney;
  }

  public Integer getTermFinancial() {
    return termFinancial;
  }

  public void setTermFinancial(Integer termFinancial) {
    this.termFinancial = termFinancial;
  }
}

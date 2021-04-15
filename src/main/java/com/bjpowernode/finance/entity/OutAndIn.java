package com.bjpowernode.finance.entity;

/**
 * @since 2021/4/8 20:40
 */
public class OutAndIn {
  private Integer outMoney;

  private Integer inMoney;
  private Integer vest;


  public Integer getVest() {
    return vest;
  }

  public void setVest(Integer vest) {
    this.vest = vest;
  }

  public Integer getOutMoney() {
    return outMoney;
  }

  public void setOutMoney(Integer outMoney) {
    this.outMoney = outMoney;
  }

  public Integer getInMoney() {
    return inMoney;
  }

  public void setInMoney(Integer inMoney) {
    this.inMoney = inMoney;
  }
}

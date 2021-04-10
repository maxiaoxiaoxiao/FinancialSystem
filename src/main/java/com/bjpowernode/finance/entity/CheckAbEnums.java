package com.bjpowernode.finance.entity;

/**
 * @since 2021/4/10 11:32
 */
public enum CheckAbEnums {
  ONE(1,30),
  SECOND(2,20),
  THREE(3,10),
  FOUR(4,0),
  ;
  private Integer select;

  private Integer score;
  CheckAbEnums(Integer select, Integer score) {
    this.select = select;
    this.score = score;
  }

  public Integer getSelect() {
    return select;
  }

  public Integer getScore() {
    return score;
  }

  public static Integer getScoreByS(Integer select) {
    for (CheckAbEnums tem : values()) {
      if (tem.getSelect() == select) {
        return tem.getScore();
      }
    }
    return null;
  }
}

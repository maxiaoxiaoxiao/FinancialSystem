package com.bjpowernode.finance.entity;

/**
 * @author 邓南平
 * @since 2021/4/10 11:32
 */
public enum AgeEnums {
  ONE(1,2),
  SECOND(2,5),
  THREE(3,3),
  FOUR(4,2)
  ;
  private Integer select;

  private Integer score;

  AgeEnums(Integer select, Integer score) {
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
    for (AgeEnums tem : values()) {
      if (tem.getSelect() == select) {
        return tem.getScore();
      }
    }
    return null;
  }

}

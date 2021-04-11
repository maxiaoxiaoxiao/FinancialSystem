package com.bjpowernode.finance.entity;

/**
 * @author 邓南平
 * @since 2021/4/10 11:32
 */
public enum ExperienceEnums {
  ONE(1,15),
  SECOND(2,10),
  THREE(3,5)
  ;
  private Integer select;

  private Integer score;
  ExperienceEnums(Integer select, Integer score) {
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
    for (ExperienceEnums tem : values()) {
      if (tem.getSelect() == select) {
        return tem.getScore();
      }
    }
    return 0;
  }
}

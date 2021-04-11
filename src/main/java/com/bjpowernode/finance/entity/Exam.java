package com.bjpowernode.finance.entity;

/**
 * @author 邓南平
 * @since 2021/4/10 11:16
 */
public class Exam {

  /*  sex    1   2   通通1分
    age   1  2分  2   5分  3  3分 4 2分
    risLevel   1  5分  2  10分  3 15分
    period     1  15分  2  10分  3 5分   4  0分
    study     通通5分
    experience   1   15分  2 10分  3 5分
    money    >=  10w   15分   5-10w   10分    《 5w   5分
    health  不为空   0分   为空   10分
    checkAb   1   30分   2 20分   3 10分   4 0分*/
  private Integer sex;//    通通1分

  private Integer age;//1  5分  2   4分  3  3分 4 2分

  private Integer risLevel;


  private Integer period;


  private Integer study;


  private Integer experience;

  private Integer money;


  private Integer checkAB;

  private String health;

  public Integer getSex() {
    return sex;
  }

  public void setSex(Integer sex) {
    this.sex = sex;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public Integer getRisLevel() {
    return risLevel;
  }

  public void setRisLevel(Integer risLevel) {
    this.risLevel = risLevel;
  }

  public Integer getPeriod() {
    return period;
  }

  public void setPeriod(Integer period) {
    this.period = period;
  }

  public Integer getStudy() {
    return study;
  }

  public void setStudy(Integer study) {
    this.study = study;
  }

  public Integer getExperience() {
    return experience;
  }

  public void setExperience(Integer experience) {
    this.experience = experience;
  }

  public Integer getMoney() {
    return money;
  }

  public void setMoney(Integer money) {
    this.money = money;
  }

  public String getHealth() {
    return health;
  }

  public void setHealth(String health) {
    this.health = health;
  }

  public Integer getCheckAB() {
    return checkAB;
  }

  public void setCheckAB(Integer checkAB) {
    this.checkAB = checkAB;
  }
}

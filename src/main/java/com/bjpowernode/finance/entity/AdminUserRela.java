package com.bjpowernode.finance.entity;

/**
 * @author 邓南平
 * @since 2021/4/11 21:04
 */
public class AdminUserRela {

  private Integer id;
  private Integer adminId;
  private Integer userId;
  private String username;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getAdminId() {
    return adminId;
  }

  public void setAdminId(Integer adminId) {
    this.adminId = adminId;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }
}

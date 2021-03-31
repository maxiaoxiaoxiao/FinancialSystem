package com.bjpowernode.finance.entity;

import java.util.Date;

/**
 * @since 2021/3/30 23:46
 */
public class Comment {

  private Integer commentId;

  private String content;

  private String createTime;

  private String updateTime;

  private Integer relaId;

  private String type;

  private Integer adminId;

  public Integer getRelaId() {
    return relaId;
  }

  public void setRelaId(Integer relaId) {
    this.relaId = relaId;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Integer getCommentId() {
    return commentId;
  }

  public void setCommentId(Integer commentId) {
    this.commentId = commentId;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }


  public Integer getAdminId() {
    return adminId;
  }

  public void setAdminId(Integer adminId) {
    this.adminId = adminId;
  }


  public String getCreateTime() {
    return createTime;
  }

  public void setCreateTime(String createTime) {
    this.createTime = createTime;
  }

  public String getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(String updateTime) {
    this.updateTime = updateTime;
  }
}

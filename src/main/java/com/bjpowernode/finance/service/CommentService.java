package com.bjpowernode.finance.service;

import com.bjpowernode.finance.entity.Comment;
import java.util.List;

/**
 * @since 2021/3/31 20:33
 */

public interface CommentService {

  /**
   * 添加/编辑评论.
   *
   * @param comment
   */
   void addComment(Comment comment);

  /**
   * 查询评论.
   *
   * @param comment
   * @return
   */
  List<Comment> searchComment(Comment comment);
}

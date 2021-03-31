package com.bjpowernode.finance.service.impl;

import com.bjpowernode.finance.entity.Admin;
import com.bjpowernode.finance.entity.Comment;
import com.bjpowernode.finance.mapper.CommentMapper;
import com.bjpowernode.finance.service.CommentService;
import com.bjpowernode.finance.utils.CheckEmptyUtil;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @since 2021/3/31 20:35
 */

@Service
public class CommentServiceImpl implements CommentService {
  @Autowired
  CommentMapper commentMapper;
  @Override
  public void addComment(Comment comment) {

    if (CheckEmptyUtil.isNotEmpty(comment.getCommentId())) {
      commentMapper.updateComment(comment);
    } else {
      commentMapper.insertComment(comment);
    }
  }

  @Override
  public List<Comment> searchComment(Comment comment) {
    return commentMapper.searchComment(comment);
  }
}

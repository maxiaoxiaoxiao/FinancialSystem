package com.bjpowernode.finance.mapper;

import com.bjpowernode.finance.entity.Comment;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @since 2021/3/31 20:39
 */
@Mapper
public interface CommentMapper {
  /**
   * 更新评论.
   *
   * @param comment
   */
  void updateComment(@Param("comment") Comment comment);

  /**
   * 新增评论.
   *
   * @param comment
   */
  void insertComment(@Param("comment") Comment comment);

  /**
   * 查询评论.
   * @param comment
   * @return
   */
  List<Comment> searchComment(@Param("comment") Comment comment);
}

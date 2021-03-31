package com.bjpowernode.finance.controller;

import com.bjpowernode.finance.common.Msg;
import com.bjpowernode.finance.entity.Admin;
import com.bjpowernode.finance.entity.Comment;
import com.bjpowernode.finance.service.CommentService;
import com.bjpowernode.finance.utils.CheckEmptyUtil;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    CommentService commentService;

    /**
     * 添加评论.
     *
     * @param comment
     * @return
     */
    @PostMapping("addComment")
    @ResponseBody
    public Msg addComment(@RequestBody Comment comment,HttpSession session) {

      if (CheckEmptyUtil.isEmpty(comment.getAdminId())) {
        Admin admin = (Admin) session.getAttribute("loginAdmin");
        comment.setAdminId(admin.getId());
      }
      commentService.addComment(comment);
      return Msg.success();

    }

  /**
   * 查询评论.
   *
   * @param comment
   * @return
   */
  @PostMapping("/searchComment")
  @ResponseBody
  public Msg searchComment(@RequestBody Comment comment) {
    List<Comment> list = commentService.searchComment(comment);
    Msg msg = new Msg();
    msg.setCode(100);
    msg.add("list",list);
    return msg;

  }
}

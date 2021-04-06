package com.bjpowernode.finance.controller;

import com.bjpowernode.finance.common.Msg;
import com.bjpowernode.finance.entity.Admin;
import com.bjpowernode.finance.entity.Comment;
import com.bjpowernode.finance.entity.CommonDto;
import com.bjpowernode.finance.entity.UseFavorites;
import com.bjpowernode.finance.entity.User;
import com.bjpowernode.finance.entity.UserChangeMoney;
import com.bjpowernode.finance.entity.UserFundProduct;
import com.bjpowernode.finance.entity.UserPayMoney;
import com.bjpowernode.finance.entity.UserTermFinancial;
import com.bjpowernode.finance.service.CommentService;
import com.bjpowernode.finance.service.UserChangeMoneyService;
import com.bjpowernode.finance.service.UserFundProductService;
import com.bjpowernode.finance.service.UserPayMoneyService;
import com.bjpowernode.finance.service.UserTermFinancialService;
import com.bjpowernode.finance.utils.CheckEmptyUtil;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    CommentService commentService;
    @Autowired
    UserChangeMoneyService userChangeMoneyService;
    @Autowired
    UserPayMoneyService userPayMoneyService;
    @Autowired
    UserTermFinancialService userTermFinancialService;
    @Autowired
    UserFundProductService userFundProductService;

    /**
     * 添加评论.
     *
     * @param comment
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "addComment")
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
  @ResponseBody
  @RequestMapping(value = "searchComment")
  public Msg searchComment(@RequestBody Comment comment) {
    List<Comment> list = commentService.searchComment(comment);
    List<CommonDto> cc = new ArrayList<>();
    int index =  1;
    if(CheckEmptyUtil.isNotEmpty(list)){
        for (Comment  c : list) {
            CommonDto dto = new CommonDto();
            dto.setIndex(String.valueOf(index++));
            dto.setContent(c.getContent());
            cc.add(dto);
        }
    }

    Msg msg = new Msg();
    msg.setCode(100);
    msg.add("list",cc);
    return msg;
  }



    /**
     * 查看收藏
     *
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "searchFavorites")
    public Msg searchFavorites(@RequestBody User user) {
//        List<Comment> list = commentService.searchComment(comment);
        //零钱理财
        List<UserChangeMoney> userChangeMonies = userChangeMoneyService.selectUserChangeMoneyByUser(user.getId());
        //工资理财
        List<UserPayMoney> userPayMonies = userPayMoneyService.selectUserPayMoneyByUserId(user.getId());
        //期限理财
        List<UserTermFinancial> userTermFinancials = userTermFinancialService.selectUserTermFinancialByUserId(user.getId());
        //基金理财
        List<UserFundProduct> userFundProducts = userFundProductService.selectUserFundProductByUserId(user.getId());

        List<UseFavorites> cc = new ArrayList<>();
        int index =  1;
        if(CheckEmptyUtil.isNotEmpty(userChangeMonies)){
            for (UserChangeMoney  c : userChangeMonies) {
                UseFavorites dto = new UseFavorites();
                dto.setIndex(String.valueOf(index++));
                dto.setType("零钱理财");
                //TDDO 加入名称
                dto.setProductName("名称");
                dto.setRisLevel("1".equalsIgnoreCase(c.getRisLevel()) ? ("2".equalsIgnoreCase(c.getRisLevel()) ? "中" : "高") : "低" );
                cc.add(dto);
            }
        }
        if(CheckEmptyUtil.isNotEmpty(userPayMonies)){
            for (UserPayMoney  c : userPayMonies) {
                UseFavorites dto = new UseFavorites();
                dto.setIndex(String.valueOf(index++));
                dto.setType("工资理财");
                //TDDO 加入名称
                dto.setProductName("名称");
                dto.setRisLevel("1".equalsIgnoreCase(c.getRisLevel()) ? ("2".equalsIgnoreCase(c.getRisLevel()) ? "中" : "高") : "低" );
                cc.add(dto);
            }
        }


        if(CheckEmptyUtil.isNotEmpty(userTermFinancials)){
            for (UserTermFinancial  c : userTermFinancials) {
                UseFavorites dto = new UseFavorites();
                dto.setIndex(String.valueOf(index++));
                dto.setType("期限理财");
                //TDDO加入名称
                dto.setProductName("名称");
                dto.setRisLevel("1".equalsIgnoreCase(c.getRisLevel()) ? ("2".equalsIgnoreCase(c.getRisLevel()) ? "中" : "高") : "低" );
                cc.add(dto);
            }
        }


        if(CheckEmptyUtil.isNotEmpty(userFundProducts)){
            for (UserFundProduct  c : userFundProducts) {
                UseFavorites dto = new UseFavorites();
                dto.setIndex(String.valueOf(index++));
                dto.setType("基金理财");
                //TDDO加入名称
                dto.setProductName("名称");
                dto.setRisLevel("1".equalsIgnoreCase(c.getRisLevel()) ? ("2".equalsIgnoreCase(c.getRisLevel()) ? "中" : "高") : "低" );
                cc.add(dto);
            }
        }


        Msg msg = new Msg();
        msg.setCode(100);
        msg.add("list",cc);
        return msg;
    }


}

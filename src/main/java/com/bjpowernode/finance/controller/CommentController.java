package com.bjpowernode.finance.controller;

import com.bjpowernode.finance.common.Msg;
import com.bjpowernode.finance.entity.Admin;
import com.bjpowernode.finance.entity.ChangeMoney;
import com.bjpowernode.finance.entity.Comment;
import com.bjpowernode.finance.entity.CommonDto;
import com.bjpowernode.finance.entity.FundProduct;
import com.bjpowernode.finance.entity.PayMoney;
import com.bjpowernode.finance.entity.TermFinancial;
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
    @RequestMapping(value = "/addComment")
    public Msg addComment(@RequestBody Comment comment,HttpSession session) {
      Msg msg = new Msg();
      if (CheckEmptyUtil.isEmpty(comment.getContent())) {
        msg.setCode(200);
        msg.setMsg("评论内容不能为空");
        return msg;
      }
      commentService.addComment(comment);
      msg.setCode(100);
      msg.setMsg("新增评论成功");
      return msg;

    }

  /**
   * 查询评论.
   *
   * @param comment
   * @return
   */
  @ResponseBody
  @RequestMapping(value = "/searchComment")
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
      //股票类基金
      List<ChangeMoney> changeMonies = userChangeMoneyService.selectUserChangeMoneyByUserId(user.getId());
      //债券类基金
      List<PayMoney> payMonies = userPayMoneyService.selectUserPayMoneyByUserId(user.getId());
      //货币基金
      List<TermFinancial> termFinancials = userTermFinancialService.selectUserTermFinancialByUserId(user.getId());
      //混合类基金
      List<FundProduct> fundProducts = userFundProductService.selectUserFundProductByUserId(user.getId());

        List<UseFavorites> cc = new ArrayList<>();
        int index =  1;
        if(CheckEmptyUtil.isNotEmpty(changeMonies)){
            for (ChangeMoney  c : changeMonies) {
                UseFavorites dto = new UseFavorites();
                dto.setIndex(c.getCode());
                dto.setType("股票类基金");
                //TDDO 加入名称
                dto.setProductName(c.getName());
              dto.setRisLevel("1".equalsIgnoreCase(String.valueOf(c.getRisLevel()))? "高":("2".equalsIgnoreCase(String.valueOf(c.getRisLevel()))?"中":"低"));
                cc.add(dto);
            }
        }
        if(CheckEmptyUtil.isNotEmpty(payMonies)){
            for (PayMoney  c : payMonies) {
                UseFavorites dto = new UseFavorites();
                dto.setIndex(c.getCode());
                dto.setType("债券类基金");
                //TDDO 加入名称
                dto.setProductName(c.getName());
              dto.setRisLevel("1".equalsIgnoreCase(c.getRisLevel())? "高":("2".equalsIgnoreCase(c.getRisLevel())?"中":"低"));
                cc.add(dto);
            }
        }


        if(CheckEmptyUtil.isNotEmpty(termFinancials)){
            for (TermFinancial  c : termFinancials) {
                UseFavorites dto = new UseFavorites();
                dto.setIndex(c.getCode());
                dto.setType("货币基金");
                //TDDO加入名称
                dto.setProductName(c.getName());
              dto.setRisLevel("1".equalsIgnoreCase(String.valueOf(c.getRisLevel()))? "高":("2".equalsIgnoreCase(String.valueOf(c.getRisLevel()))?"中":"低"));
                cc.add(dto);
            }
        }


        if(CheckEmptyUtil.isNotEmpty(fundProducts)){
            for (FundProduct  c : fundProducts) {
                UseFavorites dto = new UseFavorites();
                dto.setIndex(String.valueOf( c.getCode()));
                dto.setType("混合类基金");
                //TDDO加入名称
                dto.setProductName(c.getFunddesc());
              dto.setRisLevel("1".equalsIgnoreCase(c.getRisLevel())? "高":("2".equalsIgnoreCase(c.getRisLevel())?"中":"低"));
                cc.add(dto);
            }
        }

        Msg msg = new Msg();
        msg.setCode(100);
        msg.add("list",cc);
        return msg;
    }


}

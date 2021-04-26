package com.bjpowernode.finance.controller;

import com.bjpowernode.finance.common.Msg;
import com.bjpowernode.finance.entity.Admin;
import com.bjpowernode.finance.entity.BugPayMoeny;
import com.bjpowernode.finance.entity.PayMoney;
import com.bjpowernode.finance.service.FlowOfFundsService;
import com.bjpowernode.finance.service.PayMoneyService;
import com.bjpowernode.finance.service.UserPayMoneyService;
import com.bjpowernode.finance.utils.CheckEmptyUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PayMoneyController {

    @Autowired
    PayMoneyService payMoneyService;
    @Autowired
    UserPayMoneyService userPayMoneyService;
    @Autowired
    FlowOfFundsService flowOfFundsService;

    /**
     * 跳转到债券类基金界面
     * @param model
     * @return
     */
    @RequestMapping("/user/finance/toPayMoney.html")
    public String toPaymoney( @RequestParam(value = "code",required = false) String code,
                              @RequestParam(value = "name",required = false) String name,
                              @RequestParam(value = "company",required = false) String company,
                              @RequestParam(value = "people",required = false) String people,
                              Model model){
        List<PayMoney> list = payMoneyService.selectAllPayMoney(code, name, company, people);
        list.forEach( s -> {
            s.setRisLevel("1".equalsIgnoreCase(s.getRisLevel())? "高":("2".equalsIgnoreCase(s.getRisLevel())?"中":"低"));
        });
        model.addAttribute("payMoneyList",list);
        model.addAttribute("pageTopBarInfo","债券类基金界面");
        model.addAttribute("activeUrl1","financeActive");
        model.addAttribute("activeUrl2","payMoneyActive");
        return "/user/finance/paymoney";
    }

    /**
     * 购买债券类基金产品
     * @param payMoneyId
     * @param userId
     * @return
     */
    @PostMapping("/user/buyPayMoney")
    @ResponseBody
    public Msg buyPayMoney(@RequestParam("payMoneyId")Integer payMoneyId,
                           @RequestParam("userId") Integer userId ){
        return userPayMoneyService.insertUserPayMoney(payMoneyId,userId);

    }

  /**
   * 购买债券类基金产品
   *
   * @param payMoneyId
   * @return
   */
  @PostMapping("/user/buyPayMoneyList")
  @ResponseBody
  public Msg buyPayMoneyList(@RequestBody BugPayMoeny bugPayMoeny, HttpSession session) {
    Admin admin = (Admin) session.getAttribute("loginAdmin");
      List<Integer> list = new ArrayList<>();
      list.add(Integer.valueOf(bugPayMoeny.getUserIdList()));
    userPayMoneyService.insertUserPayMoneyList(bugPayMoeny.getPayMoneyId(), list, admin.getId(),bugPayMoeny.getConctent());
    return Msg.success();
    }

  /**
   * 跳转到债券类基金管理界面（管理员）
   *
   * @param pageNum
   * @param pageSize
   * @param model
   * @param session
   * @return
   */
  @GetMapping("/admin/finance/toPayMoney.html")
  public String toPayMoneyInfo(
      @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
      @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
      @RequestParam(value = "code",required = false) String code,
      @RequestParam(value = "name",required = false) String name,
      @RequestParam(value = "company",required = false) String company,
      @RequestParam(value = "people",required = false) String people,
      Model model,
      HttpSession session) {
        PageHelper.startPage(pageNum, pageSize);
        List<PayMoney> list = payMoneyService.selectAllPayMoney(code,name,company,people);
        list.forEach( s -> {
            s.setRisLevel("1".equalsIgnoreCase(s.getRisLevel())? "高":("2".equalsIgnoreCase(s.getRisLevel())?"中":"低"));
        });
        PageInfo<PayMoney> pageInfo = new PageInfo<PayMoney>(list, 5);
        model.addAttribute("finacnePageInfo",pageInfo);
        model.addAttribute("financeList",list);

        model.addAttribute("activeUrl1", "financeActive");
        model.addAttribute("activeUrl2", "paymoneyActive");
        model.addAttribute("pageTopBarInfo", "债券类基金管理界面");
        return "/admin/finance/paymoney";
    }

    /**
     * 新增债券类基金产品
     * @param payMoney
     * @return
     */
    @PostMapping("/admin/addPayMoney")
    @ResponseBody
    public Msg addPayMoney(PayMoney payMoney){
      Msg msg = new Msg();
      msg.setCode(200);
      if (CheckEmptyUtil.isEmpty(payMoney)) {
        msg.setMsg("内容不能为空");
        return msg;
      }
      if (CheckEmptyUtil.isEmpty(payMoney.getCode())) {
        msg.setMsg("基金代码不能为空");
        return msg;
      }
      if (CheckEmptyUtil.isEmpty(payMoney.getName())) {
        msg.setMsg("产品名称不能为空");
        return msg;
      }
      if (CheckEmptyUtil.isEmpty(payMoney.getCompany())) {
        msg.setMsg("行业不能为空");
        return msg;
      }
      if (CheckEmptyUtil.isEmpty(payMoney.getPeople())) {
        msg.setMsg("基金经理不能为空");
        return msg;
      }
      if (CheckEmptyUtil.isEmpty(payMoney.getMonthmoney())) {
        msg.setMsg("年化收益率不能为空");
        return msg;
      }
      if (CheckEmptyUtil.isEmpty(payMoney.getInstruction())) {
        msg.setMsg("基金简介不能为空");
        return msg;
      }
      if (CheckEmptyUtil.isNotEmpty(payMoney.getInstruction())
          && payMoney.getInstruction().length() >= 20) {
        msg.setMsg("基金简介不能超过20个字");
        return msg;
      }
        Integer result = payMoneyService.insertPayMoney(payMoney);
        if (result==1){
            return Msg.success();
        }
        return Msg.fail();
    }

    /**
     * 更新时回显信息
     * @param id
     * @return
     */
    @GetMapping("/admin/getPayMoneyInfoById/{id}")
    @ResponseBody
    public Msg getPayMoneyInfoById(@PathVariable("id") Integer id){
        PayMoney payMoney = payMoneyService.selectPayMoneyById(id);
        return Msg.success().add("payMoney",payMoney);
    }

    /**
     * 更新
     * @param id
     * @param payMoney
     * @return
     */
    @PutMapping("/admin/updatePayMoney/{id}")
    @ResponseBody
    public Msg updatePayMoney(@PathVariable("id") Integer id,PayMoney payMoney){
      Msg msg = new Msg();
      msg.setCode(200);
      if (CheckEmptyUtil.isEmpty(payMoney)) {
        msg.setMsg("内容不能为空");
        return msg;
      }
      if (CheckEmptyUtil.isEmpty(payMoney.getCode())) {
        msg.setMsg("基金代码不能为空");
        return msg;
      }
      if (CheckEmptyUtil.isEmpty(payMoney.getName())) {
        msg.setMsg("基金名称不能为空");
        return msg;
      }
      if (CheckEmptyUtil.isEmpty(payMoney.getCompany())) {
        msg.setMsg("基金公司不能为空");
        return msg;
      }
      if (CheckEmptyUtil.isEmpty(payMoney.getPeople())) {
        msg.setMsg("基金经理不能为空");
        return msg;
      }
      if (CheckEmptyUtil.isEmpty(payMoney.getMonthmoney())) {
        msg.setMsg("基金收益率不能为空");
        return msg;
      }
      if (CheckEmptyUtil.isEmpty(payMoney.getInstruction())) {
        msg.setMsg("基金简介不能为空");
        return msg;
      }
      if (CheckEmptyUtil.isNotEmpty(payMoney.getInstruction())
          && payMoney.getInstruction().length() >= 20) {
        msg.setMsg("基金简介不能超过20个字");
        return msg;
      }
        payMoney.setId(id);
        Integer result = payMoneyService.updatePayMoney(payMoney);
        if (result==1){
            return Msg.success();
        }
        return Msg.fail();
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @DeleteMapping("/admin/deletePayMoneyById/{id}")
    @ResponseBody
    public Msg deletePayMoneyById(@PathVariable("id") Integer id){
        Integer result = payMoneyService.deletePayMoneyById(id);
        if (result==1){
            return Msg.success();
        }
        return Msg.fail();
    }
}

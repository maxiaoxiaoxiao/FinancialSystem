package com.bjpowernode.finance.controller;

import com.bjpowernode.finance.common.Msg;
import com.bjpowernode.finance.entity.Admin;
import com.bjpowernode.finance.entity.BuyChangeMoney;
import com.bjpowernode.finance.entity.ChangeMoney;
import com.bjpowernode.finance.entity.FundProduct;
import com.bjpowernode.finance.service.ChangeMoneyService;
import com.bjpowernode.finance.service.FlowOfFundsService;
import com.bjpowernode.finance.service.UserChangeMoneyService;
import com.bjpowernode.finance.utils.CheckEmptyUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
public class ChangeMoneyController {
    @Autowired
    ChangeMoneyService changeMoneyService;
    @Autowired
    UserChangeMoneyService userChangeMoneyService;
    @Autowired
    FlowOfFundsService flowOfFundsService;

    /**
     * 跳转到股票类基金界面（用户）
     * @param model
     * @return
     */
    @RequestMapping("/user/finance/toChangeMoney.html")
    public String toChangemoney(Model model,
                                @RequestParam(value = "code",required = false) String code,
                                @RequestParam(value = "name",required = false) String name,
                                @RequestParam(value = "company",required = false) String company,
                                @RequestParam(value = "people",required = false) String people){
        List<ChangeMoney> list = changeMoneyService.selectAllChangeMoney(code, name, company, people);
        model.addAttribute("changeMoneyList",list);
        model.addAttribute("pageTopBarInfo","股票类基金界面");
        model.addAttribute("activeUrl1","financeActive");
        model.addAttribute("activeUrl2","changeMoneyActive");
        return "/user/finance/changemoney";
    }

    /**
     * 买入债券类基金
     * @param changeMoneyId
     * @param userId
     * @return
     */
    @PostMapping("/user/buyChangeMoney")
    @ResponseBody
    public Msg buyChangeMoney(@RequestParam("changeMoneyId")Integer changeMoneyId,
                              @RequestParam("userId") Integer userId ){
        return userChangeMoneyService.insertUserChangeMoney(changeMoneyId,userId);

    }

    /**
     * 推荐理财.
     * @param
     * @return
     */
    @RequestMapping("/user/buyChangeMoneyList")
    @ResponseBody
    public Msg buyChangeMoneyList(@RequestBody BuyChangeMoney buyChangeMoney, HttpSession session ){
        Admin admin = (Admin)session.getAttribute("loginAdmin");
        List<Integer> list = new ArrayList<>();
        list.add(Integer.valueOf(buyChangeMoney.getUserIdList()));
        userChangeMoneyService.insertUserListChangeMoney(buyChangeMoney.getChangeMoneyId(),list,admin.getId(),buyChangeMoney.getConctent());
        return Msg.success();

    }

    /**
     * 跳转到股票类基金管理界面（管理员）
     * @param pageNum
     * @param pageSize
     * @param model
     * @param session
     * @return
     */
    @GetMapping("/admin/finance/toChangeMoney.html")
    public String toUserInfo(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                             @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                             @RequestParam(value = "code",required = false) String code,
                             @RequestParam(value = "name",required = false) String name,
                             @RequestParam(value = "company",required = false) String company,
                             @RequestParam(value = "people",required = false) String people,
                             Model model, HttpSession session) {
        PageHelper.startPage(pageNum, pageSize);
        List<ChangeMoney> list = changeMoneyService.selectAllChangeMoney(code,name,company,people);
        PageInfo<ChangeMoney> pageInfo = new PageInfo<ChangeMoney>(list, 5);
        model.addAttribute("finacnePageInfo",pageInfo);
        model.addAttribute("financeList",list);

        model.addAttribute("activeUrl1", "financeActive");
        model.addAttribute("activeUrl2", "changemoneyActive");
        model.addAttribute("pageTopBarInfo", "股票类基金管理界面");
        return "/admin/finance/changemoney";
    }

  /**
   * 新增股票类基金产品
   *
   * @param changeMoney
   * @return
   */
  @PostMapping("/admin/addChangeMoney")
  @ResponseBody
  public Msg addChangeMoney(ChangeMoney changeMoney) {
    Msg msg = new Msg();
    msg.setCode(200);
    if (CheckEmptyUtil.isEmpty(changeMoney)) {
      msg.setMsg("内容不能为空");
      return msg;
    }
    if (CheckEmptyUtil.isEmpty(changeMoney.getCode())) {
      msg.setMsg("基金代码不能为空");
      return msg;
    }
    if (CheckEmptyUtil.isEmpty(changeMoney.getName())) {
      msg.setMsg("产品名称不能为空");
      return msg;
    }
    if (CheckEmptyUtil.isEmpty(changeMoney.getCompany())) {
      msg.setMsg("行业不能为空");
      return msg;
    }
    if (CheckEmptyUtil.isEmpty(changeMoney.getPeople())) {
      msg.setMsg("基金经理不能为空");
      return msg;
    }
    if (CheckEmptyUtil.isEmpty(changeMoney.getInstruction())) {
      msg.setMsg("基金简介不能为空");
      return msg;
    }
    if (CheckEmptyUtil.isNotEmpty(changeMoney.getInstruction())
        && changeMoney.getInstruction().length() >= 20) {
      msg.setMsg("基金简介不能超过20个字");
      return msg;
    }
      List<ChangeMoney> changeMoneyList = changeMoneyService.selectAllChangeMoney(StringUtils.EMPTY, StringUtils.EMPTY, StringUtils.EMPTY, StringUtils.EMPTY);
      Set<String> codeSet = changeMoneyList.stream().map(ChangeMoney::getCode).collect(Collectors.toSet());
      Set<String> nameSet = changeMoneyList.stream().map(ChangeMoney::getName).collect(Collectors.toSet());
      if(codeSet.contains(changeMoney.getCode())){
          msg.setMsg("基金代码不可以重复");
          return msg;
      }
      if(nameSet.contains(changeMoney.getName())){
          msg.setMsg("基金名称不可以重复");
          return msg;
      }
    Integer result = changeMoneyService.insertChangeMoney(changeMoney);
    if (result == 1) {
      return Msg.success();
    }
    return Msg.fail();
  }

    /**
     * 更新时回显信息
     * @param id
     * @return
     */
    @GetMapping("/admin/getChangeMoneyInfoById/{id}")
    @ResponseBody
    public Msg getChangeMoneyInfoById(@PathVariable("id") Integer id){
        ChangeMoney changeMoney = changeMoneyService.selectChangeMoneyById(id);
        return Msg.success().add("changeMoney",changeMoney);
    }

    /**
     * 更新
     * @param id
     * @param changeMoney
     * @return
     */
    @PutMapping("/admin/updateChangeMoney/{id}")
    @ResponseBody
    public Msg updateChangeMoney(@PathVariable("id") Integer id,ChangeMoney changeMoney){
      Msg msg = new Msg();
      msg.setCode(200);
      if (CheckEmptyUtil.isEmpty(changeMoney)) {
        msg.setMsg("内容不能为空");
        return msg;
      }
      if (CheckEmptyUtil.isEmpty(changeMoney.getCode())) {
        msg.setMsg("基金代码不能为空");
        return msg;
      }
      if (CheckEmptyUtil.isEmpty(changeMoney.getName())) {
        msg.setMsg("基金名称不能为空");
        return msg;
      }
      if (CheckEmptyUtil.isEmpty(changeMoney.getCompany())) {
        msg.setMsg("基金公司不能为空");
        return msg;
      }
      if (CheckEmptyUtil.isEmpty(changeMoney.getPeople())) {
        msg.setMsg("基金经理不能为空");
        return msg;
      }
      if (CheckEmptyUtil.isEmpty(changeMoney.getInstruction())) {
        msg.setMsg("基金简介不能为空");
        return msg;
      }
      if (CheckEmptyUtil.isNotEmpty(changeMoney.getInstruction())
          && changeMoney.getInstruction().length() >= 20) {
        msg.setMsg("基金简介不能超过20个字");
        return msg;
      }
        changeMoney.setId(id);
        Integer result = changeMoneyService.updateChangeMoney(changeMoney);
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
    @DeleteMapping("/admin/deleteChangeMoneyById/{id}")
    @ResponseBody
    public Msg deleteChangeMoneyById(@PathVariable("id") Integer id){
        Integer result = changeMoneyService.deleteChangeMoneyById(id);
        if (result==1){
            return Msg.success();
        }
        return Msg.fail();
    }
}

package com.bjpowernode.finance.controller;

import com.bjpowernode.finance.common.Msg;
import com.bjpowernode.finance.entity.Admin;
import com.bjpowernode.finance.entity.TermFinancial;
import com.bjpowernode.finance.service.FlowOfFundsService;
import com.bjpowernode.finance.service.TermFinancialService;
import com.bjpowernode.finance.service.UserTermFinancialService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class TermFinancialController {

    @Autowired
    TermFinancialService termFinancialService;
    @Autowired
    UserTermFinancialService userTermFinancialService;
    @Autowired
    FlowOfFundsService flowOfFundsService;

    /**
     * 跳转到期限理财界面
     *
     * @param model
     * @return
     */
    @RequestMapping("/user/finance/toTermFinancial.html")
    public String toPaymoney(@RequestParam(value = "id") Integer id,
                             @RequestParam(value = "name") String name,
                             @RequestParam(value = "company") String company,
                             @RequestParam(value = "people") String people,
                             Model model) {
        List<TermFinancial> list = termFinancialService.selectAllTermFinancial(
            id, name, company, people);
        model.addAttribute("termFinancialList", list);
        model.addAttribute("pageTopBarInfo", "期限理财界面");
        model.addAttribute("activeUrl1", "financeActive");
        model.addAttribute("activeUrl2", "termFinancialActive");
        return "/user/finance/termfinancial";
    }

    /**
     * 购买工资理财产品
     *
     * @param termFinancialId
     * @param userId
     * @return
     */
    @PostMapping("/user/buyTermFinancial")
    @ResponseBody
    public Msg buyTermFinancial(@RequestParam("termFinancialId") Integer termFinancialId,
                                @RequestParam("userId") Integer userId) {

        return userTermFinancialService.insertUserTermFinancial(termFinancialId,userId);
    }

    @PostMapping("/user/buyTermFinancialList")
    @ResponseBody
    public Msg buyTermFinancialList(@RequestParam("termFinancialId") Integer termFinancialId,
                                @RequestParam("userIdList") List<Integer> userIdList,HttpSession session) {

        Admin admin = (Admin)session.getAttribute("loginAdmin");
        userTermFinancialService.buyTermFinancialList(termFinancialId,userIdList,admin.getId());
        return Msg.success();
    }
  /**
   * 跳转到期限理财管理界面（管理员）
   *
   * @param pageNum
   * @param pageSize
   * @param model
   * @param session
   * @return
   */
  @GetMapping("/admin/finance/toTermFinancial.html")
  public String toTermFinancialInfo(
      @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
      @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
      @RequestParam(value = "id") Integer id,
      @RequestParam(value = "name") String name,
      @RequestParam(value = "company") String company,
      @RequestParam(value = "people") String people,
      Model model,
      HttpSession session) {
    PageHelper.startPage(pageNum, pageSize);
    List<TermFinancial> list = termFinancialService.selectAllTermFinancial(id,name,company,people);
    PageInfo<TermFinancial> pageInfo = new PageInfo<TermFinancial>(list, 5);
    model.addAttribute("finacnePageInfo", pageInfo);
    model.addAttribute("financeList", list);

    model.addAttribute("activeUrl1", "financeActive");
    model.addAttribute("activeUrl2", "termfinancialActive");
    model.addAttribute("pageTopBarInfo", "期限理财管理界面");
    return "/admin/finance/termfinancial";
  }

    /**
     * 新增期限理财产品
     *
     * @return
     */
    @PostMapping("/admin/addTermFinancial")
    @ResponseBody
    public Msg addTermFinancial(TermFinancial termFinancial){
        Integer result = termFinancialService.insertTermFinancial(termFinancial);
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
    @GetMapping("/admin/getTermFinancialInfoById/{id}")
    @ResponseBody
    public Msg getTermFinancialInfoById(@PathVariable("id") Integer id){
        TermFinancial termFinancial = termFinancialService.selectTermFinancialById(id);
        return Msg.success().add("termFinancial",termFinancial);
    }

    /**
     * 更新
     * @param id
     *
     * @return
     */
    @PutMapping("/admin/updateTermFinancial/{id}")
    @ResponseBody
    public Msg updateTermFinancial(@PathVariable("id") Integer id,TermFinancial termFinancial){
        termFinancial.setId(id);
        Integer result = termFinancialService.updateTermFinancial(termFinancial);
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
    @DeleteMapping("/admin/deleteTermFinancialById/{id}")
    @ResponseBody
    public Msg deleteTermFinancialById(@PathVariable("id") Integer id){
        Integer result = termFinancialService.deleteTermFinancialById(id);
        if (result==1){
            return Msg.success();
        }
        return Msg.fail();
    }
}

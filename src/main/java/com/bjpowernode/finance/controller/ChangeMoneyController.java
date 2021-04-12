package com.bjpowernode.finance.controller;

import com.bjpowernode.finance.common.Msg;
import com.bjpowernode.finance.entity.Admin;
import com.bjpowernode.finance.entity.ChangeMoney;
import com.bjpowernode.finance.service.ChangeMoneyService;
import com.bjpowernode.finance.service.FlowOfFundsService;
import com.bjpowernode.finance.service.UserChangeMoneyService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ChangeMoneyController {
    @Autowired
    ChangeMoneyService changeMoneyService;
    @Autowired
    UserChangeMoneyService userChangeMoneyService;
    @Autowired
    FlowOfFundsService flowOfFundsService;

    /**
     * 跳转到零钱理财界面（用户）
     * @param model
     * @return
     */
    @RequestMapping("/user/finance/toChangeMoney.html")
    public String toChangemoney(Model model,
                                @RequestParam(value = "id",required = false) Integer id,
                                @RequestParam(value = "name",required = false) String name,
                                @RequestParam(value = "company",required = false) String company,
                                @RequestParam(value = "people",required = false) String people){
        List<ChangeMoney> list = changeMoneyService.selectAllChangeMoney(id, name, company, people);
        model.addAttribute("changeMoneyList",list);
        model.addAttribute("pageTopBarInfo","零钱理财界面");
        model.addAttribute("activeUrl1","financeActive");
        model.addAttribute("activeUrl2","changeMoneyActive");
        return "/user/finance/changemoney";
    }

    /**
     * 买入工资理财产品
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
     * @param changeMoneyId
     * @return
     */
    @RequestMapping("/user/buyChangeMoneyList")
    @ResponseBody
    public Msg buyChangeMoneyList(@RequestParam("changeMoneyId")Integer changeMoneyId,
                              @RequestParam("content")  String content,
                              @RequestParam("userIdList") List<Integer> userIdList,HttpSession session ){
        Admin admin = (Admin)session.getAttribute("loginAdmin");
        userChangeMoneyService.insertUserListChangeMoney(changeMoneyId,userIdList,admin.getId(),content);
        return Msg.success();

    }

    /**
     * 跳转到零钱理财管理界面（管理员）
     * @param pageNum
     * @param pageSize
     * @param model
     * @param session
     * @return
     */
    @GetMapping("/admin/finance/toChangeMoney.html")
    public String toUserInfo(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                             @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                             @RequestParam(value = "id",required = false) Integer id,
                             @RequestParam(value = "name",required = false) String name,
                             @RequestParam(value = "company",required = false) String company,
                             @RequestParam(value = "people",required = false) String people,
                             Model model, HttpSession session) {
        PageHelper.startPage(pageNum, pageSize);
        List<ChangeMoney> list = changeMoneyService.selectAllChangeMoney(id,name,company,people);
        PageInfo<ChangeMoney> pageInfo = new PageInfo<ChangeMoney>(list, 5);
        model.addAttribute("finacnePageInfo",pageInfo);
        model.addAttribute("financeList",list);

        model.addAttribute("activeUrl1", "financeActive");
        model.addAttribute("activeUrl2", "changemoneyActive");
        model.addAttribute("pageTopBarInfo", "零钱理财管理界面");
        return "/admin/finance/changemoney";
    }

    /**
     * 新增零钱理财产品
     * @param changeMoney
     * @return
     */
    @PostMapping("/admin/addChangeMoney")
    @ResponseBody
    public Msg addChangeMoney(ChangeMoney changeMoney){
        Integer result = changeMoneyService.insertChangeMoney(changeMoney);
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

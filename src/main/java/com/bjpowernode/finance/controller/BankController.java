package com.bjpowernode.finance.controller;

import com.bjpowernode.finance.common.Msg;
import com.bjpowernode.finance.entity.Bank;
import com.bjpowernode.finance.entity.User;
import com.bjpowernode.finance.entity.UserChangeMoney;
import com.bjpowernode.finance.entity.UserFundProduct;
import com.bjpowernode.finance.entity.UserPayMoney;
import com.bjpowernode.finance.entity.UserTermFinancial;
import com.bjpowernode.finance.mapper.UserChangeMoneyMapper;
import com.bjpowernode.finance.mapper.UserFundProductMapper;
import com.bjpowernode.finance.mapper.UserPayMoneyMapper;
import com.bjpowernode.finance.mapper.UserTermFinancialMapper;
import com.bjpowernode.finance.service.BankService;
import com.bjpowernode.finance.service.UserChangeMoneyService;
import com.bjpowernode.finance.service.UserFundProductService;
import com.bjpowernode.finance.service.UserPayMoneyService;
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
public class BankController {
    @Autowired
    BankService bankService;
    @Autowired
    UserTermFinancialService userTermFinancialService;
    @Autowired
    UserChangeMoneyService userChangeMoneyService;

    @Autowired
    UserFundProductService userFundProductService;
    @Autowired
    UserPayMoneyService userPayMoneyService;

    /**
     * 跳转用户银行推荐界面
     * @param model
     * @return
     */
    @RequestMapping("/user/finance/toBank.html")
    public String toBank(Model model){
        List<Bank> list = bankService.selectAllBank();
        model.addAttribute("bankList",list);
        model.addAttribute("pageTopBarInfo","银行推荐界面");
        model.addAttribute("activeUrl1","financeActive");
        model.addAttribute("activeUrl2","bankActive");
        return "user/finance/bank";
    }

    /**
     * 跳转用户银行推荐界面
     * @param model
     * @return
     */
    @RequestMapping("/user/finance/toLiCai.html")
    public String toLiCai(Model model, HttpSession session) {
        User user = (User) session.getAttribute("loginUser");
        Integer userId = user.getId();
        List<UserChangeMoney> userChangeMoneyList = userChangeMoneyService.selectUserChangeMoneyByUser(userId);
        model.addAttribute("userChangeMoneyList", userChangeMoneyList);

        List<UserPayMoney> userPayMoneyList = userPayMoneyService.selectUserPayMoneyByUser(userId);
        model.addAttribute("userPayMoneyList", userPayMoneyList);

        List<UserTermFinancial> userTermFinancialList = userTermFinancialService.selectUserTermFinancialByUser(userId);
        model.addAttribute("userTermFinancialList", userTermFinancialList);

        List<UserFundProduct> userFundProductList = userFundProductService.selectUserFundProductByUser(userId);
        model.addAttribute("userFundProductList", userFundProductList);
        model.addAttribute("pageTopBarInfo","理财推荐界面");
        model.addAttribute("activeUrl1","financeActive");
        model.addAttribute("activeUrl2","liCaiActive");
        return "user/finance/liCai";
    }

    /**
     * 跳转到推荐银行管理界面（管理员）
     * @param pageNum
     * @param pageSize
     * @param model
     * @param session
     * @return
     */
    @GetMapping("/admin/finance/toBank.html")
    public String toBank(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                Model model, HttpSession session) {
        PageHelper.startPage(pageNum, pageSize);
        List<Bank> list = bankService.selectAllBank();
        PageInfo<Bank> pageInfo = new PageInfo<Bank>(list, 5);
        model.addAttribute("finacnePageInfo",pageInfo);
        model.addAttribute("financeList",list);

        model.addAttribute("activeUrl1", "financeActive");
        model.addAttribute("activeUrl2", "bankctive");
        model.addAttribute("pageTopBarInfo", "推荐银行管理界面");
        return "/admin/finance/bank";
    }

    /**
     * 新增推荐银行
     *
     * @return
     */
    @PostMapping("/admin/addBank")
    @ResponseBody
    public Msg addBank(Bank bank){
        Integer result = bankService.insertBank(bank);
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
    @GetMapping("/admin/getBankInfoById/{id}")
    @ResponseBody
    public Msg getBankInfoById(@PathVariable("id") Integer id){
        Bank bank = bankService.selectBankById(id);
        return Msg.success().add("bank",bank);
    }

    /**
     * 更新
     * @param id
     *
     * @return
     */
    @PutMapping("/admin/updateBank/{id}")
    @ResponseBody
    public Msg updateBank(@PathVariable("id") Integer id,Bank bank){
        bank.setId(id);
        Integer result = bankService.updateBank(bank);
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
    @DeleteMapping("/admin/deleteBankById/{id}")
    @ResponseBody
    public Msg deleteBankById(@PathVariable("id") Integer id){
        Integer result = bankService.deleteBankById(id);
        if (result==1){
            return Msg.success();
        }
        return Msg.fail();
    }
}

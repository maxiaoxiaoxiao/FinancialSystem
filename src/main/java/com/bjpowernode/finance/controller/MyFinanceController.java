package com.bjpowernode.finance.controller;

import com.bjpowernode.finance.common.Msg;
import com.bjpowernode.finance.entity.*;
import com.bjpowernode.finance.service.UserChangeMoneyService;
import com.bjpowernode.finance.service.UserFundProductService;
import com.bjpowernode.finance.service.UserPayMoneyService;
import com.bjpowernode.finance.service.UserTermFinancialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MyFinanceController {

    @Autowired
    UserChangeMoneyService userChangeMoneyService;
    @Autowired
    UserPayMoneyService userPayMoneyService;
    @Autowired
    UserFundProductService userFundProductService;
    @Autowired
    UserTermFinancialService userTermFinancialService;

    @GetMapping("/user/personal/toMyFinance.html")
    public String toMyFinance(Model model, HttpSession session) {

        User user = (User) session.getAttribute("loginUser");
        Integer userId = user.getId();

        List<ChangeMoney> userChangeMoneyList = userChangeMoneyService.selectUserChangeMoneyByUserId(userId);
        model.addAttribute("userChangeMoneyList", userChangeMoneyList);

        List<PayMoney> userPayMoneyList = userPayMoneyService.selectUserPayMoneyByUserId(userId);
        userPayMoneyList.forEach( s -> {
            s.setRisLevel("1".equalsIgnoreCase(s.getRisLevel())? "高":("2".equalsIgnoreCase(s.getRisLevel())?"中":"低"));
        });
        model.addAttribute("userPayMoneyList", userPayMoneyList);

        List<TermFinancial> userTermFinancialList = userTermFinancialService.selectUserTermFinancialByUserId(userId);
        model.addAttribute("userTermFinancialList", userTermFinancialList);

        List<FundProduct> userFundProductList = userFundProductService.selectUserFundProductByUserId(userId);
        model.addAttribute("userFundProductList", userFundProductList);
        userFundProductList.forEach( s -> {
            s.setRisLevel("1".equalsIgnoreCase(s.getRisLevel())? "高":("2".equalsIgnoreCase(s.getRisLevel())?"中":"低"));
        });

        model.addAttribute("pageTopBarInfo", "我的理财界面");
        model.addAttribute("activeUrl1", "personalActive");
        model.addAttribute("activeUrl2", "myFinanceActive");
        if (session.getAttribute("myFinanceActiveUrl")==null){
            session.setAttribute("myFinanceActiveUrl", "changeMoneyActive");
        }
        return "/user/personal/myfinance";
    }

    @PutMapping("/user/revokeUserChangeMoney")
    @ResponseBody
    public Msg revokeUserChangeMoney(@RequestParam("userChangeMoneyId") Integer userChangeMoneyId, HttpSession session) {
        User user = (User)session.getAttribute("loginUser");
        UserChangeMoney ucm = userChangeMoneyService.selectUserChangeMoneyById(userChangeMoneyId,user.getId());
        userChangeMoneyService.deletUserChangeMoney(ucm);
        session.setAttribute("myFinanceActiveUrl", "changeMoneyActive");
        return Msg.success();
    }

    @PutMapping("/user/revokeUserPayMoney")
    @ResponseBody
    public Msg revokeUserPayMoney(@RequestParam("userPayMoneyId") Integer userPayMoneyId, HttpSession session) {
        User user = (User)session.getAttribute("loginUser");
        UserPayMoney upm = userPayMoneyService.selectUserPayMoneyById(userPayMoneyId,user.getId());
        userPayMoneyService.deleteUserPayMoney(upm);
        session.setAttribute("myFinanceActiveUrl", "payMoneyActive");
        return Msg.success();
    }

    @PutMapping("/user/revokeUserTermFinancial")
    @ResponseBody
    public Msg revokeUserTermFinancial(@RequestParam("userTermFinancialId") Integer userTermFinancialId, HttpSession session) {
        User user = (User)session.getAttribute("loginUser");
        UserTermFinancial utf = userTermFinancialService.selectUserTermFinancialById(userTermFinancialId,user.getId());
        userTermFinancialService.deleteUserTermFinancial(utf);
        session.setAttribute("myFinanceActiveUrl", "termFinancialActive");
        return Msg.success();
    }

    @PutMapping("/user/revokeUserFundProduct")
    @ResponseBody
    public Msg revokeUserFundProduct(@RequestParam("userFundProductId") Integer userFundProductId,HttpSession session) {

        User user = (User) session.getAttribute("loginUser");
        UserFundProduct ufp = userFundProductService.selectUserFundProductById(userFundProductId, user.getId());
        userFundProductService.deleteUserFundProduct(ufp);

        session.setAttribute("myFinanceActiveUrl", "fundProductActive");
        return Msg.success();
    }
}

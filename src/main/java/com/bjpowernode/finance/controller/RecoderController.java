package com.bjpowernode.finance.controller;

import com.bjpowernode.finance.common.Msg;
import com.bjpowernode.finance.entity.FlowOfFunds;
import com.bjpowernode.finance.entity.User;
import com.bjpowernode.finance.entity.UserPermissions;
import com.bjpowernode.finance.service.FlowOfFundsService;
import com.bjpowernode.finance.utils.CheckEmptyUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RecoderController {

    @Autowired
    FlowOfFundsService flowOfFundsService;

    /**
     * 跳转到资金记录界面
     * @param model
     * @return
     */
    @RequestMapping("/user/tools/toRecord.html")
    public String toRecoder(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
//                            @RequestParam(value = "type") Integer type,
                            Model model, HttpSession session) {

        // 引入PageHelper插件，在查询之前调用startPage方法，传入页码以及每页大小
        PageHelper.startPage(pageNum, pageSize);
        User user = (User) session.getAttribute("loginUser");
        Integer type = 1;
        List<FlowOfFunds> list = flowOfFundsService.selectFlowOfFundsByUserId(user.getId(),type);
        // 使用PageInfo包装查询后的结果，并交给页面处理
        // PageInfo封装了详细的分页信息，包括我们查询出来的数据，还可以传入连续显示的页数（5）
        PageInfo<FlowOfFunds> pageInfo = new PageInfo<FlowOfFunds>(list, 5);

        model.addAttribute("flowOfFundsList",list);
        model.addAttribute("flowOfFundsPageInfo",pageInfo);
        model.addAttribute("pageTopBarInfo", "资金记录界面");
        model.addAttribute("activeUrl1", "toolsActive");
        model.addAttribute("activeUrl2", "recordActive");
        return "/user/tools/record";
    }

    /**
     * 增加/编辑收支记录.
     *
     * @param flowOfFunds
     * @return
     */
    @PostMapping("/user/tools/addRecord")
    @ResponseBody
    public Msg addRecord(@RequestBody FlowOfFunds flowOfFunds,HttpSession session){
        if (CheckEmptyUtil
            .isOrEmpty(flowOfFunds, flowOfFunds.getFlowmoney(), flowOfFunds.getFunddesc(),
                       flowOfFunds.getSource(),flowOfFunds.getType())) {
            Msg msg = new Msg();
            msg.setCode(200);
            msg.setMsg("填写信息不全");
            return msg;
        }
        if (CheckEmptyUtil.isEmpty(flowOfFunds.getUserid())) {
            User user = (User)session.getAttribute("loginUser");
            flowOfFunds.setUserid(user.getId());
        }
       return flowOfFundsService.addRecord(flowOfFunds);
    }

    /**
     * 删除收支记录.
     *
     * @param id
     * @return
     */
    @GetMapping("/user/tools/deleteRecord/{id}")
    @ResponseBody
    public Msg deleteRecord(@PathVariable("id") Integer id){

        return flowOfFundsService.deleteRecord(id);
    }

}

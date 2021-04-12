package com.bjpowernode.finance.controller;

import com.bjpowernode.finance.common.Msg;
import com.bjpowernode.finance.entity.Admin;
import com.bjpowernode.finance.entity.Exam;
import com.bjpowernode.finance.entity.User;
import com.bjpowernode.finance.service.UserService;
import com.bjpowernode.finance.utils.CheckEmptyUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 跳转到账户安全界面（用户）(修改密码)
     *
     * @param model
     * @return
     */
    @RequestMapping("/user/personal/toSecurity.html")
    public String toSecurity(Model model) {
        model.addAttribute("pageTopBarInfo", "账户安全界面");
        model.addAttribute("activeUrl1", "personalActive");
        model.addAttribute("activeUrl2", "securityActive");
        return "/user/personal/security";
    }

    /**
     * 跳转到个人信息界面（用户）
     *
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/user/personal/toProfile.html")
    public String toProfile(Model model, HttpSession session) {
        User loginUser = (User) session.getAttribute("loginUser");
        User user = userService.selectUserById(loginUser.getId());
        model.addAttribute("user", user);

        model.addAttribute("pageTopBarInfo", "个人信息界面");
        return "/user/personal/profile";
    }

    /**
     * 判断并更新密码（用户）
     *
     * @param request
     * @return
     */
    @PutMapping("/user/updatePwd")
    @ResponseBody
    public Msg updatePwd(HttpServletRequest request, HttpSession session) {

        String id = request.getParameter("id");
        User user = userService.selectUserById(Integer.valueOf(id));
        String oldpwd = request.getParameter("oldpwd");
        String newpwd = request.getParameter("newpwd");
        User verifyExistUser = userService.selectUserByTerms(user.getUsername(), oldpwd);
        if (verifyExistUser != null) {
            user.setPassword(newpwd);

            // 当前登录用户信息改变时session里面存储的用户信息也应该同时改变
            User loginUser = (User) session.getAttribute("loginUser");
            if (Integer.valueOf(id) == (loginUser.getId())) {
                session.setAttribute("loginUser", user);
            }
            userService.updateUser(user);
            return Msg.success();
        }
        return Msg.fail();
    }

    /**
     * 更新用户信息(用户更改自己信息)
     *
     * @param id
     * @param user
     * @param session
     * @return
     */
    @PutMapping("/user/updateUserProfile/{userId}")
    @ResponseBody
    public Msg updateUserProfile(@PathVariable("userId") Integer id, User user, HttpSession session) {
        user.setId(id);
        Integer result = userService.updateUser(user);
        if (result == 1) {
            // 当前登录用户信息改变时session里面存储的用户信息也应该同时改变
            User loginUser = (User) session.getAttribute("loginUser");
            if (loginUser!=null){
                if (id == (loginUser.getId())) {
                    session.setAttribute("loginUser", userService.selectUserById(id));
                }
            }
            return Msg.success();
        }
        return Msg.fail();
    }

    /**
     * 用户强制下线（管理员更改用户信息）
     *
     * @param id
     * @param session
     * @return
     */
    @PutMapping("/user/updateUserStatus/{id}")
    @ResponseBody
    public Msg updateUserStatus(@PathVariable("id") Integer id, HttpSession session) {
        User user = userService.selectUserById(id);
        user.setStatus(0);
        Integer result = userService.updateUser(user);
        if (result == 1) {
            // 当前登录用户强制下线
            session.removeAttribute("loginUser");
            return Msg.success();
        }
        return Msg.fail();
    }

    /**
     * 跳转到用户信息界面（管理员）
     * @param pageNum
     * @param pageSize
     * @param model
     * @param session
     * @return
     */
    @GetMapping("/admin/userinfo/toUserInfo.html")
    public String toUserInfo(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                             @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                             Model model, HttpSession session) {
        // 引入PageHelper插件，在查询之前调用startPage方法，传入页码以及每页大小
        Admin admin = (Admin)session.getAttribute("loginAdmin");
        PageHelper.startPage(pageNum, pageSize);
        List<User> list = userService.selectAllUser(admin);
        list.forEach( s -> {
            s.setRisLevel("1".equalsIgnoreCase(s.getRisLevel())? "高":("2".equalsIgnoreCase(s.getRisLevel())?"中":"低"));
        });
        // 使用PageInfo包装查询后的结果，并交给页面处理
        // PageInfo封装了详细的分页信息，包括我们查询出来的数据，还可以传入连续显示的页数（5）
        PageInfo<User> pageInfo = new PageInfo<User>(list, 5);
        model.addAttribute("userPageInfo",pageInfo);
        model.addAttribute("userList",list);

        model.addAttribute("activeUrl1", "userInfoActive");
        model.addAttribute("activeUrl2", "userInfoActive");
        model.addAttribute("pageTopBarInfo", "用户信息界面");
        return "/admin/userinfo/userinfo";
    }

    /**
     * 添加用户（管理员）
     * @param user
     * @return
     */
    @PostMapping("/user/addUser")
    @ResponseBody
    public Msg addUser(User user,HttpSession session){
        if(CheckEmptyUtil.isEmpty(user)){
            Msg msg = new Msg();
            msg.setCode(200);
            msg.setMsg("不能传入客户");
            return msg;
        }
        Integer adminId = user.getAdminId();
        if (CheckEmptyUtil.isEmpty(adminId)) {
            Admin admin = (Admin)session.getAttribute("loginAdmin");
            adminId = admin.getId();
        }

        user.setStatus(0);
        user.setReputation("良好");
        return userService.insertAdminUser(adminId,user);
    }

    /**
     * 更新用户信息时回显用户信息（管理员）
     * @param id
     * @return
     */
    @GetMapping("/user/getUserById/{id}")
    @ResponseBody
    public Msg getUserInfoById(@PathVariable("id")Integer id){
        User user = userService.selectUserById(id);
        return Msg.success().add("user",user);
    }

    /**
     * 删除用户（管理员）
     * @param id
     * @param session
     * @return
     */
    @DeleteMapping("/user/deleteUserById/{id}")
    @ResponseBody
    public Msg deleteUserById(@PathVariable("id")Integer id,HttpSession session){
        Integer result = userService.deleteUserById(id);
        if (result==1){
            // 删除用户时应先判断这个用户是否在线
            User loginUser = (User) session.getAttribute("loginUser");
            if (loginUser!=null){
                if (id == (loginUser.getId())) {
                    session.removeAttribute("loginUser");
                }
            }
            return Msg.success();
        }
        return Msg.fail();
    }

    /**
     * 跳转到用户信誉管理界面（管理员）
     * @param pageNum
     * @param pageSize
     * @param model
     * @param session
     * @return
     */
    @GetMapping("/admin/userinfo/toReputation.html")
    public String toUserReputation(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                             @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                             Model model, HttpSession session) {
//        PageHelper.startPage(pageNum, pageSize);
//        //List<User> list = userService.selectAllUser(admin.getType());
//        PageInfo<User> pageInfo = new PageInfo<User>(list, 5);
//        model.addAttribute("userPageInfo",pageInfo);
//        model.addAttribute("userList",list);
//
//        model.addAttribute("activeUrl1", "userInfoActive");
//        model.addAttribute("activeUrl2", "reputationActive");
//        model.addAttribute("pageTopBarInfo", "用户信誉界面");
        return "/admin/userinfo/reputation";
    }

    /**
     * 问卷调查
     * @param session
     * @return
     */
    @PostMapping("/user/addRisk")
    @ResponseBody
    public Msg addRisk(@RequestBody Exam exam, HttpSession session) {
        User user = (User)session.getAttribute("loginUser");
        String s = userService.addRisk(user, exam);
        Msg msg = new Msg();
        msg.setCode(100);
        msg.setMsg("您的投资意向为" +  s + "风险,谢谢您的参与");
        return msg;
    }

    /**
     * 查询所有的投资顾问
     * @return
     */
    @PostMapping("/user/selectAllAdmin")
    @ResponseBody
    public Msg selectAllAdmin() {
        List<Admin> admins = userService.selectAllAdmin();
        Msg msg = new Msg();
        msg.setCode(100);
        msg.add("list",admins);
        return msg;
    }
    /**
     * 查询所有的用户
     * @return
     */
    @PostMapping("/user/selectAllUser")
    @ResponseBody
    public Msg selectAllUser( HttpSession session) {
        Admin admin = (Admin)session.getAttribute("loginAdmin");
        List<User> list = userService.selectAllUser(admin);
        if(CheckEmptyUtil.isEmpty(list)){
            Msg msg = new Msg();
            msg.setCode(100);
            msg.setMsg("您没有客户进行推荐");
            return msg;
        }
        Msg msg = new Msg();
        msg.setCode(100);
        msg.add("list",list);
        return msg;
    }





}

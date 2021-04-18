package com.bjpowernode.finance.service.impl;

import com.bjpowernode.finance.common.Msg;
import com.bjpowernode.finance.entity.Admin;
import com.bjpowernode.finance.entity.AdminExample;
import com.bjpowernode.finance.entity.User;
import com.bjpowernode.finance.mapper.AdminMapper;
import com.bjpowernode.finance.service.AdminService;
import com.bjpowernode.finance.utils.CheckEmptyUtil;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

  @Autowired(required = false)
  AdminMapper adminMapper;

  @Override
  public Admin selectAdminByTerms(String username, String password) {
    AdminExample adminExample = new AdminExample();
    AdminExample.Criteria criteria = adminExample.createCriteria();
    if (username != null) {
      criteria.andUsernameEqualTo(username);
    }
    if (password != null) {
      criteria.andPasswordEqualTo(password);
    }
    List<Admin> list = adminMapper.selectByExample(adminExample);
    if ("[]".equals(list.toString())) {
      return null;
    } else {
      return list.get(0);
    }
  }

  @Override
  @Transactional
  public Integer updateAdmin(Admin admin) {
    int result = adminMapper.updateByPrimaryKeySelective(admin);
    return result;
  }

  @Override
  public Admin selectAdminById(Integer id) {
    Admin admin = adminMapper.selectByPrimaryKey(id);
    return admin;
  }

  @Override
  public Msg addAdmin(Admin admin) {
    Msg msg = new Msg();
    admin.setStatus(0);
    List<Admin> admins = adminMapper.selectByUserName(admin.getUsername());
    if (CheckEmptyUtil.isNotEmpty(admins)) {
      msg.setCode(200);
      msg.setMsg("该用户名已经存在");
      return msg;
    }
    adminMapper.insert(admin);
    msg.setCode(100);
    msg.setMsg("新建投资顾问成功");
    return msg;
  }

  @Override
  public Msg deleteAdminById(Integer id, HttpSession session) {
    Msg msg = new Msg();
    Admin admin = adminMapper.selectById(id);
    if (CheckEmptyUtil.isEmpty(admin)) {
      msg.setCode(200);
      msg.setMsg("投资顾问不存在");
      return msg;
    }
    if (admin.getType().equals(0)) {
      msg.setCode(200);
      msg.setMsg("不能删除管理员");
      return msg;
    }
    adminMapper.deleteByPrimaryKey(id);
    msg.setCode(100);
    msg.setMsg("删除成功");
    return msg;
  }

  @Override
  public List<Admin> selectAdmin() {
    return adminMapper.selectAdmin();

  }

  @Override
  public Admin selectAdminByName(String username) {
    return adminMapper.selectAdminByName(username);
  }
}

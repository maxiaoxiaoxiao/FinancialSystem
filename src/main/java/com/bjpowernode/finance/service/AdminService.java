package com.bjpowernode.finance.service;

import com.bjpowernode.finance.common.Msg;
import com.bjpowernode.finance.entity.Admin;
import java.util.List;
import javax.servlet.http.HttpSession;

public interface AdminService {

    Admin selectAdminByTerms(String username, String password);

    Integer updateAdmin(Admin admin);

    Admin selectAdminById(Integer id);

    /**
     * 新增管理员.
     *
     * @param admin not null.
     * @return
     */
    Msg addAdmin(Admin admin);

    /**
     * 删除管理员.
     *
     * @param id
     * @param session
     * @return
     */
    Msg deleteAdminById(Integer id, HttpSession session);

    /**
     * 查询管理员.
     *
     * @return
     */
    List<Admin> selectAdmin();
}

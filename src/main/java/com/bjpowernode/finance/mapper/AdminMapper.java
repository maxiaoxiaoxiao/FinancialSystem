package com.bjpowernode.finance.mapper;

import com.bjpowernode.finance.entity.Admin;
import com.bjpowernode.finance.entity.AdminExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AdminMapper {
    long countByExample(AdminExample example);

    int deleteByExample(AdminExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Admin record);

    int insertSelective(Admin record);

    List<Admin> selectByExample(AdminExample example);

    Admin selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByExample(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

    List<Admin> selectByUserName(@Param("userName") String userName);

    /**
     * 查询所有的管理员.
     *
     * @return
     */
  List<Admin> selectAdmin();

    Admin selectById(@Param("id") Integer id);

    Admin selectAdminByName(@Param("username") String username);
}

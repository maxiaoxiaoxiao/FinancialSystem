package com.bjpowernode.finance.mapper;

import com.bjpowernode.finance.entity.News;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NewsMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(News record);

    int insertSelective(News record);


    News selectByPrimaryKey(Integer id);


    int updateByPrimaryKeySelective(News record);

    int updateByPrimaryKey(News record);

    List<String> selectAllNews(@Param("userId") Integer userId);
}

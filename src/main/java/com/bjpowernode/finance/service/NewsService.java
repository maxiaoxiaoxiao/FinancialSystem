package com.bjpowernode.finance.service;

import com.bjpowernode.finance.entity.News;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NewsService {

    String selectAllNews(@Param("id") Integer id);
}

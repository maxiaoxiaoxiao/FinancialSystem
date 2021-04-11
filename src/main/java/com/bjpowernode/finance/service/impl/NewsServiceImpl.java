package com.bjpowernode.finance.service.impl;

import com.bjpowernode.finance.entity.News;
import com.bjpowernode.finance.mapper.NewsMapper;
import com.bjpowernode.finance.service.NewsService;
import com.bjpowernode.finance.utils.CheckEmptyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NewsServiceImpl implements NewsService {

    @Autowired(required = false)
    NewsMapper newsMapper;

    @Override
    public String selectAllNews(Integer userId) {
        List<String> news =  newsMapper.selectAllNews(userId);
        String msg = "";
        if (CheckEmptyUtil.isNotEmpty(news)) {
           for (String n :news) {
               msg = msg + n;
           }
        }
        return msg;
    }
}

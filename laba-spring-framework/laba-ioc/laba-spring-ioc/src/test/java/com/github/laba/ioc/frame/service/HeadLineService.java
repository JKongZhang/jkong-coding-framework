package com.github.laba.ioc.frame.service;

import com.github.laba.ioc.entity.bo.HeadLine;
import com.github.laba.ioc.entity.dto.Result;

import java.util.List;

public interface HeadLineService {
    //添加
    Result<Boolean> addHeadLine(HeadLine headLine);
    //删除
    Result<Boolean>  removeHeadLine(int headLineId);
    //修改
    Result<Boolean>  modifyHeadLine(HeadLine headLine);
    //查询
    Result<HeadLine>  queryHeadlineById(int headlineId);
    //获取头条列表
    Result<List<HeadLine>>  queryHeadline(HeadLine headLineCondition, int pageIndex, int pageSize);

}
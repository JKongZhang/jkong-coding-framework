package com.github.laba.ioc.frame.service.impl;

import com.github.laba.ioc.core.annotation.Service;
import com.github.laba.ioc.entity.bo.HeadLine;
import com.github.laba.ioc.entity.bo.ShopCategory;
import com.github.laba.ioc.entity.dto.MainPageInfoDTO;
import com.github.laba.ioc.entity.dto.Result;
import com.github.laba.ioc.frame.service.HeadLineService;
import com.github.laba.ioc.frame.service.HeadLineShopCategoryCombineService;
import com.github.laba.ioc.frame.service.ShopCategoryService;
import com.github.laba.ioc.inject.annotation.Autowired;

import java.util.List;

@Service
public class HeadLineShopCategoryCombineServiceImpl implements HeadLineShopCategoryCombineService {
    @Autowired
    private HeadLineService headLineService;
    @Autowired
    private ShopCategoryService shopCategoryService;
    @Override
    public Result<MainPageInfoDTO> getMainPageInfo() {
        //获取头条列表
        HeadLine headLineCCondition = new HeadLine();
        headLineCCondition.setEnableStatus(1);
        Result<List<HeadLine>> headlineResult = headLineService.queryHeadline(headLineCCondition, 1, 4);
        //获取店铺类别列表
        ShopCategory shopCategoryCondition = new ShopCategory();
        //获取所有的店铺类别信息
        Result<List<ShopCategory>> shopCategoryResult = shopCategoryService.queryShopCategory(shopCategoryCondition, 1, 100);
        //合并两者并且返回
        Result<MainPageInfoDTO> result =  mergeMainPageInfoResult(headlineResult,shopCategoryResult);
        return null;
    }

    private Result<MainPageInfoDTO> mergeMainPageInfoResult(Result<List<HeadLine>> headlineResult, Result<List<ShopCategory>> shopCategoryResult) {
        return null;
    }
}
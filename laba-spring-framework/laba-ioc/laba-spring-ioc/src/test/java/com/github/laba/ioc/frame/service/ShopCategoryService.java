package com.github.laba.ioc.frame.service;

import com.github.laba.ioc.entity.bo.ShopCategory;
import com.github.laba.ioc.entity.dto.Result;

import java.util.List;

public interface ShopCategoryService {
    //添加
    Result<Boolean> addShopCategory(ShopCategory shopCategory);
    //删除
    Result<Boolean>  removeShopCategory(int shopCategoryId);
    //修改
    Result<Boolean>  modifyShopCategory(ShopCategory shopCategory);
    //查询
    Result<ShopCategory>  queryShopCategoryById(int shopCategoryId);
    //获取头条列表
    Result<List<ShopCategory>>  queryShopCategory(ShopCategory shopCategoryCondition, int pageIndex, int pageSize);
}
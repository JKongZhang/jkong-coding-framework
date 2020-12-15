package com.github.laba.ioc.frame.service.impl;

import com.github.laba.ioc.core.annotation.Service;
import com.github.laba.ioc.entity.bo.ShopCategory;
import com.github.laba.ioc.entity.dto.Result;
import com.github.laba.ioc.frame.service.ShopCategoryService;

import java.util.List;

@Service
public class ShopCategoryServiceImpl implements ShopCategoryService {
    @Override
    public Result<Boolean> addShopCategory(ShopCategory shopCategory) {
        return null;
    }

    @Override
    public Result<Boolean> removeShopCategory(int shopCategoryId) {
        return null;
    }

    @Override
    public Result<Boolean> modifyShopCategory(ShopCategory shopCategory) {
        return null;
    }

    @Override
    public Result<ShopCategory> queryShopCategoryById(int shopCategoryId) {
        return null;
    }


    @Override
    public Result<List<ShopCategory>> queryShopCategory(ShopCategory shopCategoryCondition, int pageIndex, int pageSize) {
        return null;
    }
}
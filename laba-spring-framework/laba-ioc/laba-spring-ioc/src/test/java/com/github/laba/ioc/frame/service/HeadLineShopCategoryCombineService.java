package com.github.laba.ioc.frame.service;

import com.github.laba.ioc.entity.dto.MainPageInfoDTO;
import com.github.laba.ioc.entity.dto.Result;

public interface HeadLineShopCategoryCombineService {
    Result<MainPageInfoDTO> getMainPageInfo();
}
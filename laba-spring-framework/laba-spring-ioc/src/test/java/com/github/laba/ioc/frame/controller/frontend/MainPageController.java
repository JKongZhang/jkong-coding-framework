package com.github.laba.ioc.frame.controller.frontend;

import com.github.laba.ioc.core.annotation.Controller;
import com.github.laba.ioc.entity.dto.MainPageInfoDTO;
import com.github.laba.ioc.entity.dto.Result;
import com.github.laba.ioc.frame.service.HeadLineShopCategoryCombineService;
import com.github.laba.ioc.inject.annotation.Autowired;
import lombok.Getter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Getter
@Controller
public class MainPageController {

    @Autowired("HeadLineShopCategoryCombineServiceImpl")
    private HeadLineShopCategoryCombineService combineService;
    public Result<MainPageInfoDTO> getMainPageInfo(HttpServletRequest req, HttpServletResponse resp){
        Result<MainPageInfoDTO> info = combineService.getMainPageInfo();
        return info;
    }
    public void throwException(){
        throw new RuntimeException("抛出异常测试");
    }
}

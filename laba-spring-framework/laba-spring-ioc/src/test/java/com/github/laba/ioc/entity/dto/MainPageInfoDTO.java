package com.github.laba.ioc.entity.dto;


import com.github.laba.ioc.entity.bo.HeadLine;
import com.github.laba.ioc.entity.bo.ShopCategory;
import lombok.Data;

import java.util.List;


@Data
public class MainPageInfoDTO {
    private List<HeadLine> headLineList;
    private List<ShopCategory> shopCategoryList;
}

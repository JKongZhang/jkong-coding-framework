package com.github.laba.ioc.entity.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopCategory {
    private Long shopCategoryId;
    private String ShopCategoryName;
    private String ShopCategoryDesc;
    private String ShopCategoryImg;
    private Integer priority;
    private Date createTime;
    private Date lastsEditTime;
    private ShopCategory parent;
}

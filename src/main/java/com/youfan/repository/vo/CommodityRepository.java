package com.youfan.repository.vo;

import lombok.Data;

import java.util.Date;

@Data
public class CommodityRepository {

    /**
     * 仓库
     */
    private String repository;

    /**
     * 货品编码
     */
    private String coding;

    /**
     * 货品类别
     */
    private String category;

    /**
     * 货品名称
     */
    private String name;

    /**
     * 规格型号
     */
    private String model;

    /**
     * 单位
     */
    private String unit;


    /**
     * 入库数量/出库数量
     */
    private Integer number;

    /**
     * 出库时间/入库时间
     */
    private Date repositoryTime;

    private String username;
}

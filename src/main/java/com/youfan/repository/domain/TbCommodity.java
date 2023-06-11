package com.youfan.repository.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data//@Data是Lombok库中的一个注解，用于自动生成Java Bean中的Getter和Setter方法，以及toString()、equals()和hashCode()等方法
@TableName(value = "tb_commodity")
public class TbCommodity {
    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 仓库
     */
    @TableField(value = "repository")
    private String repository;

    /**
     * 货品编码
     */
    @TableField(value = "coding")
    private String coding;

    /**
     * 货品类别
     */
    @TableField(value = "category")
    private String category;

    /**
     * 货品名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 规格型号
     */
    @TableField(value = "model")
    private String model;

    /**
     * 单位
     */
    @TableField(value = "unit")
    private String unit;

    /**
     * 货品数量
     */
    @TableField(value = "number")
    private Integer number;

    public static final String COL_ID = "id";

    public static final String COL_REPOSITORY = "repository";

    public static final String COL_CODING = "coding";

    public static final String COL_CATEGORY = "category";

    public static final String COL_NAME = "name";

    public static final String COL_MODEL = "model";

    public static final String COL_UNIT = "unit";

    public static final String COL_NUMBER = "number";
}